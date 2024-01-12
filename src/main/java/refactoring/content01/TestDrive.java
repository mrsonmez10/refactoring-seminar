package refactoring.content01;

import java.time.OffsetDateTime;
import refactoring.content01.after.WelcomeMessageRefactored;
import refactoring.content01.before.WelcomeMessage;
import refactoring.content01.before.model.Channel;
import refactoring.content01.model.Customer;
import refactoring.content01.model.Request;

public class TestDrive {
	// https://www.baeldung.com/java-decorator-pattern

	/*
		Slide'a ekle
			Elbette! Tasarım kalıpları, yazılım tasarımında sıkça kullanılan ve tekrar eden sorunlara yönelik çözümler sunan önceden tanımlanmış bir yaklaşımdır. Bu kalıplar, yazılımın daha esnek, yeniden kullanılabilir ve bakımı daha kolay hale getirilmesine yardımcı olur. Üç tip tasarım kalıbı vardır:
			Yaratımsal Tasarım Kalıpları: Bu kalıplar, nesnelerin nasıl yaratılacağına ve oluşturulacağına yönelik sorunları ele alır. Bu kalıplar, nesnelerin yaratılmasını, sınıfların yaratılmasını ve nesne yaratımını temelde birbirinden ayırmaya yarayan bir arayüz kullanarak nesne yaratım işlevlerini birbirinden ayırmaya yardımcı olur. Örnekler arasında Fabrika Tasarım Kalıbı yer alır 1.
			Yapısal Tasarım Kalıpları: Bu kalıplar, nesnelerin nasıl bir arada kullanılacağına ve birbirleriyle nasıl ilişkilendirileceğine yönelik sorunları ele alır. Bu kalıplar, nesnelerin bir arada kullanılmasını ve birbirleriyle ilişkilendirilmesini kolaylaştırmaya yardımcı olur. Örnekler arasında Dekoratör Tasarım Kalıbı yer alır 1.
			Davranışsal Tasarım Kalıpları: Bu kalıplar, nesnelerin nasıl birbirleriyle etkileşime gireceğine ve nasıl birbirleriyle iletişim kuracaklarına yönelik sorunları ele alır. Bu kalıplar, nesnelerin birbirleriyle etkileşimini ve iletişimini kolaylaştırmaya yardımcı olur. Örnekler arasında Komut Tasarım Kalıbı yer alır 1.
	 */

	/*
		* Task: Yeni bir hoş geldin mesajı ekle
	 */

	public static void main(String[] args) {
		// Before
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

		System.out.println(welcomeMessage.generateWelcomeMessage(secureMobileRequest));


		// After
		WelcomeMessageRefactored welcomeMessageRefactored = new WelcomeMessageRefactored();

	}
}
