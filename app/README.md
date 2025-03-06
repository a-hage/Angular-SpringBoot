# Backend Directory Structure

The Backend of this project uses the Spring Boot framework. Below is the directory structure along with a brief explanation of the key changes and newly added files:

/backend
│
├── /src
│   ├── /main
│   │   ├── /java
│   │   │   ├── /com
│   │   │   │   └── /cars
│   │   │   │       └── /app
│   │   │   │           ├── AppApplication.java            
│   │   │   │           ├── /controller                 
│   │   │   │           ├── /model                     
│   │   │   │           ├── /repository                 
│   │   │   │           ├── /service                    
│   │   │   │           └── /exception                  
│   │   ├── /resources
│   │   │   ├── /application.properties                 
│   │   │   └── /static                                 
│   │   └── /test
│   │       ├── /java
│   │       │   └── /com/cars/app
│   │       │       └── /AppApplicationTests.java          
│   │       └── /resources
│   │           └── /application-test.properties
│   ├── /target                                         
│
├── /pom.xml                                           
