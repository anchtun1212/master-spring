# REST services location:

/src/main/java/com/anchtun/rest

# We can build REST services by two ways:

1- Spring MVC style: @Controller + @ResponseBody

2- @RestController (recommended)

# After restarting the server:

Please save some data in `contact_msg` table then click on the link bellow in order to consume this endpoint:

http://localhost:8080/api/contact/getMessageByStatus?status=OPEN

# You can consume the endpoints using Postman

1- Install postman.

2- Add the endpoint to consume. Example: http://localhost:8080/api/contact/getMessageByStatus?status=OPEN (GET).

3- Choose `Basic Auth` as `Authorization` and enter the `username` and `password` then call the endpoint.

# Important:

- `@RestController`: can be used to put on top of a call. This will save developers from mentioning @ResponseBody on each 
                       method.
- `@ResponseBody`: can be used on top of a method to build a REST API when we are using @Controller on top of a Java class.
- `ResponseEntity<T>`: Allow developers to send response body status, and headers on the HTTP response.
- `RequestEntity<T>`: Allow developers to receive the request body, header in a HTTP request.
- `@RequestHeader & @RequestBody`: is used to receive the request body and header individually.
- `@RestControllerAdvice`: is used to mark the class as a REST controller advice. Along with @ExceptionHandler, this can be 
                              used to handle exceptions globally inside app.

# In this project:

1- Build REST services using Spring MVC style.

2- Build REST services using @RestController.

3- Implement global error logic for REST services using @RestControllerAdvice.

4- CORS (CROSS-ORIGIN RESOURCE SHARING).

5- Sending response on XML format.

6- Use @JsonIgnore and @JsonIgnoreProperties.

7- Spring Data REST.

8- HAL explorer.

9- @RepositoryRestResource annotation.

10- Logging.

11- Properties configuration and Profiles.

12- Spring boot Actuator.


# Profile

- We will activate the `prod` profile using: Java System property way (best way and automatic).

- So go to the folder where exists the pom.xml.

- run this command: ```mvn clean install -Dmaven.test.skip=true```  will skip unit test just to generate the jar quickly.

- The jar should be generated under target folder (this jar have embedded tomcat server so we can deploy this jar).

- Will run this jar by running this command: ```mvn spring-boot:run "-Dspring-boot.run.profiles=prod"``` 

# Note:

- All REST services was consumed using `Postman`.

- Don't forgot to add `Authorization`: `Basic Auth` in order to consume REST services.

- You can run both this project and `consuming-rest-services` project in order to consume REST services using Java.

- Please refer to this documentation in order to consume REST service:

  [https://documenter.getpostman.com/view/5600930/Uz5Dobw5](https://documenter.getpostman.com/view/5600930/Uz5Dobw5)
 
 - Once you add spring data rest starter, run the application to check REST APIs exposed by Spring Data REST, so open this link:
 
   [http://localhost:8080/anchtun-api/profile](http://localhost:8080/anchtun-api/profile)
   
 - HAL(Hypertext Application Language) will make your API explorable (make you API easier to work)  so please open:
 
   [http://localhost:8080/anchtun-api](http://localhost:8080/anchtun-api)
   
 - To check APIs for search you can simply add '/search' like this:
 
   [http://localhost:8080/anchtun-api/courses/search](http://localhost:8080/anchtun-api/courses/search)
   
 - To check profiles works well please check the log and see if the queries are shown/formatted: spring.jpa.show-sql and 
 
   spring.jpa.properties.hibernate.format_sql.
 
 - To check spring boot Actuator please login then open this link:
 
   [http://localhost:8080/actuator](http://localhost:8080/actuator)
 
 - By default Actuator doesn't expose many of the endpoints since they have sensitive information. We can expose them using the 
 
   this property: `management.endpoints.web.exposure.include=*`, we add this property only for `prod` profile.    
 
 