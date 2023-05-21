package cl.disc.pa.taller.services;


/**
 * Programacion avanzada 2023
 *
 * -------------Alumnos-------------
 *
 * David Alvarez Barraza 21.162.670-4
 * Jonathan Maragaño
 *
 * ------------Profesor-------------
 *
 *         Diego Urrutia Diaz
 *
 * ------------Ayudante--------------
 *
 *       Edgardo Ortiz Gonzales
 *
 */

/**
 * Clase principal main donde se ejecuta el codigo.
 */
public class Main {
    public static void main(String[] args) {
        //Sistema principal .
        SistemaBeatTheRhythmImpl sistema = new SistemaBeatTheRhythmImpl();

        // Inicar Sistema.
        sistema.iniciarSistema();
    }

}