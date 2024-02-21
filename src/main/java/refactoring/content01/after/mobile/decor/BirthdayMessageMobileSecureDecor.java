package refactoring.content01.after.mobile.decor;

import java.time.LocalDate;
import refactoring.content01.after.WelcomeMessage;
import refactoring.content01.after.mobile.WelcomeMessageDecoratorSecure;
import refactoring.content01.model.Request;

public class BirthdayMessageMobileSecureDecor extends WelcomeMessageDecoratorSecure {

	public BirthdayMessageMobileSecureDecor(WelcomeMessage welcomeMessage) {
		super(welcomeMessage);
	}

	@Override
	public String getWelcomeMessage(Request request) {
		return getBirthdayMessage(request) + super.getWelcomeMessage(request);
	}

	private String getBirthdayMessage(Request request) {
		String birthdayMessage = "";
		LocalDate today = LocalDate.now();
		LocalDate customerBirthdate = request.getCustomer().getBirthDate().toLocalDate();

		if (today.getMonth() == customerBirthdate.getMonth() &&
				today.getDayOfMonth() == customerBirthdate.getDayOfMonth()) {
			birthdayMessage = "Happy Birthday! ";
		}
		return birthdayMessage;
	}
}
