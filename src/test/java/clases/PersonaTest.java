package clases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    Persona p1;
    Persona p2;
    Persona p3;
    Nif n,d;
    @BeforeEach
    void setUp() {
        p1 =new Persona(18478839,"Ana",'M',21,07,2004);
        p2 =new Persona(16161616,"Ana Rubio",'M',21,07,2004);
        p3 =new Persona(18478839);//only nif
        d=new Nif(18478839);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNif() {
        assertEquals(n=new Nif(18478839), p1.getNif());
    }

    @Test
    void setNif() {
        assertEquals(n=new Nif(16161616), p2.getNif());
    }

    @Test
    void getNombre() {
        assertAll("Get Nombre",
                ()->assertEquals("Ana", p1.getNombre()),
                ()->assertEquals("Ana Rubio", p2.getNombre()));
    }

    @Test
    void setNombre() {
        p1.setNombre("Meili");
        p2.setNombre("Uxue Calvo");
        assertAll("Set Nombre",
                ()->assertEquals("Meili", p1.getNombre()),
                        ()->assertEquals("Uxue Calvo", p2.getNombre()));
    }

    @Test
    void getGenero() {
        assertAll("Genero",
                ()->assertEquals('M', p2.getGenero()),
                        ()->assertEquals('M', p1.getGenero()));
    }

    @Test
    void setGenero() {
        p1.setGenero('H');
        assertEquals('H', p1.getGenero());
    }

    @Test
    void getNacimiento() {
        assertEquals(LocalDate.of(2004,07,21), p1.getNacimiento());
    }

    @Test
    void setNacimiento() {
        p1.setNacimiento(LocalDate.of(2000,06,22));
         assertEquals(LocalDate.of(2000,06,22), p1.getNacimiento());
    }

    @Test
    void getEdad() {
        assertEquals(19, p1.getEdad());
    }

    @Test
    void testToString() {
        assertAll("To String",
                ()->assertEquals("18478839-H\tAna\t\t\t19", p1.toString()),
                ()->assertEquals("16161616-E\tAna\tRubio\t\t19", p2.toString()));
    }

    @Test
    void testEquals() {
        assertAll("Equals",
                ()->assertEquals(false, p1.equals(p2)),
                ()->assertEquals(true, p1.equals(p3)));
    }

    @Test
    void testEquals1() {
        assertAll("Equals",
                ()->assertEquals(false, p1.equals(p2)),
                ()->assertEquals(true, p1.equals(p3)),
                ()->assertEquals(false, p1.equals(d)));
    }

    @Test
    void compareTo() {
        assertAll("compareTo",
                ()-> assertEquals(2, p1.compareTo(p2)),
                ()->assertEquals(0, p1.compareTo(p3)));
    }
}