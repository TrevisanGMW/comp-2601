package ca.bcit.comp2601.lab02.guilhermetrevisan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPadTest {

    private IPad pad1;
    private IPad pad2;
    private IPad pad3;
    private IPad pad4;

    @BeforeEach
    void setUp() {
        pad1 = new IPad(true, "0.0.1");
        pad2 = new IPad(false, "0.0.1");
        pad3 = new IPad(true, "0.0.2");
        pad4 = new IPad(false, "0.0.3");
    }

    @AfterEach
    void tearDown() {
        pad1 = null;
        pad2 = null;
        pad3 = null;
        pad4 = null;
    }

    @Test
    void testToString() {
        String expected;
        expected = """
                   purpose: learning
                   hasCase: true
                   operatingSystemVersion: 0.0.1""";
        assertEquals(expected, pad1.toString());
    }

    @Test
    void testEquals() {
        assertEquals(pad1, pad2);
        assertNotEquals(pad1, pad3);
        assertNotEquals(pad2, pad4);
    }
}