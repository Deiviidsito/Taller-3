package cl.disc.pa.taller.model;

import java.io.File;

public interface SistemaBeatTheRhythm {

    boolean agregarInstrumento(Cuerda instrumentoCuerda);
    boolean agregarInstrumento(Percusion instrumentoPercusion);
    boolean agregarInstrumento(Viento instrumentoViento);
    boolean agregarInstrumento();
    boolean venderInstrumento();
    boolean consultarInventario();
    void cerrarSesion();
}

