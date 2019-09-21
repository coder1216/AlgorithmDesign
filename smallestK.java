import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 */
// add all
 class Solution{
     public List<Integer> smallestK(List<Integer> array, int k){
         if(array == null || array.length < k) return array;
         List<Integer> res = new ArrrayList<>();
         Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
             @Override 
             public int compare(Integer a, integer b){
                 return b - a;
                 if(a == b) return 0;
                 return a < b ? -1 : 1; 
             }
         });
         for(int i = 0; i < array.length; i++){
             if(maxHeap.size() < k){
                 maxHeap.offer(array[i]);
             }else if(maxHeap.peek() > array[i]){
                maxHeap.poll();
                maxHeap.offer(array[i]);
             }
         }
         if(!maxHeap.isEmpty()) res.add(maxHeap.poll());
         return res;
     }
 }

 // add one
 /**
  * 用maxheap把大于kth的圈poll出来，留小的都是小的
  */
class Solution{
    public int smallestK(int[] array, int k){
        if(nums == null || nums.length < k) throw new IllegalArgumentException();
        Queue<Integer> maxHeap = new PriorityQueue<>(k, Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        for(int i = 0; i < array.length; i++){ 
            if(maxHeap.size() < k){  
                maxHeap.offer(array[i]);
            }else if(maxHeap.peek() > array[i]){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        return maxHeap.peek();
    }
}

// lambda
class Solution{
    public int smallestK(int[] array, int k){
        if(nums == null || nums.length < k) throw new IllegalArgumentException();
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        
        for(int i = 0; i < array.length; i++){
            if(maxHeap.size() < k){
                maxHeap.offer(array[i]);
            }else if(maxHeap.peek() > array[i]){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        return maxHeap.peek();
    }
}