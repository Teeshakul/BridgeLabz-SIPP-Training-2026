import java.util.Scanner;

class FolderNode {

    String folder;
    FolderNode left;
    FolderNode right;

    FolderNode(String folder) {
        this.folder = folder;
    }
}

public class DeleteFolderTree {

    static void deleteTree(FolderNode node) {

        if (node == null)
            return;

        deleteTree(node.left);
        deleteTree(node.right);

        System.out.println("Deleted: " + node.folder);
    }

    static FolderNode insert(FolderNode root, String folder) {

        if (root == null)
            return new FolderNode(folder);

        if (folder.compareTo(root.folder) < 0)
            root.left = insert(root.left, folder);
        else
            root.right = insert(root.right, folder);

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of folders: ");
        int n = sc.nextInt();
        sc.nextLine();

        FolderNode root = null;

        System.out.println("Enter folder names:");

        for (int i = 0; i < n; i++)
            root = insert(root, sc.nextLine());

        System.out.println("\nDeleting Folder Tree:");

        deleteTree(root);
    }
}