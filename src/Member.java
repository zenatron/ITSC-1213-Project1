public class Member 
{
    private String firstName;
    private String lastName;
    private long id;
    private boolean premium;
    private double totalSpent;

    //Good Constructor
    public Member(String firstName, String lastName, boolean premium) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = hash();
        this.premium = premium;
        this.totalSpent = 0.00;
    }

    //Default (bad) constructor
    // public Member() 
    // {
    //     this.firstName = "John";
    //     this.lastName = "Smith";
    //     this.id = (int) (Math.random() * 10000);
    //     this.premium = false;
    //     this.paymentType = "none";
    //     this.totalSpent = 0.00;
    // }

    //Print method
    public String toString() 
    {
        return "Member >> " + lastName + ", " + firstName + " | ID: " + id + " | Premium Status: " + premium + " | Total Spent: $" + totalSpent;
    }

    public long hash() 
    {
        //Returns generated member id
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
    
    public boolean isPremium() 
    {
        return premium;
    }
    
    public void setPremium(boolean premium) 
    {
        this.premium = premium;
    }

    public double getTotalSpent() 
    {
        return totalSpent;
    }

    public void addToTotalSpent(double dollars) 
    {
        this.totalSpent += dollars;
    }
}