import java.io.*;
import java.util.Scanner;

public class StudentReportCard {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("students.txt"));

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("report.txt", true)); // append mode

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];
                int phy = Integer.parseInt(data[1]);
                int chem = Integer.parseInt(data[2]);
                int maths = Integer.parseInt(data[3]);

                double avg = (phy + chem + maths) / 3.0;

                bw.write("Student: " + name);
                bw.newLine();
                bw.write("Average Marks: " + avg);
                bw.newLine();
                bw.write("----------------------");
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Report generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error while reading/writing file");
        }
    }
}