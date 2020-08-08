package CardGame;
import java.util.*;

public class Game {
    private final List<Player> players;
    private final Deck deck;
    private final String id;

    public Game(final String id) {
        this.id = id;
        players = new ArrayList<>();
        deck = new Deck();
    }

    public boolean init() {
        if (players.size() <= 1) return false;

        deck.init();
        deck.shuffle();

        while (deck.getSize() > 0) {
            for (Player player : players) {
                player.getCard(deck.dealCard());
            }
        }
        return true;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int index) {
        if (index < 0 || index >= players.size()) return null;

        return players.get(index);
    }

    public boolean isOver() {
        for (Player player : players) {
            if (player.getHandCard().size() == 0) {
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }
}
