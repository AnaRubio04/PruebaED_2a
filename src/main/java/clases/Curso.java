/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.TreeSet;

/**
 *
 * @author Ana Rubio
 */
public class Curso {

    private String nombre;
    private TreeSet<Persona> listaAlumnos;

    protected String getNombre() {
        return nombre;
    }

    /**
     * Constructor que recibe el nombre del curso y crea el TreeSet en donde se guardara la lista de alumnos
     * @param nombre Nombre del Curso
     */
    public Curso(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new TreeSet<>();
    }

    /**
     *
     * @return Lista de alumnos
     */
    public TreeSet<Persona> getListaAlumnos() {
        return listaAlumnos;
    }

    /**
     * Muestra una lista del curso y de los alumnos inscritos en el curso
     * @return String con el nombre del curso y las lista de alumnos
     */
    @Override
    public String toString() {
        String s = "--------------------" + nombre + "-----------------\n";
        s += "NumExp\tNIF\t\tNombre\t\tApellidos\n";
        s += "-------------------------------------------------\n";
        for (Persona listaAlumno : listaAlumnos) {
            s += listaAlumno + "\n";
        }
        return s;
    }

    /**
     * Agrega un objeto Persona a listaAlumnos
     * @param p Objeto Persona
     */
    public void aniadirAlumno(Persona p) {
        listaAlumnos.add(p);
    }
}
