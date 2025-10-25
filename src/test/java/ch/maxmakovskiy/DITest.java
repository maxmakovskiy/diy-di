package ch.maxmakovskiy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DITest {

    private int addOne(int n) {
        return n + 1;
    }

    @Test
    void alwaysPassingTest() {
        assertEquals(2, addOne(1));
    }
}
