public class Product {

    //Probably should make these final
    private String productName;
    private String productID;
    private double productCost;
    private String productType;

    //Do NOT use this constructor for standard instantiation
    public Product(String productName, String productID, double productCost, String productType) {
        this.productName = productName;
        this.productID = productID;
        this.productCost = productCost;
        this.productType = productType;
    }

    //This constructor should be used
    public Product(String productName, double productCost, String productType) {
        this.productName = productName;

        //if there is a product with the same productID, it needs to append a random number to it
        if (Bookstore.checkInStock(productName) == true) {
            this.productID = (shortenBookTitle(productName) + String.valueOf((int) (Math.random() * 10000)));
        }
        else {this.productID = shortenBookTitle(productName);}

        this.productCost = productCost;
        this.productType = productType;
    }

    //Prints the product variables
    public void printProduct() {
        System.out.println("Product: " + productName + " || with ID: " + productID + " || price: " + productCost);
    }

    //removes spaces, vowels, and illegal characters to make the productID
    public static String shortenBookTitle(String title) {
        title = title.toLowerCase().replaceAll("\\s", "");
        title = title.replaceAll("[^a-z, 0-9]", "");
        title = title.replaceAll("[aeiou]", "");
        //limits the length to 10
        if (title.length() > 10) {
            title = title.substring(0, 10);
        }
        return title;
    }

    //Getters for all the product variables
    //No setters because once they don't change
    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }

    public double getProductCost() {
        return productCost;
    }

    public String getProductType() {
        return productType;
    }
}