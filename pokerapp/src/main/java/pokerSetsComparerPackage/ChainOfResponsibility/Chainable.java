package pokerSetsComparerPackage.ChainOfResponsibility;

public interface Chainable {
	public void setSuccesor(Handler succesor);
	public Handler getSuccesor();
}
