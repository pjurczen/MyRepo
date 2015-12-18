package pokerSetsComparerPackage.UnitTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.*;

import pokerSetsComparerPackage.Card;
import pokerSetsComparerPackage.CardReader;
import pokerSetsComparerPackage.Hand;
import pokerSetsComparerPackage.HandTemplate;
import pokerSetsComparerPackage.HandsComparator;
import pokerSetsComparerPackage.Enums.PokerSets;
import pokerSetsComparerPackage.Enums.Suit;
import pokerSetsComparerPackage.Enums.Value;

public class HandTest {
	private List<Card> cards;
	private List<Card> cardsOne;
	private Hand hand; 
	private Hand handOne; 
	private HandsComparator handsComparer;
	private CardReader cardReader;
	private HandTemplate handTemplate;
	
	@Before
	public void setUp() {
		cards = new ArrayList<Card>();
		cardsOne = new ArrayList<Card>();
		hand = new Hand(cards);
		handOne = new Hand(cardsOne);
		handsComparer = new HandsComparator();
		cardReader = new CardReader();
	}
	
	@Test
	public void handleStoringCardsInHand() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.King));
		cards.add(new Card(Suit.Clubs, Value.Three));
		cards.add(new Card(Suit.Spades, Value.Five));
		//when
		int countCards = cards.size();
		//then
		Assert.assertEquals(5, countCards);
	}
	
	@Test
	public void recognizePair() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Three));
		cards.add(new Card(Suit.Spades, Value.Five));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.OnePair, winningHand);
	}
	
	@Test
	public void recognizeTwoPairs() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Five));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.TwoPairs, winningHand);
	}
	
	@Test
	public void recognizeThreeOfAKind() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Five));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.ThreeOfAKind, winningHand);
	}
	
	@Test
	public void recognizeFullHouse() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Deuce));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.FullHouse, winningHand);
	}
	
	@Test
	public void recognizeFourOfAKind() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Spades, Value.Ace));
		cards.add(new Card(Suit.Spades, Value.Deuce));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.FourOfAKind, winningHand);
	}
	
	@Test
	public void recognizeCleanStraight() {
		//given
		cards.add(new Card(Suit.Spades, Value.Five));
		cards.add(new Card(Suit.Diamonds, Value.Three));
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Six));
		cards.add(new Card(Suit.Clubs, Value.Four));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.Straight, winningHand);
	}
	
	@Test
	public void recognizeStraightFromAceToFive() {
		//given
		cards.add(new Card(Suit.Spades, Value.Five));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Three));
		cards.add(new Card(Suit.Clubs, Value.Four));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.Straight, winningHand);
	}
	
	@Test
	public void recognizeStraightFromTenToAce() {
		//given
		cards.add(new Card(Suit.Spades, Value.King));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Hearths, Value.Queen));
		cards.add(new Card(Suit.Spades, Value.Ten));
		cards.add(new Card(Suit.Clubs, Value.Jack));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.Straight, winningHand);
	}
	
	@Test
	public void recognizePokerFromAceToFive() {
		//given
		cards.add(new Card(Suit.Diamonds, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Four));
		cards.add(new Card(Suit.Diamonds, Value.Five));
		cards.add(new Card(Suit.Diamonds, Value.Three));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.Poker, winningHand);
	}
	
	@Test
	public void recognizeRoyalPoker() {
		//given
		cards.add(new Card(Suit.Diamonds, Value.King));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Queen));
		cards.add(new Card(Suit.Diamonds, Value.Ten));
		cards.add(new Card(Suit.Diamonds, Value.Jack));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.Poker, winningHand);
	}
	
	@Test
	public void recognizeFlush() {
		//given
		cards.add(new Card(Suit.Diamonds, Value.King));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ten));
		cards.add(new Card(Suit.Diamonds, Value.Jack));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.Flush, winningHand);
	}
	
	@Test
	public void recognizeHighestCard() {
		//given
		cards.add(new Card(Suit.Clubs, Value.King));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ten));
		cards.add(new Card(Suit.Diamonds, Value.Jack));
		//when
		PokerSets winningHand = hand.getOldestSetInHand();
		//then
		Assert.assertEquals(PokerSets.HighCard, winningHand);
	}
	
	@Test
	public void compareTwoHands() {
		//given
		cards.add(new Card(Suit.Clubs, Value.King));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Hearths, Value.Deuce));
		cards.add(new Card(Suit.Diamonds, Value.Ten));
		cards.add(new Card(Suit.Diamonds, Value.Jack));
		cardsOne.add(new Card(Suit.Clubs, Value.Deuce));
		cardsOne.add(new Card(Suit.Diamonds, Value.Three));
		cardsOne.add(new Card(Suit.Hearths, Value.Four));
		cardsOne.add(new Card(Suit.Clubs, Value.Five));
		cardsOne.add(new Card(Suit.Clubs, Value.Seven));
		//when
		int winningHand = handsComparer.compare(hand, handOne);
		//then
		Assert.assertEquals(1, winningHand);
	}
	
	@Test
	public void compareTwoHandsAgain() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Deuce));
		cardsOne.add(new Card(Suit.Clubs, Value.Ace));
		cardsOne.add(new Card(Suit.Diamonds, Value.Ace));
		cardsOne.add(new Card(Suit.Hearths, Value.Ace));
		cardsOne.add(new Card(Suit.Clubs, Value.Three));
		cardsOne.add(new Card(Suit.Hearths, Value.Three));
		//when
		int winningHand = handsComparer.compare(hand, handOne);
		//then
		Assert.assertEquals(-1, winningHand);
	}
	
	@Test
	public void solveTextFile() {
		//given
		int handWon = 0;
		int handOneWon = 0;
		cardReader.loadFile();
		List<Hand> hands = cardReader.getHands();
		List<Hand> handsOne = cardReader.getHandsOne();
		//when
		for(int i = 0; i < hands.size(); i++) {
			int winningHand = handsComparer.compare(hands.get(i), handsOne.get(i));
			if(winningHand == 1) {
				handWon++;
			} else if (winningHand == -1) {
				handOneWon++;
			}
		}
		//then
		Assert.assertEquals(376, handWon);
		Assert.assertEquals(624, handOneWon);
	}
	
	@Test
	public void shouldGetCardsPattern() {
		//given
		cards.add(new Card(Suit.Hearths, Value.Ace));
		cards.add(new Card(Suit.Diamonds, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Ace));
		cards.add(new Card(Suit.Clubs, Value.Deuce));
		cards.add(new Card(Suit.Spades, Value.Deuce));
		handTemplate = new HandTemplate(cards);
		//when
		Collection<Integer> cardsPattern = handTemplate.getCardsPattern();
		//then
		Assert.assertEquals(Arrays.asList(3, 2), cardsPattern);
	}
}
