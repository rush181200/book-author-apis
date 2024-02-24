# Book Author RESTful API

The Complete API is in the master branch

The API has swagger documentation use this url after running the app "http://localhost:8080/swagger-ui/index.html#/"

This is a RESTful API built with Spring Boot and PostgreSQL for managing books and authors.

## Endpoints

### Books

- **GET /books:** Retrieve a list of all books.
- **GET /books/{isbn}:** Retrieve details of a specific book by ID.
- **PATCH /books/{isbn}:** Create a new book.
- **PUT /books/{isbn}:** Update details of a specific book by ID.
- **DELETE /books/{isbn}:** Delete a specific book by ID.

### Authors

- **GET /authors:** Retrieve a list of all authors.
- **GET /authors/{id}:** Retrieve details of a specific author by ID.
- **POST /authors:** Create a new author.
- **PUT /authors/{id}:** Update details of a specific author by ID.
- **DELETE /authors/{id}:** Delete a specific author by ID.
- **PATCH /authors/{id}:**Partial Update

## Technologies Used

- Spring Boot
- PostgreSQL
- JUnit and Mockito for testing
- Maven

## How to Run

1. Clone the repository.
2. Run the docker-compose file "docker-compose up"
3. Configure PostgreSQL database settings in `application.properties`.
4. Run the application using Maven: `mvn spring-boot:run`.

## Running Integration Tests

Integration tests ensure the reliability and correctness of the API endpoints.

1. Make sure the application is running.
2. Run Maven integration tests: `mvn integration-test`.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

