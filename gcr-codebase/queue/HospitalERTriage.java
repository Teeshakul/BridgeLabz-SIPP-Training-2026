import java.util.PriorityQueue;
import java.util.Scanner;

class Patient {

    int priority;
    String name;

    Patient(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class HospitalERTriage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Patient> queue =
                new PriorityQueue<>((a, b) -> a.priority - b.priority);

        while (true) {

            System.out.println("\n1. Admit Patient");
            System.out.println("2. Call Next Patient");
            System.out.println("3. Peek Next Patient");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Priority (1-5): ");
                    int priority = sc.nextInt();

                    queue.offer(new Patient(priority, name));

                    break;

                case 2:

                    if (queue.isEmpty())
                        System.out.println("No Patients Waiting");
                    else
                        System.out.println("Calling: " + queue.poll());

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