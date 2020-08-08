package ParkingLot;

import java.util.List;

public abstract class Vechicle {
    // bus may need 5 slots
    private List<ParkingSlot> parkingSlots;
    private VechicleSize vechicleSize;
    private int spotsNeeded;
    private Level ParkingLotLevel;
    private String arrivetime;

    public Vechicle(VechicleSize vechicleSize, int spotsNeeded) {

    }

    private abstract boolean canFitInSpot(ParkingSpot parkingSpot);

    public void setParkingSpots(Level level, List<ParkingSpot> spots) {

    }

    public void depatureSpot() {

    }

}
