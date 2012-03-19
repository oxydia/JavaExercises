import fr.upemlv.data.LinkedList;

public class MediaIntegrale extends AbstractMediaBuyable {
    LinkedList<MediaBuyable> medias;

    public String title() {
        String output = "";
        for(int i=0 ; i<medias.size(); ++i)
            output += "\n" + medias.get(i).title();
        return output;
    }
    public double price() {
        double sum = 0;
        for (int i=0; i<medias.size(); ++i)
            sum += medias.get(i).price();
        return sum;
    }
    public double taxIncludedPrice(double taxRate) {
        return price() * (100 + taxRate) / 100;
    }

    // constructor
    public MediaIntegrale(String title, double price) {
        super(title, price);
    }
}
