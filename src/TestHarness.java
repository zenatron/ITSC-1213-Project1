public class TestHarness 
{
    public static void main(String[] args) 
    {

        Bookstore store = new Bookstore();
        store.initTestProducts();

        System.out.println(Bookstore.inventory.size());
        // Bookstore.getProductByElement(0).printProduct();
        // Bookstore.getProductByElement(1).printProduct();
        // Bookstore.getProductByElement(2).printProduct();

        Member person1 = new Member("Serena", "Williams", true, "credit card");
        person1.printMember();

        store.makePurchase(person1, Bookstore.getProductByName("Fahrenheit 451"));

        //NEED TO HANDLE ERRORS IF INCORRECT BOOK TITLE INPUT
        store.makePurchase(person1, Bookstore.getProductByName("1984"));

        person1.printMember();

        System.out.println(Bookstore.inventory.size());
        
    }
    
}
