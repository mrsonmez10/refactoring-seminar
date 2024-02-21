package refactoring.content02.after;

import refactoring.content02.after.operations.DirectReply;
import refactoring.content02.after.operations.PostbackReply;

public class CreditCardOperationRefactored implements DirectReply, PostbackReply {

	@Override
	public String directReply() {
		return "directReply";
	}

	@Override
	public String postbackReply() {
		return "postbackReply";
	}
}
