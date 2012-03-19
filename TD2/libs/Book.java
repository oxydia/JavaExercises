package libs;

public class Book {
    public final String _title;
    public final String _author;
    public final String _isbn;
    public final double _price;
    public static int _count = 0;


    public Book(String title, String author, String isbn, double price) {
        _title = title;
        _author = author;
        _isbn = isbn;
        _price = price;
        ++_count;
    }

    public Book(String title, String author, String isbn) {
        this(title, author, isbn, 1.);
    }

    public Book(String title, String author, double price) {
        this(title, author, "", price);
    }

    public Book(String title, String author) {
        this(title, author, "", 1.);
    }

    public void finalize() {
        --_count;
    }

    @Override public String toString() {
        return "- Bookaing -\nTitle : " + _title + "\nAuthor : " + _author + "\nPrice : " + _price;
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
