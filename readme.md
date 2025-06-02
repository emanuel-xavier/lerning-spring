# 🎮 Player Registration System

Welcome to the **Player Registration System** repository!  
This project is a multi-layered web application built with **Spring Boot**, designed to register players and assign them to missions. It uses an in-memory **H2 database** for development, **Flyway** for database migrations.

---

## 🔍 Project Overview

This system manages player profiles and their assigned missions.  
Each player can be assigned to **one mission**, while each mission can be linked to **multiple players**.

### ✅ Core Features

- Register players with `name`, `age`, `email`, and `rank`.
- Assign a mission to a player.
- Manage missions and view associated players.

---

## 🛠 Technologies Used

- **Spring Boot** – Web application framework and dependency management.
- **H2 Database** – In-memory database for development and testing.
- **Flyway** – Tool for managing and automating database migrations.
- **JPA (Java Persistence API)** – Object-relational mapping for entities.
- **Spring Data JPA** – Simplifies database interactions.
- **Maven** – Build automation and dependency management.
- **Git** – Version control system.
- **GitHub** – Repository hosting and collaboration.
- **Docker** – External database build support.
- **SQL** – For manual database manipulation.
- **Swagger** – For documentation.

---

## 🗃️ Database Design

The database schema follows the relationships below:

- **Player**: Includes fields such as `id`, `name`, `age`, `email`, and `rank`.
- **Mission**: Includes fields such as `id`, `title`, and `description`.
- A **Player** can be assigned to **one Mission**.
- A **Mission** can have **multiple Players** assigned to it.

---

## 🚀 Getting Started

To run the application locally, follow the steps below:

1. **Clone the repository**  
    ```bash
    git clone https://github.com/your-username/PlayerRegistrationSystem.git
    ```

2. **Navigate into the project directory**  
    ```bash
    cd PlayerRegistrationSystem
    ```

3. **Build the project using Maven**
    ```bash
    mvn clean install
    ```
4. **Run the application**  
   ```bash
    mvn spring-boot:run
   ```
5. **API Documentation**  
    Once the application is running, you can access the Swagger UI at:
    http://localhost:8080/swagger-ui/index.html
    This interface allows you to explore and test all available API endpoints.
