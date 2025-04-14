# 📦 Visual Binary Search Tree - Backend

This is the **Spring Boot backend** for the Visual Binary Search Tree project, built for the DSA Winter 2025 Final Sprint.

It exposes RESTful endpoints that allow users to:
- Submit numbers to build a Binary Search Tree (BST)
- Choose between regular or balanced BSTs
- Save trees to a MySQL database
- Retrieve previously submitted trees

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Web, Spring Data JPA
- MySQL
- Jackson (for JSON serialization)

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/visual-binary-search-tree-backend.git
cd visual-binary-search-tree-backend
```

### 2. Set Up MySQL
Ensure you have MySQL running. Create a database:
```sql
CREATE DATABASE visual_bst;
```

Update your `application.properties` file if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/visual_bst
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password
```

### 3. Run the App
```bash
./mvnw spring-boot:run
```

By default, the app will be available at: `http://localhost:8081`

---

## 📌 API Endpoints

### `POST /api/trees/process-numbers?balanced=true|false`
Submits a list of numbers and creates a BST.

**Request Body:**
```json
[5, 3, 8, 1, 4]
```

**Query Parameter:**
- `balanced=true` → builds a height-balanced BST
- `balanced=false` (default) → builds a regular BST based on insertion order

**Response:**
```json
{
  "value": 5,
  "left": {
    "value": 3,
    "left": { "value": 1, "left": null, "right": null },
    "right": { "value": 4, "left": null, "right": null }
  },
  "right": {
    "value": 8, "left": null, "right": null
  }
}
```

### `GET /api/trees/previous-trees`
Returns all previously submitted trees stored in the database.

**Response:**
```json
[
  {
    "inputNumbers": "5,3,8,1,4",
    "treeJson": "{...}",
    "createdAt": "2025-04-13T18:30:00"
  }
]
```

---

## 🧪 Running Tests
```bash
./mvnw test
```
You should see all unit tests pass.

---

## 🙌 Author
**Angie** — Software Development Student @ Keyin College

---

## 📄 License
MIT — feel free to use, adapt, and learn!

