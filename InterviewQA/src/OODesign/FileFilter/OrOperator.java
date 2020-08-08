package OODesign.FileFilter;

public class OrOperator implements FilterTreeOperator{
    @Override
    public boolean eval(boolean left, boolean right) {
        return left || right;
    }
}
