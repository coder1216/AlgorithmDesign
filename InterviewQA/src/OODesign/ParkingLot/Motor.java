package OODesign.ParkingLot;

public class Motor extends Vehicle{

    public Motor(VehicleSize vehicleSize) {
        super(VehicleSize.SMALL);
    }

    @Override
    public boolean canFitIntoSlot(ParkingSlot parkingSlot) {
        return VehicleSize.LARGE == parkingSlot.getSlotSize() ||
                VehicleSize.COMPACT == parkingSlot.getSlotSize() ||
                VehicleSize.SMALL == parkingSlot.getSlotSize();
    }
}
