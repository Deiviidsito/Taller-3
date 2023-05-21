package cl.disc.pa.taller.model;
/**
 * Clase que representa un instrumento de cuerda, que es un tipo de instrumento musical.
 * Extiende la clase Instrumento.
 */
public class Cuerda extends Instrumento {
    // Tipo de instrumento de cuerda
    private String tipoInstrumento;
    // Tipo de cuerda utilizada
    private String tipoCuerda;
    // Número de cuerdas del instrumento
    private int numeroCuerda;
    // Material de construcción del instrumento
    private String materialDeConstruccion;
    // Tipo del instrumento de cuerda (acústico, eléctrico, etc.)
    private String tipo;

    /**
     * Constructor de la clase Cuerda.
     *
     * @param codigo                 Código del instrumento.
     * @param precio                 Precio del instrumento.
     * @param stock                  Stock disponible del instrumento.
     * @param tipoInstrumento        Tipo de instrumento de cuerda.
     * @param tipoCuerda             Tipo de cuerda utilizada.
     * @param numeroCuerda           Número de cuerdas del instrumento.
     * @param materialDeConstruccion Material de construcción del instrumento.
     * @param tipo                   Tipo del instrumento de cuerda.
     */
    public Cuerda(int codigo, int precio, int stock, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String materialDeConstruccion, String tipo) {
        super(codigo, precio, stock);
        this.tipoInstrumento = tipoInstrumento;
        this.tipoCuerda = tipoCuerda;
        this.numeroCuerda = numeroCuerda;
        this.materialDeConstruccion = materialDeConstruccion;
        this.tipo = tipo;
    }

    /**
     * Obtiene el tipo de instrumento de cuerda.
     *
     * @return Tipo de instrumento de cuerda.
     */
    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    /**
     * Obtiene el tipo de cuerda utilizada en el instrumento de cuerda.
     *
     * @return Tipo de cuerda utilizada.
     */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    /**
     * Obtiene el número de cuerdas del instrumento de cuerda.
     *
     * @return Número de cuerdas del instrumento.
     */
    public int getNumeroCuerda() {
        return numeroCuerda;
    }

    /**
     * Obtiene el material de construcción del instrumento de cuerda.
     *
     * @return Material de construcción del instrumento.
     */
    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    /**
     * Obtiene el tipo del instrumento de cuerda.
     *
     * @return Tipo del instrumento de cuerda.
     */
    public String getTipo() {
        return tipo;
    }
}