import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}

public class SortedLeaderboardBST {

    static TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    static void inorder(TreeNode node, List<Integer> result) {

        if (node == null)
            return;

        inorder(node.left, result);

        result.add(node.value);

        inorder(node.right, result);
    }

    static List<Integer> getSortedLeaderboard(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        TreeNode root = null;

        System.out.println("Enter scores:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.println("Sorted Scores:");

        System.out.println(getSortedLeaderboard(root));
    }
}