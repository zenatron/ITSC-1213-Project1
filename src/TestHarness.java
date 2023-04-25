import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
 * @author me
 */

public class TestHarness 
{
    public static void main(String[] args) 
    {
        Bookstore store = new Bookstore();
        Scanner sc = new Scanner(System.in);

        //Initializes some test Members
        Member member1 = new Member("Kevin", "Ashwani");
        Member member2 = new PremiumMember("Bob", "Loblaw");
        Member member3 = new Member("Georgiy", "Timeshare");

        //Adds test Members into memberList
        store.addMember(member1);
        store.addMember(member2);
        store.addMember(member3);

        // //Initializes some test Products
        // Book book1 = new Book("Fahrenheit 451","Ray Bradbury", "Dystopia", 19.99);
        // Book book2 = new Book("1984", "George Orwell", "Dystopia", 69.99);
        // CD cd1 = new CD("Turkish National Anthem", "Nursultan Tuleakbav", "Turkiye", 1.49);
        // CD cd2 = new CD("Deer Sounds", "Jim Stuart", "Animal Noises", 134.79);
        // DVD dvd1 = new DVD("Shrek 5", "Sharik", "Pixar", 20.99);
        // DVD dvd2 = new DVD("Meshok Yablok", "Yuri Frankovich", "Mosfilm", 0.01);

        // //Adds 100 of each product into inventory
        // store.addIntoInventory(book1, 100);
        // store.addIntoInventory(book2, 100);
        // store.addIntoInventory(cd1, 100);
        // store.addIntoInventory(cd2, 100);
        // store.addIntoInventory(dvd1, 100);
        // store.addIntoInventory(dvd2, 100);
        

        // //Prints out the size of the inventory and all test Members
        // System.out.println(store.inventory.size());
        // System.out.println(member1.toString());
        // System.out.println(member2.toString());
        // System.out.println(member3.toString());

        // ________________________________________________________
        // //Makes some test purchases
        // store.makePurchase(member1, book1, 10, new PaymentType());
        // store.makePurchase(member2, cd1, 10, new PaymentType());
        // store.makePurchase(member3, book1, 10, new PaymentType());

        // //Prints the Members again
        // System.out.println(member1.toString());
        // System.out.println(member2.toString());
        // System.out.println(member3.toString());

        // //Prints the quantities of products
        // System.out.println(book1.getQuantity());
        // System.out.println(cd1.getQuantity());
        // System.out.println(book2.getQuantity());

        // System.out.println(store.transactions.get(0).toString());
        // System.out.println(store.transactions.get(1).toString());
        // System.out.println(store.transactions.get(2).toString());


        //TODO: Remove the goddamn spaces in the CSV file
        try {
            String filePath = "./src/start.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            //Skip the first line
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                int number = Integer.parseInt(data[0]);
                String type = data[1];
                String title = data[2];
                String author = data[3];
                String album = data[4];

                double cost = Double.parseDouble(data[5]);
                int qty = Integer.parseInt(data[6]);

                if (type.equalsIgnoreCase("book")) {
                    Book book = new Book(title, author, album, cost);
                    book.setQuantity(qty);
                    store.inventory.add(book);
                } else if (type.equalsIgnoreCase("dvd")) {
                    DVD dvd = new DVD(title, author, album, cost);
                    dvd.setQuantity(qty);
                    store.inventory.add(dvd);
                } else if (type.equalsIgnoreCase("cd")) {
                    CD cd = new CD(title, author, album, cost);
                    cd.setQuantity(qty);
                    store.inventory.add(cd);
                } else System.out.println("Incorrect type");
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        
        //Prints out the size of the inventory and all test Members
        System.out.println(store.inventory.size());
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);

         //Makes some test purchases to test Transactions
         store.makePurchase(member1, book1, 10, new PaymentType());
         store.makePurchase(member2, cd1, 10, new PaymentType());
         store.makePurchase(member3, book1, 10, new PaymentType());

         while (true)
         {
            //Check what the user wants to do
            System.out.println("\nSelect an option by typing a number:");
            System.out.println("\t 1. Register New Member");
            System.out.println("\t 2. View Member List");
            System.out.println("\t 3. Make Purchase");
            System.out.println("\t 4. View Transaction List");
            System.out.println("\t 5. Add New Product");
            System.out.println("\t 6. Restock Inventory");
            System.out.println("\t 7. Display Inventory / Value");
            System.out.println("\t 8. Compare Products By Cost");
             System.out.println("\t 9. Exit");

            int num = sc.nextInt();
            sc.nextLine();

            switch (num)
            {
                case 1:
                System.out.println("<<< Registering New Member >>>");
                System.out.println("Enter First Name:");
                String firstName = sc.nextLine();
                System.out.println("Enter Last Name:");
                String lastName = sc.nextLine();
                System.out.println("Premium Member? (Y/N)");
                char letter = sc.next().charAt(0);
                boolean premium = false;
                if (letter == 'Y' || letter == 'y')
                {
                    premium = true;
                }
                Member newMember = new Member(firstName, lastName, premium);
                store.addMember(newMember);

                System.out.println("New Member Registered with Credentials:");
                System.out.println(newMember);
                break;

                case 2:
                System.out.println("<<< Viewing Member List >>>");
                for (Member member : store.memberList)
                {
                    System.out.println(member);
                }
                break;

                case 3:
                System.out.println("<<< Making a Purchase >>>");
                purchaseOptions(store);
                break;

                case 4:
                System.out.println("<<< Viewing Transaction List >>>");
                for (Transaction transaction : store.transactions)
                {
                    System.out.println(transaction);
                }
                break;

                case 5:
                System.out.println("<<< Adding a New Product >>>");
                System.out.println("Enter the title of the product");
                String title = sc.nextLine();
                System.out.println("Enter the author of the product");
                String author = sc.nextLine();
                System.out.println("Enter the cost of the product");
                double newProductCost = sc.nextDouble();
                sc.nextLine();
                System.out.println("What kind of product is it? (CD/DVD/Book)");
                String type = sc.nextLine();
                System.out.println("Enter many units to add");
                int units = sc.nextInt();
                sc.nextLine();

                if ("book".equalsIgnoreCase(type))
                {
                    System.out.println("What is the album for the Book?");
                    String albumBook = sc.nextLine();
                    store.addIntoInventory(new Book(title, author, albumBook, newProductCost), units);
                }
                else if ("cd".equalsIgnoreCase(type))
                {
                    System.out.println("What is the album for the CD?");
                    String albumCd = sc.nextLine();
                    store.addIntoInventory(new CD(title, author, albumCd, newProductCost), units);
                }
                else if ("dvd".equalsIgnoreCase(type))
                {
                    System.out.println("What is the album for the DVD?");
                    String albumDvd = sc.nextLine();
                    store.addIntoInventory(new DVD(title, author, albumDvd, newProductCost), units);
                }
                break;

                case 6:
                System.out.println("<<< Adding into Inventory >>>");
                System.out.println("Enter the ID of the product to edit");
                long id = sc.nextLong();
                sc.nextLine();
                System.out.println("Enter the new quantity");
                int quantity = sc.nextInt();
                sc.nextLine();
                for (Product product : store.inventory)
                {
                    if (product.getId() == id)
                    {
                        product.setQuantity(quantity);
                        break;
                    }
                }
                break;

                case 7:
                System.out.println("<<< Checking Stock >>>");
                for (Product product : store.inventory)
                {
                    System.out.println(product);
                }
                break;

                case 8:
                System.exit(0);
                sc.close();
                break;
            }
            
             switch (num) {
                 case 1 -> {
                     System.out.println("<<< Registering New Member >>>");
                     System.out.println("Enter First Name:");
                     String firstName = sc.nextLine();
                     System.out.println("Enter Last Name:");
                     String lastName = sc.nextLine();
                     System.out.println("Premium Member? (Y/N)");
                     char letter = sc.next().charAt(0);
                     boolean premium = letter == 'Y' || letter == 'y';
                     Member newMember;
                     if (premium)
                     {
                         newMember = new PremiumMember(firstName, lastName);
                     }
                     else
                     {
                         newMember = new Member(firstName, lastName);
                     }
                     store.addMember(newMember);
                     System.out.println("New Member Registered with Credentials:");
                     System.out.println(newMember);
                 }
                 case 2 -> {
                     System.out.println("<<< Viewing Member List >>>");
                     for (Member member : store.memberList) {
                         System.out.println(member);
                     }
                 }
                 case 3 -> {
                     System.out.println("<<< Making a Purchase >>>");
                     purchaseOptions(store);
                 }
                 case 4 -> {
                     System.out.println("<<< Viewing Transaction List >>>");
                     for (Transaction transaction : store.transactions) {
                         System.out.println(transaction);
                     }
                 }
                 case 5 -> {
                     System.out.println("<<< Adding a New Product >>>");
                     System.out.println("Enter the title of the product");
                     String title = sc.nextLine();
                     System.out.println("Enter the author of the product");
                     String author = sc.nextLine();
                     System.out.println("Enter the cost of the product");
                     double newProductCost = sc.nextDouble();
                     sc.nextLine();
                     System.out.println("What kind of product is it? (CD/DVD/Book)");
                     String type = sc.nextLine();
                     System.out.println("Enter many units to add");
                     int units = sc.nextInt();
                     sc.nextLine();
                     if ("book".equalsIgnoreCase(type)) {
                         store.addIntoInventory(new Book(title, author, newProductCost), units);
                     } else if ("cd".equalsIgnoreCase(type)) {
                         System.out.println("What is the album for the CD?");
                         String album = sc.nextLine();
                         store.addIntoInventory(new CD(title, author, album, newProductCost), units);
                     } else if ("dvd".equalsIgnoreCase(type)) {
                         System.out.println("What is the studio for the DVD?");
                         String studio = sc.nextLine();
                         store.addIntoInventory(new DVD(title, author, studio, newProductCost), units);
                     }
                 }
                 case 6 -> {
                     System.out.println("<<< Adding into Inventory >>>");
                     System.out.println("Enter the ID of the product to edit");
                     long id = sc.nextLong();
                     sc.nextLine();
                     if (store.getProductByID(id) == null)
                     {
                         System.out.println("Sorry, this product does not exist in inventory.");
                         break;
                     }
                     else
                     {
                         System.out.println("Enter the quantity to restock:");
                     }
                     int quantity = sc.nextInt();
                     sc.nextLine();
                     store.restockProduct(store.getProductByID(id), quantity);
                 }
                 case 7 -> {
                     System.out.println("<<< Checking Stock >>>");
                     for (Product product : store.inventory) {
                         System.out.println(product);
                     }
                     System.out.println("\n\tStore's inventory value:\n\t$" + store.inventoryValue());
                 }
                 case 8 -> {
                     System.out.println("<<< Comparing Products by Cost >>>");
                     for (Product product : store.inventory) {
                         System.out.println(product);
                     }
                     System.out.println("\nEnter the ID of the first product to compare:");
                     long id = sc.nextLong();
                     sc.nextLine();
                     if (store.getProductByID(id) == null)
                     {
                         System.out.println("Sorry, this product does not exist in inventory.");
                         break;
                     }
                     else
                     {
                         System.out.println(store.getProductByID(id).getTitle());
                     }
                     System.out.println("\nEnter the ID of the second product to compare:");
                     long id2 = sc.nextLong();
                     sc.nextLine();
                     if (store.getProductByID(id2) == null)
                     {
                         System.out.println("Sorry, this product does not exist in inventory.");
                         break;
                     }
                     else
                     {
                         System.out.println(store.getProductByID(id2).getTitle());
                     }
                     System.out.println("Result:");
                     store.getProductByID(id).compareTo(store.getProductByID(id2));
                 }
                 case 9 -> System.exit(0);
             }
         }
    }

