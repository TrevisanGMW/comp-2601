import static org.junit.jupiter.api.Assertions.*;

import ca.bcit.comp2601.assignment02.Date;
import ca.bcit.comp2601.assignment02.IllegalPersonException;
import ca.bcit.comp2601.assignment02.Name;
import ca.bcit.comp2601.assignment02.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test for the class "Person"
 * Dependencies used from assignment 01: Person, Orderable, Name, Date, IllegalPersonException
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-30
 *
 */
class PersonTest {
    Person p1;
    Person p2;
    static Date VALID_DATE_A;
    static Date VALID_DATE_B;
    static Name VALID_NAME_A;
    static Name VALID_NAME_B;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Starting the test case");
        VALID_DATE_A = new Date(30, 12, 1975);
        VALID_DATE_B = new Date(15, 5, 1989);
        VALID_NAME_A = new Name("tiGer", "woODs");
        VALID_NAME_B = new Name("eLon", "MusK");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Ending the test case");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Starting a unit test");
        p1 = new Person(VALID_DATE_A, VALID_NAME_A);
        p2 = new Person(VALID_DATE_B, VALID_NAME_B);
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("Ending a unit test");
        p1 = null;
        p2 = null;
    }

    @Test
    void testConstructor() {
        assertEquals("Tiger Woods", p1.getName().getPrettyName());
        assertEquals("1975-12-30", p1.getDateOfBirth().toString());
        assertEquals("Elon Musk", p2.getName().getPrettyName());
        assertEquals("1989-05-15", p2.getDateOfBirth().toString());

        assertEquals("invalid name", testNameBadValue(null));
        assertEquals("invalid date of birth", testBornBadValue(null));
    }

    @Test
    void testIsAlive() {
        assertEquals(true, p1.isAlive());
        p1.die(VALID_DATE_B);
        assertEquals(false, p1.isAlive());
    }

    @Test
    void testDateOfBirthGetter() {
        assertEquals(VALID_DATE_A, p1.getDateOfBirth());
        assertEquals(VALID_DATE_B, p2.getDateOfBirth());
        assertEquals("1975-12-30", p1.getDateOfBirth().getYyyyMmDd());
        assertEquals("1989-05-15", p2.getDateOfBirth().getYyyyMmDd());
    }

    @Test
    void testDateOfDeathGetter() {
        assertEquals(null, p1.getDateOfDeath());
        assertEquals(null, p2.getDateOfDeath());
        p1.die(VALID_DATE_B);
        p2.die(VALID_DATE_B);
        assertEquals(VALID_DATE_B, p1.getDateOfDeath());
        assertEquals(VALID_DATE_B, p2.getDateOfDeath());
        assertEquals("1989-05-15", p1.getDateOfDeath().getYyyyMmDd());
        assertEquals("1989-05-15", p2.getDateOfDeath().getYyyyMmDd());
    }

    @Test
    void tesDie(){
        assertEquals(null, p1.getDateOfDeath());
        p1.die(VALID_DATE_B);
        assertEquals(VALID_DATE_B, p1.getDateOfDeath());
        assertEquals("1989-05-15", p1.getDateOfDeath().getYyyyMmDd());
        assertEquals("Invalid date of death", testDieBadValue(null));
    }

    @Test
    void testNameGetter(){
        assertEquals(VALID_NAME_A, p1.getName());
        assertEquals(VALID_NAME_A.getPrettyName(), p1.getName().getPrettyName());
        assertEquals(VALID_NAME_B, p2.getName());
        assertEquals(VALID_NAME_B.getPrettyName(), p2.getName().getPrettyName());
    }

    @Test
    void testCompareTo(){
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(1, p2.compareTo(p1));
        assertEquals(0, p1.compareTo(p1));
        assertEquals(0, p2.compareTo(p2));
    }

    @Test
    void testToString(){
        assertEquals("Tiger Woods was born 1975-12-30 and is still alive", p1.toString());
        p1.die(VALID_DATE_B);
        assertEquals("Tiger Woods was born 1975-12-30 and died 1989-05-15", p1.toString());
        assertEquals("Elon Musk was born 1989-05-15 and is still alive", p2.toString());
        p2.die(VALID_DATE_B);
        assertEquals("Elon Musk was born 1989-05-15 and died 1989-05-15", p2.toString());
    }

    /**
     * Method used to help test constructor (born, name)
     * Expects IllegalArgumentException if born date is null
     * @param badBorn value to test (if null IllegalPersonException)
     */
    String testBornBadValue(final Date badBorn) {
        IllegalPersonException ex;
        ex = assertThrows(IllegalPersonException.class, () -> new Person(badBorn, VALID_NAME_A));
        return ex.getMessage();
    }

    /**
     * Method used to help test constructor (born, name)
     * Expects IllegalArgumentException if name is null
     * @param badName value to test (if null IllegalPersonException)
     */
    String testNameBadValue(final Name badName) {
        IllegalPersonException ex;
        ex = assertThrows(IllegalPersonException.class, () -> new Person(VALID_DATE_A, badName));
        return ex.getMessage();
    }

    /**
     * Method used to help test constructor (born, name)
     * Expects IllegalArgumentException if name is null
     * @param badDate value to test (if null IllegalPersonException)
     */
    String testDieBadValue(final Date badDate) {
        IllegalPersonException ex;
        ex = assertThrows(IllegalPersonException.class, () -> {
            Person p;
            p = new Person(VALID_DATE_A, VALID_NAME_A);
            p.die(badDate);
        });
        return ex.getMessage();
    }
}