
# 🎓 Student Result Management System (Java CLI)

A command-line Java application for managing students and their academic results. Enables student registration, marks input, result computation, and report generation — ideal for school or college use.

---

## ✅ Key Features

- **Student Management**
  - Add new students (name, surname, ID number, age, PIN)
  - Search and remove students by ID
  - List all students

- **Result Management**
  - Input marks for subjects (e.g., Math, English, Science)
  - Automatically compute total, average, and grade level:
    - Distinction (75%+), Pass (50–74%), Fail (<50%)
  - Generate and display individual report cards

- **CLI User Interface**
  - Interactive application menu with text-based prompts
  - Input validation and error handling for robustness

---

## ⚙️ Technologies Used

- Java (JDK 8+)
- Core Java classes: `Scanner`, `ArrayList`, `LocalDateTime`
- OOP principles: encapsulation, constructors, and classes
- Exception handling for invalid user input

---

## 🗂️ Repository Structure

```
student-result-system/
├── Main.java               # Entry point with CLI menu
├── Student.java            # Student model (name, ID, age, PIN)
├── Result.java             # Handles marks and calculations
├── StudentManager.java     # Manages student list (add/search/delete)
└── README.md               # Project overview & instructions
```

---

## 🚀 How to Run

1. **Download or clone** this repository.
2. Navigate to the project folder in your terminal.
3. **Compile**:
   ```bash
   javac Main.java Student.java Result.java StudentManager.java
   ```
4. **Run**:
   ```bash
   java Main
   ```
5. **Follow the menu** to add students, input marks, search, delete, or generate reports.

---

## 📌 Future Enhancements

- Save/load data from files for persistence
- Add user roles (e.g., Admin login, Teacher access)
- Record timestamps for student registrations
- Transition to GUI (JavaFX) or full-stack Web App
- Add data export (CSV/PDF report cards)

---

## 👨‍💻 Contributors

- **Kwandumusa J. Mthethwa**
- Diploma in Computer Science (Extended), Tshwane University of Technology – eMalahleni campus

---

## 📝 License

For educational and portfolio purposes. Please credit the authors when referencing or sharing.
