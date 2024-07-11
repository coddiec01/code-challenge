# Work Cited References

## Spring Framework Documentation

1. **@Configuration**
    - **Reference**: Spring Framework Documentation. "Spring @Configuration Annotation". Available: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
2. **@Bean**
    - **Reference**: Spring Framework Documentation. "Spring @Bean Annotation". Available: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html
3. **BCryptPasswordEncoder**
    - **Reference**: Spring Security Documentation. "BCryptPasswordEncoder". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html

## Spring Security Documentation

4. **@EnableWebFluxSecurity**
    - **Reference**: Spring Security Documentation. "EnableWebFluxSecurity". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/reactive/EnableWebFluxSecurity.html
5. **ServerHttpSecurity**
    - **Reference**: Spring Security Documentation. "ServerHttpSecurity". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/web/server/ServerHttpSecurity.html
6. **SecurityWebFilterChain**
    - **Reference**: Spring Security Documentation. "SecurityWebFilterChain". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/server/SecurityWebFilterChain.html
7. **RedirectServerAuthenticationSuccessHandler**
    - **Reference**: Spring Security Documentation. "RedirectServerAuthenticationSuccessHandler". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/server/authentication/RedirectServerAuthenticationSuccessHandler.html

## Spring OAuth2 Client Documentation

8. **ClientRegistration**
    - **Reference**: Spring Security OAuth2 Documentation. "ClientRegistration". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/registration/ClientRegistration.html
9. **InMemoryClientRegistrationRepository**
    - **Reference**: Spring Security OAuth2 Documentation. "InMemoryClientRegistrationRepository". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/registration/InMemoryClientRegistrationRepository.html
10. **ReactiveClientRegistrationRepository**
    - **Reference**: Spring Security OAuth2 Documentation. "ReactiveClientRegistrationRepository". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/registration/ReactiveClientRegistrationRepository.html
11. **ServerOAuth2AuthorizedClientRepository**
    - **Reference**: Spring Security OAuth2 Documentation. "ServerOAuth2AuthorizedClientRepository". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/web/server/ServerOAuth2AuthorizedClientRepository.html
12. **WebSessionServerOAuth2AuthorizedClientRepository**
    - **Reference**: Spring Security OAuth2 Documentation. "WebSessionServerOAuth2AuthorizedClientRepository". Available: https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/web/server/WebSessionServerOAuth2AuthorizedClientRepository.html

## Explanation and Example References

1. **@Configuration and @Bean Example**:
    - **Explanation**: The `@Configuration` annotation indicates that the class can be used by the Spring IoC container as a source of bean definitions. The `@Bean` annotation tells Spring that a method annotated with `@Bean` will return an object that should be registered as a bean in the Spring application context.
    - **Example Reference**: Baeldung. "Spring @Configuration Annotation". Available: https://www.baeldung.com/spring-configuration-annotation

2. **Spring Security WebFlux Example**:
    - **Explanation**: The `@EnableWebFluxSecurity` annotation enables Spring Security's WebFlux support. The `ServerHttpSecurity` class provides a fluent API for building a `SecurityWebFilterChain` for WebFlux.
    - **Example Reference**: Baeldung. "Spring Security for Reactive Applications". Available: https://www.baeldung.com/spring-security-reactive

3. **OAuth2 Client Registration Example**:
    - **Explanation**: `ClientRegistration` represents a client registration with an OAuth2 or OpenID Connect 1.0 Provider. `InMemoryClientRegistrationRepository` is an implementation of `ClientRegistrationRepository` that stores client registrations in-memory.
    - **Example Reference**: Baeldung. "OAuth2 Logins with Spring Security 5". Available: https://www.baeldung.com/spring-security-5-oauth2-login

# Work Cited References for the Provided Classes

This document provides detailed work cited references for the classes, annotations, imports, and CRUD cases used in your project. This list will help other developers understand the sources and documentation related to the components used.

## 1. `SecurityConfig.java`

### Annotations and Configuration:

- **@Configuration**:
   - **Reference**: Spring Framework Documentation. "Spring @Configuration Annotation". Available: [Spring @Configuration Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html)
- **@EnableWebFluxSecurity**:
   - **Reference**: Spring Security Documentation. "EnableWebFluxSecurity". Available: [EnableWebFluxSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/reactive/EnableWebFluxSecurity.html)

### Imports:

- **org.springframework.context.annotation.Bean**:
   - **Reference**: Spring Framework Documentation. "Spring @Bean Annotation". Available: [Spring @Bean Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html)
- **org.springframework.security.config.web.server.ServerHttpSecurity**:
   - **Reference**: Spring Security Documentation. "ServerHttpSecurity". Available: [ServerHttpSecurity](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/web/server/ServerHttpSecurity.html)
- **org.springframework.security.web.server.SecurityWebFilterChain**:
   - **Reference**: Spring Security Documentation. "SecurityWebFilterChain". Available: [SecurityWebFilterChain](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/server/SecurityWebFilterChain.html)
- **org.springframework.security.oauth2.client.registration.ClientRegistration**:
   - **Reference**: Spring Security OAuth2 Documentation. "ClientRegistration". Available: [ClientRegistration](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/registration/ClientRegistration.html)
- **org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository**:
   - **Reference**: Spring Security OAuth2 Documentation. "InMemoryClientRegistrationRepository". Available: [InMemoryClientRegistrationRepository](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/registration/InMemoryClientRegistrationRepository.html)
