import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class Solution {
    public List<TreeNode> tree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new ArrayList<>();

        while (!stack.isEmpty() && curr != null) {
            if (curr != null) {
                stack.push(curr);
                res.add(curr); // preorder
                curr = curr.left;
            } else {
                TreeNode dummy = stack.pop();
                res.add(dummy); // in order
                dummy = dummy.right;
            }
        }
        return res;
    }
}

class Solution {
    public List<TreeNode> postorder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    res.add(curr);
                    stack.pop();
                }
            } else if (prev == curr.left) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    res.add(curr);
                    stack.pop();
                }
            } else if (prev == curr.right) {
                res.add(curr);
                stack.pop();
            } else {

            }
            prev = curr; // 更新 prev 
        }
        return res;
    } 
}