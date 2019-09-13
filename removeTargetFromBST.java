import Cell.TreeNode;

/*
LC 450 Remove target from BST

                            15
                5                       20
        3              10        18             24
                   8       12               23      25
                                                 27

exp 
如果要删掉20， 可以取左边最大的值，18， 也可以取右边最小的值，23，取补20的位置
    
case1, root.val == target
a, if root has both lchild and rchild, find smallest element from right subtree(or find the largest element from left subtree), say x, assign x's value to root, remove x' value from the right subtree by recursion
b, if root has only one child, if has one chuld, replace root with non-null child / parent connect directly to child
c, if root has no child, remove self / root = null;

case2, root.val > target, go to left subtree by recursion
case3, root.val < targte, go to right subtree by recursion

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(logn) O(1)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key == root.val){
            if(root.left != null && root.right != null){
                 //TreeNode temp = findMin(root.right);
                 //root.val = temp.val;
                root.val = findMin(root.right).val;
                root.right = deleteNode(root.right, root.val);
            }else{
                // if root.left == null, root = root.right, 左边为空，把右边补上来
                // if root.right == null, root == root.left，右边为空，把左边补上来
                root = root.left == null ? root.right : root.left;
            }
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
     // recursion 1
        private TreeNode findMin(TreeNode root){
            // the smallest val on BST should on left subtree and should be most left leaf node so we are looking for most left node
            if(root.left == null) return root;
            return findMin(root.left);
        }
    
        // //recursion 2
        // private TreeNode findMin(TreeNode root){
        //     if(root.left != null) return findMin(root.left);
        //     return root;
        // }
    
        // iteration
        // private TreeNode findMin(TreeNode root){
        //     while(root.left != null){
        //         root = root.left;
        //     }
        //     return root;
        // }
}


// class Solution{
//     public TreeNode removeTargetFromBST(TreeNode root, int target){
//         if(root == null) return null;

//             if(root.val == target){
//                 if(root.left != null && root.right != null){
//                     // TreeNode temp = findMin(root.right);
//                     // root.val = temp.val; //必须修改root.val
//                     root.val = findMin(root.right).val; // 找到右边最小的值
//                     root.right = removeTargetFromBST(root.right, root.val); // 把右边最小的补上root，root.right.val一起移上去
//                 }else{
//                     root = root.left == null ? root.right : root.left;
//                 }
//             }
//             else if(root.val > target){
//                 root = removeTargetFromBST(root.left, target);
//             }
//             else{
//                 root = removeTargetFromBST(root.right, target);
//             }
        
//         return root;
//     }
//     //recursion 1
//     private TreeNode findMin(TreeNode root){
//         if(root.left == null){
//             return root;
//         }
//         return findMin(root.left);
//     }
//     //recursion 1
//     private TreeNode findMin(TreeNode){
//         if(root.left != null){
//             return findMin(root.left);
//         }
//         return root;
//     }
//     // iteration
//     private TreeNode findMin(TreeNode root){
//         while(root.left != null){
//             root = root.left;
//         }
//         return root;
//     }
// }


// class Solution{
//     public TreeNode deleteNode(TreeNode root, int key){
//         if(root == null) return null;

//         if(key == root.val){
//             if(root.left != null && root.right != null){
//                 // TreeNode temp = findMin(root.right);
//                 // root.val = temp.val; // root.val must be changed!!
//                 root.val = findMin(root.right).val;
//                 root.right = deleteNode(root.right, root.val);
//             }else{
//                 root = root.left == null ? root.right : root.left;
//             }
//         }else if(key < root.val){
//             root.left = deleteNode(root.left, key);
//         }else{
//             root.right = deleteNode(root.right, key);
//         }
//         return root;
//     }
//     // recursion 1
//     private TreeNode findMin(TreeNode root){
//         // becuase the min of the bst is always on left subtree and we are looking for the most left leaf
//         if(root.left == null){
//             return root;
//         }
//         return findMin(root.left);
//     }
//     // recursion 2
//     private TreeNode findMin(TreeNode root){
//         // becuase the min of the bst is always on left subtree and we are looking for the most left leaf
//         if(root.left != null){
//             return findMin(root.left);
//         }
//         return root;
//     }
//     // Iteration
//     private TreeNode findMin(TreeNode root){
//         while(root.left != null){
//             root = root.left;
//         }
//         return root;
//     }
// }

/*
class Solution{
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(key == root.val){
            if(root.left != null && root.right != null){
                // TreeNode temp = getMin(root.right);
                // root.val = temp.val;
                root.val = getMin(root.right).val;
                root.right = deleteNode(root.right, root.val);
            }else{
                root = root.left == null ? root.right : root.left;
            }
        }else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    // recursion
    private TreeNode getMin(TreeNode root){
        if(root.left != null) return getMin(root.left);
        return root;
        // if(root == null) return root;
        // return getMin(root.left);
    }

    // iteration
    private TreeNode getMin(TreeNode root){
        while(root != null) root = root.left;
        return root;
    }
}
*/