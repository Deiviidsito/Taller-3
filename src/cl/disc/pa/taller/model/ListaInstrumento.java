package cl.disc.pa.taller.model;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Lista de instrumento, almacena todos los tipos de instrumentos.
 */
public class ListaInstrumento {
    // Arreglo de instrumentos en la lista.
    private Instrumento[] instrumentos;
    // Cantidad actual de instrumentos en la lista.
    private int cant_actual;
    // Cantidad máxima de instrumentos que se pueden almacenar en la lista.
    private int cant_max;

    // Nombre del archivo CSV para guardar el inventario
    private static final String NOMBRE_ARCHIVO = "instrumentos.csv";
    // Encabezado de las columnas en el archivo CSV
    private static final String[] ENCABEZADO_ARCHIVO = {"Código", "Precio", "Stock", "Tipo de instrumento", "Tipo de cuerda",
            "Número de cuerdas", "Material de construcción", "Tipo", "Tipo de percusión", "Altura"};

    /**
     * Constructor de la clase ListaInstrumento.
     *
     * @param cant_max la cantidad máxima de instrumentos que puede almacenar la lista
     */
    public ListaInstrumento(int cant_max) {
        this.cant_max = cant_max;
        this.instrumentos = new Instrumento[cant_max];
        this.cant_actual = 0;
    }

    /**
     * Agrega un instrumento a la lista.
     *
     * @param instrumento el instrumento a agregar
     * @return true si el instrumento se agregó correctamente, false si la lista está llena
     */
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

    /**
     * Elimina un instrumento de la lista por su código.
     *
     * @param codigo el código del instrumento a eliminar
     */
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


    /**
     * Busca un instrumento en la lista por su código.
     *
     * @param codigo el código del instrumento a buscar
     * @return el instrumento encontrado, o null si no se encontró
     */
    public Instrumento buscarInstrumento(int codigo) {
        for (int i = 0; i < cant_actual; i++) {
            if (instrumentos[i].getCodigo() == codigo) {
                return instrumentos[i];
            }
        }
        return null; // Si no se encuentra el instrumento, devuelve null
    }

    /**
     * Obtiene la cantidad máxima de instrumentos que puede almacenar la lista.
     *
     * @return la cantidad máxima de instrumentos
     */
    public int getCant_max() {
        return cant_max;
    }

    /**
     * Obtiene el arreglo de instrumentos de la lista.
     *
     * @return el arreglo de instrumentos
     */
    public Instrumento[] getInstrumentos() {
        return instrumentos;
    }

    /**
     * Obtiene la cantidad actual de instrumentos en la lista.
     *
     * @return la cantidad actual de instrumentos
     */
    public int getCant_actual() {
        return cant_actual;
    }


    /**
     * Guarda el inventario de instrumentos en un archivo CSV.
     */

}
