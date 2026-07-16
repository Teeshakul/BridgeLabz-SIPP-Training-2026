import java.util.Scanner;

class HistoryNode {

    String page;
    HistoryNode next;

    HistoryNode(String page) {
        this.page = page;
    }
}

public class ReverseBrowserHistory {

    static HistoryNode reverseHistory(HistoryNode head) {

        HistoryNode previous = null;
        HistoryNode current = head;

        while (current != null) {

            HistoryNode next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    static void display(HistoryNode head) {

        while (head != null) {

            System.out.print(head.page + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        sc.nextLine();

        HistoryNode head = null;
        HistoryNode tail = null;

        System.out.println("Enter page names:");

        for (int i = 0; i < n; i++) {

            HistoryNode node = new HistoryNode(sc.nextLine());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.println("\nOriginal History:");
        display(head);

        head = reverseHistory(head);

        System.out.println("\nReversed History:");
        display(head);
    }
}