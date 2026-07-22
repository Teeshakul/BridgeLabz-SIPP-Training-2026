import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {

        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("bill.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }

            reader.close();

            System.out.println("Total Lines = " + count);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}