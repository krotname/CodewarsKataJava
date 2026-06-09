package kyu7;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kyu7.ValidatePin.validatePin;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("smoke")
public class ValidatePinTest {

    @Test
    void shouldHandleCanonicalExamples() {
        assertTrue(validatePin("1234"));
        assertTrue(validatePin("000000"));
        assertFalse(validatePin("12"));
        assertFalse(validatePin("12345"));
        assertFalse(validatePin("abcdef"));
    }

    @Test
    void shouldReturnFalseForNullInput() {
        assertFalse(validatePin(null));
    }

    @Test
    void shouldReturnFalseForLeadingAndTrailingSpaces() {
        assertFalse(validatePin(" 1234"));
        assertFalse(validatePin("1234 "));
        assertFalse(validatePin("  "));
    }

}
