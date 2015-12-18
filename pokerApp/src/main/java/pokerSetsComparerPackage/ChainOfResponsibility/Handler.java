package pokerSetsComparerPackage.ChainOfResponsibility;

public abstract class Handler implements Chainable {
	protected Handler succesor;
	
	public void setSuccesor(Handler succesor) {
		this.succesor = succesor;
	}
	
	public Handler getSuccesor() {
		return succesor;
	}
	
	protected void forward(Request request) {
		if(this.succesor != null) {
			this.getSuccesor().handle(request);
		}
	}
	
	public abstract void handle(Request request);
}
