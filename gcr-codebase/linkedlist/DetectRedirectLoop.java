import java.util.Scanner;

class RedirectNode {

    String url;
    RedirectNode next;

    RedirectNode(String url) {
        this.url = url;
    }
}

public class DetectRedirectLoop {

    static boolean hasLoop(RedirectNode head) {

        RedirectNode slow = head;
        RedirectNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    static void display(RedirectNode head) {

        RedirectNode temp = head;

        while (temp != null) {

            System.out.print(temp.url + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of URLs: ");
        int n = sc.nextInt();
        sc.nextLine();

        RedirectNode head = null;
        RedirectNode tail = null;

        System.out.println("Enter URLs:");

        RedirectNode[] nodes = new RedirectNode[n];

        for (int i = 0; i < n; i++) {

            RedirectNode node = new RedirectNode(sc.nextLine());

            nodes[i] = node;

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.print("Create loop? (y/n): ");
        char choice = sc.next().charAt(0);

        if (choice == 'y' || choice == 'Y') {

            System.out.print("Enter node index to connect last node (0 to " + (n - 1) + "): ");
            int index = sc.nextInt();

            tail.next = nodes[index];
        }

        System.out.println("Loop Exists = " + hasLoop(head));
    }
}