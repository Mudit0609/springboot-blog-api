# 📝 blog-website-apis

 A RESTful **Blog Website API** built using **Java Spring Boot**.
 This project provides a backend service to handle users, posts,
 categories, and comments, suitable for blogging platforms or as
 a learning project for RESTful API design.

---

## 🚀 Features

- ✅ User registration & login (with Spring Security)
- 📝 CRUD operations on blog posts
- 🗂️ Category management
- 💬 Commenting on posts
- 🔐 Secured APIs with role-based access
- 🧩 Exception handling with custom exceptions
- 📤 DTO & Service layer architecture
- 🧪 Unit and integration tests

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Lombok
- Maven
- JUnit

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/blog-wesite-apis.git
cd blog-wesite-apis
```

### 2. Configure the Database

Create a file `application.properties` in `src/main/resources/` and add:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

⚠️ Do not commit this file to GitHub. It's listed in .gitignore.

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

## 🧪 Sample API Endpoints

### 🔐 User APIs
- POST `/api/users/register` – Register a new user
- POST `/api/users/login` – Login

### 📝 Post APIs
- POST `/api/posts` – Create new post
- GET `/api/posts` – Get all posts
- PUT `/api/posts/{id}` – Update post
- DELETE `/api/posts/{id}` – Delete post

### 🗂️ Category APIs
- POST `/api/categories` – Add category
- GET `/api/categories` – List categories

### 💬 Comment APIs
- POST `/api/comments/post/{postId}` – Add comment
- DELETE `/api/comments/{commentId}` – Remove comment

## 📂 Layers Overview

| Layer | Responsibility |
|-------|----------------|
| Controller | Handle HTTP requests/responses |
| Service | Business logic |
| Repository | Database interaction |
| DTOs | Payload structure |
| Model | JPA Entity mapping |
| Exception | Custom error handling |
| Security | JWT-based auth (if configured) |

## 📄 License

This project is open-sourced under the MIT License.

## 🙋‍♂️ Author

Mudit Singhal  
Recent BTech Graduate from SKIT, Jaipur

---
```
