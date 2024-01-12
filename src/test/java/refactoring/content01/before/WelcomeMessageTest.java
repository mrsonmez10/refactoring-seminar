package refactoring.content01.before;

import java.time.OffsetDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import refactoring.content01.before.model.Channel;
import refactoring.content01.model.Customer;
import refactoring.content01.model.Request;

class WelcomeMessageTest {

	@Test
	void testGenerateWelcomeMessage_for_secureMobile_request() {
		WelcomeMessage welcomeMessage = new WelcomeMessage();

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

		String expectedOutput = "Happy Birthday! get welcome message from cache for mobile James";
		assertEquals(expectedOutput, welcomeMessage.generateWelcomeMessage(secureMobileRequest));
	}
}
