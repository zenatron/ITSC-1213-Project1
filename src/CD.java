public class CD extends Product 
{
    private String album;
    //CDs are for audio and music
    //Includes album field

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

    @Override
    public String toString()
    {
        return "Product: " + title + " || Author: " + author + " || Album: " + album + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }

    public Product copy()
    {
        CD newCD = new CD(title, author, album, cost);
        newCD.setQuantity(quantity);
        return newCD;
    }    
}
