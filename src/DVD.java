public class DVD extends Product
{
    private String album;
    //DVDs are for video formats
    //Includes studio field

    //Constructor
    public DVD(String title, String author, String album, double cost) 
    {
        super(title, author, album, cost);
        this.id = hash();
    }

    @Override
    public long hash()
    {
        //Returns generated hash
        long result = 17;
        result = 37 * result + title.hashCode();
        result = 37 * result + author.hashCode();
        result = 37 * result + album.hashCode();
        return result;
    }

    //Prints the DVD
    @Override
    public String toString()
    {
        return "Product: " + title + " || Author: " + author + " || Album: " + album + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }

    //Abstract method that allows copying of the object, from the Product class
    @Override
    public Product copy()
    {
        DVD newDVD = new DVD(title, author, album, cost);
        newDVD.setQuantity(quantity);
        return newDVD;
    }
}
