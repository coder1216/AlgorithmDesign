import Cell.TreeNode;

/*
LC 156
***** LinkedIn Phone Interview ****** 


         1
    2        3
4      5



         4
    5        2
          3     1



        1
    2      3
4 -- 5

time O(logn) space O(1)
*/

class Solution{
    public TreeNode BTUpsideDown(TreeNode root){
        if(root == null) return null;
        if(root.left == null) return root;
        // recursion call 到底 再办事
        TreeNode newNode = BTUpsideDown(root.left);
        root.left.left = root.right;
        root.left.right = root;
        // reverse 之后要把之前的节点断开 例如root，1需要左右断开
        root.left = null;
        root.right = null;
        return newNode;
    }
}
