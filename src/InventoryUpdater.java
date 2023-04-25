import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InventoryUpdater {

    public static String toCSV(ArrayList<Product> inventory)
    {
        String content = "";
        for (Product product : inventory)
        {
            content += product.getClass().getName() + ",";
            content += product.getTitle() + ",";
            content += product.getAuthor() + ",";
            content += product.getAlbum() + ",";
            content += product.getCost() + ",";
            content += product.getQuantity() + "\n";
        }
        return content;
    }

    public static void saveInventory(ArrayList<Product> inventory) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date date = new Date();
        String timestamp = sdf.format(date);
        String newFilename = "inventory-" + timestamp + ".csv";

        try {
            FileWriter fileWriter = new FileWriter("./src/files/" + newFilename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Writes the header text
            printWriter.println("Type,Title,Author,Album,Cost,Qty");

            printWriter.println(toCSV(inventory));

            printWriter.close();

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

