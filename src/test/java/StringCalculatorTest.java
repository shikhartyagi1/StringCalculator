import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tdd.StringCalculator;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator;
    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }
    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }
    @Test
    @DisplayName("Test Empty String")
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

}