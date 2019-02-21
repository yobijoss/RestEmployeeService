# RestEmployeeService

Test Employee Service using Spring boot, Java 8, MySql, HATEOAS, Basic Auth and Gradle


## Project Structure
RestEmployeeService is the project itself

RestEmployeeClient is the module that **contains the application**


#### RestEmployeeClient.
+ Data is stored in a MySql:5.7 DB stored in [AWS] (https://console.aws.amazon.com/rds)
+ Gradle 4.10 is used for dependency management
+ Spring boot 2.1.3 as Framework


## How to Run
- inside project folder run:

        $ ./gradlew RestEmployeeClient:bootRun

## How to Use
- After server is running, click here for [Documentation](http://localhost:8080/swagger-ui.html)

## Using Jetbrains Idea Intellij IDE
- This project was built using intellij, if you want to open it in this IDE and build it please:
  - [Activate Annotation Processors](https://stackoverflow.com/questions/38911888/lombok-requires-annotation-processing/43379786)

