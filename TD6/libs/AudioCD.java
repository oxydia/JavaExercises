public class AudioCD extends AbstractMediaBuyable {
    private String _genre;
    private String _artist;

	public AudioCD(String title, double price, String genre, String artist) {
		super(title, price);
		_genre = genre;
		_artist = artist;
	}
    public String genre() {
        return _genre;
    }
    public String artist() {
        return _artist;
    }
}
