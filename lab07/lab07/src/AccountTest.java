import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for the class "Account"
 *
 * TODO:
 * 	Determine if account can become negative
 * 	Determine if an exception should be thrown when subtracting a value higher than the account balance
 * 	Determine if default constructor should be allowed to have a null account number (should it be default?)
 */
class AccountTest {
	Account a1;
	Account a2;
	Account a3;

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
		a1 = new Account();
		a2 = new Account("1234", 1000);
		a3 = new Account("1235", 2000);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Ending a unit test");
		a1 = null;
		a2 = null;
		a3 = null;
	}

	@Test
	void testDefaultConstructor() {
		assertEquals(null, a1.getAccountNumber());
		assertEquals(0, a1.getBalance());
		assertFalse(a1.isActive());
	}

	@Test
	void testOverloadedConstructor() {
		assertEquals("1234", a2.getAccountNumber());
		assertEquals(1000, a2.getBalance());
		assertTrue(a2.isActive());
		assertEquals("1235", a3.getAccountNumber());
		assertEquals(2000, a3.getBalance());
		assertTrue(a3.isActive());

		testOverLoadedConstructorBadAccountNumber(null);
		testOverLoadedConstructorBadAccountNumber("");
		testOverLoadedConstructorBadAccountNumber("");
		testOverLoadedConstructorBadAccountNumber("   ");
		testOverLoadedConstructorBadAccountNumber("\t");
		testOverLoadedConstructorBadAccountNumber("\n");

		testOverLoadedConstructorBadBalance(-1);
		testOverLoadedConstructorBadBalance(-10);
		testOverLoadedConstructorBadBalance(-100);
		testOverLoadedConstructorBadBalance(-1000);
	}

	@Test
	void testAccountNumberGetter(){
		assertEquals(null, a1.getAccountNumber());
		assertEquals("1234", a2.getAccountNumber());
		assertEquals("1235", a3.getAccountNumber());
	}

	@Test
	void testBalanceGetter(){
		assertEquals(0, a1.getBalance());
		assertEquals(1000, a2.getBalance());
		assertEquals(2000, a3.getBalance());
	}

	@Test
	void testActiveGetter(){
		assertFalse(a1.isActive());
		assertTrue(a2.isActive());
		assertTrue(a3.isActive());
	}

	@Test
	void testBalanceSetter(){
		assertEquals(0, a1.getBalance());
		a1.setBalance(100);
		assertEquals(100, a1.getBalance());

		assertEquals(1000, a2.getBalance());
		a2.setBalance(500);
		assertEquals(500, a2.getBalance());

		testSetBalanceBadValue(-1, a1);
		testSetBalanceBadValue(-100, a2);
	}

	@Test
	void testActiveSetter(){
		a1.setActive(true);
		a1.setActive(false);
		a1.setActive(false);

		assertTrue(a1.isActive());
		assertFalse(a2.isActive());
		assertFalse(a3.isActive());
	}

	@Test
	void testAddBalance(){
		assertEquals(1000, a2.getBalance());
		a2.addToBalance(200);
		assertEquals(1200, a2.getBalance());
		a2.addToBalance(1000);
		assertEquals(2200, a2.getBalance());

		testSetAddBalanceBadValue(0, a2);
		testSetAddBalanceBadValue(-10, a2);
		testSetAddBalanceBadValue(-10000, a2);
	}

	@Test
	void testSubtractBalance(){
		assertEquals(1000, a2.getBalance());
		a2.subtractFromBalance(200);
		assertEquals(800, a2.getBalance());
		a2.subtractFromBalance(1000);
		assertEquals(800, a2.getBalance()); // Stays the same, as it's unable to make balance negative

		testSubtractBalanceBadValue(0, a2);
		testSubtractBalanceBadValue(-10, a2);
		testSubtractBalanceBadValue(-10000, a2);
	}

	@Test
	void testToString(){
		assertEquals("Account [accountNumber=1234, balance=1000.0, active=true]", a2.toString());
		assertEquals("Account [accountNumber=1235, balance=2000.0, active=true]", a3.toString());
	}

	/**
	 * Method used to help test an overloaded constructor (accountNumber, balance)
	 * Expects IllegalArgumentException if given an invalid account number argument
	 * @param subtractValue value to test (if negative it should throw IllegalArgumentException)
	 * @param account account to test
	 */
	void testSubtractBalanceBadValue(final double subtractValue, final Account account) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> account.subtractFromBalance(subtractValue));
	}

	/**
	 * Method used to help test an overloaded constructor (accountNumber, balance)
	 * Expects IllegalArgumentException if given an invalid account number argument
	 * @param addValue value to test (if negative it should throw IllegalArgumentException)
	 * @param account account to test
	 */
	void testSetAddBalanceBadValue(final double addValue, final Account account) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> account.addToBalance(addValue));
	}

	/**
	 * Method used to help test an overloaded constructor (accountNumber, balance)
	 * Expects IllegalArgumentException if given an invalid account number argument
	 * @param balance value to test (if negative it should throw IllegalArgumentException)
	 * @param account account to test
	 */
	void testSetBalanceBadValue(final double balance, final Account account) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> account.setBalance(balance));
	}

	/**
	 * Method used to help test an overloaded constructor (accountNumber, balance)
	 * Expects IllegalArgumentException if given an invalid account number argument
	 * @param accountNumber value to test (if null or empty it should throw a IllegalArgumentException)
	 */
	void testOverLoadedConstructorBadAccountNumber(final String accountNumber) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> new Account(accountNumber, 1000));
	}

	/**
	 * Method used to help test an overloaded constructor (accountNumber, balance)
	 * Expects IllegalArgumentException if given an invalid initial balance argument
	 * @param balance balance to test (cannot be negative)
	 */
	void testOverLoadedConstructorBadBalance(final double balance) {
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> new Account("1234", balance));
	}

}
