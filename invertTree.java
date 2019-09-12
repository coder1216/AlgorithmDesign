/*
Definition for a b tree
class TreeNode{
    TreeeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) { val = x;}
}

*/

// from root to bottom and then start from bottom switch leaf left and leaf right

/* class Solution{
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
*/

class Solution{
    public TreeNode invertTree(TreeNode root){
        if(root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // switch nodes from leaf(left, right)
        root.left = right;
        root.right = left;

        return root;
    }
}