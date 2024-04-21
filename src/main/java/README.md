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

- @Entity(name = "shows") means irrespective of the model class name, it will be mapped to shows table in sql; because show is a key word in MySQL you cannot create table/col with it

- in Show class this line //import com.fasterxml.jackson.annotation.JsonFormat.Features; is throwing some error

- in Show class if @Entity(name = "shows") if name = "shows" removed sql table creation fails, but why not in othe classes. is it due to 

On Booking show summary view to the user ask confirmation and then gofor payment
-- proper user interface
-- may be block the items/seats until payment is successful or failure, so that other users cannot use the same seats
-- for one user summary page will open and for other not when booking seats if same seats are tried by those two users and 
-- at selection same seats are allowed to be selected by two users but no summary page for one user
-- alternatively, if you think you will allow both users to goto the payment with same seats, every payment there is a cut to the 3rd party and you loose money, user may not want to loose it if payment fails or reimbursed later 

Avoid same time writing in dB using Transactions
- Book My Show: when user clicks Book Now after selecting seats, start Transaction(serializable isolation level) proper consistency of isloation level lock 
- a lock will be taken on the rows

-- but after user starts the transaction, a db lock for such a long duration of payment success with 3rd party is not good design

add a column in dB for status and fill it and for every write from app, check the status and then proceed; for other user sorry something went wrong message

SOFT LOCKING - use status column of dB
seat status available -> blocked -> booked; one show completion make all seats available
when marked blocked, a job will run and after 15 mts and if not changed to booked then make them available

Soft Locking means you are not using java concurrent features like ReentrantLoc lock/unlock or synchronized and critical section handling; you are simply using the status column in dB and based on current status act further

pseudo code
function book(showSeatIDs) {
 1. dB Transaction lock on those seat id rows to mark status as blocked - serialization isolation level
 2. I will not directly update the status to blocked but check them for availabilotu first and then block for this user current booking
    2.1 even if one seat is not available to block, you stop the process and go back
3. if all seats are available, block them
4. end the dB transaction now
    
}

## ANNOTATIONS
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    
    //primary key for subclass like Booking
    //requires @Id annotation
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdAt;
    private Date updatedAt;
}


@Enumerated(EnumType.ORDINAL)
    @ElementCollection 
    //the above line makes a mapping table so that one Screen id and many rows of ENUM feature names mapped to it in sql table
    //one screen many features (Feature is a ENUM)
    //ENUM are not entities so @ElementCollection
	private List<Feature> features;
	
	
### Issues with JPA SQL Table creation
- row, order like class names or column names are not working because they are sql key words; use @Entity(name="orders"); orders with s is not a keyword
- forgot to add cardinality annotation in Item for ItemCategory and StorageLocation, 
- forgot to extend BaseModel


### Hibernate
- Hibernate produces new mapping table for OneToMany relationships, which is actually not required
- you can add primary key of one table as foreign key in another table, how to handle that
@OneToMany(mappedby="booking")
- the reason Hibernate doing what it is doing is due to the fact you may keep NULL; but if you no Null possible, you dont need a mapping table for OneToMany or ManyToOne cardinality

Four Options for cardinality
@OneToOne : any column can be placed in any sql table 

@OneToMany : One side column as foreign key should be put into the Many side table 
-- payment table will be keeping booking id

@ManyToOne : same as above

@ManyToMany : you need a separate new mapping table in sql (junction table)
----------------------------------------------------------------------------
DTO
: recording Code Parking Lot 1 1.30 minute starts on DTO

in parking lot app, 
public class TokentController {
    //method
	issueToken(Gate gate, Vehicle vehicle, Operator operator) {
		//lets say later you want to add a mandatory param int xyz, all calls to issueToken will fail
		//may be you need to pass more optional params
		
		//so not a good idea just to add list of params in here, which are sent from Client
		//instead use DTO : Data Transfer Object
		//you are not passing params one by one but creatin an object for that
		
		so in java project structure add dtos as folder
		and create a class
		
		public class IssueTokenRequestDTO {
			private int vehicleId;
			private int getId;
			private int operatorId;
			
		}
		
		now in TokenController class method
		issueToken(IssueTokenRequestDTO issueTokenRequestDTO) {
		
		}
		
		//**********************
		
		DTO need not be exact replica of my controller object for data
		for example there can be a DTO only for user email 
		instead of 10 other user parameters
		so that you can pass that DTO where only user email is required
		
		
	}
}
--------------------------------------------------------------------------------------
models
 - sql tables
