package Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    public static final int MAX_FLOOR = 15;
    public static final int ElEVATOR_CAPACITY = 20;
    public static final int ELEVATOR_NUM = 4;
    public static final String ELEVATOR_SYSTEM_NAME = "ElevatorSystem";

    private final List<ExternalButton> externalButtons;
    private final List<Elevator> elevators;

    private boolean isNormal = true;

    public ElevatorSystem(){
        externalButtons = new ArrayList<ExternalButton>(MAX_FLOOR);
        elevators = new ArrayList<Elevator>(ELEVATOR_NUM);

        //Generate new external buttons
        initElevator();
        initExternalButton();

        addElevatorEventListener();
    }

    private void initExternalButton(){
        for (int i = 1; i <= MAX_FLOOR; i++){
            externalButtons.add(new ExternalButton(ELEVATOR_SYSTEM_NAME + "-" + i,i,this));
        }
    }

    private void initElevator(){
        for (int i = 0; i < ELEVATOR_NUM; i++){
            final Elevator elevator = new Elevator("" + i + 1, ElEVATOR_CAPACITY);
            elevators.add(elevator);
        }
    }

    private void addElevatorEventListener(){
        for(Elevator elevator : elevators){
            for (ExternalButton externalButton : externalButtons){
                elevator.registerListener(externalButton);
            }
        }
    }

    public void handleRequest(final ExternalRequest request){
        for (Elevator elevator : elevators){
            elevator.handleExternalRequest(request);
        }
    }

    private void setAbnormal(){
        isNormal = false;
    }

    public void execute(){
        while (isNormal){
            for (Elevator elevator : elevators) {
                elevator.run();
            }
        }
    }

}
