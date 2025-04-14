# 🏦 Banking Application - Spring Boot REST API

![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green)
![License](https://img.shields.io/badge/License-MIT-blue)

A modern banking application built with Spring Boot that provides RESTful APIs for account management with deposit/withdrawal capabilities.

## 📋 Table of Contents
- [Features](#-features)
- [Architecture](#-architecture)
- [API Documentation](#-api-documentation)
- [Getting Started](#-getting-started)
- [Database Schema](#-database-schema)
- [Development](#-development)
- [Contributing](#-contributing)

## ✨ Features

- **Account Management**
  - Create new accounts
  - View account details
  - Delete accounts
- **Transaction Operations**
  - Deposit funds
  - Withdraw funds (with balance validation)
- **Reporting**
  - List all accounts
  - View account balances

## � Architecture

```mermaid
graph TD
    A[Client] --> B[Controller]
    B --> C[Service]
    C --> D[Repository]
    D --> E[Database]
    
    style A fill:#f9f,stroke:#333
    style B fill:#bbf,stroke:#333
    style C fill:#bdf,stroke:#333
    style D fill:#dfb,stroke:#333
    style E fill:#fbb,stroke:#333
Layered Architecture:

Controller Layer: Handles HTTP requests/responses

Service Layer: Contains business logic

Repository Layer: Manages database operations

Entity Layer: Maps to database tables

📚 API Documentation
Endpoints Overview
Method	Endpoint	Description	Status Codes
POST	/api/accounts	Create new account	201, 400
GET	/api/accounts/{id}	Get account details	200, 404
PUT	/api/accounts/{id}/deposit	Deposit money	200, 404
PUT	/api/accounts/{id}/withdraw	Withdraw money	200, 400, 404
GET	/api/accounts	List all accounts	200
DELETE	/api/accounts/{id}	Delete account	200, 404
Example Requests
Create Account:

bash
Copy
curl -X POST http://localhost:8080/api/accounts \
-H "Content-Type: application/json" \
-d '{"accountHolderName":"John Smith","balance":5000}'
Deposit Money:

bash
Copy
curl -X PUT http://localhost:8080/api/accounts/1/deposit \
-H "Content-Type: application/json" \
-d '{"amount":1000}'
🚀 Getting Started
Prerequisites
Java 17+

Maven 3.6+

(Optional) Docker for containerization

Installation
Clone the repository:

bash
Copy
git clone https://github.com/yourusername/banking-app.git
cd banking-app
Build and run:

bash
Copy
mvn spring-boot:run
Access the API at:

Copy
http://localhost:8080/api/accounts
🗃 Database Schema
mermaid
Copy
erDiagram
    ACCOUNTS {
        long id PK
        string accountHolderName
        double balance
    }
Table Structure:

accounts table stores all account information

Auto-incremented primary key

Balance stored as double precision

🛠 Development
Project Structure
Copy
banking-app/
├── src/
│   ├── main/
│   │   ├── java/com/banking/
│   │   │   ├── config/       # Configuration classes
│   │   │   ├── controller/   # REST controllers
│   │   │   ├── dto/          # Data Transfer Objects
│   │   │   ├── entity/       # JPA entities
│   │   │   ├── exception/    # Custom exceptions
│   │   │   ├── repository/   # Data repositories
│   │   │   ├── service/      # Business logic
│   │   │   └── BankingApplication.java
│   │   └── resources/       # Config files
│   └── test/                # Test cases
├── pom.xml                  # Maven config
└── README.md                # This file
