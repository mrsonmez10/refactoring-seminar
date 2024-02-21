package refactoring.content01.before;

import java.time.OffsetDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import refactoring.content01.after.mobile.decor.BirthdayMessageMobileSecureDecor;
import refactoring.content01.after.mobile.impl.WelcomeMessageMobileImpl;
import refactoring.content01.before.model.Channel;
import refactoring.content01.model.Customer;
import refactoring.content01.model.Request;

class WelcomeMessageTest {

	private final String EXPECTED_OUTPUT = "Happy Birthday! get welcome message from cache for mobile James";
	private final Customer customer = Customer.builder()
			.customerNo("242133")
			.surName("Hetfield")
			.name("James")
			.birthDate(OffsetDateTime.now())
			.build();
	private final Request secureMobileRequest = Request.builder()
			.secure(true)
			.channel(Channel.MOBILE)
			.code("XY").rememberMe(true)
			.customer(customer).build();

	@Test
	void testGenerateWelcomeMessage_for_secureMobile_request() {
		WelcomeMessage welcomeMessage = new WelcomeMessage();
		assertEquals(EXPECTED_OUTPUT, welcomeMessage.generateWelcomeMessage(secureMobileRequest));
	}

	@Test
	void testGenerateWelcomeMessageRefactored_for_secureMobile_request() {
		refactoring.content01.after.WelcomeMessage welcomeMessage = new BirthdayMessageMobileSecureDecor(new WelcomeMessageMobileImpl());
		assertEquals(EXPECTED_OUTPUT, welcomeMessage.getWelcomeMessage(secureMobileRequest));
	}
}
