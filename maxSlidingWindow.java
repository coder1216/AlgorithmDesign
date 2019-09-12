import java.util.ArrayDeque;
import java.util.Deque;

import com.sun.jmx.remote.internal.ArrayQueue;

/* 
max / min sliding window
LC 628

S1:
use queue or two pointers, for every possible position, iterate the elements we can see(inside the window scope) to find the max

S2:
use a maxheap to optimize the process to find max
(n-k+1) * logk

S3:
use descrending deque, the leftmost element is always the max of the current sliding window

step1, compare the left most element's value of the deque with the element on the leftmost index of the sliding
step2, from the right to left of the sliding window, if x > curtail, remove curtail repeatedly, put x int o the sliding window
step3, the leftmost element is the max value of current sliding window

exp
1 8 5 7 6 7 4
_____
8, 5
一开始只有 1 8 5，最大是8 要存一个次大，5， 因为当8消失了，补进来的会小于5，5可能是最大

1 8 5 7 6 7 4
  _____
8, 7
跟新次大，7

1 8 5 7 6 7 4
    _____
最大跟新为7，次大6

1 8 5 7 6 7 4
      _____
注意遇到duplicate， 最大7 次大也要为7，因为后面第一个7消失了会漏掉最大
.
.
.
.
一次类推

dequeue 里面存index!!!!!!
*/

/*
class Solution{
    public int[] maxSlidingWindow(int[] a, int k){
         if(a == null || k <= 0) return new int[0];
         
         int len = a.length;
         int[] res = new int[len - k + 1];
         int index = 0;
         // dequeue 里面存index!!!!!!
         Deque<Integer> q = new ArrayQueue<>();

         for(int i = 0; i < len; i++){
             // remove number out of range k
             while(!q.isEmpty() && q.peek() < i - k + 1){
                 q.poll();
             }
             // remove smaller from q
             while(!q.isEmpty() && a[q.peekLast()] < a[i]){
                 q.pollLast();
             }
             // q contains index ... res contains contend
             q.offer(i);
             if(i >= k - 1){
                 res[index++] = a[q.peek()];
             }
         }
         return res;
    }
}
*/
class Solution{
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums == null || k <= 0){
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            // keep the range of window add one delete one
            // while(!q.isEmpty() && q.peek() == i - k + 1){
            //     q,poll();
            // }
            // For every add operation, there could be only one item that is out of the range for the current window, so instead of while loop, if should suffice
            if(q.isEmpty() && q.peek() == i-k+1){
                q.poll();
            }
            // keep the largest int q
            while(q.isEmpty() && a[q.peekLast()] < a[i]){
                q.pollLast();
            }
            q.offer(i);
            // 把window里的最大值给 res
            // i 从0开始计算，0 ~ k-1正好是size of window, window 满了size 才能开始选最大值
            if(i >= k - 1){
                res[index++] = a[q.peek()];
            }
        }
        return res;
    }
}

