package cl.disc.pa.taller.model;

/**
 * Clase padre que representa un instrumento.
 */
public class Instrumento {
    //codigo del instrumento
    private int codigo;
    //precio del instrumento
    private int precio;
    //stock del instrumento
    private int stock;

    /**
     * Constructor de la clase Instrumento.
     *
     * @param codigo Código del instrumento.
     * @param precio Precio del instrumento.
     * @param stock  Stock disponible del instrumento.
     */
    public Instrumento(int codigo, int precio, int stock) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el código del instrumento.
     *
     * @return Código del instrumento.
     */
    public int getCodigo() {
        return codigo;
    }

    /***
     * Obtiene el precio del instrumento.
     *
     * @return Precio del instrumento.
     */

    public int getPrecio() {
        return precio;
    }

    /**
     * Obtiene el stock disponible del instrumento.
     *
     * @return Stock disponible del instrumento.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Obtiene el nombre del instrumento.
     *
     * @return Nombre del instrumento.
     */
    public String getInstrumento() {
        return null;
    }

    /**
     * Obtiene el tipo de instrumento.
     *
     * @return Tipo de instrumento.
     */
    public String getTipoInstrumento() {
        return getTipoInstrumento();
    }
}
