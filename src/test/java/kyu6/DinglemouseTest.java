package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class DinglemouseTest {

    @Test
    void shouldDescribeFieldsInSetterOrder() {
        String greeting = new Dinglemouse()
                .setName("Bob")
                .setAge(27)
                .setSex('M')
                .hello();

        assertEquals("Hello. My name is Bob. I am 27. I am male.", greeting);
    }

    @Test
    void repeatedSettersShouldKeepFirstPositionAndLatestValue() {
        String greeting = new Dinglemouse()
                .setAge(12)
                .setName("Alice")
                .setAge(33)
                .hello();

        assertEquals("Hello. I am 33. My name is Alice.", greeting);
    }

    @Test
    void shouldHandleEmptyGreetingAndFemaleSex() {
        assertEquals("Hello.", new Dinglemouse().hello());
        assertEquals("Hello. I am female.", new Dinglemouse().setSex('F').hello());
    }
}
