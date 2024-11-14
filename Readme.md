# Pom Root Microservice
[]()
---

## Maven Project
```sh
mvn archetype:generate -DgroupId=com.hamitmizrak.microservice -DartifactId=parent_pom -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
---

## Maven Project
```sh
git rm -r --cached address-service
git add address-service
git commit -m "Re-add address-service directory"
git push origin master
git push origin master --force
git push origin master -f
```
---



| Spring Boot Sürümü | Spring Cloud Sürümü (Release Train) |
|--------------------|------------------------------------|
| 2.4.x              | 2020.0.x (Kod adı: Ilford)         |
| 2.5.x - 2.7.x      | 2021.x (Kod adı: Jubilee)          |
| 3.0.x - 3.2.x      | 2022.x (Kod adı: Kilburn)          |
| 3.3.x ve sonrası   | 2023.x ve sonrası                  |


## Parent Root Pom
```sh
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

  <!--modelVersion-->
  <modelVersion>4.0.0</modelVersion>

  <!--parent root pom icin bunlar cok önemli-->
  <!--alt sınıflarda <parent></parent> iceriğine aşağıdakiler yazılır-->
  <groupId>com.hamitmizrak.microservice</groupId>
  <artifactId>parent_pom</artifactId>
  <version>1.0.0</version>
  <packaging>pom</packaging>

  <!-- servislerimi buraya ekleyecegim-->
  <modules></modules>

  <!--properties-->
  <properties>
    <java.version>17</java.version>
    <spring.boot.version>3.1.1</spring.boot.version>
    <spring-cloud.version>2022.0.3</spring-cloud.version>
    <spring.cloud.config.enabled>true</spring.cloud.config.enabled>
  </properties>

  <!--dependencyManagement-->
  <dependencyManagement>
    <!--spring.boot.version-->
    <dependencies>
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>${spring.boot.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>

     <!-- spring-cloud-dependencies-->
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>


  <!--dependencies-->
  <dependencies>

    <!--spring-boot-starter-web-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!--actuator-->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!--Eureka Client-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>

    <!--Config Client-->
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
  </dependencies>

  <!--build-->
  <build>
    <plugins>

      <!--spring-boot-maven icin cok gerekli-->
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>

```
---


## address-service github sadece link olarak geliyor ve tıklayamıyorsam hatası ve çözümü
```sh

```
---

Bu durumda, `address-service` klasörüne tıklayamamanızın birkaç olası nedeni olabilir. Bu sorunu çözmek için aşağıdaki yöntemleri deneyebilirsiniz:

### Olası Sebepler ve Çözümler:

1. **Klasörün İçeriği Boşsa:**
   Eğer `address-service` klasörünün içinde herhangi bir dosya yoksa, GitHub bu klasöre tıklamanıza izin vermiyor olabilir. `address-service` klasörüne dosya eklediğinizden emin olun ve tekrar kontrol edin.

2. **Git Ignore Ayarları:**
   `.gitignore` dosyanızda `address-service` klasörüne veya içindeki dosyalara yönelik bir kural eklenmiş olabilir. Bu durumda, `address-service` klasörü ve içeriği GitHub'a yüklenmez.
    - `.gitignore` dosyanızı kontrol edin ve `address-service` klasörünün ya da içindeki dosyaların eklenmesini engelleyen bir satır olup olmadığını kontrol edin. Eğer varsa bu satırı silin ve değişiklikleri tekrar commit edip push yapın.

3. **Commit ve Push Eksikliği:**
   Klasör oluşturulmuş, ancak içerik commit edilmemiş veya GitHub'a push edilmemiş olabilir. `address-service` klasöründeki dosyaların commit edildiğinden ve ardından GitHub'a push yapıldığından emin olun:
   ```sh
   git add address-service/*
   git commit -m "Added files to address-service"
   git push origin master
   ```

4. **Git Cache Temizleme:**
   Eğer `.gitignore` dosyasında değişiklik yaptıysanız ve önceden ignore edilen dosyalar hala gözükmüyorsa, Git cache'i temizleyip tekrar eklemeniz gerekebilir:
   ```sh
   git rm -r --cached address-service
   git add address-service
   git commit -m "Re-add address-service directory"
   git push origin master
   ```

5. **GitHub Güncellemeleri:**
   Bazen tarayıcı veya GitHub'ın kendisi kaynaklı bir sorun olabilir. Tarayıcı önbelleğini temizlemeyi veya başka bir tarayıcı kullanarak sayfayı kontrol etmeyi deneyin.

6. **Yeniden Dosya Eklemek:**
   `address-service` klasörünü tamamen kaldırıp yeniden ekleyebilirsiniz. Klasörü silip tekrar oluşturun ve dosyaları tekrar commit ve push yapın.

Eğer yukarıdaki adımlarla sorununuzu çözemezseniz, terminal üzerinden klasörün içeriğini kontrol edip klasörün doğru şekilde versiyon kontrolüne dahil edilip edilmediğini görmek faydalı olabilir.


## 
```sh

```
---


## 
```sh

```
---


## 
```sh

```
---
