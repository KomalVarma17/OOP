Cafe Management System
Overview
This project is a Cafe Management System built using Spring Boot and Spring Data JPA, which provides functionality for managing cafes, orders, events, vendors, payments, and related entities. The system follows an MVC (Model-View-Controller) architecture, with Thymeleaf templates used for the frontend.

Step 1: Clone the Repository
Clone the repository to your local machine using the following command:

bash: 

git clone <repository_url>  
cd cafe-management-system

Step 2: Configure the Application
The default application uses an H2 in-memory database. For production, modify the application.properties file to connect to your preferred database.

properties:
# H2 Database Config (Default)  
spring.datasource.url=jdbc:h2:mem:testdb  
spring.datasource.driver-class-name=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  
 
# spring.datasource.url=jdbc:mysql://localhost:3306/your_database  
# spring.datasource.username=your_username  
# spring.datasource.password=your_password  
# spring.jpa.hibernate.ddl-auto=update

Step 3: Build and Run
Use Maven to build the project and run the Spring Boot application.

bash:
mvn clean install  
mvn spring-boot:run


Step 4: Access the Application
Once the application is running, open your browser and navigate to:
http://localhost:8080


Step 5: Frontend Layout
Add the provided HTML layout templates to the src/main/resources/templates folder

Notes for Developers
Database Initialization: The application auto-creates  relationships based on the entity classes.
Custom Queries: Custom queries for specific operations are included in repository classes.
Error Handling: Ensure proper exception handling while extending this project.