repositories (Code Parking Lot 2 recoding 54th minute)
-- in parking lot app, you have gateId, you need to get the Gate object, data from dB
services do not directly interact with dB
intermediary : repository
GateRepository for example to get Gate data from dB whcih can be used in services


Feature Implementation
- controller folder
- dtos folder
-- dtos are for taking data inputs either from user or from somewhere else and dto objects are passed as data to controller methods (instead of having individual method params)

-- services
 - this is the place where actually the ticket will be booked BookTicketService
 - bookTicket() level @Transactional(isolation = Isolation.SERIALIZABLE)
 - until bookTicket method runs, db transaction on
 

repositories
-- interface used
-- public interface UserRepository extend JpaRepository<User, Integer> {
- Jpa and Hibernate will get you all user data for given user id

in  a service, (BookingService for example: once you decide sequence of actions
if dB is involved
JpaRepositories 

once logic is done, you have to save the data to dB
likst Show Seat status, booking data ...

@Controller - one controller object created by Spring boot
@Service - Book ticket service object created by Spring boot; because you dont need them moew than one

@Autowired; auto injected by Spring Boot of @Controller, @Service objects into respective constructors

@Repository annotation for repository classes

@Transactional(isolation = Isolation.SERIALIZABLE)


## Booking Amount calc

-- in BookingService 100 as amount hard coded
-- but based on Show, Seat Type and Price Per seat and number of seats, you have to calc booking amount

-- in services- BookingService, I have showSeats available
-- for all the Show Seats objects you have Seat, from Seat you get Seat Type - using Seat Type reach ShowSeatType object 
-- find showSeatType using show
-- using show, get Seat
-- but seat does not have price
-- ShowSeatType has price
- so now using show, and found seat type, get the price x with number of seats

-- you will need showSeatType using show - so ShowSeatTypeRepository
-- SELECT * FROM ShowSeatType WHERE show = ?

controller - dto - service - repository

## Attempt - 2:
controller calls service to get a specific service done; controller is only request - response management object

the service request generally should retunr a object, in ticket BookingService, it returns  a Booking object

Workflow:
 When I click Book (tickets) that means, 
  - I have already selected my show, seat types and seats
  - system knows my user id
  - showSeatIds, showId, userId is available from me (Client) to the backend controller logic to handle the booking request
   - what is handling the booking request means
    - you have to check availability of those requested seats, 
    - calculate the amount
    - show the summary page to user
    - on confirmation, direct the user to payment gateway
    - on payment success, mark the seats booked, 
    - return booking id and details to user (response object in controller will receive the return from service object)

      - from request object you get input data (one or more) - its a dto
      - on response object you set results (one or more) - its a dto


    - in the service, @Transactional at method level, service is inside the transaction; not only the dB ops
       -- later lets learn how to do transaction only for steps inside the method
    
    when you want data from dB or you want to save data to dB (any CRUD ops), you need to set JPA Repositories interfaces in your project ; your interface will extend JpaRepository<User, Integer> interface provided by Spring Boot;l Integer here is primary key of your dB table for User, and User is the db model object, one user table row from dB (even after complex joins when required)
    
    controller engages service object
    service engages dto and repository objects
    
    JPA Repository interface has findById kind of method and when you find a user by passed Id, it should return a User object (id, name, email....)
    but instead of direct user object, it returns an Optional, Optional<user> just to handle null responses; this is more so when individual user object is expected which may return null
    but if you are expecting a list of items, Optional may be not required because empty list [] is a valid object and NullPointerException may not be thrown
    
    
BookingController - only request - response handler
DTOs like BookTicketRequestDTO and BookTicketResponstDTO are Data Transfer Object



