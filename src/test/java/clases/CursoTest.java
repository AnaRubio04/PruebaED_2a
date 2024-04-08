package clases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {
Curso c;
    @BeforeEach
    void setUp() {
        c=new Curso("DAM");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNombre() {
        assertEquals("DAM",c.getNombre());
    }

    @Test
    void testToString() {
        c.aniadirAlumno(new Persona(12345678));
        c.aniadirAlumno(new Persona(12345679));
        c.aniadirAlumno(new Persona(12345677));
        String s = "--------------------" + c.getNombre() + "-----------------\n";
        s += "NumExp\tNIF\t\tNombre\t\tApellidos\n";
        s += "-------------------------------------------------\n";
        for (Persona listaAlumno : c.getListaAlumnos()) {
            s += listaAlumno + "\n";
        }
        assertEquals(s,c.toString());
    }


}