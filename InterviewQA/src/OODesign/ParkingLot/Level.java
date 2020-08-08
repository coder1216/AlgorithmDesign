package OODesign.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    // private static final int
    private int floor;
    private int availableSlots;
    private static final int ROWS = 5;
    private static final int COLS = 10;
    private ParkingSlot[][] slots;
    //private List<ParkingSlot> slots;

    public Level(int floor) {
        this.floor = floor;
        slots = new ParkingSlot[ROWS][COLS];
        //slots = new ArrayList<>();
    }

    public List<ParkingSlot> canParkVehicle(Vehicle vehicle) {
        for (int i = 0; i < ROWS; i++) {
            List<ParkingSlot> slots = canParkInRow(i, vehicle);
            if (!slots.isEmpty()) {
                return slots;
            }
        }
        return new ArrayList<>();
    }

    public List<ParkingSlot> canParkInRow(int rowIndex, Vehicle vehicle) {
        ParkingSlot[] row = slots[rowIndex];
        int slotNeeded = vehicle.getVehicleSize().getSize();
        int cnt = 0;
        List<ParkingSlot> slots = new ArrayList<>();

        for (int i = 0; i < COLS; i++) {
            ParkingSlot slot = row[i];
            if (slot.isAvailable() && vehicle.canFitIntoSlot(slot)) {
                cnt++;
                slots.add(slot);
            } else {
                cnt = 0;
                slots.clear();
            }

            if (cnt == slotNeeded) {
                return slots;
            }
        }
        return new ArrayList<>();
    }

    public void parkVehicle(Vehicle vehicle, List<ParkingSlot> slots) {
        vehicle.parkIntoSlot(this, slots);
        this.availableSlots -= vehicle.getVehicleSize().getSize();
    }

    public void departureVehicle(Vehicle vehicle) {
        this.availableSlots += vehicle.getVehicleSize().getSize();
    }

    // Getter and Setter

    public static int getROWS() {
        return ROWS;
    }

    public ParkingSlot[][] getSlots() {
        return slots;
    }

    public int getFloor() {
        return floor;
    }

    public static int getCOLS() {
        return COLS;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }
}
