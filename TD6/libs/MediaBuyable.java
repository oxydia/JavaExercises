package libs;

public interface MediaBuyable {
    public String title();
    public double price();
    public double taxIncludedPrice(double taxRate);
    public String toBackup();
}
