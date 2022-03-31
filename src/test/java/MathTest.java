import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MathTest {
    @Test
    void mathMin() {
        int loNo = 1;
        int hiNo = 10;

        assertEquals(loNo, Math.min(loNo, hiNo));
        assertNotEquals(hiNo, Math.min(loNo, hiNo));
    }

    @Test
    void mathMax() {
        int loNo = 1;
        int hiNo = 10;

        assertEquals(hiNo, Math.max(loNo, hiNo));
        assertNotEquals(loNo, Math.max(loNo, hiNo));
    }
}
