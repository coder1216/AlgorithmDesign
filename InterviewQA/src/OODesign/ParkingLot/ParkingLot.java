package OODesign.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static final int NUM_OF_LEVELS = 10;
    private Level[] levels;

    public ParkingLot() {
        this.levels = new Level[NUM_OF_LEVELS];
        for (int i = 0; i < this.levels.length; i++) {
            this.levels[i] = new Level(i + 1);
        }
    }

    public boolean canParkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (!level.canParkVehicle(vehicle).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void vehicleParking(Vehicle vehicle) {
        for (Level level : levels) {
            List<ParkingSlot> slots = level.canParkVehicle(vehicle);
            if (!slots.isEmpty()) {
                level.parkVehicle(vehicle, slots);
                return;
            }
        }
    }

    public void vehicleDepart(Vehicle vehicle) {
        vehicle.departureSlot();
    }

    // Getter and Setter
    public static int getNumOfLevels() {
        return NUM_OF_LEVELS;
    }

    public Level[] getLevels() {
        return levels;
    }
}
