# Email-validator
A web service that accepts http requests and returns responses based on a validation condition.


## Description
This is a spring boot web service that takes a http request containing a list of email ids as input and provide the count of the unique email ids as output.

The conditions for unique email ids are 
1) The placement of '.' in the username has to be ignored.
2) Any portion after '+' has to be ignored.


## Installation

1) To run the project, java has to be installed locally.
2) Maven is used for build automation. Installing maven is a straight forward. Please follow the instruction given in this official [url]( https://maven.apache.org/install.html).
3) Optional (Any integrated development environment) preferrably eclipse.



## To run the project

The project has been configured to run in multiple ways.

**Note** The service uses port number 8080. This can be configured by changing the value of the port number in application.properties file.


#### Method 1 - Using command prompt

1) Open command prompt navigate to the cloned folder.

2) In the command prompt, type the command `maven clean install`. This will install all the dependencies as well as run the Junit test cases.

3) In the command prompt, type the command `mvn package` to package the content as a jar file.

4) After successful run of the previous command, a new **target** folder with multiple files would be created.

5) A jar file in the name similar to `emailvalidator-0.0.1-SNAPSHOT-spring-boot.jar` would be created.

6) This jar file can be run like a normal jar file using the command `java -jar emailvalidator-0.0.1-SNAPSHOT-spring-boot.jar`. 

I have attached my jar file which can be found under [releases](https://github.com/adhithyakrishna/email-validator/releases/tag/releases).


#### Method 2 - Using IDE

1) Import the project into the eclipse or any other ide that is capable of running a java application.

2) In the command prompt, type the command `maven clean install`. This will install all the dependencies as well as run the Junit test cases.

3) Embedded tomcat is added as one of the dependency. So, this project can be run as a normal java application.

4) To run as a Java application, the run configuration has to be setup with the main class pointing to `com.validator.EmailValidator`.

5) After the configuration is done. This project can be run as a normal java application.


### Making calls to the service

The call accepts application/json as the content type and makes use of post request at the url **http://localhost:8080/countemails**. I have attached the curl command for your reference.


The postman collection for this call can be found [here](https://www.getpostman.com/collections/8fa531d5709fa94ce5e1)

Please find the curl command for reference

```
curl --location --request POST 'localhost:8080/countemails' \
--header 'Content-Type: application/json' \
--data-raw '{
    "input": ["test.email@gmail.com", "test.email+spam@gmail.com", "testemaile@gmail.com","test............email@gmail.com"]
}'
```

Please find the javascript code for reference

```javascript
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({"input":["test.email@gmail.com","test.email+spam@gmail.com","testemaile@gmail.com","test............email@gmail.com","test............email+iiiiiiiiiiiiiiiii@gmail.com"]});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("localhost:8080/countemails", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
```


### To add and run Junit tests

1) Add new test cases to the EmailValidatorTest.java file inside of the com.validator.test package under the src/test/java folder.

2) Tests can be run independently without starting up the service using `mvn clean test` command.