# Mini-Project-OOP

# Student Course Registration System (Mini OOP Project)

## 👥 Group Members

| Name                                   | Matric No     |
|----------------------------------------|---------------|
| Muhammad Syahmi Faris bin Rusli        | A23CS0138     |
| Ahmad Adib Zikri bin A.Mazlam          | A23CS0205     |

---

## 📘 Project Description

We chose to develop a **Student Course Registration System** because it reflects a common and practical use case in real-world academic environments. Every university student must register for courses each semester, and this system simulates that process while allowing us to apply key Object-Oriented Programming (OOP) principles in a meaningful way.

This console-based Java application enables users to register as either an **Undergraduate** or **Postgraduate** student. After entering their personal details, students can register for courses, and the system will display their profile and a list of registered courses.

The system was designed with scalability and good design structure in mind. All classes follow Java best practices, and the application uses **abstraction**, **inheritance**, **polymorphism**, **aggregation**, and **collection-based data management** (ArrayList). We also included **exception handling** to improve the program’s robustness against invalid input.

### 📦 Modules Involved:

1. **Student Registration Module**
   - Register as Undergraduate or Postgraduate.
   - Input student ID and full name.
   - Specific attributes for each type (e.g. year of study, thesis title).

2. **Course Registration Module**
   - Input course code and title.
   - Dynamically stores registered courses using an `ArrayList`.

3. **Display Module**
   - Uses polymorphism to display customized student information based on their type (undergrad/postgrad).
   - Lists all registered courses.

4. **Validation & Error Handling**
   - Prevents empty input for required fields.
   - Uses `try-catch` to catch invalid user actions and exceptions.

The goal of this project is not only to implement functional registration logic but to **demonstrate a full understanding of OOP concepts from Chapter 5 to Chapter 9** of our syllabus in a real-world context.

---

## 🧠 Chapter-wise Concept Implementation

### ✅ Chapter 5 – ArrayList (Dynamic Data Structure)

- `ArrayList<Course>` is used in the `Student` class to store registered courses dynamically.
- It supports dynamic addition of course objects using `.add()` and iteration using a for-each loop.

### ✅ Chapter 6 – Class Relationships (Association & Aggregation)

- **Association**: A `Student` is associated with multiple `Course` objects (`Student` registers `Course`).
- **Aggregation**: A `Student` contains a `Name` object, showing a “has-a” relationship (`Student has-a Name`).

### ✅ Chapter 7 – Inheritance

- `User` is an abstract superclass.
- `Student` is an abstract subclass of `User`.
- `Undergraduate` and `Postgraduate` are concrete subclasses of `Student`.

### ✅ Chapter 8 – Polymorphism

- The `printInfo()` method is **overridden** in both `Undergraduate` and `Postgraduate`.
- A `Student` reference is used to refer to different student types at runtime (dynamic binding).

### ✅ Chapter 9 – Exception Handling

- Input validation is implemented using `try-catch` blocks.
- Example: If the user leaves course code or title empty, an `IllegalArgumentException` is thrown and handled.

---
