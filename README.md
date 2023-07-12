# Laboratuvar Rest API

Bu repo örnek bir laboratuvar reporlama uygulamasının Back-end servisini içerir.

## Getting Started

Bu Back-end uygulaması hasta ve rapor/tanı bilgilerinin depolanmasını ve bu verilere daha sonrasında ulaşılmasını sağlar.

### This project uses
```
Java 17
Maven 3
Spring Boot 3
H2 as Database
```

### Setup

Clone the repo locally:
```bash
git clone https://github.com/RedPho/laboratuvar-backend.git
```

Run the application:
```bash
mvn spring-boot:run
```

The app will start running at http://localhost:8080 and uses in-memory database H2 by default. 
If you want to save database(use file based storage) when application be closed, you can configure /src/main/resource/application.properties:
```
spring.datasource.url=jdbc:h2:mem:testdb // If you want to save database, change here to this format: jdbc:h2:file:/examplepath/data
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=user //username of the database admin
spring.datasource.password=pwd //password of the database admin

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto= update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-ui //this is dashboard url path for database gui
```

## API Table
| Method | Url                           | Decription                                                                                             |
|--------|-------------------------------|--------------------------------------------------------------------------------------------------------|
| GET    | /files/{id}                   | Get file from database by id                                                                           |
| POST   | /upload                       | Upload file to database                                                                                |
| GET    | /laborants                    | Get information of all laborants                                                                       |
| POST   | /laborant                     | Save laborant to database                                                                              |
| GET    | /laborants/{id}               | Get information of a laborant by id                                                                    |
| DELETE | /laborants/{id}               | Delete laborant by id                                                                                  |
| GET    | /reports?queryParameter={query} | Search and get information of reports. You can omit the query parameter if you want to get all reports |
| POST   | /reports                | Save report to database                                                                                |
| GET    | /reports/{id}                | Get report by id                                                                                       |
| DELETE | /reports/{id}                | Delete report by id                                                                                    |
| PUT    | /reports/{id}              | Update report by id                                                                                    |

