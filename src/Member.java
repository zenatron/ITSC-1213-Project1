
public class Member {
    private String firstName;
    private String lastName;
    private int id;
    private boolean premium;
    private String paymentType;
    private double totalSpent;

    //Constructor
    public Member(String firstName, String lastName, boolean premium, String paymentType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = (int) (Math.random()*10000);
        this.premium = premium;
        this.paymentType = paymentType;
        this.totalSpent = 0.00;
    }

    //Default constructor
    public Member() {
        this.firstName = "John";
        this.lastName = "Smith";
        this.id = (int) (Math.random()*10000);
        this.premium = false;
        this.paymentType = "none";
        this.totalSpent = 0.00;
    }

    //Print method
    public void printMember() {
        System.out.println("Member >> " + lastName + ", " + firstName + " | ID: " + id + " | Premium Status: " + premium + " | Payment Type: " + paymentType + " | Total Spent: $" + totalSpent);
    }


    //Getters and setters for all the variables
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //No setter for ID because it does not change
    public int getId() {
        return id;
    }
    
    public boolean isPremium() {
        return premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }
}