package ca.bcit.comp2601.lab02.guilhermetrevisan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPhoneTest {

    private IPhone phone1;
    private IPhone phone2;
    private IPhone phone3;
    private IPhone phone4;

    @BeforeEach
    void setUp() {
        phone1 = new IPhone(5, "Carrier");
        phone2 = new IPhone(10, "Carrier");
        phone3 = new IPhone(16, "Carrier");
        phone4 = new IPhone(20, "Carrier");
    }

    @AfterEach
    void tearDown() {
        phone1 = null;
        phone2 = null;
        phone3 = null;
        phone4 = null;
    }

    @Test
    void testToString() {
        String expected;
        expected = """
                   purpose: talking
                   minutesRemainingPhonePlan: 5.0
                   carrierName: Carrier""";
        assertEquals(expected, phone1.toString());

    }

    @Test
    void testEquals() {
        assertEquals(phone1, phone2);
        assertNotEquals(phone1, phone3);
        assertEquals(phone2, phone4);
    }
}