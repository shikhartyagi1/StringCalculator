import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tdd.StringCalculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("Test One Number")
    public void testAddOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    @DisplayName("Test For Two Number")
    public void testAddTwoNumber() {
        assertEquals(3, stringCalculator.add("1,2"));
    }
    @Test
    @DisplayName("Test Multiple Numbers")
    public void testAddMultipleNumber() {
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }
    @Test
    @DisplayName("Test New Line")
    public void testNewLine() {
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }
    @Test
    @DisplayName("Support different delimiters")
    public void testUsesDelimiterSepcified(){
        assertEquals(3, stringCalculator.add("//;\\n1;2"));
    }

    @Test
    @DisplayName("negatives not allowed")
    public void testThrowsOnNegativeNumber() {
        assertThrows(IllegalArgumentException.class, ()-> {
            stringCalculator.add("-3");
        });
    }

    @Test
    @DisplayName("negatives not allowed with numbers")
    public void testThrowsOnNegativeNumbers() {
        assertThrowsExactly(IllegalArgumentException.class, ()->{
            stringCalculator.add("1,-3,5,-5,-13");
            },"negative number: -3,-5,-13");
    }
    @Test
    @DisplayName("Bigger than 1000 should be ignored")
    public void testNumberBiggerThan1000(){
        assertEquals(2, stringCalculator.add("2,1001"));
    }


}