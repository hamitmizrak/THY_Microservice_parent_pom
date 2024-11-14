# Pom Root Microservice
[]()
---

## Maven Project
```sh
mvn archetype:generate -DgroupId=com.hamitmizrak.microservice -DartifactId=parent_pom -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
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


## Api Gateway
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


## 
```sh

```
---
