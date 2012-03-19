//import libs.*;
package libs;

public class Library extends LinkedList<Book> {
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

    public String list(String listTitle) {
        StringBuilder output = new StringBuilder();
        output.append(listTitle+"\n");
        for(int i = 0 ; i < size; ++i)
            output.append(get(i)._title + "\n");
        return output.toString();
    }

    public String list() {
        this.list("-- List of Books --");
    }

    /*public LinkedList<Book> list() {
        LinkedList<Book> list = new LinkedList();
        for(int i = 0 ; i < size; ++i)
            list.push(books[i]);
        return list;
    }*/


    public Library comics() {
        Library comics = new Library();
        for(int i = 0; i < size; ++i)
            if(get(i) instanceof Comic)
                comics.add(this.get(i));
        return comics;
    }

    public Library author(String author) {
        Library authorBooks = new Library();
        for(int i = 0; i < size; ++i)
            if(get(i)._author.equals(author))
                authorBooks.add(this.get(i));
        return authorBooks;
    }

    /*public String listTitle(String title){
        Library booksFromTitle = new Library();
        
        ...
        StringBuilder output = new StringBuilder();
        output.append("-- List of '"+title+"' --\n");
        for(int i = 0 ; i < size; ++i)
            if(books[i]._title.equals(title))
                output.append(books[i] + "\n");
        return output.toString();
    }

    public String listAuthor(String author){
        StringBuilder output = new StringBuilder();
        output.append("-- List of "+author+"'s books --\n");
        for(int i = 0 ; i < size; ++i)
            if(books[i]._author.equals(author))
                output.append(books[i] + "\n");
        return output.toString();
    }

    public String listColored(){
       return ""; // fu
    }*/

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

    public static void main(String[] args) throws Exception {
        Library lib = new Library(5);
        Book hp1 = new Book("Harry Potter", "J.K. Rollin'", "12345-5421d-dsqd254-dqsd524", 2.00);
        Comic c1 = new Comic("Superman", "Marvel", "toto","12345-5258d-azerty-dqsd524", 2.00, true);
        lib.add(hp1);
        lib.add(new Book("L'écume des jours", "Boris Vian", "AEZD01"));

        Comic c2 = new Comic("Catwoman", "Marvel", "12345-987654-qsdfggthj-dqsd524", 2.00, false);
        Comic c3 = new Comic("Superman", "Marvel", "toto","12345-5258d-azerty-dqsd524", 2.00, true);
        lib.add(c1);
        lib.add(c2);
        lib.add(c3);
        System.out.println(lib);
        System.out.println("Harry Potter inside ? " + lib.contains(hp1));

        Book hp2 = new Book("Harry Potter2", "J.K. Rollin'", 2.00);
        System.out.println("Superman equals SUperman rolalala ? " + c1.equals(c3));

        System.out.println("Counter of books ? " + Book.count());

        System.out.println("Destruction de hp2");
        hp2 = null;
        System.out.println("Thread in pause ...");
        System.gc();
        Thread.sleep(1000);
        System.out.println("Counter of books ? " + Book.count());
        System.out.println(lib.list());
        System.out.println(lib.comics().list("Comics"));
        System.out.println(lib.author("Marvel").list("Marvel"));
        System.out.println(lib.listTitle("L'écume des jours"));
    } 
}
