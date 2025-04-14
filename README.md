
# 🏦 Simple Banking Application - Spring Boot REST API

A **Spring Boot RESTful application** that simulates basic banking operations such as account creation, deposit, withdrawal, and balance inquiry using **Java 17**, **Spring Boot**, and **Spring Data JPA**.

---

## 📂 Project Structure

```
├── controller/
│   └── AccountController.java
├── dto/
│   └── AccountDto.java
├── entity/
│   └── Account.java
├── mapper/
│   └── AccountMapper.java
├── repository/
│   └── AccountRepository.java
├── service/
│   ├── AccountService.java
│   └── AccountServiceImpl.java
├── BankingApplication.java
└── application.properties
```

---

## ✅ Features

- Create new bank account
- View account details
- Deposit money into account
- Withdraw money with validation
- View all existing accounts
- Delete account by ID

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3.1**
- **Spring Data JPA**
- **H2 / MySQL Database**
- **RESTful APIs**

---

## 🛠️ Setup Instructions

1. **Clone the repository**  
   ```bash
   git clone https://github.com/yourusername/SimpleBankingApplication.git
   cd SimpleBankingApplication
   ```

2. **Run the application using Maven**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the API endpoints**
   - Base URL: `http://localhost:8080/api/accounts`

---

## 📡 API Endpoints

| Method | Endpoint                        | Description              |
|--------|----------------------------------|--------------------------|
| POST   | `/api/accounts`                 | Create a new account     |
| GET    | `/api/accounts/{id}`           | Get account by ID        |
| PUT    | `/api/accounts/{id}/deposite`  | Deposit funds            |
| PUT    | `/api/accounts/{id}/withdraw`  | Withdraw funds           |
| GET    | `/api/accounts`                | View all accounts        |
| DELETE | `/api/accounts/{id}`           | Delete account by ID     |

---

## 🗂️ Application Flow

```mermaid
flowchart TD
    A[Client (Postman/Frontend)] --> B[Controller Layer]
    B --> C[Service Layer]
    C --> D[Repository Layer]
    D --> E[Database]
```

---

## 🧪 Sample Request (Using cURL)

**Create Account**
```bash
curl -X POST http://localhost:8080/api/accounts -H "Content-Type: application/json" -d '{"accountHolderName":"Alice", "balance":5000}'
```

**Deposit**
```bash
curl -X PUT http://localhost:8080/api/accounts/1/deposite -H "Content-Type: application/json" -d '{"amount":1000}'
```

**Withdraw**
```bash
curl -X PUT http://localhost:8080/api/accounts/1/withdraw -H "Content-Type: application/json" -d '{"amount":500}'
```

---

## 📌 Notes

- Built with clean layered architecture using Spring Boot.
- Designed for learning purposes and can be extended to full banking apps.
- `RuntimeException` is used for simplicity — in production, use custom exception handling.

---

## 👨‍💻 Author

**Abhijeet Tilekar** — [GitHub](https://github.com/yourusername)
