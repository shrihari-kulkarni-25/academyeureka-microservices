# About Microservices

------------ Microservices are an architectural way of software development where the application is divided into small components (service). It allows the application to break into small parts which helps in solving debugging issues. Thus, it saves from crashing the entire system as you have to just focus on the small component.

## AcademyEureka-Microservices
* This project divides a single application into 4 individual components(micro-services) namely courseservice, facutlyservice, feeservice, studentservice.
* These 4 micro-services implement CRUD operations on 4 corresponding tables in the MYSQL database.
* Thereby developing and working on those 4 components(services) separately without having to depend on each other.
* Thus implementing Microservices Architecture. Also, this project implements circuit breaker using Hysterix.


### Detailed Description

### -------------------------------------------------------------------------------------------------------


As you can see, there are in total 6 individual spring boot applications, each configured to run on different ports. Four (courseservice, facutlyservice, feeservice, studentservice) of these are individual micro-services that implement CRUD operations on respective tables in MYSQL DB, and information about the rest 2 is given below. 



### discoveryservice 
   This is a Eureka server application that holds information about all client-service applications. Every Microservice (courseservice, facutlyservice, feeservice, studentservice) will register into the Eureka server and the Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.


### StudentFacultyCourseFeeService
This is an another individual spring-boot application that communicates with all 4 micro-services that are running on different ports. This is achieved by using Feign-Client.



# Usage

Note: Make sure that "discoveryservice" is started first always so that the rest of the micro-services can register themselves when they are started.


Start the applications in the following order:
1) discoveryservice
2) courseservice
3) facutlyservice
4) feeservice
5) studentservice
6) StudentFacultyCourseFeeService