    //Displays the Purchasing Options
    public static void purchaseOptions(Bookstore store)
    {
        Scanner scan = new Scanner(System.in);
        //ShoppingCart cart = new ShoppingCart();
        //Print what's in stock
        for (Product product : store.inventory)
        {
            System.out.println(product);
        }
        
        while (true)
        {
            System.out.println("\nSelect an option by typing a number:");
            System.out.println("\t 1. Add a Product to cart");
            System.out.println("\t 2. Check Out");
            System.out.println("\t 3. Exit");

            int cartNum = scan.nextInt();
            scan.nextLine();

            switch (cartNum)
            {
                case 1:
                System.out.println("< Adding Items to Cart >");

                System.out.println("Enter ID of Buyer");
                long id = scan.nextLong();
                scan.nextLine();
                if (store.getMemberByID(id) == null)
                {
                    System.out.println("Sorry, this person does not exist in the system.");
                    break;
                }
                else
                {
                    System.out.println(store.getMemberByID(id).getFirstName() + " " + store.getMemberByID(id).getLastName());
                }

                System.out.println("Type product ID to add to cart:");
                long itemToAdd = scan.nextLong();
                scan.nextLine();
                if (store.getProductByID(itemToAdd) == null)
                {
                    System.out.println("Sorry, this product does not exist in inventory.");
                    break;
                }
                else
                {
                    System.out.println(store.getProductByID(itemToAdd).getTitle());
                }

                System.out.println("Enter the quantity to add to cart:");
                int quantityToBuy = scan.nextInt();
                scan.nextLine();

                for (Product product : store.inventory)
                {
                    //Adds the product to cart if the title matches
                    if (product.getId() == itemToAdd)
                    {
                        //Confirms whether we have the requested number in stock
                        if (product.getQuantity() < quantityToBuy)
                        {
                            System.out.println("We only have " + product.getQuantity() + " in stock of - " + product.getTitle());
                            System.out.println("Purchase failed.");
                            break;
                        }
                        else
                        {
                            store.getMemberByID(id).shoppingCart.addIntoInventory(product, quantityToBuy);
                            break;
                        }
                    }
                }
                break;

                case 2:
                Member buyer = null;
                System.out.println("< Checking Out >");

                System.out.println("Confirm ID of Buyer");
                id = scan.nextLong();
                scan.nextLine();
                if (store.getMemberByID(id) == null)
                {
                    System.out.println("Sorry, this person does not exist in the system.");
                    break;
                }
                else
                {
                    System.out.println(store.getMemberByID(id).getFirstName() + " " + store.getMemberByID(id).getLastName());
                    buyer = store.getMemberByID(id);
                }

                System.out.println("Confirm Items in Cart:");
                for (Product item : buyer.shoppingCart.contents)
                {
                    System.out.println(item.getTitle() + " qty: " + item.getQuantity());
                }

                System.out.println("Total Cost in cart:\n\t$" + buyer.shoppingCart.calculateCartTotal());

                System.out.println("Enter Payment Type: (feature not implemented)");
                PaymentType pType = new PaymentType();

                System.out.println("Ready to Buy? (Y/N)");
                char ready = scan.nextLine().charAt(0);
                if(ready == 'Y' || ready == 'y')
                {
                    for (Product item : buyer.shoppingCart.contents)
                    {
                        if (store.makePurchase(buyer, item, item.getQuantity(), pType))
                        {
                            System.out.println("Successfully purchased " + item.getTitle());
                        }
                        else {System.out.println("---- Something went wrong! ----");}
                    }
                    System.out.println("<< Thank you for shopping at Bookstore! >>");
                    buyer.shoppingCart.contents.clear();
                }
                else
                {
                    System.out.println("Transaction Cancelled");
                    buyer.shoppingCart.contents.clear();
                }
                break;

                case 3:
                System.out.println("< Exiting... >");
                scan.close();
                return;
            }
        }
    }
}