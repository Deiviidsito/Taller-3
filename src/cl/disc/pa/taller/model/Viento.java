package cl.disc.pa.taller.model;

public class Viento extends Instrumento{
    private String tipoInstrumento;
    private String materialDeConstruccion;

    public Viento(int codigo, int precio, int stock, String tipoInstrumento, String materialDeConstruccion) {
        super(codigo, precio, stock);
        this.tipoInstrumento = tipoInstrumento;
        this.materialDeConstruccion = materialDeConstruccion;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    public void setMaterialDeConstruccion(String materialDeConstruccion) {
        this.materialDeConstruccion = materialDeConstruccion;
    }
}
