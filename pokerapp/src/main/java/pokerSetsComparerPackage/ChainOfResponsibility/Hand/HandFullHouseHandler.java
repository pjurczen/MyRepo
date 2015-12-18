package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import java.util.Arrays;
import java.util.List;

import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandFullHouseHandler extends HandHandler {

	private List<Integer> fullHousePattern = Arrays.asList(3,2);
	
	public HandFullHouseHandler(Handler succesor) {
		this.succesor = succesor;
	}
	
	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isFullHouse()) {
			handRequest.setOldestSetInHand(PokerSets.FullHouse);
		} else {
			forward(request);
		}
	}

	private boolean isFullHouse() {
		if(handRequest.getCardsPattern().equals(fullHousePattern)) {
			return true;
		}
		return false;
	}
}
