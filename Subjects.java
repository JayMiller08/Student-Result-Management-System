public class Subjects {

    String subjectName, gradeLevel;
    int total;
    double average;

    public Subjects(String subjectName, String gradeLevel, double average, int total){
        this.subjectName = subjectName;
        this.gradeLevel = gradeLevel;
        this.average = average;
        this.total = total;
    }

    public void setSubject(String subject) {
        this.subjectName = subject;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getSubject() {
        return subjectName;
    }
}
