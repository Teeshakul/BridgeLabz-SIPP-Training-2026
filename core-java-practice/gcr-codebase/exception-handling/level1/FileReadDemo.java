import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {
    public static void main(String[] args) {

        try {
            FileReader file = new FileReader("data.txt");

            int ch;
            while ((ch = file.read()) != -1) {
                System.out.print((char) ch);
            }

            file.close();

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}