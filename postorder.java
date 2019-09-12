// postorder
// class Solution{
//     public void postorder(TreeNode root){
//         if(root == null) return;
//         postorder(root.left);
//         postorder(root.right);
//         //do sth
//     }
// }

class Solution{
    public void postorder(TreeNode root){
        if(root == null) return null;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
}