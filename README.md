# Email-validator
A web service that accepts http requests and returns responses based on a validation condition.


## Description
This is a spring boot web service that takes a http request containing a list of email ids as input and provide the count of the unique email ids as output.

The conditions for unique email ids are 
1) The placement of '.' in the username has to be ignored.
2) Any portion after '+' has to be ignored.


## Installation

1) To run the project, java has to be installed locally.
2) Maven is used for build automation. Installing maven is a straight forward task. Please follow the instruction given in this official [url]( https://maven.apache.org/install.html).
3) Optional (Any integrated development environment) preferrably eclipse.



## To run a project

The project has been configured to run in multiple ways.


#### Method 1 - Using command prompt

1) Open command prompt navigate to the cloned folder.

2) In the command prompt, type the command `maven clean install`. This will install all the dependencies as well as run the Junit test cases.

3) In the command prompt, type the command `mvn package` to package the content as a jar file.

4) After successful run of the previous command, a new **target** folder with multiple files would be created.

5) A jar file in the name similar to `emailvalidator-0.0.1-SNAPSHOT-spring-boot.jar` would be created.

6) This jar file can be run like a normal jar file using the command `java -jar emailvalidator-0.0.1-SNAPSHOT-spring-boot.jar`


#### Method 2 - Using ide

1) Import the project into the eclipse or any other ide that is capable of running a java application.

2) In the command prompt, type the command `maven clean install`. This will install all the dependencies as well as run the Junit test cases.

3) Embedded tomcat is added as one of the dependency. So, this project can be run as a normal java application.

4) To run as a Java application, the run configuration has to be setup with the main class pointing to `com.validator.EmailValidator`.

5) After the configuration is done. This project can be run as a normal java application.