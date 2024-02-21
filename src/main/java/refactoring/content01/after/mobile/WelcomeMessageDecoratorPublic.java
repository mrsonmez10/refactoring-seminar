package refactoring.content01.after.mobile;

import refactoring.content01.after.WelcomeMessage;
import refactoring.content01.model.Request;

public abstract class WelcomeMessageDecoratorPublic implements WelcomeMessage {
	private final WelcomeMessage welcomeMessage;

	protected WelcomeMessageDecoratorPublic(WelcomeMessage welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Override
	public String getWelcomeMessage(Request request) {
		return welcomeMessage.getWelcomeMessage(request);
	}
}
