package pokerSetsComparerPackage.ChainOfResponsibility.Hand;


import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandStraightHandler extends HandComplexHandler {

	public HandStraightHandler(Handler succesor) {
		this.succesor = succesor;
	}
	
	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isSequence()) {
			handRequest.setOldestSetInHand(PokerSets.Straight);
		} else {
			forward(request);
		}
	}
}
