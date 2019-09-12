/*
Binary search tree

*/

// class Solution{
//     public void BST(TreeNode root, int left, int right){
//         if(root == null) return;

//         if(left < root.val){
//             BST(root.left, left, right);
//         }
//         if(left < root.val && right > root.val) System.out.print(root.val);
//         if(right > root.val){
//             BST(root.right, left, right);
//         }
//     }
// }

class Solution{
    public void BST(TreeNode root, int left, int right){
        if(root == null) return;

        if(left < root.val){
            BST(root.left, left, right);
        }
        if(left< root.val && right > root.val) System.out.print(root.val);
        if(right > root.val){
            BST(root.right, left, right);
        }
    }
}