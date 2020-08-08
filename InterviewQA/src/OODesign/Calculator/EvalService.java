package OODesign.Calculator;

public class EvalService {
    private int dfs(ExpressionTreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("error");
        }

        if (root.val != null) return root.val;

        int leftVal = dfs(root.getLeft());
        int rightVal = dfs(root.getRight());

        return root.getOptr().cal(leftVal, rightVal);
    }

    public int eval(ExpressionTreeNode root) {
        return dfs(root);
    }
}
