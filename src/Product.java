public abstract class Product 
{
    protected String title;
    protected String author;
    protected long id;
    protected double cost;
    protected int quantity;
    
    //Do NOT use this constructor for standard instantiation
    // public Product(String productName, String productID, double productCost, String productType) 
    // {
    //     this.title = productName;
    //     this.id = productID;
    //     this.cost = productCost;
    //     this.type = productType;
    //     //TODO add author
    // }

    //This constructor should be used
    public Product(String title, String author, double cost) 
    {
        this.title = title;
        this.author = author;
        //this.id = hash();
        this.cost = cost;
        this.quantity = 0;
    }

    public abstract long hash();

    public abstract Product copy();
    
    //Prints the product variables
    public String toString()
    {
        return "Product: " + title + " Author: " + author + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }

    //removes spaces, vowels, and illegal characters to make the productID
    public static String shortenBookTitle(String title) 
    {
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
    //No setters because they don't change
    public String getTitle() 
    {
        return title;
    }

    public long getId() 
    {
        return id;
    }

    public double getCost() 
    {
        return cost;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}