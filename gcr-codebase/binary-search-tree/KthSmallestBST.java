import java.util.Scanner;
import java.util.Stack;

class KthNode {

    int value;
    KthNode left;
    KthNode right;

    KthNode(int value) {
        this.value = value;
    }
}

public class KthSmallestBST {

    static KthNode insert(KthNode root, int value) {

        if (root == null)
            return new KthNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    static int kthSmallest(KthNode root, int k) {

        Stack<KthNode> stack = new Stack<>();

        KthNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {

                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            count++;

            if (count == k)
                return current.value;

            current = current.right;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        KthNode root = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println(k + "th Smallest Element = " + kthSmallest(root, k));
    }
}