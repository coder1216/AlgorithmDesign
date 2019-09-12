/*
part of tree

left == null && right != null  --> true
小树走完了 大树还没有走完 所以是part of the tree

left != null && right == null  --> false
小树走完了 大树还没有走完 不是part of tree
*/

// symatricTree
/*
                 a
             s1      s2
           a   b   b   a
        
        s1.left = s2.right
        s1.right = s2.left

*/
// class Solution{
//     public boolean symatricTree(TreeNode root){
//         if(root == null) return true;

//         helper(root.left, root.right);
//     }
//     private boolean helper(TreeNode node1, TreeNode node2){
//         if(node1 == null && node2 == null){
//             return false;
//         }
//         if(node1 == null || node2 == null){
//             return false;
//         }
//         if(node1.val != node2.val){
//             return false;
//         }
//         if(node1.val == node2.val && helper(node1.left, node2.right) == true && helper(node1.right, node2.left) == true){
//             return true;
//         }
//         return false;
//     }
// }

class Solution{
    public boolean symatricTree(TreeNode root){
        if(root == null) return false;

        helper(root.left, root.right);
    }

    private boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return false;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        if(node1.val == node2.val && helper(node1.left, node2.right) == true && helper(node1.right, node2.left) == true){
            return true;
        }
        return false;
    }
}

