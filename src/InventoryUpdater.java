import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InventoryUpdater {
    private String filename;

    public void toCSV(ArrayList<Product> inventory)
    {
        String content = "";
        for (Product product : inventory)
        {
            content += product.getClass().toString() + ",";
            content += product.getTitle() + ",";
            content += product.getAuthor() + ",";
            content += product.getAlbum() + ",";
        }
    }

    public void saveInventory() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String timestamp = sdf.format(date);
        String newFilename = "inventory-" + timestamp + ".csv";

        try {
            FileWriter fileWriter = new FileWriter("./src/files/" + newFilename);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Writes the header text
            printWriter.println("Type,Title,Author,Album,Cost,Qty");

            //TODO: write the content string from toCSV

            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

