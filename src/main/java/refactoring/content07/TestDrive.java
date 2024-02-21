package refactoring.content07;

public class TestDrive {

	public static void main(String[] args) {

		Scope scope = new Scope();
		scope.getCustomer("01");

		scope.getCustomer("02");

		for (String customerInfo: scope.customerAccounts) {
			System.out.println(customerInfo);
		}
	}
}

