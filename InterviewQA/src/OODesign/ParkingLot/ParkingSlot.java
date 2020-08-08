package OODesign.ParkingLot;

public class ParkingSlot {
    private String slotId;
    private Vehicle vehicle;
    private VehicleSize slotSize;
    private Level level;
    private boolean electricSlot;

    public ParkingSlot(VehicleSize slotSize, String slotId, Level level, boolean electricSlot) {
        this.level = level;
        this.slotId = slotId;
        this.slotSize = slotSize;
        this.electricSlot = electricSlot;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    // Getter and Setter
    public VehicleSize getSlotSize() {
        return slotSize;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSlotId() {
        return slotId;
    }

    public Level getLevel() {
        return level;
    }
}
