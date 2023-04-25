import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Inventory {
    private String filename;

    public void toCSV(ArrayList<Product> inventory)
    {

    }

    public void saveInventory() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String timestamp = formatter.format(date);
        String newFilename = "inventory_" + timestamp + ".csv";

        try {
            FileWriter fileWriter = new FileWriter("./src/files/" + newFilename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Write the header
            printWriter.println("Type,Title,Author,Album,Cost,Qty");


            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

