package AmazonLocker;

public enum OrderSize {
    SMALL("SMALL", 1),
    MID("MID", 2),
    LARGE("LARGE", 3);

    final String type;
    final int size;

    OrderSize(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
