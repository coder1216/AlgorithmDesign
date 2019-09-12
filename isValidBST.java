/* 
valide BST

• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.

*/

/*

class Solution{
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;

        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper){
        int val = node.val;

        // if left node exist then check it has  
        // correct data or not i.e. left node's data  
        // should be less than root's data
        if(lower != null && val <= lower) return false;

        // if right node exist then check it has  
        // correct data or not i.e. right node's data  
        // should be greater than root's data
        if(upper != null && val >= upper) return false;

        // check recursively for every node.
        if(!helper(root.left, lower, val)) return false;
        if(!helper(root.right, val, upper)) return false;

        return true;
    }
}
*/

class Solution{
    public boolean isValidBST(TreeNode root){
        if(root == null) return true;

        helper(root, low, up);
    }

    private boolean helper(TreeNode root, Integer low, Integer up){
        // if left node exist then check it has  
        // correct data or not i.e. left node's data  
        // should be less than root's data
        if(low != null && root.val <= low) return false;

        // if right node exist then check it has  
        // correct data or not i.e. right node's data  
        // should be greater than root's data
        if(up != null && root.val >= up) return false;

        // check recursively for every node.
        if(!helper(root.left, low, root.val)) return false;
        if(!helper(root.right, root.val, up)) return false;

        return true;
    }
}
