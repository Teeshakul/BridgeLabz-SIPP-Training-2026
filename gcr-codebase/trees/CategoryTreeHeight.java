import java.util.Scanner;

class CategoryNode {

    int id;
    CategoryNode left;
    CategoryNode right;

    CategoryNode(int id) {
        this.id = id;
    }
}

public class CategoryTreeHeight {

    static CategoryNode insert(CategoryNode root, int id) {

        if (root == null)
            return new CategoryNode(id);

        if (id < root.id)
            root.left = insert(root.left, id);
        else
            root.right = insert(root.right, id);

        return root;
    }

    static int height(CategoryNode node) {

        if (node == null)
            return -1;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static boolean exceedsThreshold(CategoryNode root, int threshold) {

        return height(root) > threshold;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of categories: ");
        int n = sc.nextInt();

        CategoryNode root = null;

        System.out.println("Enter category IDs:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        int treeHeight = height(root);

        System.out.println("Tree Height = " + treeHeight);

        if (exceedsThreshold(root, threshold))
            System.out.println("Category Tree Exceeds Threshold");
        else
            System.out.println("Category Tree Within Threshold");
    }
}