Complex JAVA course

Lab for ITHS Java-19


List of instructions for the Lab:

JAVA EE / JAX-RS - Labb

● Forka startprojekt från
https://github.com/pontusredig-alten/student-management-system

● CRUD-funktionalitet ska implementeras (Create, Read, Update, Delete)

● Data om en student ska kunna hämtas med efternamn som parameter i URL:en

● När en ny student ska läggas till, är alla fält obligatoriska utom telefonnummer

● Skapa minst en egen exception

● Inga 500 - Internal Server Error får uppstå

I've made my lab in cooperation with Halim (https://github.com/halimdakir/student-management-system.git) 
We chose to report our repos on our own as they have slight differences. I skipped implementing of annotation package. 
Handling of NOT_FOUND exception is made by own created StudentNotFoundException class and 
handling of more then one of the same lastname is limited by ".setMaxResults(1)" function in findStudentByLastName method.

End points for the app:

POST    /se.iths/api/v1/student/create

GET     /se.iths/api/v1/student/getall

PUT     /se.iths/api/v1/student/update

DELETE  /se.iths/api/v1/student/{lastName}

GET     /se.iths/api/v1/student/{lastName}


The structure of the JSON data:

{

	"firstName": "Elena",
	
	"lastname": "Iths",
	
	"email": "elena@iths.se",
	
	"phoneNumber": "0700 000007"
	
}
