import java.util.ArrayDeque;
import java.util.Deque;

import Cell.TreeNode;

/**
 * time O(n)
 * space O(h) 
 * 
 */
public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}

 class Solution{
     public boolean twoSum(TreeNode root, int target){
         // cc
         Deque<TreeNode> left = new ArrayDeque<>();
         Deque<TreeNode> right = new ArrayDeque<>();

         while(!left.isEmpty() && !right.isEmpty()){
             if(left.peek() == right.peek()){
                 break;
             }
             TreeNode topLeft = left.peek();
             TreeNode topRight = right.peek();
             if(topLeft.val + topRight.val == target){
                 return true;
             }else if(topLeft.val + topRight.val < target){
                TreeNoe node = left.pop();
                TreeNode curr = node.right;
                while(curr != null){
                    left.push(curr);
                    curr = curr.left;
                }
             }else{
                 TreeNode node = right.pop();
                 TreeNode curr = node.left;
                 while(curr != null){
                     right.push(curr);
                     curr = curr.right;
                 }
             }
         }
         return false;
     }
 }