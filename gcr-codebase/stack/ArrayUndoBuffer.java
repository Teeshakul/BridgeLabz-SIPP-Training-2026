import java.util.Scanner;

public class ArrayUndoBuffer {

    private String[] data;
    private int top;

    public ArrayUndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    boolean push(String edit) {

        if (top == data.length - 1) {
            System.out.println("Undo Buffer Full");
            return false;
        }

        data[++top] = edit;
        return true;
    }

    String pop() {

        if (isEmpty())
            return "Nothing to Undo";

        return data[top--];
    }

    String peek() {

        if (isEmpty())
            return "Undo Buffer Empty";

        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Undo Buffer Empty");
            return;
        }

        System.out.println("Undo Buffer:");

        for (int i = top; i >= 0; i--)
            System.out.println(data[i]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum undo size: ");
        int size = sc.nextInt();
        sc.nextLine();

        ArrayUndoBuffer buffer = new ArrayUndoBuffer(size);

        while (true) {

            System.out.println("\n1. Push");
            System.out.println("2. Undo");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter edit: ");
                    buffer.push(sc.nextLine());
                    break;

                case 2:
                    System.out.println("Undo: " + buffer.pop());
                    break;

                case 3:
                    System.out.println("Latest Edit: " + buffer.peek());
                    break;

                case 4:
                    buffer.display();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}