- **org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder**:
   - **Reference**: Spring Security Documentation. "BCryptPasswordEncoder". Available: [BCryptPasswordEncoder](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html)

### CRUD and OAuth2 Configuration:

- **ClientRegistrationRepository**:
   - **Reference**: Spring Security OAuth2 Documentation. "ClientRegistrationRepository". Available: [ClientRegistrationRepository](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/oauth2/client/registration/ClientRegistrationRepository.html)
- **BCryptPasswordEncoder**:
   - **Reference**: Spring Security Documentation. "BCryptPasswordEncoder". Available: [BCryptPasswordEncoder](https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html)

## 2. `ImageController.java`

### Annotations:

- **@RestController**:
   - **Reference**: Spring Framework Documentation. "Spring @RestController Annotation". Available: [Spring @RestController Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)
- **@RequestMapping**:
   - **Reference**: Spring Framework Documentation. "Spring @RequestMapping Annotation". Available: [Spring @RequestMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)

### Imports:

- **org.springframework.web.bind.annotation.GetMapping**:
   - **Reference**: Spring Framework Documentation. "Spring @GetMapping Annotation". Available: [Spring @GetMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)
- **org.springframework.web.bind.annotation.PostMapping**:
   - **Reference**: Spring Framework Documentation. "Spring @PostMapping Annotation". Available: [Spring @PostMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html)

### CRUD Operations:

- **Create (POST)**:
   - **Reference**: Spring Framework Documentation. "Spring @PostMapping Annotation". Available: [Spring @PostMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html)
- **Read (GET)**:
   - **Reference**: Spring Framework Documentation. "Spring @GetMapping Annotation". Available: [Spring @GetMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)

## 3. `UserController.java`

### Annotations:

- **@RestController**:
   - **Reference**: Spring Framework Documentation. "Spring @RestController Annotation". Available: [Spring @RestController Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)
- **@RequestMapping**:
   - **Reference**: Spring Framework Documentation. "Spring @RequestMapping Annotation". Available: [Spring @RequestMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html)

### Imports:

- **org.springframework.web.bind.annotation.GetMapping**:
   - **Reference**: Spring Framework Documentation. "Spring @GetMapping Annotation". Available: [Spring @GetMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)
- **org.springframework.web.bind.annotation.PostMapping**:
   - **Reference**: Spring Framework Documentation. "Spring @PostMapping Annotation". Available: [Spring @PostMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html)

### CRUD Operations:

- **Create (POST)**:
   - **Reference**: Spring Framework Documentation. "Spring @PostMapping Annotation". Available: [Spring @PostMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html)
- **Read (GET)**:
   - **Reference**: Spring Framework Documentation. "Spring @GetMapping Annotation". Available: [Spring @GetMapping Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html)

## 4. `Image.java` and `User.java`

### Annotations:

- **@Entity**:
   - **Reference**: Spring Data JPA Documentation. "Spring @Entity Annotation". Available: [Spring @Entity Annotation](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/domain/support/AuditingEntityListener.html)

### Imports:

- **javax.persistence.Entity**:
   - **Reference**: Java Persistence API Documentation. "javax.persistence.Entity". Available: [javax.persistence.Entity](https://docs.oracle.com/javaee/7/api/javax/persistence/Entity.html)
- **javax.persistence.Id**:
   - **Reference**: Java Persistence API Documentation. "javax.persistence.Id". Available: [javax.persistence.Id](https://docs.oracle.com/javaee/7/api/javax/persistence/Id.html)

### CRUD Operations:

- **Create and Update**:
   - **Reference**: Java Persistence API Documentation. "javax.persistence.EntityManager#persist". Available: [javax.persistence.EntityManager#persist](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html#persist-java.lang.Object-)
- **Read**:
   - **Reference**: Java Persistence API Documentation. "javax.persistence.EntityManager#find". Available: [javax.persistence.EntityManager#find](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html#find-java.lang.Class-java.lang.Object-)
- **Delete**:
   - **Reference**: Java Persistence API Documentation. "javax.persistence.EntityManager#remove". Available: [javax.persistence.EntityManager#remove](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html#remove-java.lang.Object-)

## 5. `ImageRepository.java` and `UserRepository.java`

### Annotations:

- **@Repository**:
   - **Reference**: Spring Data JPA Documentation. "Spring @Repository Annotation". Available: [Spring @Repository Annotation](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/repository/Repository.html)

### Imports:

- **org.springframework.data.jpa.repository.JpaRepository**:
   - **Reference**: Spring Data JPA Documentation. "JpaRepository Interface". Available: [JpaRepository Interface](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)

### CRUD Operations:

- **Create, Read, Update, Delete**:
   - **Reference**: Spring Data JPA Documentation. "JpaRepository Interface". Available: [JpaRepository Interface](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)

## 6. `ImageService.java`, `ImageServiceImpl.java`, `UserService.java`, `UserServiceImpl.java`

### Annotations:

- **@Service**:
   - **Reference**: Spring Framework Documentation. "Spring @Service Annotation". Available: [Spring @Service Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html)

### Imports:

- **org.springframework.stereotype.Service**:
   - **Reference**: Spring Framework Documentation. "Spring @Service Annotation". Available: [Spring @Service Annotation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html)

### CRUD Operations:

- **Create, Read, Update, Delete**:
   - **Reference**: Spring Data JPA Documentation. "JpaRepository Interface". Available: [JpaRepository Interface](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)
