// class Solution{
//     public int closestValue(TreeNode root, double target){
//         if(root == null){
//             throw new IllegalArgumentException();
//         }
//         int val = 0;
//         int closet = root.val;
//         while(root != null){
//             val = root.val;
//             closet = Math.abs(closet - target) < Math.abs(val - target) ? closet : val;
//             root = target < root.val ? root.left : root.right;
//         }
//         return closet;
//     }
// }

// return the number that closet to target 
class Solution{
    public int closestValue(TreeNode root, int target){
        if(root == null){
            throw new IllegalArgumentException();
        }
        int val = 0;
        int closet = root.val;
        
        while(root != null){
            val = root.val;
            closet = Math.abs(val - target) < Math.abs(closet - target) ? val : closet;
            root = target < root.val ? root.left : root.right;
        }
        return closet;
    }

}

// return the closet value
// ??? could be wrong!!!!
/* 
class Solution{
    public int closestValue(TreeNode root, int target){
        if(root == null){
            throw new IllegalArgumentException();
        }
        int val = 0;
        int closet = root.val;

        while(root != null){
            int val = root.val;
            closet = Math.min(Math.abs(target - val), Math.abs(closet - val));
            if(target < root.val){
                root = root.left;
            }else if(target > root.val){
                root = root.right;
            }else{
                return root.val;
            }
        }
        return closet;
    }
} 
*/