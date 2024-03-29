package libs;
import java.io.*;

public class Book extends AbstractMediaBuyable {
    public String _author;
    public String _isbn;
    public static int _count = 0;

    public Book(String title, String author, String isbn, double price) {
        super(title, price);
        _author = author;
        _isbn = isbn;
        ++_count;
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

    public Book() {
        _author = "";
        _isbn = "";
    }

    public void finalize() {
        --_count;
    }

    @Override public String toString() {
        return "- Bookaing -\nTitle : " + title() + "\nAuthor : " + _author;
    }

    public int hashCode() {
        return (int)(super.hashCode() + _author.hashCode() + _isbn.hashCode());
    }

    public boolean equals(Book o) {
        return o instanceof Book && o.hashCode() == hashCode();
    }

    public static int count() {
        return _count;
    }

    public String toBackup() {
        return "Book\n"+title()+"\n"+_author+"\n"+_isbn+"\n"+price()+"\n\n";
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

    // Externalization
    public void writeExternal(ObjectOutput out) {
        super.writeExternal(out);
        out.writeUTF(_author);
        out.writeUTF(_isbn);
        out.writeInt(_count);
    }
    public void readExternal(ObjectInput in) {
        super.readExternal(in);
        _author = in.readUTF();
        _isbn = in.readUTF();
        _count = in.readInt();
    }
}
