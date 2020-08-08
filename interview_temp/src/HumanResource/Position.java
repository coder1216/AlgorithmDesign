package HumanResource;

public enum Position {
    CEO("CEO", 3),
    TEACHER("TEACHER", 2),
    STUDENT("STEDUNT", 1);

    final String type;
    final int level;

    Position(String type, int level) {
        this.level = level;
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }
}
