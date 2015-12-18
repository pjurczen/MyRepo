package pokerSetsComparerPackage;

import java.util.*;

import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandFlushHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandFourOfAKindHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandFullHouseHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandHighCardHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandOnePairHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandPokerHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandRequest;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandStraightHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandThreeOfAKindHandler;
import pokerSetsComparerPackage.ChainOfResponsibility.Hand.HandTwoPairsHandler;
import pokerSetsComparerPackage.Enums.PokerSets;
import pokerSetsComparerPackage.Enums.Value;


public class Hand {
	private List<Card> cards;
	private List<Integer> cardsPattern;
	private List<Value> cardsValues;
	private HandTemplate handTemplate;
	
	public Hand(List<Card> hand) {
		this.cards = hand;
		handTemplate = new HandTemplate(cards);
	}
	
	public List<Value> getCardsValuesInHand() {
		return cardsValues;
	}
	
	public PokerSets getOldestSetInHand() {
		cardsPattern = handTemplate.getCardsPattern();
		cards = handTemplate.getSortedCards();
		cardsValues = handTemplate.getCardsValues();

		HandRequest request = new HandRequest(cards, cardsPattern);
		
		HandHandler chainEnd = new HandHighCardHandler();
		HandHandler chainSeven = new HandOnePairHandler(chainEnd);
		HandHandler chainSix = new HandTwoPairsHandler(chainSeven);
		HandHandler chainFive = new HandThreeOfAKindHandler(chainSix);
		HandHandler chainFour = new HandStraightHandler(chainFive);
		HandHandler chainThree = new HandFlushHandler(chainFour);
		HandHandler chainTwo = new HandFullHouseHandler(chainThree);
		HandHandler chainOne = new HandFourOfAKindHandler(chainTwo);
		HandHandler chainBegin = new HandPokerHandler(chainOne);
		
		chainBegin.handle(request);
		
		return request.getOldestSetInHand();
	}
}