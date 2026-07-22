import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueensSensorPlacement {

    static boolean isSafe(int row,
                          int col,
                          int[] sensorCol) {

        for (int i = 0; i < row; i++) {

            if (sensorCol[i] == col)
                return false;

            if (Math.abs(sensorCol[i] - col) == Math.abs(i - row))
                return false;
        }

        return true;
    }

    static void solve(int n,
                      int row,
                      int[] sensorCol,
                      List<List<String>> result) {

        if (row == n) {

            result.add(buildBoard(n, sensorCol));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, sensorCol)) {

                sensorCol[row] = col;

                solve(n,
                        row + 1,
                        sensorCol,
                        result);
            }
        }
    }

    static List<String> buildBoard(int n,
                                   int[] sensorCol) {

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {

                if (sensorCol[i] == j)
                    row.append("Q ");
                else
                    row.append(". ");
            }

            board.add(row.toString());
        }

        return board;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size: ");
        int n = sc.nextInt();

        List<List<String>> result = new ArrayList<>();

        solve(n,
                0,
                new int[n],
                result);

        System.out.println("\nPossible Arrangements:");

        for (List<String> board : result) {

            for (String row : board)
                System.out.println(row);

            System.out.println();
        }
    }
}