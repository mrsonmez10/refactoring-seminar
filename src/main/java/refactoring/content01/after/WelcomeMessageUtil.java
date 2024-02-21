package refactoring.content01.after;

import refactoring.content01.before.model.Channel;
import refactoring.content01.model.Request;

public final class WelcomeMessageUtil {

	private WelcomeMessageUtil() {

	}

	public static String getWelcomeMessageFromCache(Request request) {
		String welcomeMessage;
		if (request.isSecure()) { // secure side
			if (request.getChannel() == Channel.MOBILE) {
				welcomeMessage = "get welcome message from cache for mobile #NAME#";
			} else {
				welcomeMessage = "get welcome message from cache for internet #NAME#";
			}
		} else { // public side
			if (request.getChannel() == Channel.MOBILE && request.isRememberMe()) {
				welcomeMessage = "get welcome message from cache for mobile #NAME#";
			} else if (request.getChannel() == Channel.MOBILE) {
				welcomeMessage = "get welcome message from cache for mobile";
			}  else {
				welcomeMessage = "get welcome message from cache for internet";
			}
		}
		return welcomeMessage;
	}

}
