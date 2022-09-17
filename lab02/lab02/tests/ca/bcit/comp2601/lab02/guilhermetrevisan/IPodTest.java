package ca.bcit.comp2601.lab02.guilhermetrevisan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class IPodTest {

    private IPod pod1;
    private IPod pod2;
    private IPod pod3;
    private IPod pod4;

    @BeforeEach
    void setUp() {
        pod1 = new IPod(5, 130);
        pod2 = new IPod(6, 140);
        pod3 = new IPod(5, 150);
        pod4 = new IPod(5, 160);
    }

    @AfterEach
    void tearDown() {
        pod1 = null;
        pod2 = null;
        pod3 = null;
        pod4 = null;
    }

    @Test
    void testToString() {
        String expected;
        expected = """
                   purpose: music
                   numStoredSongs: 5
                   maxVolumeDecibels: 130.0""";
        assertEquals(expected, pod1.toString());
    }

    @Test
    void testEquals() {
        assertNotEquals(pod1, pod2);
        assertEquals(pod1, pod3);
        assertEquals(pod1, pod4);
    }
}