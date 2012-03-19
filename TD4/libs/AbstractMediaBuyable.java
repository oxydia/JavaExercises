package libs;
import fr.upemlv.data.LinkedList;

public class AbstractMediaBuyable implements MediaBuyable {

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
    private LinkedList<Subpart> _subparts;

    public String title() {
        return _title;
    }

    public double price() {
        return _price;
    }

    public double taxIncludedPrice(double taxRate) {
        return _price * (100 + taxRate) / 100;
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
}
