import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportGenerator
{
    public static void generateReport(String report)
    {
        try {
            // Creates a unique filename based on current date and time
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String fileName = "report-" + sdf.format(new Date()) + ".txt";

            // Creates a file object in the ./src/files directory
            File file = new File("./src/files/" + fileName);

            // Writes the report data to the file
            FileWriter writer = new FileWriter(file);
            writer.write(report);
            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
