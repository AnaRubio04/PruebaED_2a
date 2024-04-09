/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * @author Ana Rubio
 */
public class Persona implements Comparable<Persona> {

    private Nif nif;
    private String nombre;
    private char genero;
    private LocalDate nacimiento;

    /**
     * Constructor por defecto, inicializa los valores
     */
    public Persona() {
        nif = new Nif();
        nombre = "";
        genero = ' ';
        nacimiento = LocalDate.of(1990, 1, 1);
    }

    /**
     * Constructor que recibe el número de Dni y crea una persona con esos datos
     * @param nif Número de Nif de la persona
     */
    public Persona(int nif) {
        this();
        this.nif = new Nif(nif);
    }

    /**
     * Constructor que crea una persona con todos los atributos que se han proporcionado
     * @param nif Número de Dni de la persona
     * @param nombre Nombre de la persona
     * @param genero Género de la persona
     * @param dia Día de nacimiento de la persona
     * @param mes Mes de nacimiento de la persona
     * @param ano Año de nacimiento de la persona
     */
    public Persona(int nif, String nombre, char genero,
            int dia, int mes, int ano) {
        this.nif = new Nif(nif);
        this.nombre = nombre;
        this.genero = genero;
        this.nacimiento
                = LocalDate.of(ano, mes, dia);
    }

    /**
     * devuelve el nif de la persona
     *
     * @return nif de la persona
     */
    public Nif getNif() {
        return nif;
    }

    /**
     * Establece el Nif de la persona
     * @param nif nuevo nif de la persona
     */
    public void setNif(Nif nif) {
        this.nif = nif;
    }

    /**
     * devuelve el nombre de la persona
     * @return nombre completo de la `persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona
     * @param nombre nombre nuevo de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * devuelve el género de la persona
     * @return el género de la persona
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Establece un nuevo género para la persona
     * @param genero nuevo género de la persona
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * devuelve la fecha de nacimiento de la persona
     * @return fecha de nacimiento de la persona
     */
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    /**
     * Establece una nueva fecha de nacimiento para la persona
     * @param nacimiento nueva fecha nacimiento de la persona
     */
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     *Calcula la edad de la persona en años, calculado con el año actual restado al año de nacimiento
     *
     * @return la edad de la persona en años
     */
    public int getEdad() {
        return Period.between(nacimiento, LocalDate.now()).getYears();
    }

    /**
     * Devuelve una string encadenada de la información recogida de la persona
     * @return Cadena con la información de la persona
     */
    @Override
    public String toString() {
        if (nombre.split(" ").length > 1) {//Separa el nombre en un array
            return nif + "\t" + nombre.split(" ")[0]
                    + '\t' + nombre.split(" ")[1] + "\t\t" + getEdad();
        } else {//Si solo está el nombre
            return nif + "\t" + nombre + "\t\t\t" + getEdad();
        }
    }

    /**
     *Compara si dos objetos persona son iguales
     *
     * @param a Objeto persona a comparar
     * @return true si son iguales
     * @return false en caso contrario
     */
    public boolean equals(Persona a) {
        if (a == null) {
            return false;
        }
        return a.nif.toString().equals(this.nif.toString());
    }

    /**
     * Sobreescribe el metodo equals para comparar si dos objetos Persona son iguales
     *
     * @param obj Objeto a comparar
     * @return true si los objetos son iguales
     * @return false en caso de ser diferentes o nulos
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;

        return Objects.equals(this.nif, other.nif);
    }

    /**
     * Metodo de comparación para ordenar los objetos Persona según su Nif
     *
     * @param o the object to be compared. La persona con la que se compara
     * @return -1 si esta persona es mayor que la otra
     * @return 0 si son iguales
     * @return 1 si esta persona es mayor
     */
    @Override
    public int compareTo(Persona o) {
        return this.nif.toString().compareTo(o.nif.toString());
    }

}
