import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 * Kth Smallest Number In Sorted Matrix
[
  [1,   4,  5, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

 * 
 *  已经sorted的 matrix
 * 
 * 
 * 
 */
public class Element {
    int value;
    int x;
    int y;
    public Element(int value, int x, int y) {
    this.value = value;
    this.x = x;
    this.y = y;
        }
    }
// 进来1个 poll 出去 2个
class Solution{
    public int Kth(int[][] matrix, int k){
        if(matrix == null || matrix.length < k || matrix[0].length < k) throw new IllegalArgumentException();
        boolean[][] visited = new boolean [maxtrix.length][matrix[0].length];
        Queue<Integer> minHeap = new PriorityQueue<>(k, Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return a - b; //不推荐 会越界
                if(a == b) return 0;
                return a < b ? 1 : -1;
            }
        });
        for(int i = 0; i < k - 1; i++){
            Element ele = minHeap.poll(); // 每次进来2个，下面和右边，比较万后和原有的一个比较，小的被poll出去
            if(ele.y < matrix[0].length && visited[ele.x][ele.y + 1] == false){
                minHeap.offer(new Element(matrix[ele.x][ele.y + 1]));
                visited[ele.x][ele.y] = true;
            }
            if(ele.x < matrix.length && visited[ele.x + 1][ele.y] == false){
                minHeap.offer(matrix[ele.x + 1][ele.y]);
                visited[ele.x + 1][ele.y] = true;
            }
        }
        return minHeap.poll().val;
    } 
}

class Solution{
    public int Kth(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) throw new IllegalArgumentException();
        Queue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        
        for(int i = 0; i < k-1; i++){
            Element ele = minHeap.poll();
            if(ele.y < matrix[0].length && visited[ele.x][ele.y + 1] == false){
                minHeap.offer(new Element(matrix[ele.x][ele.y + 1]));
                visited[ele.x][ele.y + 1] = true;
            }
            if(ele.x < matrix.length && visited[ele.x + 1][ele.y] == false){
                minHeap.offer(new Emement(matrix[ele.x + 1][ele.y]));
                visited[ele.x + 1][ele.y] = true;
            }
        }
        return minHeap.peek().val;
    }
}