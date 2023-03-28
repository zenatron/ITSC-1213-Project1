import java.util.ArrayList;

public class Bookstore implements BookStoreSpecification
{
    //ArrayLists for the Members, Products, and Transactions
    public ArrayList<Member> memberList = new ArrayList<>();
    public ArrayList<Product> inventory = new ArrayList<>();
    public ArrayList<Transaction> transactions = new ArrayList<>();
    private long transactionCounter;
    private double monthlyFee;

    //Constructor
    public Bookstore()
    {
        transactionCounter = 0;
        monthlyFee = 10.0;
    }

    //Adds a Transaction into the transactions ArrayList
    public void addTransaction(long memberId, long productId, PaymentType paymentType, double amount)
    {
        //Increments transaction counter, instantiates a new Transaction, and adds it to the transactions ArrayList
        transactionCounter++;
        Transaction t = new Transaction(transactionCounter, memberId, productId, paymentType, amount);
        transactions.add(t);
    }

    //Returns the Member from the given id
    public Member getMemberByID(long id) 
    {
        for (Member member : memberList) 
        {
            if (member.getId() == id) 
            {
                return member;
            }
        }
        return null;
    }

    //Returns the product from the given id
    public Product getProductByID(long id) 
    {
        for (Product product : inventory)
        {
            if (product.getId() == id) 
            {
                return product;
            }
        }
        return null;
    }

    //Returns the transaction from the given id
    public Transaction getTransactionByID(long id) 
    {
        for (Transaction transaction : transactions) 
        {
            if (transaction.getId() == id)
            {
                return transaction;
            }
        }
        return null;
    }

    //Adds a new Member into the memberList
    public void addMember(Member member)
    {
        if (getMemberByID(member.getId()) == null)
        {
            memberList.add(member);
        }
    }
    
    //Inventory management methods
    //Returns true if the number of requested items is in stock for a given Product
    public boolean checkInStock(Product product, int requestedQty) 
    {
        Product p = getProductByID(product.getId());
        if (p == null)
        {
            return false;
        }
        else 
        {
            int available = p.getQuantity();
            return available >= requestedQty;
        }
    }

    //Adds products into inventory
    public void addIntoInventory(Product product, int qty)
    {
        Product p = getProductByID(product.getId());
        //Checks if the product already exists
        if (p == null)
        {
            product.setQuantity(qty);
            inventory.add(product);
            System.out.println("Added New: " + product);
        }
        else
        {
            p.setQuantity(p.getQuantity() + qty);
            System.out.println("Product Adjusted: " + product);
        }
    }

    //Call only when checkInStock == true
    //Removes a given qty of Product from inventory
    public void removeFromInventory(Product product, int qty) 
    {
        Product p = getProductByID(product.getId());
        p.setQuantity(p.getQuantity() - qty);
    }

    //Returns false if makePurchase fails
    //Core to the Bookstore's functionality
    public boolean makePurchase(Member member, Product product, int requestedQty, PaymentType paymentType)
    {
        addMember(member); //Member will be added into system if it doesn't exist in system
        if (!checkInStock(product, requestedQty)) //Checks if requestedQty is in stock
        {
            return false;
        }
        removeFromInventory(product, requestedQty); //Removes requestedQty from stock
        double charge = requestedQty * product.getCost(); //Gets total cost
        member.addToTotalSpent(charge); //Adds to member's total spent

        addTransaction(member.getId(), product.getId(), paymentType, charge); //Adds the transaction to transactionList

        return true;
    }

    //Run this method every month
    public void collectMonthlyFee(double fee)
    {
        for (Member member : memberList)
        {
            if (member instanceof PremiumMember)
            {
                ((PremiumMember) member).payFees(fee);
            }
        }
    }

    public long getLifetimeTransactions()
    {
        return transactionCounter;
    }

    @Override
    public void restockProduct(Product product, int qty)
    {
        addIntoInventory(product, qty);
    }

    public double inventoryValue()
    {
        double value = 0;
        for (Product product : inventory)
        {
            value += product.getQuantity() * product.getCost();
        }
        return value;
    }

    public double getMonthlyFee()
    {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee)
    {
        this.monthlyFee = monthlyFee;
    }
}