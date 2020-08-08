package FileSystem;

import java.io.File;
import java.util.List;

public class Directory extends FileSystem{
    private List<FileSystem> contents;

    public boolean deleteFile(FileSystem files) {
        return this.contents.remove(files);
    }

    public void addFile(FileSystem file) {
        this.contents.add(file);
    }

    public int numberOfFiles() {
        int cnt = 0;
        for (FileSystem f : this.contents) {
            if (f instanceof File) {
                cnt++;
            } else if (f instanceof Directory) {
                cnt += ((Directory) f).numberOfFiles() + 1;
            }
        }
        return cnt;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public String getFullPath() {
        return null;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
