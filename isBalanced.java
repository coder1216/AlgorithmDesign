/*
Definition of a binary tree
public class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) { val = x; }
}

*/

// class Soltuion{
//     public boolean isBalanced(TreeNode root){
//         return maxDepth(root) != null;
//     }

//     private Integer maxDepth(TreeNode root){
//         if(root == null) return null;

//         Integer leftMax = maxDepth(root.left);
//         Integer righMax = maxDepth(root.right);

//         if(leftMax == null || rightMax == null){
//             return null;
//         }
//         if(Math.abs(leftMax - rightMax) > 1){
//             return null;
//         }

//         return Math.max(leftMax, rightMax) + 1;
//     }
// }

class Solution{
    public boolean isBalenced(TreeNode root){
        return maxDepth(root) != null;
    }

    private Integer maxDepth(TreeNode root){
        if(root == null) return null;

        Integer leftMax = maxDepth(root.left);
        Integer rightMax = maxDepth(root.right);

        if(leftMax == null || rightMax == null){
            return null;
        }
        if(Math.abs(leftMax - rightMax) > 1){
            return null;
        }
        return Math.max(leftMax, rightMax) + 1;
    } 
}