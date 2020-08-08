package OODesign.ParkingLot;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private String id;
    private VehicleSize vehicleSize;
    private Time arriveTime;
    private List<ParkingSlot> parkingSlotList;
    private Level level;
    private boolean isElectricCar;

    public Vehicle(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
        parkingSlotList = new ArrayList<>();
    }

    public abstract boolean canFitIntoSlot(ParkingSlot parkingSlot);

    public void parkIntoSlot(Level level, List<ParkingSlot> slots) {
        this.level = level;
        for (ParkingSlot slot : slots) {
            // 标记被占位置的slots
            slot.parkVehicle(this);
        }
        this.parkingSlotList.addAll(slots);
    }

    public void departureSlot() {
        for (ParkingSlot slot : parkingSlotList) {
            slot.removeVehicle();
        }
        this.parkingSlotList.clear();
        this.level.departureVehicle(this);
    }

    // Getter and Setter
    public Time getArriveTime() {
        return arriveTime;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public String getId() {
        return id;
    }

    public Level getLevel() {
        return level;
    }
}
