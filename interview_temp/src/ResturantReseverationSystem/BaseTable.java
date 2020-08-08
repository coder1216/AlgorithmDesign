package ResturantReseverationSystem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ResturantReseverationSystem.TableState.*;

public class BaseTable {
    //The id of the table
    private final String tableId;

    //The type of the table
    private final TableType tableType;

    //The max number of customer this table can take
    private final int capacity;

    /*
     *  The Map to track the extra info
     *  Key is the name of the field as a string
     *  Value if the actual object
     */
    private final Map<String,Object> notes;

    /*
     *  The Map to track reservation with the time period
     *  Key is the reservation id
     *  Value is the corresponding time period
     */
    private final Map<String, long[]> reservations;

    //The list to save the listener of this class
    private final List<ITableEventListener> tableEventListeners;

    //The current state of this table
    private TableState state;

    public BaseTable(@NotNull final String id,@NotNull final TableType tableType){
        this.tableId = id;
        this.tableType = tableType;
        this.capacity = tableType.getCapacity();

        tableEventListeners = new ArrayList<>();
        reservations = new HashMap<>();
        notes = new HashMap<>();
        state = Empty;
    }

    /*
     * The method to track if the table is available with the given time period
     * @param id            The id of this table
     * @param tableType     The type of this table
     */
    public boolean isAvailable(@NotNull final long[] timeStamp){
        if(timeStamp == null) return false;
        if(state == Empty) return true;

        final long currentTime = System.currentTimeMillis();

        long start = timeStamp[0];
        long end = timeStamp[1];

        if(currentTime >= start || currentTime >= end) return false;

        //Traverse the existing reservations, if none existing reservation
        //has conflict with this time stamp, then it can be reserved.
        for(long[] period : reservations.values()){
            if(period[0] >= start && period[0] <= end) return false;
            if(period[1] >= start && period[1] <= end) return false;
        }

        return true;
    }

    //Clear all the references
    public void clear(){
        reservations.clear();
        notes.clear();
        tableEventListeners.clear();
        state = Empty;
    }

    public void setState(@NotNull final TableState state){
        this.state = state;
    }

    /*
     * The method to reserve this table
     * @return boolean          Return the reservation is successful or not
     * @param reservationId     The id of the reservation
     * @param timeStamp         The time period of the reservation
     */
    public boolean reserve(@NotNull final String reservationId,@NotNull final long[] timeStamp){
        if(!isAvailable(timeStamp)) return false;

        reservations.put(reservationId,timeStamp);

        if (state == Empty) {
            onTableReserved();
            state = Reserved;
        }

        return true;
    }

    /*
     * The method to reserve this table
     * @return boolean          Return the cancellation is successful or not
     * @param reservationId     The id of the reservation
     */
    public boolean cancel(@NotNull final String reservationId){
        if(!reservations.containsKey(reservationId)) return false;

        reservations.remove(reservationId);

        if(reservations.size() == 0){
            if (state != Occupy) {
                onTableCleared();
                state = Empty;
            }
        } else {
            if (state != Occupy) {
                state = Reserved;
            }
        }

        return true;
    }

    /*
     *
     *         ss  ee
     *                                           ss ee
     *     ------------------Start---------End------------
     *
     * */

    /*
     * The method to occupy the table
     */
    public boolean occupyTable(){
        if (state != Occupy){
            onTableOccupied();
            state = Occupy;
            return true;
        }

        return false;
    }

    /*
     * The moment that the table is occupied
     */
    public void onTableOccupied(){
        notifyListener(tableId,state,Occupy);
    }

    /*
     * The moment that the table is Reserved
     */
    public void onTableReserved(){
        notifyListener(tableId,state,Reserved);
    }

    /*
     * The moment that the customers leave the table
     */
    public void onTableCleared(){
        notifyListener(tableId,state,Empty);
    }

    /*
     * The method to register listener
     */
    public void registerListener(final ITableEventListener tableEventListener){
        tableEventListeners.add(tableEventListener);
    }

    /*
     * The method to deregister listener
     */
    public void deregisterListener(final ITableEventListener tableEventListener){
        tableEventListeners.remove(tableEventListener);
    }

    /*
     * The method to notify listeners
     * @param tableId       The id of the table
     * @param fromState     The initial state of the table
     * @param toState       The current state if the table
     */
    private void notifyListener(final String tableId, TableState fromState, final TableState toTableState){
        for(ITableEventListener tableEventListener : tableEventListeners){
            tableEventListener.onTableStateChanged(tableId,fromState,toTableState);
        }
    }

    //Getters
    public String getTableId(){
        return tableId;
    }

    public TableType getTableType(){
        return tableType;
    }

    public TableState getState(){
        return state;
    }

    public int getCapacity(){
        return capacity;
    }

    public Map<String,Object> getNotes(){
        return notes;
    }

}
