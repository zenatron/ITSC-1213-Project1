public class Product {

    private String productName;
    private String productID;
    private double productCost;

    public Product(String productName, String productID, double productCost) {
        this.productName = productName;
        this.productID = productID;
        this.productCost = productCost;
    }

    public Product(String productName, double productCost) {
        this.productName = productName;
        this.productID = shortenBookTitle(productName);
        this.productCost = productCost;
    }

    //removes spaces, vowels, and illegal characters to make the productID
    public static String shortenBookTitle(String title) {
        title = title.toLowerCase().replaceAll("\\s", "");
        title = title.replaceAll("[^a-z, 0-9]", "");
        title = title.replaceAll("[aeiou]", "");
        //limits the length to 8
        if (title.length() > 8) {
            title = title.substring(0, 8);
        }
        return title;
    }
}