package libs;

public class Book implements MediaBuyable {
    public final String _author;
    public final String _isbn;
    public static int _count = 0;
    private String _title;
    private double _price;

    public Book(String title, String author, String isbn, double price) {
        _title = title;
        _author = author;
        _isbn = isbn;
        _price = price;
        ++_count;
    }
    public String title() {
        return _title;
    }
    public double price() {
        return _price;
    }
    public double taxIncludedPrice(double taxRate) {
        return _price * (100 + taxRate) / 100;
    }

    public Book(String title, String author, String isbn) {
        this(title, author, isbn, 0.);
    }

    public Book(String title, String author, double price) {
        this(title, author, "", price);
    }

    public Book(String title, String author) {
        this(title, author, "", 0.);
    }

    public void finalize() {
        --_count;
    }

    @Override public String toString() {
        return "- Bookaing -\nTitle : " + _title + "\nAuthor : " + _author;
    }

    public int hashCode() {
        return (int)(_title.hashCode() + _author.hashCode() + _isbn.hashCode() + (int)(_price*100));
    }

    public boolean equals(Book o) {
        return o instanceof Book && o.hashCode() == hashCode();
    }

    public static int count() {
        return _count;
    }

   /* public static void main(String[] params) {
        Book book = new Book("Harry Potter", "J.K. Rollin'", "12345-5421d-dsqd254-dqsd524", 2.00);
        System.out.println(book);

        Book b1 = new Book("L'écume des jours", "Boris Vian", "AEZD01", 9.99);
        Book b2 = new Book("L'écume des jours", "Boris Vian", "AEZD01", 9.99);
        Book b3 = b1;
        System.out.println(b1.equals(b2)); 
        System.out.println(b1.equals(b3)); 
		
    }*/
}
