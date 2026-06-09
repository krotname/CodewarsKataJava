package kyu7;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Tag;
import net.jqwik.api.constraints.NumericChars;
import net.jqwik.api.constraints.StringLength;

import static kyu7.ValidatePin.validatePin;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("property")
class ValidatePinPropertyTest {

    @Property
    void shouldMatchLengthRuleForNumericOnlyStrings(@ForAll @NumericChars @StringLength(min = 1, max = 20) String pin) {
        boolean shouldBeValid = pin.length() == 4 || pin.length() == 6;
        assertEquals(shouldBeValid, validatePin(pin));
    }
}
