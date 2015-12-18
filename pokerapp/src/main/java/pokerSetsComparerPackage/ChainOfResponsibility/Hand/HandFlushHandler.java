package pokerSetsComparerPackage.ChainOfResponsibility.Hand;

import pokerSetsComparerPackage.ChainOfResponsibility.Handler;
import pokerSetsComparerPackage.ChainOfResponsibility.Request;
import pokerSetsComparerPackage.Enums.PokerSets;

public class HandFlushHandler extends HandComplexHandler {

	public HandFlushHandler(Handler succesor) {
		this.succesor = succesor;
	}
	
	@Override
	public void handle(Request request) {
		handRequest = (HandRequest)request;
		if(isOneColor()) {
			handRequest.setOldestSetInHand(PokerSets.Flush);
		} else {
			forward(request);
		}
	}

}
