import java.util.ArrayList;

public class ShoppingCart 
{
    private int itemsInCart;
    private double totalCost;

    //ArrayList of what is inside the Shopping Cart
    public ArrayList<Product> contents = new ArrayList<Product>();
    
    //Constructor
    public ShoppingCart()
    {
        this.itemsInCart = 0;
        this.totalCost = 0.0;
    }

    //Allows printing of the Shopping Cart
    public String toString()
    {
        return "Cart contains: " + calculateItemsInCart(contents) + " items, totaling: $" + calculateCartTotal();
    }

    //Adds into the contents of the Shopping Cart
    public void addIntoInventory(Product product, int qty) 
    {
        Product p = getProductByID(product.getId());
        //Checks if the product already exists
        if (p == null)
        {
            Product item = product.copy();
            item.setQuantity(qty);
            contents.add(item);
            System.out.println("Added: " + item);
        }
        else 
        {
            p.setQuantity(p.getQuantity() + qty);
            System.out.println("NOT Added: " + product);
        }
    }

    //Gets the Product from the given id
    public Product getProductByID(long id) 
    {
        for (Product product : contents)
        {
            if (product.getId() == id) 
            {
                return product;
            }
        }
        return null;
    }

    //Returns the total cost of everything in the cart
    public double calculateCartTotal()
    {
        double total = 0;
        for (Product item : contents)
        {
            total += (item.cost * item.quantity);
        }
        return total;
    }

    //Returns the total number of items in the cart
    public int calculateItemsInCart(ArrayList<Product> contents)
    {
        int total = 0;
        for (Product item : contents)
        {
            total += (item.quantity);
        }
        return total;
    }

    //Generic getters and setters
    public int getItemsInCart() {
        return this.itemsInCart;
    }

    public void setItemsInCart(int itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public double getTotalCost() {
        return this.totalCost;
    }
}