package com.hamitmizrak.customerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
// @EntityScan(basePackages = "com.hamitmizrak.data.entity") //Entity bulamadığı zaman
// @EnableJpaRepositories(basePackages = "com.hamitmizrak.data.repository") //Repository bulamadığı zaman
// @ComponentScan("com")

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching

// Auditing Aktif etmek
 @EnableJpaAuditing(auditorAwareRef = "auditingAwareBeanMethod")

// Spring Security: Şimdilik dahil etme, çünkü Bcrypted kullancağım ancak Spring security için gerekli kütüphaneleri dahil
// Buradaki exclude ne zaman kapatmam gerekiyor ? cevap: Spring Security ile çalıştığımız zaman kapat
@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

// Microservice
@EnableDiscoveryClient
/*@SpringBootApplication*/
 @RestController
public class CustomerServiceApplication {

	// application.properties içindeki customer.default değerini inject ediyoruz
	@Value("${customer.default}")
	private String defaultCustomer;

	// http://localhost:2222/api/customer
	// Adresi döndüren bir GET endpoint tanımlıyoruz
	@GetMapping("/api/customer")
	public String getDefaultCustomer() {
		return defaultCustomer;
	}


	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
