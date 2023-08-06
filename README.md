# About Microservices

Microservices are an architectural way of software development where the application is divided into small components (service). It allows the application to break into small parts which helps in solving debugging issues. Thus, it saves from crashing the entire system as you've to just focus on the small component.

## AcademyEureka-Microservices
This project divides a single application into 4 individual components(services) which implement CRUD operations on 4 corresponding tables in MYSQL database, thereby developing and working on those 4 components(services) separately without having to depend on each other, thus implementing Microservices Architecture.





### Detailed Description

As you can see, there are in total 6 individual spring boot applications, each configured to run on different ports. 4 of these (courseservice,facutlyservice,feeservice,studentservice) will create 4 tables respectively in MY SQL db when started.

"discoveryservice" is a Eureka server application that holds information about all client-service applications. Every Microservice (courseservice,facutlyservice,feeservice,studentservice) will register into the Eureka server and the Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server. 

