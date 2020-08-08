package OODesign.Calculator;

public class ExpressionTreeNode {
    public Integer val;
    private SelfOptr optr;
    private ExpressionTreeNode left;
    private ExpressionTreeNode right;

    public ExpressionTreeNode(int val) {
        this.val = val;
        this.optr = null;
        this.left = null;
        this.right = null;
    }

    public ExpressionTreeNode(SelfOptr optr) {
        this.val = null;
        this.optr = optr;
        this.left = null;
        this.right = null;
    }

    public ExpressionTreeNode getRight() {
        return left;
    }

    public Integer getVal() {
        return val;
    }

    public SelfOptr getOptr() {
        return optr;
    }

    public ExpressionTreeNode getLeft() {
        return left;
    }
}
