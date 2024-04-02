package clases;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class NifTest {
    Nif n;
    Nif n2;
    Nif n3;
    @BeforeEach
    void setUp() {
        n=new Nif(18478839);
        n2=new Nif(18478564);
        n3=new Nif(18478839);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        assertEquals("18478839-H", n.toString());
    }

    @Test
    void setNif() {
        n.setNif(58049992);
        assertEquals("16161616-E", n.toString());
    }

    @Test
    void testEquals() {
        assertAll("Iguales",
                ()->assertEquals(false, n.equals(n2)),
                ()->assertEquals(true, n.equals(n3)));
    }
}