package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class GenerationOfBracketSequencesTest {

    @Test
    void shouldGenerateBaseCases() {
        assertIterableEquals(List.of(), GenerationOfBracketSequences.generate(-1));
        assertIterableEquals(List.of(""), GenerationOfBracketSequences.generate(0));
        assertIterableEquals(List.of("()"), GenerationOfBracketSequences.generate(1));
    }

    @Test
    void shouldGenerateCatalanSetForThreePairs() {
        List<String> generated = GenerationOfBracketSequences.generate(3);

        assertEquals(5, generated.size());
        assertTrue(generated.containsAll(List.of("((()))", "(()())", "(())()", "()(())", "()()()")));
    }

    @Test
    void shouldNotShareStateBetweenCalls() {
        assertEquals(14, GenerationOfBracketSequences.generate(4).size());
        assertIterableEquals(List.of("()"), GenerationOfBracketSequences.generate(1));
    }
}
