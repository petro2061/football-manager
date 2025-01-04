# Football Manager

A simple football management system built with Java, Spring Boot, Hibernate, and MySQL.  
The project supports CRUD operations for teams and players, as well as player transfers between teams.  

## Features

- **CRUD Operations**:
  - Create, Read, Update, and Delete teams and players.
- **Player Transfers**:
  - Transfer players between teams with:
    - Transfer cost calculation:  
      `Transfer Cost = (Experience in months * 100,000) / Player's age in years`
    - Commission: Configurable (0% to 10%) for each team.
    - Balance adjustments for buying and selling teams.
- **Validation**:
  - Input validation and meaningful error responses.
- **REST API Documentation**:
  - A [Postman Collection - Football Manager](https://www.postman.com/maintenance-physicist-78577540/workspace/fotball-manager) is provided for testing.

---

## Prerequisites

- **Java** 17+
- **Maven** 3.8+
- **Docker** (for running the application with Docker)
- **Postman** (optional, for testing the API)

---

## How to Run the Project

### 1. Run Locally with Maven
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/football-manager.git
   cd football-manager
