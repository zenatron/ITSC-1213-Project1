public class Book extends Product 
{
    private String album;
    //Books are books
    //Includes album information

    //Constructor
    public Book(String title, String author, String album, double cost) 
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

    //Prints the book
    @Override
    public String toString()
    {
        return "Product: " + title + " || Author: " + author + " || Album: " + album + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }

    //Abstract method that allows copying of the object, from the Product class
    @Override
    public Product copy()
    {
        Book newBook = new Book(title, author, album, cost);
        newBook.setQuantity(quantity);
        return newBook;
    }
}
