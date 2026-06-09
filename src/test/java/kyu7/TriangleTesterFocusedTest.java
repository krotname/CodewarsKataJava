package kyu7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("unit")
class TriangleTesterFocusedTest {

    @ParameterizedTest
    @CsvSource({
            "3,4,5,true",
            "1,1,1,true",
            "0,1,1,false",
            "1,0,1,false",
            "1,1,0,false",
            "1,2,3,false",
            "1,3,2,false",
            "3,1,2,false",
            "-1,2,2,false"
    })
    void validatesTriangleInequalityAndPositiveSides(int a, int b, int c, boolean expected) {
        assertEquals(expected, TriangleTester.isTriangle(a, b, c));
    }
}
