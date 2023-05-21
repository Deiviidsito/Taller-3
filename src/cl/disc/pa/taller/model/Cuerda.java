package cl.disc.pa.taller.model;

public class Cuerda extends Instrumento{
    private String tipoInstrumento;
    private String tipoCuerda;
    private int numeroCuerda;
    private String materialDeConstruccion;
    private String tipo;

    public Cuerda(int codigo, int precio, int stock, String tipoInstrumento, String tipoCuerda, int numeroCuerda, String materialDeConstruccion, String tipo) {
        super(codigo, precio, stock);
        this.tipoInstrumento = tipoInstrumento;
        this.tipoCuerda = tipoCuerda;
        this.numeroCuerda = numeroCuerda;
        this.materialDeConstruccion = materialDeConstruccion;
        this.tipo = tipo;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getTipoCuerda() {
        return tipoCuerda;
    }

    public void setTipoCuerda(String tipoCuerda) {
        this.tipoCuerda = tipoCuerda;
    }

    public int getNumeroCuerda() {
        return numeroCuerda;
    }

    public void setNumeroCuerda(int numeroCuerda) {
        this.numeroCuerda = numeroCuerda;
    }

    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    public void setMaterialDeConstruccion(String materialDeConstruccion) {
        this.materialDeConstruccion = materialDeConstruccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
