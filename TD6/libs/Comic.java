package libs;
import java.io.*;

public class Comic extends Book {
    public String _drawer;
    public boolean _colored;

    public Comic(String title, String author, String drawer, String isbn, double price, boolean colored) {
        super(title, author, isbn, price);
        _drawer = drawer;
        _colored = colored;
    }

    public Comic(String title, String author, String isbn, double price, boolean colored) {
        this(title, author, author, isbn, price, colored);
    }

    public Comic() {
        _drawer = "";
        _colored = false;
    }

    @Override public String toString() {
        return "- Comic sans ms -\nTitle : " + title() + "\nAuthor : " + _author + "\nDrawer : " + _drawer + "\nIn color ? " + _colored;
    }

    public boolean equals(Comic o) {
        return o instanceof Comic && o.hashCode() == hashCode();
    }

    public int hashCode() {
        return (int)(super.hashCode() + _drawer.hashCode() + (_colored?1:0));
    }

    public String toBackup() {
        return "Comic\n"+title()+"\n"+price()+"\n"+_drawer+"\n"+_isbn+"\n"+price()+"\n"+_colored+"\n\n";
    }

    // Externalization
    public void writeExternal(ObjectOutput out) {
        super.writeExternal(out);
        out.writeUTF(_drawer);
        out.writeBoolean(_colored);
    }
    public void readExternal(ObjectInput in) {
        super.readExternal(in);
        _drawer = in.readUTF();
        _colored = in.readBoolean();
    }
}
