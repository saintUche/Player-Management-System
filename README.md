# Player management system 

This repository contains my deliverable for the QA Software Core - Practical Project

### Project brief 

The overall objective of the project is the following:

To create an OOP-based application with utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.
More specifically, you are required to create a full-stack web application following the enterprise architecture model:

- An application back-end developed using Java (Spring Boot framework).
- A test suite utilising JUnit and Mockito for integration and unit tests of the back-end as well as Selenium for automated front-end tests
- A managed MySQL database hosted locally or within a cloud provider examined during Cloud Fundamentals module.
- A front-end developed using JavaScript, HTML and CSS.

## APP DESIGN

UML design shows how classes are related. First the model must be defined, then the model DTO class is used to pass data in one shot from the client to the sever. The player service file contains the defined crud functions and the controller sets up the api which the user has access to. 

Got to master branch for files


The logic for the ER diagram is as follows.

![image](https://user-images.githubusercontent.com/79328765/184562508-23a6bf8b-3858-43e0-8a47-231d09b548f3.png)



A Player has an ID and attributes, the player also has information on their match data and information on their fans. 



### CI interface

In addition to the above requirements, the project required the implementation of several stages of a typical CI pipeline. These were project tracking, version control, development environment and build server. For project tracking agile was used to create a Kanban board. Story points and labels were assigned to each item. Here is a look at a the kanban board created when a sprint for item section was created.

https://github.com/saintUche/pms/blob/master/project%202%20images/jira.png

For version control, git was used, with the project repository hosted on github. Version control via git allows changes to the project to be made and committed whilst keeping the commit history for access to earlier versions. GitHub as a repository hosting service allows the repository to be stored away from the development environment, as well as providing webhooks, which send http POST requests to the build server to automate building and testing.

The Databse was in SQL and back-end programming was done in java and the build tool used was Maven.  Maven is chiefly used for Java-based projects, helping to download dependencies, which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as there may be different versions of separate packages.


### Risk assessment 

Prior to building the app, a risk assessment was undertaken to identify risks and propose measures to control these risks. These measures could then be implemented in the app. This initial risk assessment is shown below:

##rsik asssessment matrix

As this is simple program hosted on the local machine there were not many risks involved in building the program.

### Testing

Testing the ims was an essential part of the development process. Two types of testing were implemented:

Unit testing tests units of functionality (i.e functions) within the app. Unit tests were written for create, read, update and delete functionality, to ensure that these worked as intended.
Integration testing tests the function of the app in an as-live environment, being able to simulate keyboard input and mouse clicks to ensure that these elements of the app function as intended. Integration tests were written for many of the forms employed in the app.

JUnit is the testing framework that is extensively used for java projects built in the maven project format for unit testing purposes.
JUnit was used to test the DAO files and checked to see if the database queries functioned as expected. 

Mockito is a mocking framework, JAVA-based library that is used for effective unit testing of JAVA applications. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.
Mockito was used to test the controller classes and checked to see if the CRUD actions performed gave the expected outputs. 

EqualsVerifier can be used in JUnit unit tests to verify whether the contract for the equals and hashCode methods is met.
EqualsVerifier was used to test the class methods.

Selenium was also attempted but not fully complete 


![image](https://user-images.githubusercontent.com/79328765/184562540-dfab56c8-a178-405a-a226-d14c63852189.png)



### The PMS System

This is the home page.

![image](https://user-images.githubusercontent.com/79328765/184562557-a4ca12f6-8530-4500-a105-281a2ad6a685.png)


If we selected an entity for examaple players, it takes us to the players page.
Each player had buttons for crud functions 

![image](https://user-images.githubusercontent.com/79328765/184562575-c0411656-0040-4ca5-882b-576f05412b4b.png)



A pop up box opens for each crud function. Here the example is to add player.

![image](https://user-images.githubusercontent.com/79328765/184562592-b9f7e7a6-e311-4cfd-b551-b706929ed40c.png)

When the player is added it shows up on the screen
![image](https://user-images.githubusercontent.com/79328765/184562599-4c21e89c-706d-4f5b-9035-b7f13c8bd22c.png)


### Note
The only crud methods that work are get all and create. I had diffculties impelementing the others

## Links 

* **Jira** - https://ucheegbon.atlassian.net/jira/software/projects/IMS2/settings/details

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Springboot](https://spring.io/projects/spring-boot) 

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Uche Egbon** 

