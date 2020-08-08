package Observer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StateChangeObserverable {

    private List<StateObserver> stateObservers = new ArrayList<StateObserver>();

    private int state;

    public StateChangeObserverable(final int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void registerListeners(StateObserver stateObserver) {
        stateObservers.add(stateObserver);
    }

    public void unregisterListeners(StateObserver stateObserver) {
        stateObservers.remove(stateObserver);
    }

    private void notification() {
        for (StateObserver stateObserver : stateObservers) {
            stateObserver.onStateChange();
        }
    }
}
