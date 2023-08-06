# About Microservices

Microservices are an architectural way of software development where the application is divided into small components (service). It allows the application to break into small parts which helps in solving debugging issues. Thus, it saves from crashing the entire system as you've to just focus on the small component.

# About this project
This project divides a single application into 4 individual components(services) which implement CRUD operations on MY SQL database, thereby developing and working on those 4 components(services) separately without having to depend on each other, thus implementing Microservices Architecture.

As you can see, there are in total 6 individual spring boot applications configured to run on different ports. 4 of these (courseservice,facutlyservice,feeservice,studentservice) will create 4 tables respectively in MY SQL db when started.

