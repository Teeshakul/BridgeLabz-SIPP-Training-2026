import java.util.Scanner;

public class WarehouseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Stock Array
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] stock = new int[n];

        System.out.println("Enter stock quantities:");
        for (int i = 0; i < n; i++) {
            stock[i] = sc.nextInt();
        }

        int max = stock[0];
        int min = stock[0];
        int total = 0;

        System.out.println("\nDuplicate Quantities:");
        boolean foundDuplicate = false;

        for (int i = 0; i < n; i++) {
            total += stock[i];

            if (stock[i] > max)
                max = stock[i];

            if (stock[i] < min)
                min = stock[i];

            for (int j = i + 1; j < n; j++) {
                if (stock[i] == stock[j]) {
                    System.out.println(stock[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate)
            System.out.println("No Duplicates");

        System.out.println("\nMaximum Stock = " + max);
        System.out.println("Minimum Stock = " + min);
        System.out.println("Total Stock = " + total);

        // Rotate Array
        System.out.print("\nEnter rotation value k: ");
        int k = sc.nextInt();

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = stock[i];
        }

        System.out.print("Rotated Stock Array: ");
        for (int num : rotated) {
            System.out.print(num + " ");
        }

        // 2D Shelf Grid
        System.out.print("\n\nEnter rows and columns of shelf grid: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] shelf = new int[rows][cols];

        System.out.println("Enter shelf values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                shelf[i][j] = sc.nextInt();
            }
        }

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = shelf[i][j];
            }
        }

        System.out.println("\nTransposed Shelf Grid:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}