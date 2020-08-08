/*
Implement an API to filter the given input files, and return the files satisfied filter conditions. The filter condition can be size filter, suffix filter
Follow up:
What if add more filter filter: filter by creator and creation  date
How to implement filter combination, like filter condition is that the txt file with size 500 or the file created by Tony yesterday.

**
* Given a list of files, filter them according to passed-in filter conditions and filter parameters.
* Return a list of filtered files.
*/

package OODesign.FileFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFilter {
    // single filter condition
    List<File> filter(List<File> files, FilterCondition filterCondition) {
        List<File> res = new ArrayList<>();
        if (files == null || files.size() == 0) return new ArrayList<>();

        for (File file : files) {
            if (filterCondition.filter(file)) {
                res.add(file);
            }
        }
        return res;
    }

    // multi filter conditions
    List<File> filter(List<File> files, FilterTreeNode root) {
        List<File> res = new ArrayList<>();
        if (files == null || files.size() == 0) return new ArrayList<>();

        for (File file : files) {
            if (root.eval(file)) {
                res.add(file);
            }
        }
        return res;
    }
}
