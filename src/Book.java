public class Book extends Product 
{
    //Books are books
    public Book(String title, String author, double cost) 
    {
        super(title, author, cost);
        this.id = hash();
    }

    @Override
    public long hash() 
    {
        //Returns generated hash
        long result = 17;
        result = 37 * result + title.hashCode();
        result = 37 * result + author.hashCode();
        return result;
    }
}
