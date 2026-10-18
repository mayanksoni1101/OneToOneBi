# One-to-One Bidirectional Mapping (JPA / Hibernate)

This project demonstrates a complete implementation of a **One-to-One Bidirectional Association** in Java using JPA (Java Persistence API) and Hibernate. The application models the relationship between a `User` entity and an `AadharCard` entity, providing utility classes for persisting data and querying records from both ends of the relationship.

---

## 🛠️ Project Details & Configuration

* **Package:** `org.jsp.onetonebi`
* **Persistence Unit Name:** `M15`
* **OR Mapping Type:** `@OneToOne` (Bidirectional with `CascadeType.ALL` and `mappedBy`)

---

## 📁 File Breakdown & Architecture

### 1. Entity Classes
* **`User.java`**: Represents the `User` table.
  * Fields: `id` (PK, Auto-generated), `name`, `password`, `phone` (Unique), and `card` (`@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")`).
* **`AadharCard.java`**: Represents the `AadharCard` table.
  * Fields: `id` (PK, Auto-generated), `number` (Unique), `dob`, `address`, and `user` (`@OneToOne` with `@JoinColumn`).

### 2. Data Insertion
* **`InsertData.java`**: Creates and links a `User` and `AadharCard` entity and persists the parent object using `em.persist(u)`.

### 3. User Lookup Utilities
* **`FindUserById.java`**: Retrieves a `User` by primary key using `em.find()`.
* **`FindUserByName.java`**: Fetches a list of users matching a given name via JPQL.
* **`FindUserByPhone.java`**: Fetches a unique `User` using their registered phone number.
* **`FindUserByAadharId.java`**: Finds the `User` associated with a specific `AadharCard` ID.
* **`FindUserByAadharNumber.java`**: Queries the `User` associated with a specific Aadhar card number.
* **`FindUserByAadharNumberAndDob.java`**: Finds the `User` using a combination of Aadhar card number and Date of Birth (DOB).

### 4. Aadhar Card Lookup Utilities
* **`FindAadharById.java`**: Retrieves an `AadharCard` by primary key using `em.find()`.
* **`FindAadharByNumber.java`**: Fetches an `AadharCard` using its unique card number.
* **`FindAadharByNumberAndDob.java`**: Queries an `AadharCard` using its card number and DOB.
* **`FindAadharByUserId.java`**: Fetches the `AadharCard` associated with a given `User` ID.
* **`FindAadharByUserPhone.java`**: Retrieves the `AadharCard` using the associated user's phone number.
* **`FindAadharByUserNameAndPhone.java`**: Queries the `AadharCard` matching both the user's name and phone number.

---

## 🚀 How to Run

1. **Prerequisites:**
   * Java Development Kit (JDK 8 or higher).
   * JPA/Hibernate dependencies added to your classpath.
   * `persistence.xml` properly configured under `META-INF` with persistence unit name `"M15"` and your database connection details.

2. **Populate Data:**
   * Run `InsertData.java` as a Java application to populate sample user and Aadhar card records into the database.

3. **Query Data:**
   * Run any of the `FindUser...` or `FindAadhar...` classes to search records interactively via console prompts.
