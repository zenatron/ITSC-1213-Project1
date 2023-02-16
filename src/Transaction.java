import java.text.SimpleDateFormat;

public class Transaction 
{
    private long id;
    private long memberId;
    private long productId;
    private PaymentType paymentType;
    private double amount;
    private String timestamp;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //Constructor
    public Transaction(long id, long memberId, long productId, PaymentType paymentType, double amount)
    {
        this.id = id;
        this.memberId = memberId;
        this.productId = productId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.timestamp = sdf.format(System.currentTimeMillis());
    }

    //Allows printing of the Transaction
    public String toString()
    {
        return "Transaction >>> " + id + " ||Member: " + memberId + " ||Product: " + productId + " ||Amt: " + amount + " || Payment: " + paymentType +" ||Time: " + timestamp; 
    }

    //Generic getters and setters
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}