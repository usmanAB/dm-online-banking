# Spring TP 2 dm-online-banking 

Run application :  

mvn spring-boot:run



***Advisor***
***Create user :*** 

http://localhost:25001/client-management/advisor/client

Response :
{"lastName":"Usman",
"firstName":"ABID BUTT",
"phone":"0100000000",
"dateOfBirth":"01-01-1994"}



***Consult user's info by id :***
http://localhost:25001/client-management/advisor/client/1
Response  : 

{
    "id": "1",
    "lastName": "moi",
    "firstName": "test",
    "phone": null,
    "dateOfBirth": "01-01-1994"
}


***Créeate account to a user :***

http://localhost:25001/client-management/advisor/account/1

{"type":"CC",
"amount":"0"
}

The same account did'nt create (check Database)


***Create livret jeune account :***

http://localhost:25001/client-management/advisor

{"type":"LIVRETJEUNE",
"amount":"0"
}

Remarque : Impossible pour les plus de 18 ans.


***CLIENT***

***Add money to user account LDD (user id=1) with 250 € ; ***

http://localhost:25000/client-service/client/addMoney/1/250/LDD

Response : Vous avez déposé 250 €

***Add money to unauthorized account :***

http://localhost:25000/client-service/client/addMoney/1/250/LDDS

Response  : Dépôt non autorisé !


***Consult user's accounts : ***
http://localhost:25000/client-service/client/consultAccount/1

Response : 
[
    {
        "accountNumber": "1",
        "amount": "250",
        "userId": "1",
        "type": "LDD"
    },
    {
        "accountNumber": "2",
        "amount": "0",
        "userId": "1",
        "type": "LDDS"
    }
]

***consult user's history :***
http://localhost:25000/client-service/client/historyInfo/1

Response : 
[
    {
        "type": "LDD",
        "amount": "+250",
        "userId": null,
        "date": "2017-11-07"
    },
    {
        "type": "LDD",
        "amount": "+50",
        "userId": null,
        "date": "2017-11-07"
    },
    {
        "type": "LDD",
        "amount": "+50",
        "userId": null,
        "date": "2017-11-07"
    }
]


***Re-try with Advisor :*** 
***Consult user's informations :*** 
http://localhost:25001/client-management/advisor/userInfo/1 

Response : 

{
    "accountDto": [
        {
            "accountNumber": "1",
            "amount": "350",
            "userId": "1",
            "type": "LDD"
        },
        {
            "accountNumber": "2",
            "amount": "0",
            "userId": "1",
            "type": "LDDS"
        }
    ],
    "userDto": {
        "id": "1",
        "lastName": "moi",
        "firstName": "test",
        "phone": null,
        "dateOfBirth": "01-01-1994"
    }
}




# Project's  structure
  
* There are 5 modules :

* ***aspectj-aop-utils***  
* ***client-management-services***  
* ***client-models***  
* ***client-services***  
* ***data-access-service***  
 

# Class diagram

![alt text](http://image.noelshack.com/fichiers/2017/44/7/1509916792-classdiagram1.jpg) 


# Class diagram (generate by IntelliJ IDE)

<a href="http://www.noelshack.com/2017-44-7-1509916989-intellijdiagramme.png"><img src="http://image.noelshack.com/minis/2017/44/7/1509916989-intellijdiagramme.png" border="0" alt="1509916989-intellijdiagramme.png - envoi d'image avec NoelShack" title="1509916989-intellijdiagramme.png"/></a>


# Deployment diagram 


![alt text](http://image.noelshack.com/fichiers/2017/44/7/1509916792-deploymentdiagramtp2.jpg) 
