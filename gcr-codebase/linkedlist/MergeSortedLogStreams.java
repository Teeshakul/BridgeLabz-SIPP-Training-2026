import java.util.Scanner;

class LogNode {

    int timestamp;
    LogNode next;

    LogNode(int timestamp) {
        this.timestamp = timestamp;
    }
}

public class MergeSortedLogStreams {

    static LogNode merge(LogNode first, LogNode second) {

        LogNode dummy = new LogNode(0);
        LogNode tail = dummy;

        while (first != null && second != null) {

            if (first.timestamp <= second.timestamp) {

                tail.next = first;
                first = first.next;

            } else {

                tail.next = second;
                second = second.next;
            }

            tail = tail.next;
        }

        if (first != null)
            tail.next = first;
        else
            tail.next = second;

        return dummy.next;
    }

    static void display(LogNode head) {

        while (head != null) {

            System.out.print(head.timestamp + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    static LogNode createList(Scanner sc, int n) {

        LogNode head = null;
        LogNode tail = null;

        for (int i = 0; i < n; i++) {

            LogNode node = new LogNode(sc.nextInt());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first log stream: ");
        int n1 = sc.nextInt();

        System.out.println("Enter sorted timestamps:");
        LogNode first = createList(sc, n1);

        System.out.print("Enter size of second log stream: ");
        int n2 = sc.nextInt();

        System.out.println("Enter sorted timestamps:");
        LogNode second = createList(sc, n2);

        LogNode merged = merge(first, second);

        System.out.println("\nMerged Log Stream:");

        display(merged);
    }
}