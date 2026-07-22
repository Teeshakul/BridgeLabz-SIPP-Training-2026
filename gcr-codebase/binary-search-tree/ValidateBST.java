import java.util.Scanner;

class ValidateNode {

    int value;
    ValidateNode left;
    ValidateNode right;

    ValidateNode(int value) {
        this.value = value;
    }
}

public class ValidateBST {

    static ValidateNode insert(ValidateNode root, int value) {

        if (root == null)
            return new ValidateNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    static boolean validate(ValidateNode node, long min, long max) {

        if (node == null)
            return true;

        if (node.value <= min || node.value >= max)
            return false;

        return validate(node.left, min, node.value)
                && validate(node.right, node.value, max);
    }

    static boolean isValidBST(ValidateNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ValidateNode root = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        if (isValidBST(root))
            System.out.println("Valid BST");
        else
            System.out.println("Invalid BST");
    }
}