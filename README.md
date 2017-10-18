# Spring TP dm-online-banking

Run application :  

Step 1 : 
- Download the project
- Extract files

Step 2 :
- run : "mvn package" from root directory 
- run : "mvn spring-boot:run" from root directory

Step 3 :  
Send a request from a client (postman or navigator):

For example : 
http://localhost:8090/client/getall

Step 4 :  
Observe log console 


# Project's  structure
  
There's a ***dm-online-banking*** project with only one module :
  
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

# Deployment diagram (of components)

https://image.noelshack.com/fichiers/2017/42/3/1508346376-deploymentdiagram1.jpg
 
