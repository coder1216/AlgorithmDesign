package CardGame;
import java.util.*;

public class Deck {
    private int size;
    private final List<Card> cards;

    public Deck() {
        size = 0;
        cards = new ArrayList<>();
    }

    // 发牌
    public void init() {
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(suit, i));
            }
        }
        size = cards.size();
    }

    // 洗牌
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            final int randomIndex = new Random().nextInt(i + 1);
            final Card tempCard = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, tempCard);
        }
    }

    // 发牌的时候 总数量会改变，return 分到每一个人手里的牌
    public Card dealCard() {
        if (size == 0) return null;
        final Card topCard = cards.get(size - 1);
        cards.remove(size - 1);
        size--;
        return topCard;
    }

    public Card peer() {
        if (size == 0) return null;
        return cards.get(size - 1);
    }

    public int getSize() {
        return size;
    }
}
