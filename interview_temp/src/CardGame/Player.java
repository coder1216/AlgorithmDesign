package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int id;
    private final String name;

    private final List<Card> handCard;

    public Player(final int id, final String name) {
        this.id = id;
        this.name = name;
        handCard = new ArrayList<>();
    }

    // 发到牌了
    public boolean getCard(Card card) {
        if (card == null) return false;
        handCard.add(card);
        return true;
    }

    // 出牌
    public Card popCard(int index) {
        if (index < 0 || index >= handCard.size()) return null;

        final Card selectedCard = handCard.get(index);
        handCard.remove(index);
        return selectedCard;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHandCard() {
        return handCard;
    }
}
