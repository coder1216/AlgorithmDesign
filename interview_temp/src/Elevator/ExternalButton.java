package Elevator;

import static Elevator.Direction.DOWN;
import static Elevator.Direction.UP;

public class ExternalButton extends Button implements ElevatorEventListener{
    private final ElevatorSystem elevatorSystem;

    public ExternalButton(final String id, final int levelNumber, final ElevatorSystem elevatorSystem) {
        super(id, levelNumber);
        this.elevatorSystem = elevatorSystem;
    }

    public void sendUpRequest() {
        elevatorSystem.handleRequest(new ExternalRequest(levelNumber,UP));
    }

    public void sendDownRequest(){
        elevatorSystem.handleRequest(new ExternalRequest(levelNumber,DOWN));
    }

    public ElevatorSystem getElevatorSystem(){
        return elevatorSystem;
    }

    @Override
    public void onElevatorStop() {
        System.out.println("Allow to add users here");
    }

    @Override
    public void calLevelNumber(){
        super.calLevelNumber();
    }

}
