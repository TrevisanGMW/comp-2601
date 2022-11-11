import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for the class "Customer"
 *
 * @author Guilherme Trevisan and Monika Szucs
 * @version 0.0.1
 * @since 2022-11-07
 *
 * Assumptions:
 * 	Default constructor description states that it sets default values. These were assumed to be "Unknown".
 * 	In order to create more tests, extra validation requirements were added to firstName, lastName and passcode.
 */
class CustomerTest {
	Customer c1;
	Customer c2;
	Customer c3;

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
		System.out.println("Starting a unit test");
		c1 = new Customer();
		c2 = new Customer("tIgeR", "wOOds", "1234");
		c3 = new Customer("bARBara", "lisKOV", "0001");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Ending a unit test");
		c1 = null;
		c2 = null;
		c3 = null;
	}

	@Test
	void testDefaultConstructor() {
		// Default constructor is described as assigning default values to each field
		assertEquals("Unknown", c1.getFirstName());
		assertEquals("Unknown", c1.getLastName());
		assertEquals("0000", c1.getPasscode());
	}

	@Test
	void testOverloadedConstructor() {
		assertEquals("Tiger", c2.getFirstName());
		assertEquals("Woods", c2.getLastName());
		assertEquals("1234", c2.getPasscode());

		assertEquals("Barbara", c3.getFirstName());
		assertEquals("Liskov", c3.getLastName());
		assertEquals("0001", c3.getPasscode());

		testFirstNameBadValue(null);
		testFirstNameBadValue("");
		testFirstNameBadValue("");
		testFirstNameBadValue("   ");
		testFirstNameBadValue("\t");
		testFirstNameBadValue("\n");

		testLastNameBadValue(null);
		testLastNameBadValue("");
		testLastNameBadValue("");
		testLastNameBadValue("   ");
		testLastNameBadValue("\t");
		testLastNameBadValue("\n");
	}

	@Test
	void testGetAccount() {
		Account a;
		Account b;
		a = new Account();
		b = new Account();
		assertEquals(null, c1.getAccount());
		assertEquals(null, c2.getAccount());
		c1.setAccount(a);
		c2.setAccount(b);
		assertEquals(a, c1.getAccount());
		assertEquals(b, c2.getAccount());
	}

	@Test
	void testSetAccount() {
		Account a;
		Account b;
		a = new Account();
		b = new Account();

		c2.setAccount(a);
		c3.setAccount(b);
		assertEquals(a, c2.getAccount());
		assertEquals(b, c3.getAccount());

		c2.setAccount(b);
		c3.setAccount(a);
		assertEquals(b, c2.getAccount());
		assertEquals(a, c3.getAccount());
	}

	@Test
	void testGetFirstName() {
		assertEquals("Unknown", c1.getFirstName());
		assertEquals("Tiger", c2.getFirstName());
		assertEquals("Barbara", c3.getFirstName());
	}

	@Test
	void testSetFirstName() {
		assertEquals("Unknown", c1.getFirstName());
		assertEquals("Tiger", c2.getFirstName());
		assertEquals("Barbara", c3.getFirstName());

		c1.setFirstName("bOb");
		c2.setFirstName("MARY");
		c2.setFirstName("jason");

		assertEquals("Bob", c1.getFirstName());
		assertEquals("Mary", c2.getFirstName());
		assertEquals("Jason", c3.getFirstName());

		testFirstNameBadValue(null);
		testFirstNameBadValue("");
		testFirstNameBadValue("");
		testFirstNameBadValue("   ");
		testFirstNameBadValue("\t");
		testFirstNameBadValue("\n");
	}

	@Test
	void testGetLastName() {
		assertEquals("Unknown", c1.getLastName());
		assertEquals("Woods", c2.getLastName());
		assertEquals("Liskov", c3.getLastName());
	}

	@Test
	void testSetLastName() {
		assertEquals("Unknown", c1.getLastName());
		assertEquals("Woods", c2.getLastName());
		assertEquals("Liskov", c3.getLastName());

		c1.setLastName("smith");
		c2.setLastName("loo");
		c2.setLastName("Brown");

		assertEquals("Smith", c1.getLastName());
		assertEquals("Loo", c2.getLastName());
		assertEquals("Brown", c3.getLastName());

		testLastNameBadValue(null);
		testLastNameBadValue("");
		testLastNameBadValue("");
		testLastNameBadValue("   ");
		testLastNameBadValue("\t");
		testLastNameBadValue("\n");
	}

	@Test
	void testGetPasscode() {
		assertEquals("0000", c1.getPasscode()); // Default constructor assigned default value
		assertEquals("1234", c2.getPasscode());
		assertEquals("0001", c3.getPasscode());
	}

	@Test
	void testSetPasscode() {
		assertEquals("1234", c2.getPasscode());
		assertEquals("0001", c3.getPasscode());
		c2.setPasscode("1235");
		c3.setPasscode("0002");
		assertEquals("1235", c2.getPasscode());
		assertEquals("0002", c3.getPasscode());

		// Cannot be null, empty or different from 4 digits
		testPasscodeBadValue(null);
		testPasscodeBadValue("12345");
		testPasscodeBadValue("123");
		testPasscodeBadValue("");
		testPasscodeBadValue("\n\n\n\n");
	}

	@Test
	void testToString(){
		assertEquals("Customer [firstName=Unknown, lastName=Unknown, passcode=null, account=null]", c1.toString());
		assertEquals("Customer [firstName=Tiger, lastName=Woods, passcode=1234, account=null]", c2.toString());
		assertEquals("Customer [firstName=Barbara, lastName=Liskov, passcode=0001, account=null]", c3.toString());
	}

	/**
	 * Method used to help test an overloaded constructor (firstName, lastName, passcode)
	 * Expects IllegalArgumentException if given an invalid firstName
	 * @param badPasscode value to test, throws IllegalArgumentException if null, not only 4 digits
	 */
	void testPasscodeBadValue(final String badPasscode) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> new Customer("firstName", "lastName", badPasscode));
	}

	/**
	 * Method used to help test an overloaded constructor (firstName, lastName, passcode)
	 * Expects IllegalArgumentException if given an invalid firstName
	 * @param badFirstName value to test (if null, blank or invalid throws IllegalArgumentException)
	 */
	void testFirstNameBadValue(final String badFirstName) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> new Customer(badFirstName, "lastName", "1234"));
	}

	/**
	 * Method used to help test an overloaded constructor (firstName, lastName, passcode)
	 * Expects IllegalArgumentException if given an invalid firstName
	 * @param badLastName value to test (if null, blank or invalid throws IllegalArgumentException)
	 */
	void testLastNameBadValue(final String badLastName) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> new Customer("firstName", badLastName, "1234"));
	}

}
