import java.util.Scanner;

class SearchNode {

    int value;
    SearchNode left;
    SearchNode right;

    SearchNode(int value) {
        this.value = value;
    }
}

public class BSTSearch {

    static SearchNode insert(SearchNode root, int value) {

        if (root == null)
            return new SearchNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    static boolean search(SearchNode root, int target) {

        SearchNode current = root;

        while (current != null) {

            if (target == current.value)
                return true;

            if (target < current.value)
                current = current.left;
            else
                current = current.right;
        }

        return false;
    }

    static void inorder(SearchNode root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        SearchNode root = null;

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.print("BST: ");
        inorder(root);

        System.out.print("\nEnter value to search: ");
        int target = sc.nextInt();

        if (search(root, target))
            System.out.println("Value Found");
        else
            System.out.println("Value Not Found");
    }
}