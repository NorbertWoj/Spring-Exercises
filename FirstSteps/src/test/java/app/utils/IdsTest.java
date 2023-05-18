package app.utils;

import com.sun.source.doctree.SeeTree;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IdsTest {

    @Test
    public void testEmptySet() {
        Integer result = Ids.getNewId(Collections.emptySet());
            assertEquals(0, result);
    }

    @Test
    public void testGenerateNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);
        int resut = Ids.getNewId(sample);
        assertEquals(7, resut);
    }

}