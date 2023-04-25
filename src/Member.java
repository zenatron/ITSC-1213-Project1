public class Member 
{
    protected String firstName;
    protected String lastName;
    protected long id;
    protected double totalSpent;
    protected ShoppingCart shoppingCart;

    //Constructor
    public Member(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = hash();
        this.totalSpent = 0.00;
        shoppingCart = new ShoppingCart();
    }

    //Print method
    public String toString()
    {
        return "Member >> " + lastName + ", " + firstName + " | ID: " + id + " | Total Spent: $" + totalSpent;
    }

    //Returns generated member id from hash
    public long hash() 
    {
        long result = 17;
        result = 37 * result + firstName.hashCode();
        result = 37 * result + lastName.hashCode();
        return result;
    }
    //Getters and setters for all the variables
    public String getFirstName() 
    {
        return firstName;
    }
    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }
    public String getLastName() 
    {
        return lastName;
    }
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    //No setter for ID because it does not change
    public long getId() 
    {
        return id;
    }

    public double getTotalSpent() 
    {
        return totalSpent;
    }

    public void setTotalSpent(double dollars)
    {
        this.totalSpent = dollars;
    }

    public void addToTotalSpent(double dollars) 
    {
        this.totalSpent += dollars;
    }
}