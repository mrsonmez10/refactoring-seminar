package refactoring.content01.after.mobile;

import refactoring.content01.after.WelcomeMessage;
import refactoring.content01.model.Customer;
import refactoring.content01.model.Request;

public abstract class WelcomeMessageDecoratorSecure implements WelcomeMessage {
	private final WelcomeMessage welcomeMessage;

	protected WelcomeMessageDecoratorSecure (WelcomeMessage welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Override
	public String getWelcomeMessage(Request request) {
		return replaceName(welcomeMessage.getWelcomeMessage(request), request.getCustomer());
	}

	private String replaceName(String welcomeMessage, Customer customer) {
		return welcomeMessage.replace("#NAME#", customer.getName());
	}
}
