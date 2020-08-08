package Elevator;

import com.oracle.tools.packager.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static Elevator.Direction.*;
import static Elevator.ElevatorSystem.MAX_FLOOR;

public class Elevator {
    //The id for the Elevator
    private final String id;

    //The capacity for the elevator
    private final int capacity;

    //The task manager for up and down tasks
    private final PriorityQueue<Integer> upTasks;

    private final PriorityQueue<Integer> downTasks;

    //The current running direction
    private Direction currentDirection;

    //The current floor number
    private int currentLevelNumber;

    //The list of users
    private final List<User> users;

    //The observers of this elevator
    private final List<ElevatorEventListener> elevatorEventListeners;

    //Internal Buttons
    private final List<InternalButton> internalButtons;

    //Constructor
    public Elevator(final String id, final int capacity){

        this.id = id;
        this.capacity =capacity;
        currentDirection = STOP;
        currentLevelNumber = 1;
        users = new ArrayList<>();
        elevatorEventListeners = new ArrayList<>();
        internalButtons = new ArrayList<>();

        //Initialize Internal Buttons
        initInteralButtons();

        //initialize other fields
        //Min Heap
        upTasks = new PriorityQueue<>(MAX_FLOOR, (r1, r2) -> {
            if (r1.equals(r2)) return 0;

            return r1 > r2 ? 1 : -1;
        });

        //MaxHeap
        downTasks = new PriorityQueue<>(MAX_FLOOR, (r1, r2) -> {
            if (r1.equals(r2)) return 0;

            return r2 > r1 ? 1 : -1;
        });
    }

    //Initialize Internal Buttons
    private void initInteralButtons(){
        for (int i = 1; i < MAX_FLOOR; i++) {
            internalButtons.add(new InternalButton(id + "-" + "1",i,this));
        }
    }

    //Register Listeners
    public void registerListener(final ElevatorEventListener elevatorEventListener){
        elevatorEventListeners.add(elevatorEventListener);
    }

    //deregisterListeners
    public void deregisterListeners(final ElevatorEventListener elevatorEventListener){
        elevatorEventListeners.remove(elevatorEventListener);
    }

    //Notify Listeners
    private void notifyEventListener(){
        for (ElevatorEventListener elevatorEventListener : elevatorEventListeners){
            elevatorEventListener.onElevatorStop();
        }
    }

    //Handle the request
    public boolean handleInternalRequest(final Request request){

        if (!checkValid(request)) {
            return false;
        }

        final Integer requestLevelNumber = request.getLevelNumber();

        //Handle the task according to the currentLevel
        if (requestLevelNumber > currentLevelNumber && currentDirection == UP) {
            upTasks.offer(requestLevelNumber);
            return true;
        } else if(requestLevelNumber < currentLevelNumber && currentDirection == DOWN) {
            downTasks.offer(requestLevelNumber);
            return true;
        }

        return false;
    }

    public boolean handleExternalRequest(final ExternalRequest externalRequest) {
        if (!checkValid(externalRequest)) {
            return false;
        }

        final int requestLevelNumber = externalRequest.getLevelNumber();
        if (externalRequest.getDirection() == UP && currentDirection == UP){
            if (externalRequest.getLevelNumber() > currentLevelNumber){
                upTasks.offer(requestLevelNumber);
                return true;
            }
        } else if(externalRequest.getDirection() == DOWN && currentDirection == DOWN){
            if (externalRequest.getLevelNumber() < currentLevelNumber){
                downTasks.offer(requestLevelNumber);
                return true;
            }
        }

        return true;
    }

    private boolean checkValid(final Request request){
        if (request == null) return false;

        final Integer requestLevelNumber = request.getLevelNumber();

        if(requestLevelNumber < 1 || requestLevelNumber > MAX_FLOOR){
            //Edge cases

            Log.info("Elevator: The request is invalid");
            return false;
        } else if (requestLevelNumber == currentLevelNumber || upTasks.contains(requestLevelNumber) || downTasks.contains(requestLevelNumber)) {
            //Duplicate cases
            Log.info("Elevator: The request is duplicate");
            return false;
        }

        return true;
    }

    //Elevator Move Up
    public void moveUp(){
        currentDirection = UP;

        while(!upTasks.isEmpty()){
            currentLevelNumber = upTasks.poll();
            notifyEventListener();
        }

        currentDirection = STOP;
    }


    //Elevator Move down
    public void moveDown(){
        currentDirection = DOWN;
        while(!downTasks.isEmpty()){
            currentLevelNumber = downTasks.poll();
            notifyEventListener();
        }

        currentDirection = STOP;
    }

    public void run(){
        if(currentDirection == STOP){
            while (!upTasks.isEmpty()) {
                moveUp();
            }

            while(!downTasks.isEmpty()){
                moveDown();
            }
        }
    }

    //Add users
    public boolean addUser(User user) {
        if(users.size() > capacity) return false;

        users.add(user);
        return true;
    }

    //Getters
    public String getId(){
        return id;
    }

    public int getCapacity(){
        return capacity;
    }

    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public List<User> getUsers(){
        return users;
    }

    public int getCurrentLevelNumber(){
        return currentLevelNumber;
    }

}
