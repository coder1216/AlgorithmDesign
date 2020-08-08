package OODesign.ParkingLot;

public class Car extends Vehicle{

    public Car (VehicleSize vehicleSize) {
        super(VehicleSize.COMPACT);
    }

    @Override
    public boolean canFitIntoSlot(ParkingSlot parkingSlot) {
        return VehicleSize.LARGE == parkingSlot.getSlotSize() || VehicleSize.COMPACT == parkingSlot.getSlotSize();
    }
}
