package ab2.impl.Siarheyeu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ab2ImplTest {

    @Test
    void quadraticProbing() {
        // see VO 6-16

        int[] m7 = {5,6,4,2,1,0,3};
        for (int j = 0; j < m7.length; j++) {
            int h = Ab2Impl.quadraticProbing(j, 5, m7.length);
            assertEquals(m7[j], h, "j=" + j + " expected " + m7[j] + " but was " +h);
        }

        int[] m8 = {5, 6, 4, 1, 1, 6, 4, 5};
        for (int j = 0; j < m8.length; j++) {
            int h = Ab2Impl.quadraticProbing(j, 5, m8.length);
            assertEquals(m8[j], h, "j=" + j + " expected " + m8[j] + " but was " +h);
        }
    }
}