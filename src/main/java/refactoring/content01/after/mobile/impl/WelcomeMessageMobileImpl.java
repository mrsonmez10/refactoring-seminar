package refactoring.content01.after.mobile.impl;

import refactoring.content01.after.WelcomeMessage;
import refactoring.content01.after.WelcomeMessageUtil;
import refactoring.content01.model.Request;

public class WelcomeMessageMobileImpl implements WelcomeMessage {

	@Override
	public String getWelcomeMessage(Request request) {
		return WelcomeMessageUtil.getWelcomeMessageFromCache(request);
	}
}
