import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InventoryUpdater {

    public static void saveInventory(ArrayList<Product> inventory) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        Date date = new Date();
        String timestamp = sdf.format(date);
        String newFilename = "inventory-" + timestamp + ".csv";

        try {

            FileWriter fileWriter = new FileWriter("./src/files/" + newFilename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Writes the header text
            printWriter.write("Type,Title,Author,Album,Cost,Qty");

            for (Product product : inventory) {
                printWriter.write("\n");
                printWriter.write(product.getClass().getName() + "," + product.getTitle() + "," + product.getAuthor() + "," + product.getAlbum() + "," + product.getCost() + "," + product.getQuantity());
            }

            fileWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

