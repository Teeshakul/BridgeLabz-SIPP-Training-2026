import java.util.PriorityQueue;
import java.util.Scanner;

class Patient {

    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class EmergencyRoomTriage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Patient> queue =
                new PriorityQueue<>((a, b) -> b.severity - a.severity);

        while (true) {

            System.out.println("\n1. Add Patient");
            System.out.println("2. Treat Next Patient");
            System.out.println("3. Peek Highest Priority");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Severity: ");
                    int severity = sc.nextInt();

                    queue.offer(new Patient(name, severity));

                    break;

                case 2:

                    if (queue.isEmpty())
                        System.out.println("No Patients Waiting");
                    else
                        System.out.println("Treating: " + queue.poll());

                    break;

                case 3:

                    if (queue.isEmpty())
                        System.out.println("No Patients Waiting");
                    else
                        System.out.println("Next Patient: " + queue.peek());

                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}