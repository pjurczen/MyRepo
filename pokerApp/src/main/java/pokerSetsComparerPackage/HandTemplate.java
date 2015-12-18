package pokerSetsComparerPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import pokerSetsComparerPackage.Enums.Value;;

public class HandTemplate {
	private List<Card> cards;
	private List<Integer> cardsPattern;
	private List<Value> cardsValues;
	private CardComparator cardComparer;
	private ValueComparator valueComparer;
	
	public HandTemplate(List<Card> cards) {
		this.cards = cards;
		cardComparer = new CardComparator();
		valueComparer = new ValueComparator();
		cardsPattern = new ArrayList<Integer>();
		cardsValues = new ArrayList<Value>();
	}
	
	public List<Integer> getCardsPattern() {
		cardsPattern.clear();
		cards.stream().distinct().forEach(card -> cardsPattern.add(Collections.frequency(cards, card)));
		Collections.sort(cardsPattern, Collections.reverseOrder());
		return cardsPattern;
	}
	
	public List<Value> getCardsValues() {
		cardsValues.clear();
		prepareCards();
		cards.forEach(card -> cardsValues.add(card.getValue()));
		cardsValues.forEach(cardValue -> cardValue.frequency = Collections.frequency(cardsValues, cardValue));
		Collections.sort(cardsValues, valueComparer);
		return cardsValues;
	}
	
	public List<Card> getSortedCards() {
		prepareCards();
		return cards;
	}
	
	private void prepareCards() {
		Value.setAceToLow();
		Collections.sort(cards, cardComparer);
		int lastMinusFirst = cards.get(4).getValue().getValueOfValue() - cards.get(0).getValue().getValueOfValue();
		List<Integer> tmpPatterns = getCardsPattern().stream().filter(x -> x > 1).collect(Collectors.toList());
		if(!tmpPatterns.isEmpty() || lastMinusFirst != 4) {
			Value.setAceToHigh();
			Collections.sort(cards, cardComparer);
		}
	}
}
