import java.util.ArrayList;

public class Bookstore {

    //inventory manager here
    public static ArrayList<Product> inventory;

    public void initTestProducts() {
        inventory = new ArrayList<Product>();
        Product product1 = new Product("Fahrenheit 451", 19.99);
        Product product2 = new Product("1984", 22.79);
        Product product3 = new Product("Animal Farm", 8.49);
        addIntoInventory(product1);
        addIntoInventory(product2);
        addIntoInventory(product3);
    }

    public static Product getProductByElement(int element) {
        return inventory.get(element);
    }

    public static Product getProductByName(String name) {
        for (Product product : inventory) {
            if (product.getProductName() == name) {
                return product;
            }
        }
        return null;
    }

    public static Product getProductByID(String ID) {
        for (Product product : inventory) {
            if (product.getProductID().equals(ID)) {
                return product;
            }
        }
        return null;
    }

    public void makePurchase(Member member, Product product) {
        member.addToTotalSpent(product.getProductCost());
        removeFromInventory(product);
        //adds the cost of the product to the member's total spend
        //remove the product from the inventory

    }
    
    //Inventory management methods
    public static boolean checkInStock(String name) {
        for (Product product : inventory) {
            if (product.getProductName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addIntoInventory(Product product) {
        inventory.add(product);
    }

    public void removeFromInventory(Product item) {
        for (Product product : inventory) {
            if (product.equals(item)) {
                inventory.remove(product);
                return;
            }
        }
    }
}