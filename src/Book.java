public class Book extends Product 
{
    //Books are books
    //Constructor
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

    //Abstract method that allows copying of the object, from the Product class
    @Override
    public Product copy()
    {
        Book newBook = new Book(title, author, cost);
        newBook.setQuantity(quantity);
        return newBook;
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
