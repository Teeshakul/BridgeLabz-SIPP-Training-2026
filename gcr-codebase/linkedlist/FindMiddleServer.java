import java.util.Scanner;

class ServerNode {

    String serverName;
    ServerNode next;

    ServerNode(String serverName) {
        this.serverName = serverName;
    }
}

public class FindMiddleServer {

    static ServerNode findMiddle(ServerNode head) {

        ServerNode slow = head;
        ServerNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static void display(ServerNode head) {

        while (head != null) {

            System.out.print(head.serverName + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of servers: ");
        int n = sc.nextInt();
        sc.nextLine();

        ServerNode head = null;
        ServerNode tail = null;

        System.out.println("Enter server names:");

        for (int i = 0; i < n; i++) {

            ServerNode node = new ServerNode(sc.nextLine());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.println("\nServer Chain:");
        display(head);

        ServerNode middle = findMiddle(head);

        if (middle != null)
            System.out.println("Middle Server = " + middle.serverName);
    }
}