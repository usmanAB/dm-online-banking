# Spring TP dm-online-banking

Run application : 
Step 1 : 
- Download the project
- Extract files
Step 2 :
- run : "mvn package" from root folder
- run : "mvn spring-boot:run" from root folder
Step 3 : 
Send a request from a client (postman or navigator):
For example : 
http://localhost:8090/client/getall

Step 4 : Observe log console 


This project is a tutorial for people who learn Maven multi-modules projects.  
  
There's a ***dm-online-banking*** project with a module :
  
* ***client-management-services***  

This module contains ***fr.usman.client.business*** package composed 6 packages : 

* ***aspect***  

This package contains MyAspect Class to trace and inspect http requests from Controller

* ***controllers***  
This package contains UserController Class.

* ***models***  
This package contains UserDto Class.

* ***repositories***  
This package contains IClientService Interface.

* ***services***  
This package contains ClientService Class.

* ***utils***  
Empty package (to respect rules....)

 
