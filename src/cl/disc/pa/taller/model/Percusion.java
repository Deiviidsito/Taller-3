package cl.disc.pa.taller.model;

public class Percusion extends Instrumento{
    private String tipoInstrumento;
    private String tipoPercusion;
    private String materialDeConstruccion;
    private String altura;

    public Percusion(int codigo, int precio, int stock, String tipoInstrumento, String tipoPercusion, String materialDeConstruccion, String altura) {
        super(codigo, precio, stock);
        this.tipoInstrumento = tipoInstrumento;
        this.tipoPercusion = tipoPercusion;
        this.materialDeConstruccion = materialDeConstruccion;
        this.altura = altura;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getTipoPercusion() {
        return tipoPercusion;
    }

    public void setTipoPercusion(String tipoPercusion) {
        this.tipoPercusion = tipoPercusion;
    }

    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    public void setMaterialDeConstruccion(String materialDeConstruccion) {
        this.materialDeConstruccion = materialDeConstruccion;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
}
