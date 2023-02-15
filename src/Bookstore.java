import java.util.ArrayList;

public class Bookstore 
{
    public ArrayList<Member> memberList = new ArrayList<Member>();
    public ArrayList<Product> inventory = new ArrayList<Product>();
    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private long transactionCounter;

    public Bookstore()
    {
        transactionCounter = 0;
    }

    public void addTransaction(long memberId, long productId, PaymentType paymentType, double amount)
    {
        //Increments transaction counter, instantiates a new Transaction, and adds it to the transactions ArrayList
        transactionCounter++;
        Transaction t = new Transaction(productId, memberId, productId, paymentType, amount);
        transactions.add(t);
    }

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

    public void addMember(Member member)
    {
        if (getMemberByID(member.getId()) == null)
        {
            memberList.add(member);
        }
        return;
    }
    
    //Inventory management methods
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

    public void addIntoInventory(Product product, int qty) 
    {
        Product p = getProductByID(product.getId());
        //Checks if the product already exists
        if (p == null)
        {
            product.setQuantity(qty);
            inventory.add(product);
            System.out.println("Added: " + product);
        }
        else 
        {
            p.setQuantity(p.getQuantity() + qty);
            System.out.println("NOT Added: " + product);
        }
    }

    //Call only when checkInStock == true
    public void removeFromInventory(Product product, int qty) 
    {
        Product p = getProductByID(product.getId());
        p.setQuantity(p.getQuantity() - qty);
    }

    //Returns false if makePurchase fails
    public boolean makePurchase(Member member, Product product, int requestedQty, PaymentType paymentType)
    {
        addMember(member); //Member will be added into system if doesn't exist in system
        if (checkInStock(product, requestedQty) == false) //Checks if requestedQty is in stock
        {
            return false;
        }
        removeFromInventory(product, requestedQty); //Removes requestedQty from stock
        double charge = requestedQty * product.getCost(); //Gets total cost
        member.addToTotalSpent(charge); //Adds to member's total spent

        addTransaction(member.getId(), product.getId(), paymentType, charge); //Adds the transaction to transactionList

        return true;
    }

    public void collectMonthlyFee()
    {
        //Stub method
    }
}