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
    public Product copy()
    {
        DVD newDVD = new DVD(title, author, studio, cost);
        newDVD.setQuantity(quantity);
        return newDVD;
    }

    @Override
    public void compareTo(Product p1, Product p2)
    {
        if (p1.getCost() > p2.getCost())
            System.out.println("Product 1 costs more");
        if (p1.getCost() < p2.getCost())
            System.out.println("Product 2 costs more");
        if (p1.getCost() == p2.getCost())
            System.out.println("Product 1 and Product 2 have the same cost");
    }
}
