package FileSystem;

public abstract class FileSystem {
    protected Directory parent;
    protected long createdTime;
    protected long lastedUpdatedTime;
    protected long lastAccessedTime;
    protected String name;

    public abstract boolean delete();

    public abstract int size();

    public abstract String getFullPath();


}

