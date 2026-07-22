import java.util.Scanner;

public class CircularPacketBuffer {

    private int[] buffer;
    private int front;
    private int count;

    public CircularPacketBuffer(int capacity) {

        buffer = new int[capacity];
        front = 0;
        count = 0;
    }

    boolean enqueue(int packet) {

        if (count == buffer.length) {

            System.out.println("Buffer Full");
            return false;
        }

        int rear = (front + count) % buffer.length;

        buffer[rear] = packet;

        count++;

        return true;
    }

    int dequeue() {

        if (count == 0) {

            System.out.println("Buffer Empty");
            return -1;
        }

        int packet = buffer[front];

        front = (front + 1) % buffer.length;

        count--;

        return packet;
    }

    void display() {

        if (count == 0) {

            System.out.println("Buffer Empty");
            return;
        }

        System.out.print("Packets: ");

        for (int i = 0; i < count; i++) {

            System.out.print(buffer[(front + i) % buffer.length] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Buffer Capacity: ");
        int size = sc.nextInt();

        CircularPacketBuffer queue = new CircularPacketBuffer(size);

        while (true) {

            System.out.println("\n1. Enqueue Packet");
            System.out.println("2. Dequeue Packet");
            System.out.println("3. Display Buffer");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Packet ID: ");
                    queue.enqueue(sc.nextInt());
                    break;

                case 2:

                    int packet = queue.dequeue();

                    if (packet != -1)
                        System.out.println("Processed Packet: " + packet);

                    break;

                case 3:

                    queue.display();
                    break;

                case 4:

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}