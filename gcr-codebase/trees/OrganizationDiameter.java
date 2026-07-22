import java.util.Scanner;

class Employee {

    int id;
    Employee left;
    Employee right;

    Employee(int id) {
        this.id = id;
    }
}

public class OrganizationDiameter {

    static int diameter = 0;

    static Employee insert(Employee root, int id) {

        if (root == null)
            return new Employee(id);

        if (id < root.id)
            root.left = insert(root.left, id);
        else
            root.right = insert(root.right, id);

        return root;
    }

    static int height(Employee node) {

        if (node == null)
            return -1;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int findDiameter(Employee root) {

        diameter = 0;
        height(root);

        return diameter;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee root = null;

        System.out.println("Enter employee IDs:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextInt());

        System.out.println("Diameter = " + findDiameter(root));
    }
}