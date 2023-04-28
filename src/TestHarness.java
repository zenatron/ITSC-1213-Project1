import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * @author me
 */

public class TestHarness {
    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        Scanner sc = new Scanner(System.in);

        try {
            String startFilePath = "./src/files/start.csv";
            BufferedReader reader = new BufferedReader(new FileReader(startFilePath));

            //Skip the first line
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                String type = data[0];
                String title = data[1];
                String author = data[2];
                String album = data[3];

                double cost = Double.parseDouble(data[4]);
                int qty = Integer.parseInt(data[5]);

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

                } else System.out.println("Incorrect type in file: " + startFilePath);
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        try {
            String membersFilePath = "./src/files/members.csv";
            BufferedReader reader = new BufferedReader(new FileReader(membersFilePath));

            //Skip the first line
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                String first = data[0];
                String last = data[1];
                double totalSpent = Double.parseDouble(data[3]);
                String isPremium = data[4];

                if (isPremium.equalsIgnoreCase("false")) {
                    Member member = new Member(first, last);
                    member.setTotalSpent(totalSpent);
                    store.memberList.add(member);

                } else if (isPremium.equalsIgnoreCase("true")) {
                    PremiumMember premiumMember = new PremiumMember(first, last);
                    premiumMember.setTotalSpent(totalSpent);
                    store.memberList.add(premiumMember);

                } else System.out.println("Incorrect type in file: " + membersFilePath);
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        System.out.println(store.inventory.size());

        while (true) {
            //Check what the user wants to do
            System.out.println("\nSelect an option by typing a number:");
            System.out.println("\t 1. Add / Remove Members");
            System.out.println("\t 2. View Member List");
            System.out.println("\t 3. Make Purchase");
            System.out.println("\t 4. View Transaction List");
            System.out.println("\t 5. Add New Product");
            System.out.println("\t 6. Restock Inventory");
            System.out.println("\t 7. Display Inventory / Value");
            System.out.println("\t 8. Compare Products By Cost");
            System.out.println("\t 9. Exit");

            try {
                int num = sc.nextInt();
                sc.nextLine();

                switch (num) {
                    case 1 -> {
                        memberOptions(store);
                    }
                    case 2 -> {
                        try {
                            System.out.println("<<< Viewing Member List >>>");
                            for (Member member : store.memberList) {
                                System.out.println(member);
                            }
                        } catch (Exception e) {
                            System.err.println("Error Viewing Members. " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.println("<<< Making a Purchase >>>");
                        purchaseOptions(store);
                    }
                    case 4 -> {
                        try {
                            System.out.println("<<< Viewing Transaction List >>>");
                            for (Transaction transaction : store.transactions) {
                                System.out.println(transaction);
                            }
                        } catch (Exception e) {
                            System.err.println("Error Viewing Transactions. " + e.getMessage());
                        }
                    }
                    case 5 -> {
                        try {
                            System.out.println("<<< Adding a New Product >>>");
                            System.out.println("Enter the title of the product");
                            String title = sc.nextLine();
                            System.out.println("Enter the author of the product");
                            String author = sc.nextLine();
                            System.out.println("Enter the album of the product");
                            String album = sc.nextLine();
                            System.out.println("Enter the cost of the product");
                            double newProductCost = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("What kind of product is it? (CD/DVD/Book)");
                            String type = sc.nextLine();
                            System.out.println("Enter many units to add");
                            int units = sc.nextInt();
                            sc.nextLine();
                            if ("book".equalsIgnoreCase(type)) {
                                store.addIntoInventory(new Book(title, author, album, newProductCost), units);
                            } else if ("cd".equalsIgnoreCase(type)) {
                                store.addIntoInventory(new CD(title, author, album, newProductCost), units);
                            } else if ("dvd".equalsIgnoreCase(type)) {
                                store.addIntoInventory(new DVD(title, author, album, newProductCost), units);
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("You entered a wrong value. " + e.getMessage());
                        } catch (Exception e) {
                            System.err.println("Error Adding a Product. " + e.getMessage());
                        }
                    }
                    case 6 -> {
                        try {
                            System.out.println("<<< Adding into Inventory >>>");
                            System.out.println("Enter the ID of the product to edit");
                            long id = sc.nextLong();
                            sc.nextLine();
                            if (store.getProductByID(id) == null) {
                                System.out.println("Sorry, this product does not exist in inventory.");
                                break;
                            } else {
                                System.out.println("Enter the quantity to restock:");
                            }
                            int quantity = sc.nextInt();
                            sc.nextLine();
                            store.restockProduct(store.getProductByID(id), quantity);
                        } catch (InputMismatchException e) {
                            System.err.println("You entered a wrong value. " + e.getMessage());
                        } catch (Exception e) {
                            System.err.println("Error Adding to Inventory. " + e.getMessage());
                        }
                    }
                    case 7 -> {
                        try {
                            System.out.println("<<< Checking Stock >>>");
                            for (Product product : store.inventory) {
                                System.out.println(product);
                            }
                            System.out.println("\n\tStore's inventory value:\n\t$" + store.inventoryValue());
                        } catch (Exception e) {
                            System.err.println("Error Checking Stock. " + e.getMessage());
                        }
                    }
                    case 8 -> {
                        try {
                            System.out.println("<<< Comparing Products by Cost >>>");
                            for (Product product : store.inventory) {
                                System.out.println(product);
                            }
                            System.out.println("\nEnter the ID of the first product to compare:");
                            long id = sc.nextLong();
                            sc.nextLine();
                            if (store.getProductByID(id) == null) {
                                System.out.println("Sorry, this product does not exist in inventory.");
                                break;
                            } else {
                                System.out.println(store.getProductByID(id).getTitle());
                            }
                            System.out.println("\nEnter the ID of the second product to compare:");
                            long id2 = sc.nextLong();
                            sc.nextLine();
                            if (store.getProductByID(id2) == null) {
                                System.out.println("Sorry, this product does not exist in inventory.");
                                break;
                            } else {
                                System.out.println(store.getProductByID(id2).getTitle());
                            }
                            System.out.println("Result:");
                            store.getProductByID(id).compareTo(store.getProductByID(id2));
                        } catch (InputMismatchException e) {
                            System.err.println("You entered a wrong value. " + e.getMessage());
                        } catch (Exception e) {
                            System.err.println("Error Comparing Products. " + e.getMessage());
                        }
                    }


                    case 9 -> {
                        try {
                            StringBuilder report = new StringBuilder("*** Daily Report ***");
                            double dayRevenue = 0.0;
                            for (Transaction transaction : store.transactions) {
                                report.append("\nTransaction Added: ").append(transaction);
                                dayRevenue += transaction.getAmount();
                            }
                            report.append("\nTotal Revenue Today: $").append(dayRevenue);

                            if (membersAddedToday.isEmpty()) {
                                report.append("\nNo new members added today.");
                            } else {
                                for (Member member : membersAddedToday) {
                                    report.append("\nMember Added: ").append(member);
                                }
                            }

                            ReportGenerator.generateReport(report.toString());

                            InventorySaver.saveInventory(store.inventory);

                            MemberSaver.saveMembers(store.memberList);

                            System.exit(0);
                        } catch (Exception e) {
                            System.err.println("Error Generating Report. " + e.getMessage());
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("You entered a wrong value. " + e.getMessage());
                break;
            } catch (Exception e) {
                System.err.println("Something went wrong. " + e.getMessage());
                break;
            }
        }
    }

    //Displays the Purchasing Options
    public static void purchaseOptions(Bookstore store) {
        Scanner scan = new Scanner(System.in);

        //Print what's in stock
        for (Product product : store.inventory) {
            System.out.println(product);
        }

        while (true) {
            System.out.println("\nSelect an option by typing a number:");
            System.out.println("\t 1. Add a Product to cart");
            System.out.println("\t 2. Check Out");
            System.out.println("\t 3. Exit");

            try {
                int cartOptionsNum = scan.nextInt();
                scan.nextLine();

                switch (cartOptionsNum) {
                    case 1 -> {
                        try {
                            System.out.println("< Adding Items to Cart >");

                            System.out.println("Enter ID of Buyer");
                            long id = scan.nextLong();
                            scan.nextLine();
                            if (store.getMemberByID(id) == null) {
                                System.out.println("Sorry, this person does not exist in the system.");
                                break;
                            } else {
                                System.out.println(store.getMemberByID(id).getFirstName() + " " + store.getMemberByID(id).getLastName());
                            }

                            System.out.println("Type product ID to add to cart:");
                            long itemToAdd = scan.nextLong();
                            scan.nextLine();
                            if (store.getProductByID(itemToAdd) == null) {
                                System.out.println("Sorry, this product does not exist in inventory.");
                                break;
                            } else {
                                System.out.println(store.getProductByID(itemToAdd).getTitle());
                            }

                            System.out.println("Enter the quantity to add to cart:");
                            int quantityToBuy = scan.nextInt();
                            scan.nextLine();

                            for (Product product : store.inventory) {
                                //Adds the product to cart if the title matches
                                if (product.getId() == itemToAdd) {
                                    //Confirms whether we have the requested number in stock
                                    if (product.getQuantity() < quantityToBuy) {
                                        System.out.println("We only have " + product.getQuantity() + " in stock of - " + product.getTitle());
                                        System.out.println("Purchase failed.");
                                        break;
                                    } else {
                                        store.getMemberByID(id).shoppingCart.addIntoInventory(product, quantityToBuy);
                                        break;
                                    }
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("You entered a wrong value. " + e.getMessage());
                        } catch (Exception e) {
                            System.err.println("Error Adding to Cart. " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            Member buyer = null;
                            System.out.println("< Checking Out >");
                            System.out.println("Confirm ID of Buyer");
                            long id = scan.nextLong();
                            scan.nextLine();
                            if (store.getMemberByID(id) == null) {
                                System.out.println("Sorry, this person does not exist in the system.");
                                break;
                            } else {
                                System.out.println(store.getMemberByID(id).getFirstName() + " " + store.getMemberByID(id).getLastName());
                                buyer = store.getMemberByID(id);
                            }
                            System.out.println("Confirm Items in Cart:");
                            for (Product item : buyer.shoppingCart.contents) {
                                System.out.println(item.getTitle() + " qty: " + item.getQuantity());
                            }
                            System.out.println("Total Cost in cart:\n\t$" + buyer.shoppingCart.calculateCartTotal());
                            System.out.println("Enter Payment Type: (feature not implemented)");
                            PaymentType pType = new PaymentType();
                            System.out.println("Ready to Buy? (Y/N)");
                            char ready = scan.nextLine().charAt(0);
                            if (ready == 'Y' || ready == 'y') {
                                for (Product item : buyer.shoppingCart.contents) {
                                    if (store.makePurchase(buyer, item, item.getQuantity(), pType)) {
                                        System.out.println("Successfully purchased " + item.getTitle());
                                    } else {
                                        System.out.println("---- Something went wrong! ----");
                                    }
                                }
                                System.out.println("<< Thank you for shopping at Bookstore! >>");
                                buyer.shoppingCart.contents.clear();
                            } else {
                                System.out.println("Transaction Cancelled");
                                buyer.shoppingCart.contents.clear();
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("You entered a wrong value. " + e.getMessage());
                        } catch (Exception e) {
                            System.err.println("Error Checking Out. " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.println("< Exiting... >");
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("You entered a wrong value. " + e.getMessage());
                break;
            } catch (Exception e) {
                System.err.println("Something went wrong. " + e.getMessage());
                break;
            }
        }
    }

    static ArrayList<Member> membersAddedToday = new ArrayList<>();
    public static void memberOptions(Bookstore store) {
        Scanner memberScanner = new Scanner(System.in);

        //Print all the Members
        for (Member member : store.memberList) {
            System.out.println(member);
        }

        while (true) {
            System.out.println("\nSelect an option by typing a number:");
            System.out.println("\t 1. Add a New Member");
            System.out.println("\t 2. Delete a Member");
            System.out.println("\t 3. Exit");

            try {
                int memberOptionsNum = memberScanner.nextInt();
                memberScanner.nextLine();

                switch (memberOptionsNum) {
                    case 1 -> {
                        try {
                            System.out.println("<<< Registering New Member >>>");
                            System.out.println("Enter First Name:");
                            String firstName = memberScanner.nextLine();
                            System.out.println("Enter Last Name:");
                            String lastName = memberScanner.nextLine();
                            System.out.println("Premium Member? (Y/N)");
                            char letter = memberScanner.next().charAt(0);
                            boolean premium = letter == 'Y' || letter == 'y';
                            Member newMember;
                            if (premium) {
                                newMember = new PremiumMember(firstName, lastName);
                            } else {
                                newMember = new Member(firstName, lastName);
                            }
                            store.addMember(newMember);
                            System.out.println("New Member Registered with Credentials:");
                            System.out.println(newMember);
                            membersAddedToday.add(newMember);

                        } catch (Exception e) {
                            System.err.println("Error Registering a Member. " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("<<<! Removing a Member !>>>");
                        System.out.println("Enter Member ID to Remove:");
                        try {
                            long id = memberScanner.nextLong();
                            memberScanner.nextLine();
                            if (store.getMemberByID(id) == null) {
                                System.out.println("Sorry, this member does not exist.");
                                break;
                            } else {
                                System.out.println(store.getMemberByID(id));
                            }
                            memberScanner.nextLine();
                            System.out.println("Ready to Delete? (Y/N)");
                            char ready = memberScanner.nextLine().charAt(0);
                            if (ready == 'Y' || ready == 'y') {
                                System.out.println("Successfully Removed " + store.getMemberByID(id).getFirstName() + " " + store.getMemberByID(id).getLastName());
                                store.memberList.remove(store.getMemberByID(id));
                            } else {
                                System.out.println("Deletion Cancelled");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("You entered a wrong value. " + e.getMessage());
                        }
                    }
                    case 3 -> {
                        System.out.println("< Exiting... >");
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("You entered a wrong value. " + e.getMessage());
                break;
            } catch (Exception e) {
                System.err.println("Something went wrong. " + e.getMessage());
                break;
            }
        }
    }
}