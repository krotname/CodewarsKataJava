package kyu5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("smoke")
class ValidParenthesesTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "()", "(())((()())())", "text(with parentheses)"})
    void shouldAcceptBalancedParentheses(String input) {
        assertTrue(ValidParentheses.validParentheses(input));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {")(", ")(()))", "(", "(()"})
    void shouldRejectUnbalancedParentheses(String input) {
        assertFalse(ValidParentheses.validParentheses(input));
    }
}
