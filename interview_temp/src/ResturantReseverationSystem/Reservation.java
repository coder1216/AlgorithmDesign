package ResturantReseverationSystem;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Reservation {
    //The id of the reservation
    private final String id;

    //The size of the party
    private final int size;

    //The start time of this reservation
    private final long startTime;

    //The end time of the reservation
    private final long endTime;

    //The time period
    private final long[] reservationPeriod;

    //The data structure to save extra information
    private final Map<String,Object> notes;

    /*
     * Constructor
     * The builder design pattern is used here to build the reservation
     * @param builder    The object to build the reservation
     */
    private Reservation(@NotNull final Reservation builder){
        this.id = builder.id;
        this.size = builder.size;
        this.startTime = builder.startTime;
        this.endTime =builder.endTime;
        this.notes = new HashMap<>();
        reservationPeriod = new long[]{startTime,endTime};
    }

    public long[] getReservationPeriod() throws IllegalArgumentException {
        if (startTime < endTime) {
            return reservationPeriod;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Map<String,Object> getExtra(){
        return notes;
    }

    //Getters
    public String getId(){
        return id;
    }

    public int getSize(){
        return size;
    }

    public long getStartTime(){
        return startTime;
    }

    public long getEndTime(){
        return endTime;
    }
}
