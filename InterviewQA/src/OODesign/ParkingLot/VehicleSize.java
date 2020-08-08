package OODesign.ParkingLot;

public enum VehicleSize {

    SMALL("SMALL", 1),
    COMPACT("COMPACT", 3),
    LARGE("LARGE", 5);

    final String type;
    final int size;


    VehicleSize(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
