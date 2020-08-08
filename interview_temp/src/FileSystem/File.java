package FileSystem;

public class File extends FileSystem{
    private String content;
    private int size;

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

    public File(String name, Directory parent, int size) {
        this.name = name;
        this.parent = parent;
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
