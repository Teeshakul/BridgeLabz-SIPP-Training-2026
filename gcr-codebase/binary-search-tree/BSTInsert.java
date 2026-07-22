import java.util.Scanner;

class InsertNode {

    int value;
    InsertNode left;
    InsertNode right;

    InsertNode(int value) {
        this.value = value;
    }
}

public class BSTInsert {

    static InsertNode insert(InsertNode root, int value) {

        if (root == null)
            return new InsertNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    static void inorder(InsertNode root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of initial nodes: ");
        int n = sc.nextInt();

        InsertNode root = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.print("Enter new value to insert: ");
        int value = sc.nextInt();

        root = insert(root, value);

        System.out.println("BST After Insertion:");

        inorder(root);
    }
}