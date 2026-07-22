import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class OrgNode {

    int id;
    OrgNode left;
    OrgNode right;

    OrgNode(int id) {
        this.id = id;
    }
}

public class IterativePreorderOrgChart {

    static OrgNode insert(OrgNode root, int id) {

        if (root == null)
            return new OrgNode(id);

        if (id < root.id)
            root.left = insert(root.left, id);
        else
            root.right = insert(root.right, id);

        return root;
    }

    static List<Integer> preorder(OrgNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<OrgNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            OrgNode current = stack.pop();

            result.add(current.id);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        OrgNode root = null;

        System.out.println("Enter employee IDs:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.println("Preorder Traversal:");

        System.out.println(preorder(root));
    }
}