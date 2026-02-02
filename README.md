# RetailHub POS Backend

## Overview

RetailHub POS Backend is a **Spring Boot–based RESTful backend** for a retail Point of Sale (POS) system. It provides secure, role-based APIs for managing categories, items, users, orders, and dashboard analytics. The project is designed with a clean layered architecture, JWT-based authentication, and MySQL persistence, making it suitable for real-world retail and billing use cases.

The backend supports **ADMIN** and **USER** roles, ensuring secure access to critical operations such as inventory management, order processing, and sales analytics.

---

## Features

* 🔐 JWT-based authentication and authorization
* 👥 Role-based access control (ADMIN / USER)
* 🗂 Category management (create, read, delete)
* 📦 Item / product management with category mapping
* 🧾 Order creation with order items and payment details
* 💳 Multiple payment methods (CASH, UPI)
* 📊 Dashboard analytics (sales summary & recent orders)
* 🛡 Spring Security integration
* 🗄 MySQL database with JPA & Hibernate

---

## Project Structure

```
in/ankitsaahariya/retailhub_pos
│
├── RetailhubPosApplication.java
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── CategoryController.java
│   ├── DashboardController.java
│   ├── ItemController.java
│   ├── OrderController.java
│   └── UserController.java
│
├── entity
│   ├── CategoryEntity.java
│   ├── ItemEntity.java
│   ├── OrderEntity.java
│   ├── OrderItemEntity.java
│   └── UserEntity.java
│
├── filter
│   └── JwtRequestFilter.java
│
├── io (DTOs)
│   ├── AuthRequest.java
│   ├── AuthResponse.java
│   ├── CategoryRequest.java
│   ├── CategoryResponse.java
│   ├── DashboardResponse.java
│   ├── ItemRequest.java
│   ├── ItemResponse.java
│   ├── OrderRequest.java
│   ├── OrderResponse.java
│   ├── PaymentDetails.java
│   ├── PaymentMethod.java
│   ├── UserRequest.java
│   └── UserResponse.java
│
├── repository
│   ├── CategoryRepository.java
│   ├── ItemsRepository.java
│   ├── OrderEntityRepository.java
│   ├── OrderItemEntityRepository.java
│   └── UserRepository.java
│
├── service
│   ├── CategoryService.java
│   ├── ItemService.java
│   ├── OrderService.java
│   └── UserService.java
│
├── serviceImp
│   ├── AppUserDetailService.java
│   ├── CategoryServiceImp.java
│   ├── ItemServiceImp.java
│   ├── OrderServiceImpl.java
│   └── UserServiceImp.java
│
└── util
    └── JwtUtil.java
```

---

## Tech Stack

* **Java 17**
* **Spring Boot**
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* Hibernate
* MySQL
* Lombok
* Maven

---

## Base API URL

```
/api/v1.0
```

---

## API Endpoints

### 🔹 Category APIs (`tbl_category`)

| Action          | Method | Endpoint                         | Role           |
| --------------- | ------ | -------------------------------- | -------------- |
| Create Category | POST   | `/admin/categories`              | ADMIN          |
| Read Categories | GET    | `/categories/get`                | PUBLIC / ADMIN |
| Delete Category | DELETE | `/admin/categories/{categoryId}` | ADMIN          |

⚠️ **Note:** Category deletion will fail if related items exist (FK constraint).

---

### 🔹 Item APIs (`tbl_items`)

| Action      | Method | Endpoint                | Role         |
| ----------- | ------ | ----------------------- | ------------ |
| Create Item | POST   | `/admin/items`          | ADMIN        |
| Read Items  | GET    | `/items`                | USER / ADMIN |
| Delete Item | DELETE | `/admin/items/{itemId}` | ADMIN        |

---

### 🔹 User & Auth APIs (`tbl_users`)

| Action              | Method | Endpoint                | Role   |
| ------------------- | ------ | ----------------------- | ------ |
| Admin Register User | POST   | `/admin/register`       | ADMIN  |
| Login               | POST   | `/login`                | PUBLIC |
| Read Users          | GET    | `/admin/users`          | ADMIN  |
| Delete User         | DELETE | `/admin/users/{userId}` | ADMIN  |

---

### 🔹 Order APIs (`tbl_orders`)

| Action             | Method | Endpoint            | Role  |
| ------------------ | ------ | ------------------- | ----- |
| Create Order       | POST   | `/orders/create`    | USER  |
| Read Latest Orders | GET    | `/orders/latest`    | ADMIN |
| Delete Order       | DELETE | `/orders/{orderId}` | ADMIN |

---

### 🔹 Dashboard APIs (Aggregated)

| Action            | Method | Endpoint             | Role  |
| ----------------- | ------ | -------------------- | ----- |
| Dashboard Summary | GET    | `/dashboard/summary` | ADMIN |

---

## How to Run Locally

1. Clone the repository

```bash
git clone https://github.com/your-username/retailhub-pos-backend.git
```

2. Configure MySQL database

* Create a database named `retail_pos_system`

3. Update `application.properties`

4. Build and run the application

```bash
mvn clean install
mvn spring-boot:run
```

5. Access APIs via Postman or any REST client

---

## application.properties Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/retail_pos_system
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update

server.servlet.context-path=/api/v1.0

jwt.secret=YOUR_SECRET_KEY
jwt.expiration=YOUR_EXPIRATION_TIME
```

---

## License

This project is licensed under the **MIT License**.

---

## Contact

**Ankit Saahariya**
Backend Java Developer (Spring Boot)
📧 Email: *[your-email@example.com](mailto:AnkitK.software@gmail.com)*
🔗 GitHub: *[https://github.com/Ankit-kumar8-1](https://github.com/Ankit-kumar8-1)*

---

⭐ If you find this project useful, consider giving it a star!
