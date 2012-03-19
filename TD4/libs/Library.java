package libs;
import fr.upemlv.data.LinkedList;

public class Library extends LinkedList<MediaBuyable> {
    private final int capacity;

    public boolean add(MediaBuyable m) {
        if(size() >= capacity)
            return false;
        super.addFirst(m);
        return true;
    }

    @Override public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i = 0 ; i < size(); ++i)
            output.append(get(i) + "\n-------------------------------------\n");
        return output.toString();
    }

    public String list(String listTitle) {
        StringBuilder output = new StringBuilder();
        output.append(listTitle+"\n");
        for(int i = 0 ; i < size(); ++i)
            output.append(get(i).title() + "\n");
        return output.toString();
    }

    public String list() {
        return list("-- List of Books --");
    }

    public Library comics() {
        Library comics = new Library(capacity);
        for(int i = 0; i < size(); ++i)
            if(get(i) instanceof Comic)
                comics.add(this.get(i));
        return comics;
    }

    public Library author(String author) {
        Library fromAuthor = new Library(capacity);
        for(int i = 0; i < size(); ++i)
            if (get(i) instanceof Book && ((Book)get(i))._author.equals(author))
                fromAuthor.add(this.get(i));
        return fromAuthor;
    }

    
    public Library title(String title) {
        Library withTitle = new Library(capacity);
        for(int i = 0; i < size(); ++i)
            if(get(i).title().equals(title))
                withTitle.add(this.get(i));
        return withTitle;
    }

    public double priceAverage() {
        double avg = 0.0;
        int i = 0;
        for(; i < size(); ++i)
            avg += get(i).price();
        if (i!=0)
            avg /= i;
        return avg;
    }

    public int capacity() {
        return capacity;
    }

    public Library(int cap) {
        capacity = cap;
    }

    public boolean contains(MediaBuyable m) {
        for(int i = 0 ; i < size(); ++i)
            if(get(i) == m)
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
        System.out.println(lib.comics().list("-- Comics --"));
        System.out.println(lib.author("Marvel").list("-- Marvel --"));
        System.out.println(lib.title("L'écume des jours").list("Looking for L'écume des jours ?"));
    } 
}
