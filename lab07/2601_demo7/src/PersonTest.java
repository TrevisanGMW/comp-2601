import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
	
	Person p;

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
		p = new Person();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Ending a unit test");
		p = null;
	}

	@Test
	void testOverloadedConstructor() {
		
		Person person = new Person("Brady", 3, true);
		assertEquals("Brady", person.getName());
		assertEquals(3, person.getAge());
		assertTrue(person.isHappy());
	}

	@Test
	void testConstructorNameValidation() {

		testOverLoadedConstructorBadName(null);
		testOverLoadedConstructorBadName("");
		testOverLoadedConstructorBadName("   ");
		testOverLoadedConstructorBadName("\t");
		testOverLoadedConstructorBadName("\n");
	}

	void testOverLoadedConstructorBadName(String name) {
		
		IllegalArgumentException ex;
		ex = assertThrows(IllegalArgumentException.class, () -> new Person(name, 3, true));

	}

}
