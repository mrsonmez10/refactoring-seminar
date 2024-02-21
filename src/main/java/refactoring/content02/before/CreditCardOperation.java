package refactoring.content02.before;

public class CreditCardOperation implements Operation {

	@Override
	public String directReply() {
		return "directReply";
	}

	@Override
	public String postbackReply() {
		return "postbackReply";
	}

	@Override
	public String flowReply() {
		return null;
	}
}
