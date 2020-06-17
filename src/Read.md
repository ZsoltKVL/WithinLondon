The Task:
Using the language of your choice please build your own API which calls the API at https://bpdts-test-app.herokuapp.com/, 
and returns people who are listed as either living in London, or whose current coordinates are within 50 miles of London. 

A Spring boot task. 
Can call for example with :
http://localhost:8080/usersinsidedistane/London
London is a default city for this application.
Runs in asynchronous way so if there is no available stored data, than necessary to call it again for the result.

