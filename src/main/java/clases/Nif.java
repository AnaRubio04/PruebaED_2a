/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Ana Rubio
 */
public class Nif {

    private int numero;
    private char letra;

    //CONSTANTE: no accesible - compartido por todo - no modificable
   /**
    * Conjunto de caracteres almacenados que contienen las letras asociadas a la division del Dni entre 23
    */
    private static final char[] LETRAS
            = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L',
                'C', 'K', 'E'};


    /**
     *Metodo principal para calcular la letra del dni a partir de los numeros por los que esta compuesto
     *
     * @param numero Número del dni para el que se va a calcular la letra
     * @return la letra del dni calculada
     */
    private static char calcularLetra(int numero) {
        return LETRAS[numero % 23];
    }

    /**
     * Constructor por defecto que no recibe nada e inicializa los parametros
     */
    protected Nif() {
        this.numero = 0;
        this.letra = ' ';
    }

    /**
     * Constructor que recibe el número de dni y calcula su letra automaticamente
     * @param numero Número del Dni
     */
    protected Nif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }

    /**
     *  devuelve la representacion del DNI, en número y letra
     * @return  cadena con el formato número-letra
     */
    @Override
    public String toString() {
        return numero + "-" + letra;
    }

    /**
     * establece un numero nuevo que calcula automaticamente la letra correspondiente al nuevo Nif
     * @param numero nuevo numero de nif que se le asignara
     */
    protected void setNif(int numero) {
        this.numero = numero;
        this.letra = calcularLetra(numero);
    }

    /**
     * Compara dos objetos NIF para comprobar si son iguales, son iguales si tienen mismo número y letra
     * @param obj Objeto que se va a comparar
     * @return true en caso de que los objetos nif sean iguales
     * @return false en caso de que los objetos nif sean diferentes o nulos
     *
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
        final Nif other = (Nif) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return this.letra == other.letra;
    }
}
