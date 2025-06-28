# Mini-Project-OOP

## 📚 Student Course Registration System (Mini OOP Project)

---

## 👥 Group Members

| Name                                   | Matric No     |
|----------------------------------------|---------------|
| Muhammad Syahmi Faris bin Rusli        | A23CS0138     |
| Ahmad Adib Zikri bin A.Mazlam          | A23CS0205     |

---

## 📘 Project Description

We developed a **Student Course Registration System** to simulate a real-world university scenario where students register for subjects each semester. This system was chosen because it is relatable, practical, and allows us to demonstrate key Object-Oriented Programming (OOP) concepts in an organized and useful way.

The application is **console-based and built using Java**. It allows users to register as either an **Undergraduate** (limited to Year 1–3 only) or a **Postgraduate** student. Once registered, students can:
- Add new courses
- View their registered courses
- Drop courses if needed
- View their personal and academic details

The system integrates **abstraction**, **inheritance**, **polymorphism**, **aggregation**, **association**, and **exception handling** across different modules.

---

## 📦 Modules Involved

1. **Student Registration Module**
   - Register as Undergraduate or Postgraduate.
   - Input student ID, full name.
   - Additional detail:
     - `Undergraduate` must specify a valid year (only Year 1–3).
     - `Postgraduate` provides thesis title.

2. **Course Registration Module**
   - Students enter course code and title.
   - Registered using `ArrayList`.

3. **Drop Course Module**
   - Shows list of registered courses before asking for the code.
   - If no courses exist, prevents unnecessary input.
   - Removes the selected course if found.

4. **Display Module**
   - Displays student profile using overridden method based on type.
   - Lists all registered courses.

5. **Validation & Error Handling**
   - Input validation for:
     - Student type selection (must be 1 or 2)
     - Year (must be Year 1–3)
     - Non-empty course inputs
   - Uses `try-catch` for graceful error messages.

---

## 🧠 Chapter-wise Concept Implementation

### ✅ Chapter 5 – ArrayList (Dynamic Data Structure)
- `ArrayList<Course>` used to store registered courses dynamically.
- Supports addition and removal of `Course` objects.

### ✅ Chapter 6 – Class Relationships (Association & Aggregation)
- **Association**: `Student` is associated with multiple `Course` objects.
- **Aggregation**: `Student` "has a" `Name` object (can exist independently).

### ✅ Chapter 7 – Inheritance
- `User` is an abstract superclass.
- `Student` extends `User`.
- `Undergraduate` and `Postgraduate` extend `Student`.

### ✅ Chapter 8 – Polymorphism
- `printInfo()` is overridden by both `Undergraduate` and `Postgraduate`.
- Polymorphic calls are made via a `Student` reference.

### ✅ Chapter 9 – Exception Handling
- `try-catch` blocks handle invalid inputs.
- Input loops ensure only valid data is accepted (e.g., valid year, student type).

---
