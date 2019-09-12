// inorder traverse
// class Solution{
//     public void inorder(TreeNode root){
//         if(root == null) return;
//         inorder(root.left);
//         // do sth
//         inorder(root.right);
//         
//     }
// }

class Solution{
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
        
    }
}