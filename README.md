# QA-BAE12 Project 1: Full stack CRUD functionality

## Contents
1.	Resources
2.	Scope
3.	Jira Board
4.	Data Stack
5.	Front-end
6.	Testing


## Resources
•	PowerPoint (https://1drv.ms/p/s!AiYMu6X1C5XjiypDT1IT5Rn5uqBK?e=fUeK7N) 
•	Jira Board (https://test-jira11.atlassian.net/jira/software/projects/BOOT/boards/2/roadmap) 

## Scope
To create a fully functional CRUD application encompassing fully functional front and back ends. The CRUD application will be built utilising the supporting tools, methodologies and technologies that encapsulate the concepts covered during the training.
The project includes:
•	Project Management (Jira Board + Version Control)
•	Databases
•	JAVA
•	Spring Boot
•	HTML + CSS + JAVASCRIPT
•	Back-end testing (Junit and Mockito)
•	A brush with Selenium 

## Jira Board
My Jira board for the project is linked above – it contains examples of user stories, smart commits, a Kanban board and a couple of linked Git repositories.


Jira Board:

![image](https://user-images.githubusercontent.com/86298693/127569227-6e20316c-4c7e-4392-8193-98f3450f4021.png)

Smart Commit:

![image](https://user-images.githubusercontent.com/86298693/127569274-6c7f8f18-36ae-4bc4-a7c2-053bb7061f4e.png)

## Database
I used one persistent SQL database and a local H2 Console that create-drops a new table for each test. Using a local database lets each integration test be run simultaneously and independently from different versions of a pre-created H2 database. A MYSQL database has been used for data persistence. 

## Backend
The back end is powered by Java using the Spring Boot Framework. This allows the database, back-end and front-end to be easily connected via some local host shenanigans. The back-end has the CRUD mapping logic for the HTTP requests and allows the front-end to access the DB and work with the data there.

## Front-end
My front end is written in HTML and JavaScript with the occasional interaction with CSS to create some potentially hostile web architecture that utilises the Bootstrap framework to fine tune the layout of the web page. There is also a toggleable list feature and forms for Post and Update functions. JavaScript connects the website to the HTTP requests in Spring to allow users to edit the database via the front-end.

### Pictures

Home:

![image](https://user-images.githubusercontent.com/86298693/127574054-01679ae5-e7f3-4121-a8fb-a88d63e40f82.png)

Create Page:

![image](https://user-images.githubusercontent.com/86298693/127574125-0a7c8470-928e-450d-a1e6-eca9ad2db3ed.png)

The Great Spice List:

![image](https://user-images.githubusercontent.com/86298693/127574237-acb8cbe6-8142-457f-a03c-8d790e977628.png)



## Testing
The back-end has integration testing for full CRUD functionality and Mockito unit testing for each HTTP request method.
An attempt has also been made at automated web testing for the front-end via Selenium – this technically works but is of somewhat limited value as it tests primarily for alerts that can technically work while CRUD functionality is broken provided it breaks in such a way as to not upset the JavaScript function.

## Further work to be done/ stretch goals
1.	Finish Selenium testing – my working for more elegant methods is included but not functioning.
2.	Add secondary table and DoM 
3.	More sophisticated exception handling – passing in an id that has been deleted should not fail to return any input (and indeed generate an initially mystifying axios error) 

## Author and Acknowledgements
Grateful acknowledgement to our glorious trainers Jordan Harrison and Jordan Benbelaid. 
BAE-12 Team 1 also has my effusive gratitude, with special thanks to Eva Bullman and Charlotte Cartwright who are both inimitable queens of style.
Project by Ryan Donaghue.
