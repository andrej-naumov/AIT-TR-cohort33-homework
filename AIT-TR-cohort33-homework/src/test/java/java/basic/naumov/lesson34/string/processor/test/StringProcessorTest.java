package java.basic.naumov.lesson34.string.processor.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import basic.naumov.lesson34.string.processor.StringProcessorPlus;

public class StringProcessorTest {

    private StringProcessorPlus stringProcessor;

    @BeforeEach
    public void setUp() {
        stringProcessor = new StringProcessorPlus();
    }

    @Test
    public void testConcatenate() {
        String result = stringProcessor.concatenate("Привет, ", "мир!");
        assertEquals("Привет, мир!", result);
    }

    @Test
    public void testGetLength() {
        int length = stringProcessor.getLength("Hello");
        assertEquals(5, length);
    }

    @Test
    public void testReverse() {
        String reversed = stringProcessor.reverse("Java");
        assertEquals("avaJ", reversed);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringProcessor.isPalindrome("А роза упала на лапу Азора"));
        assertFalse(stringProcessor.isPalindrome("Привет"));
    }
}

