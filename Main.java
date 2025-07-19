import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean mainMenuRunning = true;

        do {

            int option = 0;
            try {
                System.out.println("****** Student Result Management System ******\n");
                System.out.println("<1> Register Student");
                System.out.println("<2> Login Student");
                System.out.println("<3> Student List");
                System.out.println("<4> Search Student");
                System.out.println("<0> Exit");
                System.out.print("Select: ");
                option = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something Wrong!");
                throw new RuntimeException(e);
            }

            switch (option) {
                case 1:
                    registerStudent(sc);
                    break;
                case 2:
                    loginStudent(sc);
                    break;
                case 3:
                    studentList(sc);
                    break;
                case 4: searchStudent(sc);
                    break;
                case 0:
                    System.out.println("Thank You, Goodbye ;-)");
                    mainMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid Selection.");
            }
        }while (mainMenuRunning);
    }

    public static void registerStudent(Scanner sc){
        String name, surname, idNumber;
        int age, pin;

        boolean registerStudentMenu = true;

        while(registerStudentMenu) {
            System.out.println("===== Register Student =====\n");
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Surname: ");
            surname = sc.nextLine();
            System.out.print("ID Number: ");
            idNumber = sc.nextLine();
            System.out.print("Set Student PIN: (4-digit pin): ");
            pin = sc.nextInt();
            System.out.print("Age: ");
            age = sc.nextInt();
            sc.nextLine();

            Student newStudent = new Student(name, surname, idNumber, age, pin);
            manager.students.add(newStudent);
            System.out.println("Successfully Added, "+name+" "+surname+", welcome!\n");
            System.out.println("Add Another Student?");
            System.out.println("<1> Yes");
            System.out.println("<0> No");
            int opt = sc.nextInt();

            if( opt == 1 )
                System.out.println();
            else if( opt == 0 ){
                System.out.println("Returning to Main Menu....");
                registerStudentMenu = false;
            } else{
                System.out.println("Invalid Option! ");
                break;
            }

        }

    }

    public static void loginStudent(Scanner sc) {

        boolean loginStudentMenuRunning = true;

        while ( loginStudentMenuRunning ){

            int option3 = 0;

            System.out.println("===== Student Login =====");
            System.out.print("Enter Student ID: ");
            String idNumLogin = sc.nextLine();
            System.out.print("Enter Student Pin: ");
            int pinLogin = sc.nextInt();
            sc.nextLine();

            boolean found = false;

            for (Student sm : manager.students) {
                if( idNumLogin.equalsIgnoreCase(sm.getIdNumber()) && pinLogin == sm.getPin()) {
                    System.out.println("Access Granted!\nWelcome "+ sm+"\n");
                    Student.studentMenu();
                }
            }
            if ( !found ) {
                System.out.println("Invalid Student Details - User Not Found.");
            }

            System.out.println("\n<0> Return to Main Menu");
            option3 = sc.nextInt();
            sc.nextLine();

            if ( option3 == 0 ) {
                System.out.println("Returning to Main Menu....");
                loginStudentMenuRunning = false;
            }
        }
    }

    public static void studentList(Scanner sc) {
        boolean studentListMenuRunning = true;
        int option4 = 0;

        while( studentListMenuRunning ) {

            System.out.println("\n");

            if ( manager.students.isEmpty() ) {
                System.out.println("No Students Registered.\n");
                System.out.println("Returning to Main Menu....");
                studentListMenuRunning = false;
            } else {
                for ( Student sm : manager.students ) {
                    System.out.println(sm.toString());
                }
                System.out.println("Returning to Main Menu....");
                studentListMenuRunning = false;
            }
        }

    }
    public static void searchStudent(Scanner sc) {

        boolean searchStudentMenuRunning = true;
        int option = 0;

        while ( searchStudentMenuRunning ) {

            System.out.println("===== Student Search =====\n");
            System.out.println("<1> Search Student by Name");
            System.out.println("<2> Search Student by Surname");
            System.out.println("<3> Search Student by ID");
            System.out.println("<0> Exit");
            System.out.print("Select: ");
            option = sc.nextInt();
            sc.nextLine();

            if ( option == 1 ) {

                boolean found = false;

                if ( manager.students.isEmpty() ) {
                    System.out.println("No Students Registered");
                } else {
                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    for ( Student s : manager.students ) {
                        if ( studentName.equalsIgnoreCase(s.name) ) {
                            System.out.println("Student: "+s.name+" found!");
                            found = true;
                        }
                    }
                    if ( !found ) {
                        System.out.println("Student Not Found.");
                    }
                }
            } else if ( option == 2 ) {
                boolean found = false;

                if ( manager.students.isEmpty() ) {
                    System.out.println("No Students Registered");
                } else {
                    System.out.print("Enter Student Surname: ");
                    String studentSurname = sc.nextLine();

                    for ( Student s : manager.students ) {
                        if ( studentSurname.equalsIgnoreCase(s.surname) ) {
                            System.out.println("Student: "+s.surname+" found!");
                            found = true;
                        }
                    }
                    if ( !found ) {
                        System.out.println("Student Not Found.");
                    }
                }
            } else if ( option == 3 ) {
                boolean found = false;

                if ( manager.students.isEmpty() ) {
                    System.out.println("No Students Registered");
                } else {
                    System.out.print("Enter Student ID: ");
                    String studentID = sc.nextLine();

                    for ( Student s : manager.students ) {
                        if ( studentID.equalsIgnoreCase(s.idNumber) ) {
                            System.out.println("Student: "+s.idNumber+" found!");
                            found = true;
                        }
                    }
                    if ( !found ) {
                        System.out.println("Student Not Found.");
                    }
                }
            } else if ( option == 0 )  {
                System.out.println("Returning to Main Menu...");
                searchStudentMenuRunning = false;
            }

        }
    }
}

