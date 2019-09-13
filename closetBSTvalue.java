/*

given a non-empty bst and a target value, find the value in the bst that is closet to the target
Given target value is a floating point
You are guaranteed to have only one unique value in the BST that is closet to the target

                            15 (root)               cur      17         18           1
                    5                     20
               3       14            18       23  
    
    Use a global_closet to store the closet diff / value / node (high level wrapper)
    case 1: if cur.value > target, update global_closet if needed, move cur to cur.left
    case 2: if cur.value < target, update global_closet if needed, move cur to cur.right 
    case 3: if cur.value == target, return target



*/

// class Solution{
//     public int closetValue(TreeNode root, int target){
//         if(root == null){
//             throw new IllegalArgumentException();
//             // return 0;
//         }
//         int closet = root.val;
//         while(root != null){
//             if(root.val == target){
//                 return root.val;
//             }
//             if(Math.abs(root.val - target) < Math.abs(closet - target)){
//                 closet = root.val;
//             }
//             if(root.val > target){
//                 root = root.left;
//             }else{
//                 root = root.right;
//             }
//         }
//         return closet;
//     }
// }

// class Solution{
//     public int closetValue(TreeNode root, int target){
//         if(root == null) throw new IllegalArgumentException();

//         int closet = root.val;
//         while(root != null){
//             if(root.val == target){
//                 return root.val;
//             }
//             closet = Math.abs(root.val - target) < Math.abs(closet - target) ? root.val : closet;
//             root = root.val < target ? root.right : root.left;
//         }
//         return closet;
//     }
// }



class Solution{
    public int closetValue(TreeNode root, double target){
        if(root == null) throw new IllegalArgumentException();

        int closet = root.val;
        while(root != null){
            if(root.val == target){
                return root.val;
            }
            if(Math.abs(root.val - target) < Math.abs(closet - target)){
                closet = root.val;
            }
           // closet = Math.abs(root.val - target) < Math.abs(closet - target) ? root.val : closet;
            root = root.val > target ? root.left : root.right;
        }
        return closet;
    }
}


