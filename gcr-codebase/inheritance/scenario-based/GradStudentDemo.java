class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name;
    }
}

class Student extends Person {
    final int studentId;
    double gpa;

    Student(String name, int studentId, double gpa) {
        super(name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() +
                "\nStudent ID: " + studentId +
                "\nGPA: " + gpa;
    }
}

class GradStudent extends Student {
    String thesis;

    GradStudent(String name, int studentId, double gpa, String thesis) {
        super(name, studentId, gpa);
        this.thesis = thesis;
    }

    public String toString() {
        return super.toString() +
                "\nThesis: " + thesis;
    }
}

public class GradStudentDemo {
    public static void main(String[] args) {

        GradStudent g = new GradStudent("Teesha",101,9.2,"AI");

        System.out.println(g);

        System.out.println(g instanceof Student);
        System.out.println(g instanceof Person);
    }
}