package cl.disc.pa.taller.model;

public class Instrumento {
    private int codigo;
    private int precio;
    private int stock;

    public Instrumento(int codigo, int precio, int stock) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
