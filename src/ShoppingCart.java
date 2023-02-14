import java.util.ArrayList;

public class ShoppingCart 
{
    private int itemsInCart;
    private double totalCost;

    public ArrayList<Product> contents = new ArrayList<Product>();
    
    public ShoppingCart()
    {
        this.itemsInCart = 0;
        this.totalCost = 0.0;
    }

    public String toString()
    {
        return "Cart contains: " + calculateItemsInCart(contents) + " items, totaling: $" + calculateCartTotal(contents);
    }

    public void addIntoInventory(Product product, int qty) 
    {
        Product p = getProductByID(product.getId());
        //Checks if the product already exists
        if (p == null)
        {
            product.setQuantity(qty);
            contents.add(product);
            System.out.println("Added: " + product);
        }
        else 
        {
            p.setQuantity(p.getQuantity() + qty);
            System.out.println("NOT Added: " + product);
        }
    }

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

    public double calculateCartTotal(ArrayList<Product> contents)
    {
        double total = 0;
        for (Product item : contents)
        {
            total += (item.cost * item.quantity);
        }
        return total;
    }

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

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
