package OODesign.FileFilter;

public class AndOperator implements FilterTreeOperator{

    @Override
    public boolean eval(boolean left, boolean right) {
        return left && right;
    }
}
