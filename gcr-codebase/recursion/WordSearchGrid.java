import java.util.Scanner;

public class WordSearchGrid {

    static boolean search(char[][] grid,
                          String word,
                          int index,
                          int row,
                          int col,
                          boolean[][] visited) {

        if (index == word.length())
            return true;

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length)
            return false;

        if (visited[row][col])
            return false;

        if (grid[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        boolean found =
                search(grid, word, index + 1, row + 1, col, visited) ||
                search(grid, word, index + 1, row - 1, col, visited) ||
                search(grid, word, index + 1, row, col + 1, visited) ||
                search(grid, word, index + 1, row, col - 1, visited);

        visited[row][col] = false;

        return found;
    }

    static boolean exists(char[][] grid, String word) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (search(grid, word, 0, i, j, visited))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        char[][] grid = new char[rows][cols];

        System.out.println("Enter grid:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.print("Enter word: ");
        String word = sc.next();

        if (exists(grid, word))
            System.out.println("Word Found");
        else
            System.out.println("Word Not Found");
    }
}