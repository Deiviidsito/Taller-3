package cl.disc.pa.taller.model;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ListaInstrumento {
    private Instrumento[] instrumentos;
    private int cant_actual;
    private int cant_max;

    private static final String NOMBRE_ARCHIVO = "instrumentos.csv";
    private static final String[] ENCABEZADO_ARCHIVO = {"Código", "Precio", "Stock", "Tipo de instrumento", "Tipo de cuerda",
            "Número de cuerdas", "Material de construcción", "Tipo", "Tipo de percusión", "Altura"};

    public ListaInstrumento(int cant_max) {
        this.cant_max = cant_max;
        this.instrumentos = new Instrumento[cant_max];
        this.cant_actual = 0;
    }

    public boolean agregarInstrumento(Instrumento instrumento) {
        if (cant_actual < cant_max) {
            instrumentos[cant_actual] = instrumento;
            cant_actual++;
            System.out.println("Instrumento agregado correctamente.");
            System.out.println(("  _____________________\n" +
                    " |  _________________  |\n" +
                    " | |                 | |\n" +
                    " | |   instrumentos  | |\n" +
                    " | |                 | |\n" +
                    " | |     añadido     | |\n" +
                    " | |   exitosamente  | |\n" +
                    " | |                 | |\n" +
                    " | |                 | |\n" +
                    " | |                 | |\n" +
                    " | |_________________| |\n" +
                    " |_____________________|\n"));
            return true; // Instrumento agregado exitosamente
        } else {
            System.out.println("No se puede agregar más instrumentos. La lista está llena.");
            return false; // No se pudo agregar el instrumento
        }
    }
    public void eliminarInstrumento(int codigo) {
        int indice = -1;
        for (int i = 0; i < cant_actual; i++) {
            if (instrumentos[i].getCodigo() == codigo) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            // Desplazar los elementos hacia atrás para llenar el espacio vacío
            for (int i = indice; i < cant_actual - 1; i++) {
                instrumentos[i] = instrumentos[i + 1];
            }

            instrumentos[cant_actual - 1] = null; // Eliminar la referencia al último elemento
            cant_actual--;
            System.out.println("Instrumento eliminado correctamente.");
        } else {
            System.out.println("No se encontró el instrumento con el código especificado.");
        }
    }

    public Instrumento buscarInstrumento(int codigo) {
        for (int i = 0; i < cant_actual; i++) {
            if (instrumentos[i].getCodigo() == codigo) {
                return instrumentos[i];
            }
        }
        return null; // Si no se encuentra el instrumento, devuelve null
    }

    public int getCant_max() {
        return cant_max;
    }

    public void setCant_max(int cant_max) {
        this.cant_max = cant_max;
    }

    public Instrumento[] getInstrumentos() {
        return instrumentos;
    }

    public int getCant_actual() {
        return cant_actual;
    }

    public void guardarInventarioEnCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            writer.writeNext(ENCABEZADO_ARCHIVO);

            for (Instrumento instrumento : instrumentos) {
                // Crear un arreglo de datos según el tipo de instrumento
                String[] datos;
                if (instrumento instanceof Cuerda) {
                    Cuerda cuerda = (Cuerda) instrumento;
                    datos = new String[]{
                            String.valueOf(cuerda.getCodigo()),
                            String.valueOf(cuerda.getPrecio()),
                            String.valueOf(cuerda.getStock()),
                            cuerda.getTipoInstrumento(),
                            cuerda.getTipoCuerda(),
                            String.valueOf(cuerda.getNumeroCuerda()),
                            cuerda.getMaterialDeConstruccion(),
                            cuerda.getTipo(),
                            "",
                            ""
                    };
                } else if (instrumento instanceof Percusion) {
                    Percusion percusion = (Percusion) instrumento;
                    datos = new String[]{
                            String.valueOf(percusion.getCodigo()),
                            String.valueOf(percusion.getPrecio()),
                            String.valueOf(percusion.getStock()),
                            percusion.getTipoInstrumento(),
                            "",
                            "",
                            percusion.getMaterialDeConstruccion(),
                            "",
                            percusion.getTipoPercusion(),
                            percusion.getAltura()
                    };
                } else if (instrumento instanceof Viento) {
                    Viento viento = (Viento) instrumento;
                    datos = new String[]{
                            String.valueOf(viento.getCodigo()),
                            String.valueOf(viento.getPrecio()),
                            String.valueOf(viento.getStock()),
                            viento.getTipoInstrumento(),
                            "",
                            "",
                            viento.getMaterialDeConstruccion(),
                            "",
                            "",
                            ""
                    };
                } else {
                    // Si el tipo de instrumento no se reconoce, se omitirá en el archivo CSV
                    continue;
                }

                writer.writeNext(datos);
            }

            System.out.println("Inventario guardado correctamente en el archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario en el archivo CSV.");
            e.printStackTrace();
        }
    }

}
