import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Subjects> subjects = new ArrayList<>();

    String name, surname, idNumber;
    int age, pin;

    public Student(String name, String surname, String idNumber, int age, int pin) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.age = age;
        this.pin = pin;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getIdNumber() {
        return idNumber;
    }
    public int getPin(){
        return pin;
    }
    public static void studentMenu(){

        boolean studentMenuRunning = true;

        do {

            int option = 0;
            try {
                System.out.println("===== Student Menu =====");
                System.out.println("<1> Log Results");
                System.out.println("<2> See Average");
                System.out.println("<3> Add Subject");
                System.out.println("<0> Exit");
                System.out.print("Select: ");
                option = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something Went Wrong!");
                throw new RuntimeException(e);
            }

            switch ( option ) {
                case 1: logResults();
                    break;
                case 2: seeAverage();
                    break;
                case 3: addSubject();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    studentMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid Selection!");
            }

        }while(studentMenuRunning);
    }

    public static void logResults() {

        boolean logResultsMenuRunning = true;
        int subjectOpt = 0;
        String selectedSubject = "", gradeLevel = "";
        while ( logResultsMenuRunning ) {

            try {
                System.out.println("<1> Math");
                System.out.println("<2> English");
                System.out.println("<3> Science");
                System.out.println("<0> Exit");
                System.out.print("Select: ");
                subjectOpt = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Something Went Wrong!");
                throw new RuntimeException(e);
            }

            switch ( subjectOpt ) {
                case 1: selectedSubject = "MATH";
                    break;
                case 2: selectedSubject = "ENGLISH";
                    break;
                case 3: selectedSubject = "SCIENCE";
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    logResultsMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid Selection!");

            }
            if ( subjectOpt != 0 ) {

                System.out.println("Selected "+selectedSubject);
                System.out.print("Enter Number of Tests/Exams: ");
                int numOfTests = sc.nextInt();
                sc.nextLine();
                int counter = 1, total = 0, finalTotal = 0;
                double markReceived = 0.0, average = 0.0, percentage = 0.0;
                while ( counter <= numOfTests ) {
                    System.out.print("Enter Test/Exam "+counter+" Total: ");
                    total = sc.nextInt();
                    System.out.print("Enter Mark Received: ");
                    markReceived = sc.nextDouble();
                    percentage = ( ( markReceived / total ) * 100 );
                    finalTotal += total;
                    average += percentage;
                    counter++;
                }
                average = (average / numOfTests);
                if ( average < 50.0 ) {
                    gradeLevel = "Fail";
                } else if ( average >= 50.00 && average < 75.00 ) {
                    gradeLevel = "Pass";
                } else if ( average >= 75 ) {
                    gradeLevel = "Distinction";
                }
                Subjects newSubject = new Subjects(selectedSubject, gradeLevel, average, finalTotal);
                subjects.add(newSubject);
            }

        }

    }
    public static void seeAverage(){
        boolean seeAverageMenuRunning = true;
        int option = 0;
        String selectedSubject = "";
        while ( seeAverageMenuRunning ) {


            try {
                System.out.println("<1> Math");
                System.out.println("<2> English");
                System.out.println("<3> Science");
                System.out.println("<0> Exit");
                System.out.print("Select: ");
                option = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something Went Wrong");
                throw new RuntimeException(e);
            }

            switch ( option ) {
                case 1: selectedSubject = "MATH";
                    break;
                case 2: selectedSubject = "ENGLISH";
                    break;
                case 3: selectedSubject = "SCIENCE";
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    seeAverageMenuRunning = false;
                    break;
                default:
                    System.out.println("Error!");
                    seeAverageMenuRunning = false;
            }

            boolean found = false;
            if (subjects.isEmpty())
                System.out.println("No Subjects Logged.");
            else{
                for (Subjects s : subjects){
                    if ( selectedSubject.equalsIgnoreCase(s.getSubject()) ) {
                        System.out.println("Average for "+selectedSubject+": "+(Math.round(s.getAverage() * 100.0)/100.0)+"%");
                    } else if( !found ) {
                        System.out.println("Subject Result Not Found");
                    }
                }
            }
        }

    }
    public static void addSubject(){
        System.out.println("FEATURE COMING SOON!!");
    }
    @Override
    public String toString(){
        return "Name: "+name+"\nSurname: "+surname+"\n===============";
    }
}
