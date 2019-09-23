// OOD I
// step1: find nouns and verbs
// step2: classes
// step3: relationship
// step4: for Class, fields & methods
// step5: public private → outside

// Q1 Design a generic deck of cards
// Step1: Deck Cards
// Step2: Deck Card
// Step3: Deck contains	List<Card> cards / Card[] cards
// Step4: 
// 	enum Suit
// 	class Card:	value(int), suit(Enum: Suit)
// 			constructor to set value & suit
// 			get value or suit
// 	class Deck:	ArrayList<Card> cards / Card[]
// 			constructor to create object → new ArrayList<Card>()
// 			shuffle(); deal();

// Object object = new Object(); 
// general? 		concrete class
// enum, interface, class
// Suit suit

// c0, c1, c2 …c40.. c51
// p0, p1, p2

// random(k) [0, k) → random.nextInt(k)

// public enum Suit {
// 	CLUB, ♣️
// DIAMOND, ♦️
// 	HEART, ♥️
// 	SPADE ♠️
// }

// Suit.values() 

public class Card { // ORM
	private final int value;
	private final Suit suit;

	public Card(int val, Suit suit){ // constructor
		// c c
	value = val;
	this.suit = suit;
}
public int getCardVal() { // Lombok
return value;
}
public Suit getCardSuit(){
return suit;
}
}

public class Deck{ 
	// fields
	prviate ArrayList<Card> cards;

	// methods
	public Deck() {
		cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				cards.add(new Card(i, suit));
			}
		}
	}
	
	public void shuffle(){
		for (int i = 0; i < cards.size(); i++) { // you can do it from cards.size() - 1 to 0
		int j = random.nextInt(cards.size() - i) + i;
		Card card1 = cards.get(i);
		Card card2 = cards.get(j);
		cards.set(i, card2);
		cards.set(j, card1);
	}
	}

public Card deal() {	
	return cards.remove(cards.size() - 1);
}

public List<Card> deal(int num) {
	for (int i = 0; i < num; i++) {
		deal();
	}
}
}

//Extension 1: extend design to player Hand
// class Hand:	int id;
// 		ArrayList<Card> handCards
// 		constructor → handCards + id
// 		addCard() 	addCards()	→ Overloading
// 		removeCard()

public class Hand {
	private/protected final int id;
	private List<Card> handCards;
	
	public Hand(int id) {
		this.id = id;
		handCards = new ArrayList<>();
}

public void addCard(Card card) {
	// corner case
	handCards.add(card);
}
}
public void addCard(List<Card> cards) { //List better than ArrayList Universal
	// corner case
	for (Card card: cards) {
		addCard(card);
}

public Card removeCard(int i) {
	if (handCards.size() == 0 || i > handCards.size()) return null;
	return handCards.remove(i);
}	
}

// Extension 2: extend design to BlackJack
// BlackJack Rule:
// 2 ~ 10 score as it's value
// J,Q,K  score 10
// A         score either 1 or 11

// option 1: BlackJackCard extends Card
// option 2: BlackJackHand extends Hand

Class BlackJackHand: Hand
			score()
			isBursted()
			is21()
			isBJ()

class BlackJackHand extends Hand {
	public BlackJackHand(int id) {
	super(id);
	// this.id = id;
}

	public int score() {
	if (handCards.size() == 0) return 0;
	int sum = 0;
	for (Card c : handCards) { // 2 4 A 3 7
		int val = c.getValue();
	if (val > 1 && val <= 10) {
	sum +=val;
} else if (val == 11 || val == 12 || val == 13) {  // J Q K
	sum += 10;
} else {  // A what if multiple A  Wrong
	if (sum > 10) sum += 1;
	else sum += 11;
}
}
return sum;
}
	public int score() {
		int res = 0, val, aceCount = 0;
		for (Card card : cards) {
			val = card.getVal();
			if (val >= 2 && val <= 10) res += card.getVal();
if (val >= 11 && val <= 13) res += 10;
if (val == 1) aceCount++;
		}
		for (int i = aceCount; i > 0; i--) {
			if (res + 11 * i + aceCount - i <= 21)
				return res + 11 * i + aceCount - i;
		}
		return res + aceCount;
	}
public boolean isBursted() {
	return score() > 21;
}
public boolean is21() {
	return score() == 21;
}
public boolean isBJ() {
	return is21() && handCards.size() == 2;
}
}

//Extension 3: extend to runnalbe aplication
class Game {
	main() {
		new Deck;
		new List<BlackJackHand> list;

		deck.shuffle();

		while() {
			for … list
				cards = deck.deal();
				handCards.addCard(cards);

			for … list
				score hand.score();
				...
		}
	}
}

//Extension 4: extend to Texas Holder
