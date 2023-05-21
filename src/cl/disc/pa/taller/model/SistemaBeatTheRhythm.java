package cl.disc.pa.taller.model;

import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface SistemaBeatTheRhythm {

    boolean agregarInstrumento();
    boolean agregarInstrumentoCuerda();

    boolean agregarInstrumentoViento();

    boolean agregarInstrumentoPercusion();

    void guardarListaInstrumentosEnCSV();

    boolean venderInstrumento();
    boolean consultarInventario();
    boolean cerrarSesion();

}

