// preorder traverse
// class Solution{
//     public void preorder(TreeNode root){
//         if(root == null) return;
//         //do sth
//         preorder(root.left);
//         preorder(root.right);
//     }
// }

class Solution{
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.left);
    }
}