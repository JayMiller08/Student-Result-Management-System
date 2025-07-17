import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean mainMenuRunning = true;

        do {

            int option = 0;
            try {
                System.out.println("****** Student Result Management System ******\n");
                System.out.println("<1> Register Student");
                System.out.println("<2> Login Student");
                System.out.println("<3> Student List");
                System.out.println("<0> Exit");
                option = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something Wrong!");
                throw new RuntimeException(e);
            }

            switch (option) {
                case 1:
                    registerStudent(sc, students);
                    break;
                case 2:
                    loginStudent(sc, students);
                    break;
                case 3:
                    studentList(sc, students);
                    break;
                case 0:
                    System.out.println("Thank You, Goodbye ;-)");
            }
        }while (mainMenuRunning);
    }

    public static void registerStudent(Scanner sc, ArrayList<Student> students){
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
            students.add(newStudent);
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

    public static void loginStudent(Scanner sc, ArrayList<Student> students) {

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

            for (Student s : students) {
                if( idNumLogin.equalsIgnoreCase(s.getIdNumber()) && pinLogin == s.getPin()) {
                    System.out.println("Access Granted!");
                    Student.studentMenu();
                } else if ( !found ) {
                    System.out.println("Invalid Student Details - User Not Found.");
                }
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

    public static void studentList(Scanner sc, ArrayList<Student> students) {
        boolean studentListMenuRunning = true;
        int option4 = 0;

        while( studentListMenuRunning ) {

            System.out.println("\n");

            if ( students.isEmpty() ) {
                System.out.println("No Students Registered.\n");
                System.out.println("Returning to Main Menu....");
                studentListMenuRunning = false;
            } else {
                for ( Student s : students ) {
                    System.out.println(s.toString());
                }
                System.out.println("Returning to Main Menu....");
                studentListMenuRunning = false;
            }
        }

    }
}

