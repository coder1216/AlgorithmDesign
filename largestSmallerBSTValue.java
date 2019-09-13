/*
                
                        15(root)                19 -> 4(差4)   15(走到15)
                5                    20
            3       14          18       23
                                 
if target = 19
case1 
if cur.val >= target, root = root.left
case2
if cur.val < target, update global_closet if needed, root = root.right

***** 找到小于target的最大值 *****
*/

class Solution{
    public int smallerBSTvalue(TreeNode root, int target){
        if(root == null) throw new IllegalAccessException();

        int closet = Integer.MIN_VALUE;
        while(root != null){
            if(root.val >= target){
                root = root.left;
            }else{
                // 在小于target的情况下找最大的, if 当前root.val大于，就赋值给closet
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
 class Solution{
    public int smallerBSTvalue(TreeNode root, int key){
        if(root == null) throw new IllegalArgumentException();
        int closet = root.val;
        while(root != null){
            if(key <= root.val){
                root = root.left;
            }else{
                // key 大于root.val，找大于里面的最小的
                if(closet < root.val){
                    closet = root.val;
                }
                root = root.right;
            }
        }
        return closet;
    }
}

*/

