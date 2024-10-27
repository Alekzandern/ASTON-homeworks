package Lesson_14_junit_5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    void testFactorial_Positive_Number() {
        int number = 5;
        long expected = 120;
        long actual = Factorial.factorial(number);
        assertEquals(expected, actual);
    }

    @Test
    void testFactorial_Zero() {
        int number = 0;
        long expected = 1;
        long actual = Factorial.factorial(number);
        assertEquals(expected, actual);
    }

    @Test
    void testFactorial_One() {
        int number = 1;
        long expected = 1;
        long actual = Factorial.factorial(number);
        assertEquals(expected, actual);
    }

    @Test
    void testFactorial_Negative_Number() {
        int number = -5;
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(number));
    }

    @Test
    void testFactorial_Large_Number() {
        int number = 20;
        long actual = Factorial.factorial(number);
        assertTrue(actual >= 2432902008176640000L && actual <= 2432902008176640001L);
    }
}