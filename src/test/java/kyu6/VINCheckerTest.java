package kyu6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("smoke")
class VINCheckerTest {

    @ParameterizedTest
    @ValueSource(strings = {"5YJ3E1EA7HF000337", "5YJ3E1EAXHF000347", "5yj3e1ea7hf000337"})
    void shouldAcceptValidVinCodes(String vin) {
        assertTrue(VINChecker.checkVin(vin));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "5YJ3E1EA7HF00033",
            "5YJ3E1EA8HF000337",
            "5YJ3E1IA7HF000337",
            "5YJ3E1OA7HF000337",
            "5YJ3E1QA7HF000337",
            "5YJ3E1*A7HF000337"
    })
    void shouldRejectInvalidVinCodes(String vin) {
        assertFalse(VINChecker.checkVin(vin));
    }

    @Test
    void shouldRejectNullVinCode() {
        assertFalse(VINChecker.checkVin(null));
    }
}
