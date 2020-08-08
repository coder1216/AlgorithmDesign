package SnakeGame;
import SnakeGame.Constants.*;

import static SnakeGame.Constants.*;

public class Board {
    private final int width;
    private int height;

    private final Character[][] maze;
    private final String id;

    private Snake snake;

    public Board(final String id, final int width, final int height) {
        this.id = id;
        this.height = height;
        this.width = width;
        maze = new Character[height][width];
        init();
    }

    private void init() {
        for (int i = 0; i < height; i++) {
            maze[i][0] = wallChar;
            maze[0][width - 1] = wallChar;
        }

        for (int i = 0; i < width; i++) {
            maze[0][i] = wallChar;
            maze[width -1][i] = wallChar;
        }
    }

    //Add the oringinal snake to the board, which is a single point
    public boolean addSnake(final Snake snake, final int i, final int j){
        if(this.snake != null || snake == null || snake.size() > 1) return false;
        if(!checkBoundary(i, j) || maze[i][j] != null) return false;
        maze[i][j] = snakeChar;
        this.snake = snake;
        snake.setBoard(this);
        return true;
    }

    //Check boundary
    public boolean checkBoundary(final int i, final int j){
        return !(i < 0 || i >= height || j < 0 || j >= width);
    }

    //Set char for wall in the maze
    public boolean setWall(final int i, final int j){
        if(!checkBoundary(i, j)) return false;

        if(maze[i][j] == null){
            maze[i][j] = wallChar;
            return true;
        }
        return false;
    }

    //Set char for food in the maze
    public boolean setFood(final int i, final int j){
        if(!checkBoundary(i, j)) return false;

        if(maze[i][j] == null){
            maze[i][j] = foodChar;
            return true;
        }
        return false;
    }

    //Set the char for snake in the maze
    public boolean setSnakeBody(final int i, final int j){
        if(!checkBoundary(i,j)) return false;

        if(maze[i][j] == null || maze[i][j] == foodChar){
            maze[i][j] = snakeChar;
            return true;
        }
        return false;
    }

    //Clear the entry for the maze
    public boolean setEmpty(final int i, final int j){
        if(!checkBoundary(i, j)) return false;

        maze[i][j] = null;
        return false;
    }

    // getter
    public String getId() {
        return id;
    }

    public Character[][] getMaze() {
        return maze;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
