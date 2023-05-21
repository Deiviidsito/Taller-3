package cl.disc.pa.taller.services;

public interface SistemaBeatTheRhythm {


    /**
     * Agrega un nuevo instrumento al sistema.
     *
     * @return true si el instrumento fue agregado correctamente, false en caso contrario.
     */
    boolean agregarInstrumento();

    /**
     * Guarda la lista de instrumentos en un archivo CSV.
     */
    void guardarListaInstrumentosEnCSV();

    /**
     * Realiza la venta de un instrumento.
     *
     * @return true si la venta fue realizada correctamente, false en caso contrario.
     */
    boolean venderInstrumento();

    /**
     * Consulta el inventario de instrumentos disponibles.
     *
     * @return true si la consulta fue exitosa, false en caso contrario.
     */
    boolean consultarInventario();

    /**
     * Cierra la sesión activa en el sistema.
     *
     * @return true si se cerró la sesión correctamente, false en caso contrario.
     */
    boolean cerrarSesion();

}

