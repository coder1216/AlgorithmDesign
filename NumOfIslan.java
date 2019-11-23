/**
 * 
 *  O(mn)
 * num of isLand return the square of the island
 * 返回最大面积的岛
 */


 class Solution{
     public int numOfIsland(int[][] grid){
         if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
         int row = grid.length;
         int col = grid[0].length;
         boolean[][] isVisited = new boolean[row][col];
         int maxSquare = 0; 
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    maxSquare = Math.max(maxSquare, dfs(grid, isVisited, row, col, i, j));
                }
            }
        }
        return maxSquare;
     }
     private int dfs(int[][] grid, boolean[][] isVisited, int row, int col, int i, int j){
         if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0' || isVisited[i][j]) return 1;
         isVisited[i][j] = true;
         return 1 + dfs(grid, isVisited, row, col, i+1, j) + dfs(grid, isVisited, row, col, i-1, j) + dfs(grid, isVisited, row, col+1, i, j) + dfs(grid, isVisited, row, col-1, i, j);

     }
 }

 /**
 * 
 * 
 * 返回形状一样的岛
 * O(mn)
 */
class Solution{
    public int numOfIsland(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int maxSquare = 0; 
       for(int i = 0; i < row; i++){
           for(int j = 0; j < col; j++){
               if(grid[i][j] == '1' && !isVisited[i][j]){
                   dfs(grid, isVisited, row, col, i, j);
                   set.put(path.toString());
               }
           }
       }
       return maxSquare;
    }
    private void dfs(int[][] grid, boolean[][] isVisited, int row, int col, int i, int j, path, ch){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0' || isVisited[i][j]) return;
        isVisited[i][j] = true;
        path.addpend(ch);
        dfs(grid, isVisited, row, col, i+1, j, 'd');
        dfs(grid, isVisited, row, col, i-1, j, 'u');
        dfs(grid, isVisited, row, col+1, i, j, 'l'); 
        dfs(grid, isVisited, row, col-1, i, j, 'r');
        path.append('x');
    }
}

/**
 * 给岛做标记, 返回 srrxdxxx 因为会回去
 *   s   s   r
 *   1   1   1
 *   0   1   0
 *       d
 *   
 * 
 *  return srrdxxxx
 *   s   r   r
 *   1   1   1
 *   0   0   1
 *           d
 */