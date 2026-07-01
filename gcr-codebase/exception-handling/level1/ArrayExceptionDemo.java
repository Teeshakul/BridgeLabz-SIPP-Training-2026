import java.util.*;

public class ArrayExceptionDemo{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int[] arr={10,20,30};

        int index=sc.nextInt();

        try{
            System.out.println("Value = "+arr[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index!");
        }
        catch(NullPointerException e){
            System.out.println("Array is not initialized!");
        }
    }
}