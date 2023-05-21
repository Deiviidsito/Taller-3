package cl.disc.pa.taller.model;

import java.io.File;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;


public class SistemaBeatTheRhythmImpl implements SistemaBeatTheRhythm{
    private static final String ARCHIVO_INSTRUMENTOS = "instrumentos.csv";

    private ListaInstrumento[] instrumentos;


    public SistemaBeatTheRhythmImpl() {
    }


    @Override
    public boolean agregarInstrumento(Cuerda instrumentoCuerda) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ARCHIVO_INSTRUMENTOS, true));
            String[] instrumento = {
                    String.valueOf(instrumentoCuerda.getCodigo()),
                    String.valueOf(instrumentoCuerda.getPrecio()),
                    String.valueOf(instrumentoCuerda.getStock()),
                    instrumentoCuerda.getTipoInstrumento(),
                    instrumentoCuerda.getTipoCuerda(),
                    String.valueOf(instrumentoCuerda.getNumeroCuerda()),
                    instrumentoCuerda.getMaterialDeConstruccion(),
                    instrumentoCuerda.getTipo()
            };
            writer.writeNext(instrumento);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarInstrumento(Percusion instrumentoPercusion) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ARCHIVO_INSTRUMENTOS, true));
            String[] instrumento = {
                    String.valueOf(instrumentoPercusion.getCodigo()),
                    String.valueOf(instrumentoPercusion.getPrecio()),
                    String.valueOf(instrumentoPercusion.getStock()),
                    instrumentoPercusion.getTipoInstrumento(),
                    instrumentoPercusion.getTipoPercusion(),
                    instrumentoPercusion.getMaterialDeConstruccion(),
                    instrumentoPercusion.getAltura()
            };
            writer.writeNext(instrumento);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarInstrumento(Viento instrumentoViento) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ARCHIVO_INSTRUMENTOS, true));
            String[] instrumento = {
                    String.valueOf(instrumentoViento.getCodigo()),
                    String.valueOf(instrumentoViento.getPrecio()),
                    String.valueOf(instrumentoViento.getStock()),
                    instrumentoViento.getTipoInstrumento(),
                    instrumentoViento.getMaterialDeConstruccion()
            };
            writer.writeNext(instrumento);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarInstrumento() {
        return false;
    }

    // Implementar el resto de los métodos de la interfaz...


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
