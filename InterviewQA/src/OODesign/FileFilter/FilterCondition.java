package OODesign.FileFilter;

import java.io.File;

public abstract class FilterCondition {
    protected FilterParameter filterParameter;
    public FilterCondition(FilterParameter filterParameter) {
        this.filterParameter = filterParameter;
    }

    abstract boolean filter(File file);
}
