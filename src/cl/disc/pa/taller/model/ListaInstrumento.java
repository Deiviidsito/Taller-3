package cl.disc.pa.taller.model;

public class ListaInstrumento {
    private Instrumento[] instrumentos;
    private int cant_actual;
    private int cant_max;

    public ListaInstrumento(int cant_max) {
        this.cant_max = cant_max;
        this.instrumentos = new Instrumento[cant_max];
        this.cant_actual = 0;
    }

    public void agregarInstrumento(Instrumento instrumento) {
        if (cant_actual < cant_max) {
            instrumentos[cant_actual] = instrumento;
            cant_actual++;
            System.out.println("Instrumento agregado correctamente.");
        } else {
            System.out.println("No se puede agregar más instrumentos. La lista está llena.");
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
}
