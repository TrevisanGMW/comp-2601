package ca.bcit.comp2601.quiz_03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for the class "Name"
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-11-12
 *
 */
class NameTest {
    Name name1;
    Name name2;
    Name name3;

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
        name1 = new Name("tiGer", "wooDs");
        name2 = new Name("AlAn", "TURING");
        name3 = new Name("steve", "WozNIaK");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("Ending a unit test");
        name1 = null;
        name2 = null;
        name3 = null;
    }

    @Test
    void testDefaultConstructor() {
        assertEquals("Tiger Woods", name1.getName());
        assertEquals("Alan Turing", name2.getName());
        assertEquals("Steve Wozniak", name3.getName());

        testBadFirstName(null);
        testBadFirstName("");
        testBadFirstName("   ");
        testBadFirstName("\n");

        testBadLastName(null);
        testBadLastName("");
        testBadLastName("   ");
        testBadLastName("\n");
    }

    @Test
    void testGetName() {
        Name n1;
        n1 = new Name("first", "last");
        assertEquals("First Last", n1.getName());

        assertEquals("Tiger Woods", name1.getName());
        assertEquals("Alan Turing", name2.getName());
        assertEquals("Steve Wozniak", name3.getName());
    }

    /**
     * Method used to help test an overloaded constructor (first, last)
     * @param badFirstName Bad first name, null, blank or empty
     */
    private String testBadFirstName(final String badFirstName) {
        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> new Name(badFirstName, "lastName"));
        return ex.getMessage();
    }

    /**
     * Method used to help test an overloaded constructor (first, last)
     * @param badLastName Bad last name, null, blank or empty
     */
    private String testBadLastName(final String badLastName) {
        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> new Name("firstName", badLastName));
        return ex.getMessage();
    }
}
