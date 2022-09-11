package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getYear() {
    }

    @Test
    void getMonth() {
    }

    @Test
    void getDay() {
    }

    @Test
    void getYyyyMmDd() {
    }

    @Test
    void getDayOfTheWeek() {
        // YYYY-MM-DD - EXPECTED
        // 2021-03-15 - Monday
        Date date = new Date(2021, 3, 15);

        String expectedMessage = "Monday";
        String actualMessage = date.getDayOfTheWeek();

        assertEquals(actualMessage, expectedMessage);

        // 1977-10-31 - Monday
        date = new Date(1977, 10, 31);

        expectedMessage = "Monday";
        actualMessage = date.getDayOfTheWeek();

        assertEquals(actualMessage, expectedMessage);

        // 2020-01-08 - Wednesday
        date = new Date(2020, 1, 8);

        expectedMessage = "Wednesday";
        actualMessage = date.getDayOfTheWeek();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void isLeapYear() {
        // 2020 - True
        Date date = new Date(2020, 1, 1);
        boolean actualResult = date.isLeapYear(2020);
        assertTrue(actualResult);
    }
}