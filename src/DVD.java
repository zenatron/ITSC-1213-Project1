public class DVD extends Product
{
    private String studio;
    //DVDs are for video formats
    //Includes studio field

    //Constructor
    public DVD(String title, String author, String studio, double cost)
    {
        super(title, author, cost);
        this.studio = studio;
        this.id = hash();
    }

    @Override
    public long hash()
    {
        //Returns generated hash
        long result = 17;
        result = 37 * result + title.hashCode();
        result = 37 * result + author.hashCode();
        result = 37 * result + studio.hashCode();
        return result;
    }

    //Prints the DVD
    @Override
    public String toString()
    {
        return "Product: " + title + " || Author: " + author + " || Studio: " + studio + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }

    //Abstract method that allows copying of the object, from the Product class
    @Override
    public Product copy()
    {
        DVD newDVD = new DVD(title, author, studio, cost);
        newDVD.setQuantity(quantity);
        return newDVD;
    }

    @Override
    public void compareTo(Product other)
    {
        if (this.getCost() > other.getCost())
            System.out.println(this.getTitle() + " costs more");
        if (this.getCost() < other.getCost())
            System.out.println(other.getTitle() + " costs more");
        if (this.getCost() == other.getCost())
            System.out.println(this.getTitle() + " and " + other.getTitle() + " have the same cost");
    }
}
