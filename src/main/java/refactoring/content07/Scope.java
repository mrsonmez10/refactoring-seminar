package refactoring.content07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scope {
	public final List<String> customerAccounts = new ArrayList<>();

	public void getCustomer(String customerNo) {
		String customerInfo = customerNo+generateRandomChar();
		customerAccounts.add(customerInfo);
	}

	private char generateRandomChar() {
		Random random = new Random();
		// ASCII range for printable characters: 32 to 126
		return (char) (random.nextInt(95) + 32);
	}
}
