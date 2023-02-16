public abstract class Product 
{
    protected String title;
    protected String author;
    protected long id;
    protected double cost;
    protected int quantity;
   
    //Constructor
    public Product(String title, String author, double cost) 
    {
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.quantity = 0;
    }

    //Two abstract methods that subclasses must use
    public abstract long hash();

    public abstract Product copy();
    
    //Prints the product variables
    public String toString()
    {
        return "Product: " + title + " Author: " + author + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
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