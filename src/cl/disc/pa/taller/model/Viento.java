package cl.disc.pa.taller.model;

/**
 * Clase que representa un instrumento de viento, que es un tipo de instrumento musical.
 * Extiende la clase Instrumento.
 */
public class Viento extends Instrumento{
    // Tipo de instrumento de viento
    private String tipoInstrumento;
    // Material de construcción del instrumento
    private String materialDeConstruccion;

    /**
     * Constructor de la clase Viento.
     *
     * @param codigo                 Código del instrumento.
     * @param precio                 Precio del instrumento.
     * @param stock                  Stock disponible del instrumento.
     * @param tipoInstrumento        Tipo de instrumento de viento.
     * @param materialDeConstruccion Material de construcción del instrumento.
     */
    public Viento(int codigo, int precio, int stock, String tipoInstrumento, String materialDeConstruccion) {
        super(codigo, precio, stock);
        this.tipoInstrumento = tipoInstrumento;
        this.materialDeConstruccion = materialDeConstruccion;
    }

    /**
     * Obtiene el tipo de instrumento de viento.
     *
     * @return Tipo de instrumento de viento.
     */
    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    /**
     * Obtiene el material de construcción del instrumento de viento.
     *
     * @return Material de construcción del instrumento.
     */
    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

}
