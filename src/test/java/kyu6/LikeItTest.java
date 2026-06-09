package kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class LikeItTest {

    @Test
    void shouldFormatLikeCounterText() {
        assertEquals("no one likes this", LikeIt.whoLikesIt());
        assertEquals("Peter likes this", LikeIt.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", LikeIt.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", LikeIt.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", LikeIt.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}
