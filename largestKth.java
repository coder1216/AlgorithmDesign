import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * largest Kth element
 * 放到minHeap里 小于target的圈poll出来最后剩下的是kth大的，再把剩下的poll出来得到结果
 */

// sol1
class Solution{
    public int largestK(int[] array, int k){
        if(array == null || array.length < 2) throw new IllegalArgumentException();
        Queue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        for(int i = 0; i < array.length; i++){
            if(minHeap.size() < k){ // heap里留下的都是大的，小的都要被poll出来，求第k大的，所以小于k的都poll出来
                minHeap.offer(array[k]);
            }else if(minHeap.peek() < array[k]){ // minhep，小的都poll出来，只保留从第k个开始，往后的
                minHeap.poll(); 
                minHeap.offer(array[k]);
            }
        }
        return minHeap.peek(); // 把第k个poll出来
    }
}

// lambda
class Solution{
    public int largestK(int[] array, int k){
        if(array == null || array.length < k) throw new IllegalArgumentException();
        Queue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for(int i = 0; i < array.length; i++){
            if(minHeap.size() < k){
                minHeap.offer(array[i]);
            }else if(minHeap.peek() < array[i]){
                minHeap.poll();
                minHeap.offer(array[i]);
            }
        }
        return minHeap.peek();
    }
}