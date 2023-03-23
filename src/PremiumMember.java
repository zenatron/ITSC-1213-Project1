public class PremiumMember extends Member
{
    protected boolean paidThisMonth;
    public PremiumMember(String firstName, String lastName)
    {
        super(firstName, lastName);
        paidThisMonth = false;
    }
    public void payFees(double fee)
    {
        super.addToTotalSpent(fee);
        paidThisMonth = true;
    }

    @Override
    public String toString()
    {
        return "PREMIUM Member >> " + lastName + ", " + firstName + " | ID: " + id + " | Total Spent: $" + totalSpent;
    }
}
