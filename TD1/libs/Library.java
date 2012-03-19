//import libs.*;
package libs;

public class Library {
    public Book[] books;
    private final int capacity;
    private int size;

    public boolean add(Book book) {
        if(size >= capacity)
            return false;
        books[size] = book;
        ++size;
        return true;
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i = 0 ; i < size; ++i) {
            output.append(books[i]);
            output.append("\n-------------------------------------\n");
        }
        return output.toString();
    }

    public int capacity() {
        return capacity;
    }

    public Library(int cap) {
        capacity = cap;
        books = new Book[capacity];
        size = 0;
    }

    public int size() {
        return size; //books.length;
    }

    public boolean contains(Book book) {
        for(int i = 0 ; i < size; ++i)
            if(books[i] == book)
                return true;
        return false;
    }

    public static void main(String[] args) {
        Library lib = new Library(5);
        Book hp1 = new Book("Harry Potter", "J.K. Rollin'", "12345-5421d-dsqd254-dqsd524", 2.00);
        lib.add(hp1);
        lib.add(new Book("L'écume des jours", "Boris Vian", "AEZD01", 9.99));

        System.out.println(lib);
        System.out.println("Harry Potter inside ? " + lib.contains(hp1));

        Book hp2 = new Book("Harry Potter2", "J.K. Rollin'", "12345-5421d-dsqd254-dqsd524", 2.00);
        System.out.println("Harry Potter 2 equals HP1 ? " + hp1.equals(hp2));
    } 
}
