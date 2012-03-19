package libs;
import fr.upemlv.data.LinkedList;
import java.io.*;

public class AbstractMediaBuyable implements MediaBuyable, Externalizable {

    public class Subpart {
        private String _title;
        public Subpart(String title) {
            _title = title;
        }
        public String title() {
            return _title;
        }
        public void title(String title){
            _title = title;
        }
    }

    private String _title;
    private double _price;
    private Version _version;
    private LinkedList<Subpart> _subparts;

    // Constructor
    public AbstractMediaBuyable(String title, double price) {
        _title = title;
        _price = price;
        _version = Version.NORMAL;
    }

    public AbstractMediaBuyable(){
        _title = "";
        _price = 0;
        _version = Version.NORMAL;
    }

    // Accessors
    public String title() {
        return _title + " " + _version.suffix();
    }

    public double price() {
        return _price * _version.rate();
    }

    public double taxIncludedPrice(double taxRate) {
        return price() * (100 + taxRate) / 100;
    }

    protected void price(double price) {
        _price = price;
    }

    protected void title(String title) {
        _title = title;
    }

    public void addSubpart(String title) {
        _subparts.addFirst(new Subpart(title));
    }

    public String getSubpart(int index){
        return _subparts.get(index).title();
    }

    public Subpart subpart(int index) {
        return _subparts.get(index);
    }

    public Version version() {
        return _version;
    }

    public void version(Version version) {
        _version = version;
    }

    // utils
    public int hashCode() {
        return (int)(_title.hashCode() + price()*100 + _version.suffix().hashCode());
    }

    public boolean equals(AbstractMediaBuyable amb) {
        return amb.hashCode() == hashCode();
    }

    @Override public String toString() {
        return "Title : " + _title + "\nPrice : " + _price;
    }

    public String toBackup() {
        return "AbstractMediaBuyable\n"+_title+"\n"+_price+"\n\n";
    }

    public void writeExternal(ObjectOutput out) {
        out.writeUTF(_title);
        out.writeDouble(_price);
        out.writeUTF(_version.name());
        out.writeInt(_subparts.size);
        // loop on _subparts
        for(Iterator<Subpart> it = _subparts.iterator(); it.hasNext();)
            out.writeUTF(it.next().title());
    }

    public void readExternal(ObjectInput in) {
        try {
            _title = in.readUTF();
            _price = in.readDouble();
            _version = Version.valueOf(in.readUTF());
            nbSubparts = in.readInt();
            for(int i = 0; i < nbSubparts; ++i)
                this.addSubpart(new Subpart(in.readUTF()));
        } catch(Exception e){}
    }
}