package libs;
import java.io.Serializable;

public interface MediaBuyable extends Serializable {
    public String title();
    public double price();
    public double taxIncludedPrice(double taxRate);
    public String toBackup();
}
