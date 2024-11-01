package Lesson_14_testng;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static Lesson_14_testng.Factorial.factorial;
import static org.testng.Assert.assertThrows;
public class TestFactorial {
    @org.junit.Test
    public void testFactorial_Positive_Number() {
        int number = 5;
        long expected = 120;
        long actual = factorial(number);
        org.testng.Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorial_Zero() {
        int number = 0;
        long expected = 1;
        long actual = factorial(number);
        org.testng.Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorial_One() {
        int number = 1;
        long expected = 1;
        long actual = factorial(number);
        org.testng.Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorial_Negative_Number() {
        int number = -5;
        assertThrows(IllegalArgumentException.class, () -> factorial(number));
    }

    @Test
    public void testFactorial_Large_Number() {
        int number = 20;
        long actual = factorial(number);
        Assertions.assertTrue(actual >= 2432902008176640000L && actual <= 2432902008176640001L);
    }
}

