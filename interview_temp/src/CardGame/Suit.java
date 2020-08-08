package CardGame;

public enum Suit {
    Club("Club", 1),
    Diamond("Diamond", 2),
    Spade("Spade", 3);

    private final String suit;
    private final int value;

    Suit(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }
}
