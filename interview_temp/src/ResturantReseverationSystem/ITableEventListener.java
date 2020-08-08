package ResturantReseverationSystem;

public interface ITableEventListener {
    /*
     * The method to notify listeners
     * @param tableId       The id of the table
     * @param fromState     The initial state of the table
     * @param toState       The current state if the table
     */
    void onTableStateChanged(final String tableId, TableState fromState, final TableState toState);
}
