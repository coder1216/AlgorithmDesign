package ReadBook;

import org.jetbrains.annotations.NotNull;

public class Person {
    private final String name;
    private final String id;

    public Person(@NotNull final String name, @NotNull final String id) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String read(Readable readable) {
        return readable.getContent();
    }
}
