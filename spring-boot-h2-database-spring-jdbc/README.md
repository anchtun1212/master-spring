# JDBC URL configuration:

   By default when you open this URL: http://localhost:8080/h2-console
   
   ```sh
   JDBC URL: jdbc:h2:~/test
   ```

   So you need to change it with the value of: `spring.datasource.url` that exists in your application.properties

   In our case: `jdbc:h2:mem:testdb`

   Then test your connection
   
# In this project:

1- Configure and use H2 database

2- Using JdbcTemplate
   