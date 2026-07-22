import java.util.Scanner;

class Node {

    int trackId;
    Node next;

    Node(int trackId) {
        this.trackId = trackId;
    }
}

public class InsertTrackPlaylist {

    static Node insertAfter(Node current, int trackId) {

        if (current == null)
            return null;

        Node newNode = new Node(trackId);

        newNode.next = current.next;
        current.next = newNode;

        return newNode;
    }

    static void display(Node head) {

        while (head != null) {
            System.out.print(head.trackId + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tracks: ");
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        System.out.println("Enter Track IDs:");

        for (int i = 0; i < n; i++) {

            Node node = new Node(sc.nextInt());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.print("Enter current track ID: ");
        int currentId = sc.nextInt();

        System.out.print("Enter new track ID: ");
        int newTrack = sc.nextInt();

        Node current = head;

        while (current != null && current.trackId != currentId)
            current = current.next;

        insertAfter(current, newTrack);

        System.out.println("Updated Playlist:");

        display(head);
    }
}