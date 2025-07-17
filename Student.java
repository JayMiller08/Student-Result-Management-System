public class Student {

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
        System.out.println("**This Runs Student Class Menu*");
    }

    @Override
    public String toString(){
        return "Name: "+name+"\nSurname: "+surname;
    }
}
