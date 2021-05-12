import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterTest {

    @Test
    void count() {
        var counter = new WordsCounter();
        List<String> lines = Arrays.asList("java helps people", "java is hard to learn", "i ve heard python is ok");
        assertEquals(counter.count(lines, "i"), 1);
        assertEquals(counter.count(lines, "java"), 2);
        assertEquals(counter.count(lines, "Сергей"), 0);
        assertThrows(IllegalArgumentException.class, () -> counter.count(lines, "123"));
        assertThrows(IllegalArgumentException.class, () -> counter.count(lines, null));
        assertThrows(IllegalArgumentException.class, () -> counter.count(null, null));
        assertThrows(IllegalArgumentException.class, () -> counter.count(null, " "));
        assertThrows(IllegalArgumentException.class, () -> counter.count(null, "123"));
    }
}
