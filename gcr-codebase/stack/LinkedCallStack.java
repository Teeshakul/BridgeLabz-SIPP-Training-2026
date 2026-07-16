import java.util.Scanner;

class Frame {

    String functionName;
    Frame next;

    Frame(String functionName, Frame next) {
        this.functionName = functionName;
        this.next = next;
    }
}

public class LinkedCallStack {

    private Frame top = null;

    void push(String functionName) {

        top = new Frame(functionName, top);
    }

    String pop() {

        if (isEmpty())
            return "No Active Function";

        String name = top.functionName;
        top = top.next;

        return name;
    }

    String peek() {

        if (isEmpty())
            return "No Active Function";

        return top.functionName;
    }

    boolean isEmpty() {
        return top == null;
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Call Stack Empty");
            return;
        }

        Frame temp = top;

        System.out.println("Call Stack:");

        while (temp != null) {

            System.out.println(temp.functionName);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedCallStack stack = new LinkedCallStack();

        while (true) {

            System.out.println("\n1. Push Function");
            System.out.println("2. Return Function");
            System.out.println("3. Current Function");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Function Name: ");
                    stack.push(sc.nextLine());
                    break;

                case 2:
                    System.out.println("Returned: " + stack.pop());
                    break;

                case 3:
                    System.out.println("Current Function: " + stack.peek());
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}