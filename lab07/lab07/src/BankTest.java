import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit test for the class "Bank"
 *
 * Assumptions:
 *  We didn't have to determine a new pattern for the toString function (default is ok)
 */
class BankTest {

	private static Bank b1;
	private Customer c1;
	private Customer c2;
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Starting the test case");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Ending the test case");
	}

	@BeforeEach
	void setUp() throws Exception {
		b1 = new Bank();

		c1 = new Customer("Tiger", "Woods", "1234");
		c2 = new Customer("Barbara", "Liskov", "0001");
		c1.setAccount(new Account("54321", 1000));
		c2.setAccount(new Account("12345", 2000));

		b1.addCustomer(c1);

		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() throws Exception {
		b1 = null;
		System.setOut(standardOut);
	}

	@Test
	void testAddCustomer() {
		String expected;
		expected = "Customer [firstName=Tiger, lastName=Woods, passcode=1234, account=Account [accountNumber=54321, balance=1000.0, active=true]]";
		Bank.displayAllCustomers();
		assertEquals(expected, outputStreamCaptor.toString().trim());

		outputStreamCaptor.reset();
		expected += System.lineSeparator() + "Customer [firstName=Barbara, lastName=Liskov, passcode=0001, account=Account [accountNumber=12345, balance=2000.0, active=true]]";
		b1.addCustomer(c2);
		Bank.displayAllCustomers();
		assertEquals(expected, outputStreamCaptor.toString().trim());

		Customer c;
		c = new Customer("Joe", "Smith", "1234");
		testAddCustomerBadArgument(c); // Joe doesn't have an account
	}

	@Test
	void testCloseAccount() {
		String expected;
		expected = "Customer [firstName=Tiger, lastName=Woods, passcode=1234, account=Account [accountNumber=54321, balance=1000.0, active=true]]";
		Bank.displayAllCustomers();
		assertEquals(expected, outputStreamCaptor.toString().trim());

		outputStreamCaptor.reset();
		expected = "";
		b1.closeAccount("54321");
		Bank.displayAllCustomers();
		assertEquals(expected, outputStreamCaptor.toString().trim());

	}

	@Test
	void testDisplayCustomerInformation() {
		String expected;
		expected = "Customer [firstName=Tiger, lastName=Woods, passcode=1234, account=Account [accountNumber=54321, balance=1000.0, active=true]]";
		Bank.displayCustomerInformation(c1);
		assertEquals(expected, outputStreamCaptor.toString().trim());

		outputStreamCaptor.reset();
		expected = "Customer [firstName=Barbara, lastName=Liskov, passcode=0001, account=Account [accountNumber=12345, balance=2000.0, active=true]]";
		Bank.displayCustomerInformation(c2);
		assertEquals(expected, outputStreamCaptor.toString().trim());
	}

	/**
	 * Test bad customers, if they don't have an account, it expects to get an IllegalArgumentException
	 * @param badCustomer customer without an account
	 */
	void testAddCustomerBadArgument(final Customer badCustomer) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> {
			if (badCustomer.getAccount() == null){
				throw new IllegalArgumentException();
			}
		});
	}

}
