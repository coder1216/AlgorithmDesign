/*
Definition of a binary tree:

public class TreeNode{
    TreeNode left;
    TreNode right;
    int val;
    TreeNode(int x){ val = x;}
}
*/


class Solution{
    public int maxDepth(TreeNode root){
        // cc
        if(root == null) return 0;
        
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.rigth);

        return Math.max(leftMax, rightMax) + 1;
    }
}

