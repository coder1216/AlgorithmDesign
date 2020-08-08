package OODesign.ParkingLot;

public class Bus extends Vehicle{

    public Bus(VehicleSize vehicleSize) {
        super(VehicleSize.LARGE);
    }

    @Override
    public boolean canFitIntoSlot(ParkingSlot parkingSlot) {
        return VehicleSize.LARGE == parkingSlot.getSlotSize();
    }
}
