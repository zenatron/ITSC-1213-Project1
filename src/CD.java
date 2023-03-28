public class CD extends Product 
{
    private String album;
    //CDs are for audio and music
    //Includes album field

    //Constructor
    public CD(String title, String author, String album, double cost) 
    {
        super(title, author, cost);
        this.album = album;
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

    //Prints the CD
    @Override
    public String toString()
    {
        return "CD: " + title + " || Author: " + author + " || Album: " + album + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }

    //Abstract method that allows copying of the object, from the Product class
    @Override
    public Product copy()
    {
        CD newCD = new CD(title, author, album, cost);
        newCD.setQuantity(quantity);
        return newCD;
    }
}
