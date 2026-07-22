import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrintQueueDeque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        while (true) {

            System.out.println("\n1. Submit Normal Job");
            System.out.println("2. Submit Urgent Job");
            System.out.println("3. Print Next Job");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Job Name: ");
                    queue.addLast(sc.nextLine());
                    break;

                case 2:

                    System.out.print("Urgent Job Name: ");
                    queue.addFirst(sc.nextLine());
                    break;

                case 3:

                    if (queue.isEmpty())
                        System.out.println("Queue Empty");
                    else
                        System.out.println("Printing: " + queue.removeFirst());

                    break;

                case 4:

                    System.out.println(queue);

                    break;

                case 5:

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}