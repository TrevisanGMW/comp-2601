package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    Date d1;
    Date d2;

    @BeforeEach
    void setUp() {
        d1 = new Date(1989, 5, 15);
        d2 = new Date(2022, 1, 8);
    }

    @AfterEach
    void tearDown() {
        d1 = null;
        d2 = null;
    }

    @Test
    void getYear() {
        assertEquals(1989, d1.getYear());
        assertEquals(2022, d2.getYear());
    }

    @Test
    void getMonth() {
        assertEquals(5, d1.getMonth());
        assertEquals(1, d2.getMonth());
    }

    @Test
    void getDay() {
        assertEquals(15, d1.getDay());
        assertEquals(8, d2.getDay());
    }

    @Test
    void getYyyyMmDd() {
        assertEquals("1989-05-15", d1.getYyyyMmDd());
        assertEquals("2022-01-08", d2.getYyyyMmDd());
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

        actualResult = date.isLeapYear(2023);
        assertFalse(actualResult);

    }
}