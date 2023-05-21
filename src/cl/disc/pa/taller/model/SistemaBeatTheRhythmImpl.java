package cl.disc.pa.taller.model;

import java.io.File;

public class SistemaBeatTheRhythmImpl implements SistemaBeatTheRhythm{

    private ListaInstrumento[] instrumentos;

    public SistemaBeatTheRhythmImpl() {
    }


    @Override
    public boolean agregarInstrumento() {
        return false;
    }


    @Override
    public boolean venderInstrumento() {
        return false;
    }

    @Override
    public boolean consultarInventario() {
        return false;
    }

    @Override
    public void cerrarSesion() {

    }
}
