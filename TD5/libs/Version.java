package libs;

public enum Version {
    COLLECTOR("collector", 1.1),
    NORMAL("", 1.0),
    DISCOUNT("discount", 0.5);

    private final String _suffix;
    private final double _rate;

    Version(String suffix, double rate) {
        _suffix = suffix;
        _rate = rate;
    }

    public String suffix() {
        return _suffix;
    }

    public double rate() {
        return _rate;
    }
}