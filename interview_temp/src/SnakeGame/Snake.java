package SnakeGame;
import java.util.*;
import static SnakeGame.Constants.*;
import SnakeGame.Constants.*;

public class Snake {
    /*1. How to init a snake? a set of coordinates
     *2. How do we simulate the movement of the snake? Movement of coordinates
     *3. How to move ? Head + Tail and Body
     *4. Which data structures we need to use for head, tail and body?
     *    Head/Tail --> int[]    Body ? --> Queue
     **/

    private int[] head;
    private int[] tail;
    private Queue<int[]> body;
    private String id;

    //Allow the access to the snake board
    private Board board;

    //User observer design pattern to board the snake event, such as live or dead
    private List<SnakeEventListener> snakeEventListeners;

    public Snake(final String id){
        this.id = id;
        head = new int[2];
        body = new LinkedList<int[]>();
        body.add(head);
        tail = body.peek();
        snakeEventListeners = new ArrayList<SnakeEventListener>();
    }

    //Use of interface: SnakeEventListener
    public interface SnakeEventListener{
        void onStateChange();
    }

    //BoardCast the event
    public void notifyListener(){
        for (SnakeEventListener snakeEventListener : snakeEventListeners){
            snakeEventListener.onStateChange();
        }
    }

    //Add the listener
    public void registerListener(SnakeEventListener snakeEventListener){
        snakeEventListeners.add(snakeEventListener);
    }

    //Remove the listener
    public void removeListener(SnakeEventListener snakeEventListener){
        snakeEventListeners.remove(snakeEventListener);
    }

    /*
     * Simulate the movement --> pop the tail and offer the head
     */
    public boolean move(Direction direction){
        //Conner case
        if (board == null) return false;

        //update the coordinate of the head
        int[] temp = direction.getValue();
        int[] newHead = new int[2];

        newHead[0] = head[0] + temp[0];
        newHead[1] = head[1] + temp[1];

        //Check the newHead is valid or not
        if (!checkAlive(newHead)){
            //If the position of newHead is invalid, then notify the listener
            notifyListener();
        }

        //Update the head
        body.offer(newHead);
        head = newHead;

        /*
         * How to simulate the "eat" and grow for the snake?
         * Offer head but no pop the tail
         */
        if(!isFood(newHead)){
            //If the newHead's position is not food, then pop the tail
            int[] drop = body.poll();

            //Update the entry in board when tail is popped
            board.setEmpty(drop[0], drop[1]);
        }

        //Update the entry in the body when newHead is offered
        board.setSnakeBody(newHead[0],newHead[1]);

        //Update the tail
        tail = body.peek();

        return true;
    }

    private boolean checkAlive(int[] position){
        final int i = position[0];
        final int j = position[1];

        //Check boundary
        if (!board.checkBoundary(i,j)) return false;

        //Get the char of the entry with coordinate i,j
        final Character tempChar = board.getMaze()[i][j];

        //If the entry is empty, directly return true
        if (tempChar == null) return true;

        //Then invalid cases: wall, snake body
        if(tempChar.equals(wallChar) || tempChar.equals(snakeChar)) return false;

        return true;
    }

    //To check the entry has food or not
    private boolean isFood(int[] position){
        final int i = position[0];
        final int j = position[1];
        if (!board.checkBoundary(i, j)) return false;
        final Character tempChar = board.getMaze()[i][j];

        if(tempChar == null || !tempChar.equals(foodChar)) return false;
        return true;
    }

    //Getters
    public int[] getHead(){
        return head;
    }

    public int[] getTail(){
        return tail;
    }

    public String getId(){
        return id;
    }

    public List<Object> getBody(){
        return Arrays.asList(body.toArray());
    }

    public int size(){
        return body.size();
    }

    //Setters
    public boolean setBoard(Board board){
        if(this.board != null || board == null) return false;
        this.board = board;
        return true;
    }

    public void setHead(final int i, final int j){
        head[0] = i;
        head[1] = j;
    }
}
