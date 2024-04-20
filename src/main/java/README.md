# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql.jdbc)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

# Scaler Notes
https://hibernate.org/
https://www.baeldung.com/intro-to-project-lombok 
https://start.spring.io/
https://github.com/MohitSharma-dev/BookmyshowApr23


5 dependencies from Scaler session 
spring-boot-devtools
lombok; Ramki - @Getter @Setter annotations
spring-boot-configuration-processor; Ramki - application.properties 
mysql-connector-j
spring-boot-starter-data-jpa

lombok was not showing .get or .set autocompletion
so goto Maven Dependencies in your folder structure, right click on lombok jar file and Run As java application and selecct eclipse.ext and install
once installation is successful save your files and close eclipse and re-open
it took couple of iterations for me
LOMBOK Issue
//for lombok to work after dependencies are done in sprint.io
//got0 C:\Users\Ramkrishnan S\.m2\repository\org\projectlombok\lombok\1.18.30>
//java -jar .\lombok-1.18.30.jar
//restart eclipse and
//right click on your projecct name scaler_bms and Run As maven clean
@Getter
@Setter

//to let Hibernate know that this int id is used 
//in all child classes as primary key
//MappedSuperClass means, all these attributes should be separately added as columns in each sql table
//


Step 1:
- Goto package com.ramki.bookmyshow and create New - Folder (it will create it as a package in Eclipse) - com.ramki.bookmyshow.models
- Create all model classes like Region, Theater, Show, User, Booking, Payment....

Step 2: 
- https://hibernate.org/
- ORM : Object Relation Mapping - Hibernate 
- model class  to sql table
- Hiberntate helps to create table using Java Spring JPA

- Model Class to table by @Entity annotation

- @MappedSuperClass and @ID in BaseModel class, @Entity in individual child classes sets BaseModel id attribute as primary key in all tables and also makes all BaseModel attributes as columns in sql table

- Cardinality setting between Booking and User for example 
- @ManyToOne in Booking Class

- @Entity(name = "shows") means irrespective of the model class name, it will be mapped to shows table in sql

- in Show class this line //import com.fasterxml.jackson.annotation.JsonFormat.Features; is throwing some error

- in Show class if @Entity(name = "shows") if name = "shows" removed sql table creation fails, but why not in othe classes. is it due to 

### Issues with JPA SQL Table creation
- row, order like class names or column names are not working because they are sql key words; use @Entity(name="orders"); orders with s is not a keyword
- forgot to add cardinality annotation in Item for ItemCategory and StorageLocation, 
- forgot to extend BaseModel

