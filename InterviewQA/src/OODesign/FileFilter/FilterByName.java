package OODesign.FileFilter;

import java.io.File;

public class FilterByName extends FilterCondition{
    public FilterByName(FilterParameter filterParameter) {
        super(filterParameter);
    }

    @Override
    boolean filter(File file) {
        return file.getName().equals(this.filterParameter.getName());
    }
}
