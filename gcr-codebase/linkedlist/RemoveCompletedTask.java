import java.util.Scanner;

class TaskNode {

    int taskId;
    TaskNode next;

    TaskNode(int taskId) {
        this.taskId = taskId;
    }
}

public class RemoveCompletedTask {

    static TaskNode removeTask(TaskNode head, int taskId) {

        if (head == null)
            return null;

        if (head.taskId == taskId)
            return head.next;

        TaskNode previous = head;
        TaskNode current = head.next;

        while (current != null && current.taskId != taskId) {

            previous = current;
            current = current.next;
        }

        if (current != null)
            previous.next = current.next;

        return head;
    }

    static void display(TaskNode head) {

        while (head != null) {
            System.out.print(head.taskId + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        TaskNode head = null;
        TaskNode tail = null;

        System.out.println("Enter Task IDs:");

        for (int i = 0; i < n; i++) {

            TaskNode node = new TaskNode(sc.nextInt());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        System.out.print("Enter completed Task ID: ");
        int id = sc.nextInt();

        head = removeTask(head, id);

        System.out.println("Updated Task Queue:");

        display(head);
    }
}