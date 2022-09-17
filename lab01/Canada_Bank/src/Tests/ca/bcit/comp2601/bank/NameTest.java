package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @BeforeEach
    void setUp() {
        // Nothing
    }

    @AfterEach
    void tearDown() {
        // Nothing
    }

    @Test
    void getFirst()
    {
        Name name = new Name("tigER", "wooDS");
        assertEquals("tigER", name.getFirst());

        name = new Name("eLoN", "MuSk");
        assertEquals("eLoN", name.getFirst());
    }

    @Test
    void getLast() {
        Name name = new Name("tigER", "wooDS");
        assertEquals("wooDS", name.getLast());

        name = new Name("eLoN", "MuSk");
        assertEquals("MuSk", name.getLast());
    }

    @Test
    void getInitials() {
        Name name = new Name("tigER", "wooDS");
        assertEquals("T.W.", name.getInitials());

        name = new Name("eLoN", "MuSk");
        assertEquals("E.M.", name.getInitials());
    }

    @Test
    void getFullName() {
        Name name = new Name("tigER", "wooDS");
        assertEquals("Tiger Woods", name.getFullName());

        name = new Name("eLoN", "MuSk");
        assertEquals("Elon Musk", name.getFullName());
    }

    @Test
    void constructorThrows_withBadArgument() {
        String validFirstName = "tIgEr";
        String validLastName = "wooDS";

        // Test Null First
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(null, validLastName);
        });

        String expectedMessage = "Invalid name";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.startsWith(expectedMessage));
        // Test Null Last
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(validFirstName, null);
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.startsWith(expectedMessage));

        // Test Empty First
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("", validLastName);
        });

        actualMessage = exception.getMessage();

        assertTrue(actualMessage.startsWith(expectedMessage));
        // Test Empty Last
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(validFirstName, "");
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.startsWith(expectedMessage));

        // Test White Spaces First
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("        ", validLastName);
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.startsWith(expectedMessage));
        // Test White Spaces Last
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(validFirstName, "        ");
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.startsWith(expectedMessage));

        // Test Admin in Name First
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("tigerAdmin", validLastName);
        });

        actualMessage = exception.getMessage();

        assertTrue(actualMessage.startsWith(expectedMessage));
        // Test Admin in Name First
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(validFirstName, "adminWooDS");
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.startsWith(expectedMessage));

        // Test Max 45 length limit first
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("ThisIsALongNameWithMoreThanFortyFiveCharacters", validLastName);
        });

        actualMessage = exception.getMessage();

        assertTrue(actualMessage.startsWith(expectedMessage));
        // Test Max 45 length limit last
        exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(validFirstName, "ThisIsALongNameWithMoreThanFortyFiveCharacters");
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.startsWith(expectedMessage));
    }

}