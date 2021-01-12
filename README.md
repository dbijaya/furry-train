# furry-train
a SpringBoot full CRUD API in Java.

This is my new SpringBoot RESRful API development starter project. I have made some advancements in this project than in my previous project [Springboot-api-starter-project](https://github.com/dbijaya/Springboot-api-starter-project).

**Advancements:** 
- Service Components: a singleton, also called Business Service in Spring, used for write business-logic in different layers seperated from RestController class file.
- Customized Spring Boot: updates in application.properties file. Read: [Common Application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
- Dynamic: Integrated Apache Derby database (an embedded database shipped with JDK), Derby is a relational database management system written in Java.
- Spring Data JPA: with JPA help, can work with ORM tool even in easier way. Read: [Spring Data JPA](https://spring.io/projects/spring-data-jpa#overview)
- SpringBoot Deployment:
  1. in terminal: locate to your project repo.
  1. hit: `$mvn clean install`
  1. hit: `$java -jar target/<your-project-name....jar` *tab* for autocomplete.
  1. can also deploy do old *WAR* deployment model.
  now, you have your IDE undependent project.
  
- Monitoring and Management:
  1. add dependency for Spring Boot Actuator in pom.xml
  ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
   ```
  2. run: `http://127.0.0.1:8080/health`
  3. Read: [Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
  
 - Management:
  1. in application.properties, add: `management.port:9001`
  1. new run: `http://localhost:9001/health`
  1. Read: [Management over HTTP](https://docs.spring.io/spring-boot/docs/1.5.3.RELEASE/reference/html/production-ready-monitoring.html)
  
  **New Advanced Project:** : [fluffy-train](https://github.com/dbijaya/fluffy-train)
  
  ...more to go.
  
  **Wish me Luck**
