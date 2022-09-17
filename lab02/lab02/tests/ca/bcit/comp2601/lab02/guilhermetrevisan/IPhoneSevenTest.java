package ca.bcit.comp2601.lab02.guilhermetrevisan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPhoneSevenTest {

    private IPhoneSeven phoneSeven1;
    private IPhoneSeven phoneSeven2;
    private IPhoneSeven phoneSeven3;
    private IPhoneSeven phoneSeven4;

    @BeforeEach
    void setUp() {
        phoneSeven1 = new IPhoneSeven(5,"Carrier", true, 256);
        phoneSeven2 = new IPhoneSeven(16,"Carrier", true, 256);
        phoneSeven3 = new IPhoneSeven(8,"Carrier", false, 256);
        phoneSeven4 = new IPhoneSeven(8,"Carrier", true, 256);
    }

    @AfterEach
    void tearDown() {
        phoneSeven1 = null;
        phoneSeven2 = null;
        phoneSeven3 = null;
        phoneSeven4 = null;
    }

    @Test
    void testToString() {
        String expected;
        expected = """
                   purpose: talking
                   minutesRemainingPhonePlan: 5.0
                   carrierName: Carrier
                   hasHighResCamera: true
                   memoryGb: 256""";
        assertEquals(expected, phoneSeven1.toString());
    }

    @Test
    void testEquals() {
        assertNotEquals(phoneSeven1, phoneSeven2); // Using IPhone difference (double threshold)
        assertNotEquals(phoneSeven2, phoneSeven3); // No highResCamera
        assertEquals(phoneSeven1, phoneSeven4);

    }
}