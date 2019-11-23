// a - b - c
import java.util.*;
public class Solution {
    static private class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
   private static class Queue{
        Node front;
        Node end;
        int size;
        int capacity;
        public Queue(int size){
            this.size = size;
            front = end = null;
            capacity = 10;
        }
        public int peek(){
            if(size == 0) throw new IllegalArgumentException();
            return end.val;
        }
        public void offer(int val){
            Node curr = new Node(val);
            if(size > capacity) return;
            if(end == null){
                front = end = curr;
                return;
            }
            end.next = curr;
            end = end.next;
            size++;
        }
        public int poll(){
            if(size == 0) throw new IllegalArgumentException();
            Node curr = front;
            front = front.next;
            size --;
            return curr.val;
        }
    }
     public static void main(String[] args){
       // Queue queue = new Queue(10);
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
     }
}