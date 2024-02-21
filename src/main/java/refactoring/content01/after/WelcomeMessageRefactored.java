package refactoring.content01.after;

import java.time.OffsetDateTime;
import refactoring.content01.after.mobile.decor.BirthdayMessageMobileSecureDecor;
import refactoring.content01.after.mobile.impl.WelcomeMessageMobileImpl;
import refactoring.content01.before.model.Channel;
import refactoring.content01.model.Customer;
import refactoring.content01.model.Request;

public class WelcomeMessageRefactored {

	public static void main(String[] args) {

		// Mobile Secureside
		Customer customer = Customer.builder()
				.customerNo("242133")
				.surName("Hetfield")
				.name("James")
				.birthDate(OffsetDateTime.now())
				.build();

		Request secureMobileRequest = Request.builder()
				.secure(true)
				.channel(Channel.MOBILE)
				.code("XY").rememberMe(true)
				.customer(customer).build();


		// Decide algorithm like switch case with "RefactorChannel" Enum or if else logic or some pattern..
		WelcomeMessage welcomeMessage = new BirthdayMessageMobileSecureDecor(new WelcomeMessageMobileImpl());
		System.out.println(welcomeMessage.getWelcomeMessage(secureMobileRequest));
	}
}
