package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandHighCardHandler extends HandHandler {

	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		handRequest.setOldestSetInHand(PokerSets.HighCard);
	}
}

