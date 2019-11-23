/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return new String("");
        dfs(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] str = data.split(",");
        Deque<TreeNode> stack = new ArrayDeque<>();
        int num = Integer.valueOf(str[0]);
        TreeNode root = new TreeNode(num);
        TreeNode curr = root;
        stack.push(curr);
        
        for(int i = 1; i < str.length; i++){
            num = Integer.valueOf(str[i]);
            if(num < stack.peek().val){
                curr.left = new TreeNode(num);
                curr = curr.left;
                stack.push(curr);
            }else{
                while(!stack.isEmpty() && num > stack.peek().val){
                    curr = stack.pop();
                }
                curr.right = new TreeNode(num);
                curr = curr.right;
                stack.push(curr);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));