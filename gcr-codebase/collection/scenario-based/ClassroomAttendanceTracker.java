import java.util.*;

public class ClassroomAttendanceTracker {
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> attendance = new HashMap<>();

        markAttendance(attendance, "Java", "Rahul");
        markAttendance(attendance, "Java", "Aman");
        markAttendance(attendance, "Java", "Rahul");

        markAttendance(attendance, "Python", "Neha");
        markAttendance(attendance, "Python", "Riya");

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject: " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String s : students)
                System.out.println(s);

            System.out.println("Total Students = " + students.size());
        }
    }

    static void markAttendance(HashMap<String, ArrayList<String>> map,
                               String subject,
                               String student) {

        map.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> list = map.get(subject);

        if (!list.contains(student))
            list.add(student);
        else
            System.out.println(student + " already marked in " + subject);
    }
}