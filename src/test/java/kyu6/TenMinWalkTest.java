package kyu6;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("smoke")
class TenMinWalkTest {

    @ParameterizedTest
    @ValueSource(strings = {"nsnsnsnsns", "nsewnsewns", "eeeeewwwww"})
    void shouldAcceptTenMinuteWalkThatReturnsHome(String route) {
        assertTrue(TenMinWalk.isValid(route.toCharArray()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ns", "nsnsnsnsn", "nnnnnsssee", "nsnsnsnsnx"})
    void shouldRejectInvalidWalks(String route) {
        assertFalse(TenMinWalk.isValid(route.toCharArray()));
    }
}
