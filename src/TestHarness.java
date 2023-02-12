public class TestHarness 
{
    public static void main(String[] args) 
    {
        Bookstore store = new Bookstore();

        Member member1 = new Member("Kevin", "Aswani", false);
        Member member2 = new Member("Azerbath", "Nazar", true);
        Member member3 = new Member("Georgiy", "Smesharik", false);

        Book book1 = new Book("Fahrenheit 451","Ray Bradbury", 19.99);
        Book book2 = new Book("1984", "George Orwell", 69.99);
        CD cd1 = new CD("Turkish National Anthem", "Nursultan Tuleakbav", "Turkiye", 1.49);
        CD cd2 = new CD("Deer Sounds", "Jim Stuart", "Animal Noises", 134.79);
        DVD dvd1 = new DVD("Shrek 5", "Sharik", "Lionsgate", 20.99);
        DVD dvd2 = new DVD("Meshok Yablok", "Yuri Segeiivich XVIII", "Mosfilm", 0.01);

        store.addIntoInventory(book1, 100);
        store.addIntoInventory(book2, 100);
        store.addIntoInventory(cd1, 100);
        store.addIntoInventory(cd2, 100);
        store.addIntoInventory(dvd1, 100);
        store.addIntoInventory(dvd2, 100);
        
        System.out.println(store.inventory.size());
        System.out.println(member1.toString());
        System.out.println(member2.toString());
        System.out.println(member3.toString());


        store.makePurchase(member1, book1, 10, new PaymentType());
        store.makePurchase(member2, cd1, 10, new PaymentType());
        store.makePurchase(member3, book1, 10, new PaymentType());


        System.out.println(member1.toString());
        System.out.println(member2.toString());
        System.out.println(member3.toString());

        System.out.println(book1.getQuantity());
        System.out.println(cd1.getQuantity());
        System.out.println(book2.getQuantity());

    }
    
}
