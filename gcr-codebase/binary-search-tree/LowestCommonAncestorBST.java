import java.util.Scanner;

class LcaNode {

    int value;
    LcaNode left;
    LcaNode right;

    LcaNode(int value) {
        this.value = value;
    }
}

public class LowestCommonAncestorBST {

    static LcaNode insert(LcaNode root, int value) {

        if (root == null)
            return new LcaNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    static LcaNode lowestCommonAncestor(LcaNode root, int first, int second) {

        LcaNode current = root;

        while (current != null) {

            if (first < current.value && second < current.value)
                current = current.left;

            else if (first > current.value && second > current.value)
                current = current.right;

            else
                return current;
        }

        return null;
    }

    static void inorder(LcaNode root) {

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

        LcaNode root = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.print("Enter first node: ");
        int first = sc.nextInt();

        System.out.print("Enter second node: ");
        int second = sc.nextInt();

        LcaNode lca = lowestCommonAncestor(root, first, second);

        System.out.print("BST (Inorder): ");
        inorder(root);

        if (lca != null)
            System.out.println("\nLowest Common Ancestor = " + lca.value);
        else
            System.out.println("\nNodes not found.");
    }
}