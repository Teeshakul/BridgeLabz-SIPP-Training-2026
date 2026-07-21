import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class EmployeeNode {

    int id;
    EmployeeNode left;
    EmployeeNode right;

    EmployeeNode(int id) {
        this.id = id;
    }
}

public class LevelOrderBroadcast {

    static EmployeeNode insert(EmployeeNode root, int id) {

        if (root == null)
            return new EmployeeNode(id);

        if (id < root.id)
            root.left = insert(root.left, id);
        else
            root.right = insert(root.right, id);

        return root;
    }

    static List<List<Integer>> levelOrder(EmployeeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<EmployeeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                EmployeeNode current = queue.poll();

                level.add(current.id);

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        EmployeeNode root = null;

        System.out.println("Enter employee IDs:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.println("Broadcast Order:");

        List<List<Integer>> result = levelOrder(root);

        for (List<Integer> level : result)
            System.out.println(level);
    }
}