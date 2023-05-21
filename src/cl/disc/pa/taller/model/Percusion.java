package cl.disc.pa.taller.model;
/**
 * Clase que representa un instrumento de percusión, que es un tipo de instrumento musical.
 * Extiende la clase Instrumento.
 */
public class Percusion extends Instrumento {
    // Tipo de instrumento de percusión
    private String tipoInstrumento;
    // Tipo de percusión
    private String tipoPercusion;
    // Material de construcción del instrumento
    private String materialDeConstruccion;
    // Altura del instrumento de percusión
    private String altura;

    /**
     * Constructor de la clase Percusion.
     *
     * @param codigo                 Código del instrumento.
     * @param precio                 Precio del instrumento.
     * @param stock                  Stock disponible del instrumento.
     * @param tipoInstrumento        Tipo de instrumento de percusión.
     * @param tipoPercusion          Tipo de percusión.
     * @param materialDeConstruccion Material de construcción del instrumento.
     * @param altura                 Altura del instrumento de percusión.
     */
    public Percusion(int codigo, int precio, int stock, String tipoInstrumento, String tipoPercusion, String materialDeConstruccion, String altura) {
        super(codigo, precio, stock);
        this.tipoInstrumento = tipoInstrumento;
        this.tipoPercusion = tipoPercusion;
        this.materialDeConstruccion = materialDeConstruccion;
        this.altura = altura;
    }

    /**
     * Obtiene el tipo de instrumento de percusión.
     *
     * @return Tipo de instrumento de percusión.
     */
    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    /**
     * Obtiene el tipo de percusión del instrumento.
     *
     * @return Tipo de percusión.
     */
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    /**
     * Obtiene el material de construcción del instrumento de percusión.
     *
     * @return Material de construcción del instrumento.
     */
    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    /**
     * Obtiene la altura del instrumento de percusión.
     *
     * @return Altura del instrumento de percusión.
     */
    public String getAltura() {
        return altura;
    }

}