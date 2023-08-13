# springboot-crud-demo
Simple Springboot Crud Demo
Spring Boot CRUD demo is demonstrating how to implement simple CRUD operations

# what's inside
Use below packages

1.Maven

2.Spring Web

3.Spring Data JPA

4.MySQL Driver

5.Lombok

# DB configuration
Change application.properties as below

<code>spring.datasource.url=jdbc:mysql://localhost:3306/ems?useSSL=false
spring.datasource.username=root
spring.datasource.password=password</code>

!*--create sql and execute sql as per the database--
<code>spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect</code>

!*--Will update the existing table data-- when the deployment update should validate or create
<code>spring.jpa.hibernate.ddl-auto = update</code>
