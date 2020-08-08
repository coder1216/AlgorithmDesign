package OODesign.FileFilter;

import java.io.File;

public class FilterBySize extends FilterCondition {

    public FilterBySize(FilterParameter filterParameter) {
        super(filterParameter);
    }

    @Override
    boolean filter(File file) {
        return file.length() == this.filterParameter.getSize();
    }
}
