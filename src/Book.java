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
    public Product copy()
    {
        Book newBook = new Book(title, author, cost);
        newBook.setQuantity(quantity);
        return newBook;
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
