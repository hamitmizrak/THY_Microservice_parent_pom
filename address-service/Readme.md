# THY address-service
git push origin master --force
git push origin master -f


Address-Service ve Customer-Service'i içeren bir Spring Cloud microservice uygulaması oluşturmak için aşağıdaki gibi bir örnek kod yapısı hazırlayabiliriz. Bu örnek, sorunuzda verdiğiniz tüm teknolojileri içerecek şekilde ayrıntılı olarak hazırlanmıştır. Projenin detaylarını ve gerekli konfigürasyonları adım adım ele alacağız.

---

| Spring Boot Sürümü | Spring Cloud Sürümü (Release Train) |
|--------------------|------------------------------------|
| 2.4.x              | 2020.0.x (Kod adı: Ilford)         |
| 2.5.x - 2.7.x      | 2021.x (Kod adı: Jubilee)          |
| 3.0.x - 3.2.x      | 2022.x (Kod adı: Kilburn)          |
| 3.3.x ve sonrası   | 2023.x ve sonrası                  |

### Adımlar ve Teknolojiler

**1. Projeye Genel Bakış:**
- `address-service`: Adres bilgilerini sağlayan bir mikroservis.
- `customer-service`: Müşteri bilgilerini sağlayan bir mikroservis.
- `discovery-service`: Mikroservisler arasında servis keşfi için Eureka Server.
- `api-gateway`: API isteklerini yönlendiren bir gateway (Netflix Zuul veya Spring Cloud Gateway kullanılabilir).
- `config-server`: Konfigürasyon yönetimi için merkezi konfigürasyon sunucusu.
- `zipkin-server`: Dağıtık izleme ve logging için Zipkin.

**Kullanılacak Teknolojiler:**
- **Spring Boot**: Uygulama yapılandırması.
- **Spring REST**: RESTful servislerin oluşturulması.
- **Eureka Server/Client**: Servis keşfi için Eureka.
- **Feign Client**: Servisler arası iletişim.
- **Spring Cloud Config**: Merkezi konfigürasyon yönetimi.
- **Sleuth ve Zipkin**: İzleme ve log yönetimi.
- **Hystrix**: Circuit breaker mekanizması.
- **API Gateway**: API yönetimi ve yönlendirme.

---

### 1. Config Server

`config-server`, tüm servisler için merkezi bir konfigürasyon yönetimi sağlar.

#### application.yml (Config Server)

```yaml
server:
  port: 8888

spring:
  cloud:
    config:
      server:
        git:
          uri: https://github.com/your-repo/config-repo
          default-label: main
```

#### Main Class

```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

---

### 2. Discovery Server (Eureka Server)

`discovery-service` mikroservislerin birbirini bulabilmesi için kullanılır.

#### application.yml (Discovery Service)

```yaml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false

spring:
  application:
    name: discovery-service
```

#### Main Class

```java
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
```

---

### 3. API Gateway

API isteklerini yönlendirmek için kullanılır.

#### application.yml (API Gateway)

```yaml
server:
  port: 8080

spring:
  application:
    name: api-gateway

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

#### Main Class

```java
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
```

---

### 4. Address-Service

Address bilgilerini yönetir.

#### application.yml (Address Service)

```yaml
server:
  port: 8081

spring:
  application:
    name: address-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

#### Address Entity

```java
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    // Getters and Setters
}
```

#### Address Repository

```java
public interface AddressRepository extends JpaRepository<Address, Long> {}
```

#### Address Controller

```java
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
```

---

### 5. Customer-Service

Müşteri bilgilerini yönetir ve `address-service` ile iletişim kurar.

#### application.yml (Customer Service)

```yaml
server:
  port: 8082

spring:
  application:
    name: customer-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

#### Customer Entity

```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    
    private Long addressId; // Address Service ID
    
    // Getters and Setters
}
```

#### Feign Client (Address Service)

```java
@FeignClient(name = "address-service")
public interface AddressClient {

    @GetMapping("/api/address/{id}")
    Address getAddressById(@PathVariable("id") Long id);
}
```

#### Customer Controller

```java
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final AddressClient addressClient;

    public CustomerController(CustomerRepository customerRepository, AddressClient addressClient) {
        this.customerRepository = customerRepository;
        this.addressClient = addressClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        Address address = addressClient.getAddressById(customer.getAddressId());

        CustomerDTO customerDTO = new CustomerDTO(customer, address);
        return ResponseEntity.ok(customerDTO);
    }
}
```

---

### 6. Zipkin ve Sleuth

`zipkin` servisini çalıştırarak log ve trace mekanizmasını etkinleştirebilirsiniz. Bunun için `zipkin-server` kullanabilir veya Docker ile Zipkin'i ayağa kaldırabilirsiniz.

#### application.yml (Zipkin ve Sleuth Konfigürasyonu)

```yaml
spring:
  zipkin:
    base-url: http://localhost:9411
  sleuth:
    sampler:
      probability: 1.0
```

---

### 7. Hystrix (Circuit Breaker)

Hystrix ile `address-service` çalışmadığında müşteri bilgilerini döndürebilmek için bir fallback mekanizması ekleyebiliriz.

```java
@FeignClient(name = "address-service", fallback = AddressClientFallback.class)
public interface AddressClient {
    @GetMapping("/api/address/{id}")
    Address getAddressById(@PathVariable("id") Long id);
}

@Component
public class AddressClientFallback implements AddressClient {
    @Override
    public Address getAddressById(Long id) {
        return new Address(); // Boş bir Address objesi döndür
    }
}
```

---

Bu örnekle Address-Service ve Customer-Service mikroservisleri tamamladık. Her serviste kullanılan tüm teknolojiler detaylı bir şekilde uygulanmıştır.