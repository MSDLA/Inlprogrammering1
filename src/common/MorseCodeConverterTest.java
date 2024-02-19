package common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class MorseCodeConverterTest {
    @Test
    public void testTextToMorse() {
        assertEquals(".- -... / -.-. -..", MorseCodeConverter.textToMorse("AB CD"));
    }

    @Test
    public void testMorseToText() {
        assertEquals("AB CD", MorseCodeConverter.morseToText(".- -... / -.-. -.."));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> MorseCodeConverter.textToMorse("AB$CD"));
        assertThrows(IllegalArgumentException.class, () -> MorseCodeConverter.morseToText(".- -... / -.-. $"));
    }
}
