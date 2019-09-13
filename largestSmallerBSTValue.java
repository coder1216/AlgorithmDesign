/*
                
                        15(root)                19 -> 4(差4)   15(走到15)
                5                    20
            3       14          18       23
                                 
if target = 19
case1 
if cur.val >= target, root = root.left
case2
if cur.val < target, update global_closet if needed, root = root.right

找到小于target的最大值
*/

class Solution{
    public int smallerBSTvalue(TreeNode root, int target){
        if(root == null) throw new IllegalAccessException();

        int closet = Integer.MIN_VALUE;
        while(root != null){
            if(root.val >= target){
                root = root.left;
            }else{
                if(closet < root.val){
                    closet = root.val;
                }
                root = root.right;
            }
        }
        return closet;
    }
}

/*
 



*/