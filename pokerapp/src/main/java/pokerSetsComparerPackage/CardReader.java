package pokerSetsComparerPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pokerSetsComparerPackage.Enums.Suit;
import pokerSetsComparerPackage.Enums.Value;

public class CardReader {
	private List<Hand> hands = new ArrayList<Hand>();
	private List<Hand> handsOne = new ArrayList<Hand>();
	private String[] cards;
	
	public void loadFile() {
		try {
			String line = "";
			BufferedReader cardReader = new BufferedReader(new InputStreamReader(CardReader.class.getResourceAsStream("poker.txt")));
			while((line = cardReader.readLine()) != null) {
				List<Card> handRead = new ArrayList<Card>();
				List<Card> handReadOne = new ArrayList<Card>();
				cards = line.split(" ");
				for(int i = 0; i < 5; i++) {
					handRead.add(new Card(getSuit(cards[i].substring(1, 2)), getValue(cards[i].substring(0,1))));
					handReadOne.add(new Card(getSuit(cards[i+5].substring(1, 2)), getValue(cards[i+5].substring(0,1))));
				}
				hands.add(new Hand(handRead));
				handsOne.add(new Hand(handReadOne));
			}
			cardReader.close();
		} catch (Exception excteption) {
			excteption.printStackTrace();
		}
	}
	
	public List<Hand> getHands() {
		return hands;
	}
	
	public List<Hand> getHandsOne() {
		return handsOne;
	}
	
	private Value getValue(String inputChar) {
		return Value.fromString(inputChar);
	}

	private Suit getSuit(String inputChar) {
		return Suit.fromString(inputChar);
	}
}
