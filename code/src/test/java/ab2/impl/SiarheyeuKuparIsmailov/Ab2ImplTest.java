package ab2.impl.SiarheyeuKuparIsmailov;

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

    @Test
    void binary() {
        int[] a = {1,2,3,4,5};
        assertEquals(0, Ab2Impl.binary(a, 1, 0, a.length+1));
        assertEquals(1, Ab2Impl.binary(a, 2, 0, a.length+1));
        assertEquals(2, Ab2Impl.binary(a, 3, 0, a.length+1));
    }
}