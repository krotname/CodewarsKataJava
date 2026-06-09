package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("smoke")
class LargestFiveDigitNumberTest {

    @ParameterizedTest
    @CsvSource({
            "1234567890, 67890",
            "73167176531330624919225119674426574742355349194934, 96744",
            "11111, 11111",
            "12, 0"
    })
    void shouldFindLargestConsecutiveFiveDigitNumber(String digits, int expected) {
        assertEquals(expected, LargestFiveDigitNumber.solve(digits));
        assertEquals(expected, LargestFiveDigitNumber.solveStream(digits));
    }

    @ParameterizedTest
    @CsvSource({
            "1234567890, 98765",
            "11111, 11111",
            "90901, 99100"
    })
    void shouldFindLargestValueMadeFromAnyFiveDigits(String digits, int expected) {
        assertEquals(expected, LargestFiveDigitNumber.maxValueFrom5Dig(digits));
    }
}
