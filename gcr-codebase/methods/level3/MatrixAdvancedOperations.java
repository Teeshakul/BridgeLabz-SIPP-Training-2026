public class MatrixAdvancedOperations {

    static int[][] randomMatrix() {

        int[][] mat = new int[2][2];

        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                mat[i][j]=1+(int)(Math.random()*9);

        return mat;
    }

    static int[][] transpose(int[][] a){

        int[][] t=new int[a[0].length][a.length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                t[j][i]=a[i][j];

        return t;
    }

    static int determinant(int[][] a){

        return a[0][0]*a[1][1]-a[0][1]*a[1][0];
    }

    static void inverse(int[][] a){

        int det=determinant(a);

        if(det==0){

            System.out.println("Inverse Not Possible");
            return;
        }

        System.out.println("Inverse Matrix");

        System.out.printf("%.2f %.2f%n",
                a[1][1]/(double)det,
                -a[0][1]/(double)det);

        System.out.printf("%.2f %.2f%n",
                -a[1][0]/(double)det,
                a[0][0]/(double)det);
    }

    static void display(int[][] a){

        for(int[] row:a){

            for(int x:row)
                System.out.print(x+" ");

            System.out.println();
        }
    }

    public static void main(String[] args){

        int[][] mat=randomMatrix();

        System.out.println("Matrix");
        display(mat);

        System.out.println("\nTranspose");
        display(transpose(mat));

        System.out.println("\nDeterminant = "+determinant(mat));

        inverse(mat);
    }
}