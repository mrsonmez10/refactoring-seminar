package refactoring.content01.before;

import java.time.LocalDate;
import refactoring.content01.before.model.Channel;
import refactoring.content01.model.Customer;
import refactoring.content01.model.Request;

public class WelcomeMessage {

	public String generateWelcomeMessage(Request request) {
		// set welcome message
		String welcomeMessage = "";
		String birthdayMessage = "";

		if(request.isSecure()) { // Secure side
			if (request.getChannel() == Channel.MOBILE) {
				welcomeMessage = replaceName(getWelcomeMessageFromCache(request), request.getCustomer());
			} else {
				welcomeMessage = replaceName(getWelcomeMessageFromCache(request), request.getCustomer());
			}
		} else { // public side
			if (request.getChannel() == Channel.MOBILE && request.isRememberMe()) {
				welcomeMessage = replaceName(getWelcomeMessageFromCache(request), request.getCustomer());
			} else if (request.getChannel() == Channel.MOBILE) {
				welcomeMessage = getWelcomeMessageFromCache(request);
			} else {
				welcomeMessage = getWelcomeMessageFromCache(request);
			}
		}

		birthdayMessage = checkForBirthdayMessage(request);

		if (!birthdayMessage.equalsIgnoreCase("")) {
			welcomeMessage = birthdayMessage + " " + welcomeMessage;
		}

		/*
			- Satırlarca kod...
				- Kredisi var mı?
				- Özel günleri kutla (Zafer, kurban vs bayramlar)
				- kuruma özel tonla implementasyon
		 */

		return welcomeMessage;
	}

	private String getWelcomeMessageFromCache(Request request) {
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

	private String checkForBirthdayMessage(Request request) {
		String birthdayMessage = "";
		LocalDate today = LocalDate.now();
		LocalDate customerBirthdate = request.getCustomer().getBirthDate().toLocalDate();

		if (today.getMonth() == customerBirthdate.getMonth() &&
				today.getDayOfMonth() == customerBirthdate.getDayOfMonth()) {
			birthdayMessage = "Happy Birthday!";
		}
		return birthdayMessage;
	}

	public String replaceName(String welcomeMessage, Customer customer) {
		return welcomeMessage.replace("#NAME#", customer.getName());
	}
}
