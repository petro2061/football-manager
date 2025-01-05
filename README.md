# Football Manager Application

## Overview
The Football Manager application is a RESTful web service designed to manage football teams, players, and match statistics. It allows users to perform CRUD operations on entities such as teams and players, simulate matches, and view statistics. This project demonstrates the use of modern Java development practices, frameworks, and tools.

## Features
- **Team Management:** Create, update, delete, and view football teams.
- **Player Management:** Manage players within teams, including their stats and positions.
- **Transfer Management:** Manage the transfer of players from one team to another.

## Technologies Used
- **Java 17**
- **Spring Boot 3** (Spring Data JPA, Spring Web, Spring Validation)
- **Hibernate**
- **MySql** as the database
- **Docker** for containerization
- **Lombok** for boilerplate code reduction
- **MapStruct** for object mapping
- **Maven** for build and dependency management

## Project Structure
The project follows the standard layered architecture:

```
src/main/java
|
|-- com.example.footballmanager
    |-- controller  // REST controllers for handling HTTP requests
    |-- dto         // Data Transfer Objects
    |-- model       // Entity classes
    |-- repository  // Spring Data JPA repositories
    |-- service     // Business logic services
    |-- util        // Utility classes (e.g., mappers, constants)
```

## Endpoints
### Team Management
- **GET /teams** - Retrieve all teams
- **POST /teams** - Create a new team
- **GET /teams/{id}** - Retrieve a team by ID
- **PUT /teams/{id}** - Update a team's details
- **DELETE /teams/{id}** - Delete a team

### Player Management
- **GET /players** - Retrieve all players
- **POST /players** - Add a new player to a team
- **GET /players/{id}** - Retrieve a player by ID
- **PUT /players/{id}** - Update player details
- **DELETE /players/{id}** - Remove a player from a team
- **GET /players/team/{id}** - Get all players on the team

### Transfer Simulation
- **PUT /{transferPlayerId}/to/{buyingTeamId}** - Simulates player transfers between teams

## Installation
### Prerequisites
- Java 17 or higher
- Docker
- Maven

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/football-manager.git
   cd football-manager
   ```
2. Start the database using Docker:
   ```bash
   docker-compose up -d
   ```
3. Build and run the application:
   ```bash
   mvn clean install
   java -jar target/football-manager-0.0.1-SNAPSHOT.jar
   ```

## Postman Collection
Postman collection, for quickly testing APIs -> [Postman Collection](https://www.postman.com/maintenance-physicist-78577540/workspace/fotball-manager/collection/36281725-6914d51d-1a15-435e-8a00-b6f03dbcbf5c?action=share&creator=36281725)

## Development Notes
- Ensure Docker is running before starting the application.
- Use the `.env` file for configuration. The structure below is for a MySQL database conection.
- Example .evn file structure:
  ```properties
  SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/football_manager?serverTimezone=UTC
  SPRING_DATASOURCE_USERNAME=user_name
  SPRING_DATASOURCE_PASSWORD=password
  SERVER_PORT=8080
  MYSQL_ROOT_PASSWORD=password
  MYSQL_DATABASE=football_manager
  ```
---

Enjoy managing your football teams! For issues, feel free to open a ticket in the GitHub repository.

