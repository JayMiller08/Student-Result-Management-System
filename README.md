# 🎓 Student Result Management System (Java CLI)

This is a command-line Java application designed to manage students and their academic results. Built using object-oriented principles, it allows users (teachers/admins) to register students, record subject marks, calculate performance, and generate academic reports — all from the terminal.

---

## ✅ Features

### 🧑‍🎓 Student Management
- Register new students (Name, ID, Age)
- Search students by ID
- Delete student records
- View all registered students

### 📝 Result Management
- Input marks for Math, Science, and English
- Calculate total marks and average
- Determine grade level:
  - 75%+ = Distinction
  - 50%–74% = Pass
  - Below 50% = Fail
- Generate full report cards

---

## 🔧 Technologies Used

- **Java (JDK 8+)**
- `Scanner` for input
- `ArrayList` for storing students
- `OOP Principles`: Classes, Constructors, Encapsulation, Inheritance
- (Optional) `LocalDate` for date/time stamps

---

## 🗂️ File Structure

```📁 student-result-system/
├── Main.java // CLI entry point
├── Student.java // Handles student info
├── Result.java // Handles marks & calculations
├── StudentManager.java // Manages student list & logic
├── README.md // Project documentation
```

---

## 📌 How to Run

1. Clone the repository or download the `.zip`
2. Compile the code:
   ```
   javac Main.java
Run the program:
```
java Main
