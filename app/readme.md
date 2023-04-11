# Client Management API

This is a RESTful API built with Spring Boot that allows you to list, add, update, and delete clients.



## Getting started

To get started, you'll need to have Java 17 or later installed on your machine. You'll also need to have Maven installed to build the application.

To build the application, run the following command from the root directory of the project:

```
mvn clean install -DskipTests=true
```

This will build the application and create an executable JAR file in the target directory.

To run the application, use the following command:

```
java -jar target/app-0.0.1-SNAPSHOT.jar
```

Or using Maven:

```
mvn spring-boot:run
```

By default, the application will listen on port 8080. You can change this by editing the application.properties file in the src/main/resources directory.



## API Endpoints

The API has the following endpoints:

### List Clients

```
GET /api/v1/clients
```
This endpoint returns a list of all clients in the system.

### Add Client

```
POST /api/v1/clients
```
This endpoint adds a new client to the system. The request body should be a JSON object representing the client. For example:

```
{
  "id": 516,
  "firstName": "sonne",
  "lastName": "sonntag",
  "email": "sonne@sonntag.com",
  "gender": "female",
  "ip": "36.238.135.53"
}
```

### Update Client

```
PUT /api/v1/clients/{id}
```

This endpoint updates an existing client with the specified ID. The request body should be a JSON object representing the updated client. For example:

```
{
  "id": 216,
  "firstName": "sonne",
  "lastName": "sonntag",
  "email": "sonne@sonntag.net",
  "gender": "female",
  "ip": "36.238.135.53"
}
```
### Delete Client

```
DELETE /api/v1/clients/{id}
```

This endpoint deletes an existing client with the specified ID.

## Conclusion

That's it! You now have a simple Spring Boot API that manages clients. If you have any questions or issues, feel free to reach out to the project maintainers.