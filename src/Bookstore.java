import java.util.ArrayList;

public class Bookstore {

    //inventory manager here
    ArrayList<Product> inventory = new ArrayList<Product>();
    Product product1 = new Product("Fahrenheit 451", 19.99);
    Product product2 = new Product("1984", 22.79);
    Product product3 = new Product("Animal Farm", 8.49);
    

    public void makePurchase(Member member, Product product) {
        //adds the cost of the product to the member's total spend
        //remove the product from the inventory

    }

    public void addIntoInventory(Product product) {
        inventory.add(product);
    }

    public void removeFromInventory() {
        //sorting and removal algorithm here
    }
}