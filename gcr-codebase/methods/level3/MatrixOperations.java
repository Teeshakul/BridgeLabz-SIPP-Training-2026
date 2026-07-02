public class MatrixOperations {

    static int[][] randomMatrix(int r, int c) {

        int[][] mat = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = 1 + (int)(Math.random() * 9);

        return mat;
    }

    static int[][] add(int[][] a, int[][] b) {

        int[][] ans = new int[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                ans[i][j]=a[i][j]+b[i][j];

        return ans;
    }

    static int[][] subtract(int[][] a,int[][] b){

        int[][] ans=new int[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                ans[i][j]=a[i][j]-b[i][j];

        return ans;
    }

    static int[][] multiply(int[][] a,int[][] b){

        int[][] ans=new int[a.length][b[0].length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<b[0].length;j++)
                for(int k=0;k<b.length;k++)
                    ans[i][j]+=a[i][k]*b[k][j];

        return ans;
    }

    static void display(int[][] mat){

        for(int[] row:mat){

            for(int val:row)
                System.out.print(val+" ");

            System.out.println();
        }
    }

    public static void main(String[] args){

        int[][] a=randomMatrix(3,3);
        int[][] b=randomMatrix(3,3);

        System.out.println("Matrix A");
        display(a);

        System.out.println("\nMatrix B");
        display(b);

        System.out.println("\nAddition");
        display(add(a,b));

        System.out.println("\nSubtraction");
        display(subtract(a,b));

        System.out.println("\nMultiplication");
        display(multiply(a,b));
    }
}