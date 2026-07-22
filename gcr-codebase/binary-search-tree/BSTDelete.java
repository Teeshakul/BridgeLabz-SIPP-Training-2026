import java.util.Scanner;

class DeleteNode {

    int value;
    DeleteNode left;
    DeleteNode right;

    DeleteNode(int value) {
        this.value = value;
    }
}

public class BSTDelete {

    static DeleteNode insert(DeleteNode root, int value) {

        if (root == null)
            return new DeleteNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    static DeleteNode delete(DeleteNode root, int value) {

        if (root == null)
            return null;

        if (value < root.value)
            root.left = delete(root.left, value);

        else if (value > root.value)
            root.right = delete(root.right, value);

        else {

            if (root.left == null && root.right == null)
                return null;

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            DeleteNode successor = root.right;

            while (successor.left != null)
                successor = successor.left;

            root.value = successor.value;

            root.right = delete(root.right, successor.value);
        }

        return root;
    }

    static void inorder(DeleteNode root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        DeleteNode root = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.print("Enter value to delete: ");
        int value = sc.nextInt();

        root = delete(root, value);

        System.out.println("BST After Deletion:");

        inorder(root);
    }
}