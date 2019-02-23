# RestEmployeeService

Test Employee Service using AWS RDS and EC2, Spring boot, Java 8, MySql, HATEOAS, Basic Auth and Gradle


## Project Structure
RestEmployeeService is the project itself

RestEmployeeClient is the module that **contains the application**


#### RestEmployeeClient.
+ Data is stored in a MySql:5.7 DB stored in [AWS] (https://console.aws.amazon.com/rds)
+ Gradle 4.10 is used for dependency management
+ Spring boot 2.1.3 as Framework

## This client lives in an AWS EC2 instance:
- [EC2 Api Documentation](http://ec2-3-82-9-122.compute-1.amazonaws.com:8080/swagger-ui.html) 
- Please Run AWS Hosted Employee Client with post man  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/936b23b53242c427fb16)

## Do you want to run it locally? follow next steps :)

## How to Run
- inside project folder run:

        $ ./gradlew RestEmployeeClient:bootRun

## How to Package
- inside project folder run:

        $ ./gradlew RestEmployeeClient:bootJar

- You will find the jar inside RestEmployeeClient/build/libs folder

## How to Run packaged jar

    java -jar <file>.jar

## How to Use the Application (LocalHost)
- After server is running, click here for [Documentation](http://localhost:8080/swagger-ui.html)

#### A post man collection has been provided to use this application on localhost
- [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/83df8c13886b24818010)
- Basic Auth credentials are already in the Postman Collection

## Using Jetbrains Idea Intellij IDE
- This project was built using intellij, if you want to open it in this IDE and build it please:
  - [Activate Annotation Processors](https://stackoverflow.com/questions/38911888/lombok-requires-annotation-processing/43379786)
