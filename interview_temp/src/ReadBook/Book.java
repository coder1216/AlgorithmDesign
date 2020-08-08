package ReadBook;

public class Book implements Readable{

    public String getEdition() {
        return "A";
    }

    @Override
    public String getContent() {
        return null;
    }
}
