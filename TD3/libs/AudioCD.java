public class AudioCD implements MediaBuyable {
    private String _title;
    private double _price;
    private String _genre;
    private String _director;

    public String title() {
        return _title;
    }
    public double price() {
        return _price;
    }
    public String genre() {
        return _genre;
    }
    public String director() {
        return _director;
    }
    public double taxIncludedPrice(double taxRate) {
        return _price * (100 + taxRate) / 100;
    }
}
