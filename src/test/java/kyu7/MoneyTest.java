package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("smoke")
class MoneyTest {

    @ParameterizedTest
    @CsvSource({
            "1000, 0.05, 0.18, 1000, 0",
            "1000, 0.05, 0.18, 1100, 3",
            "1000, 0.01625, 0.18, 1200, 14"
    })
    void shouldCalculateYearsNeededForDesiredPrincipal(
            double principal,
            double interest,
            double tax,
            double desired,
            int expectedYears
    ) {
        assertEquals(expectedYears, Money.calculateYears(principal, interest, tax, desired));
    }
}
