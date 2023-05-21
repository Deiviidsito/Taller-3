package cl.disc.pa.taller.services;

import cl.disc.pa.taller.model.*;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Scanner;

public class SistemaBeatTheRhythmImpl implements SistemaBeatTheRhythm {

    public static final String NOMBRE_ARCHIVO = "instrumentos.csv";
    public static final String[] ENCABEZADO_ARCHIVO = {"Código", "Precio", "Stock", "Tipo de instrumento", "Tipo de cuerda",
            "Número de cuerdas", "Material de construcción", "Tipo", "Tipo de percusión", "Altura"};
    private boolean sesionActiva;

    private ListaInstrumento listaInstrumento;


    public SistemaBeatTheRhythmImpl() {
        listaInstrumento = new ListaInstrumento(10000);
        sesionActiva = false;
    }

    /**
     * Agrega un nuevo instrumento al sistema.
     *
     * @return true si el instrumento fue agregado correctamente, false en caso contrario.
     */
    public boolean agregarInstrumento() {
        sesionActiva = true;
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Ingrese el tipo de instrumento que desea agregar:");
            System.out.println("1. Cuerda");
            System.out.println("2. Viento");
            System.out.println("3. Percusión");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion < 1 || opcion > 3);

        switch (opcion) {
            case 1:
                agregarInstrumentoCuerda();
                break;
            case 2:
                agregarInstrumentoViento();
                break;
            case 3:
                agregarInstrumentoPercusion();
                break;
        }

        return false;
    }

    public boolean agregarInstrumentoCuerda() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del instrumento de cuerda:");

        // Validación del campo Código
        int codigo;
        while (true) {
            System.out.print("Código: ");
            String codigoStr = scanner.nextLine();
            try {
                codigo = Integer.parseInt(codigoStr);
                if (codigo > 0) {
                    break;
                } else {
                    System.out.println("Error: El código debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Precio
        int precio;
        while (true) {
            System.out.print("Precio: ");
            String precioStr = scanner.nextLine();
            try {
                precio = Integer.parseInt(precioStr);
                if (precio > 0) {
                    break;
                } else {
                    System.out.println("Error: El precio debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Stock
        int stock;
        while (true) {
            System.out.print("Stock: ");
            String stockStr = scanner.nextLine();
            try {
                stock = Integer.parseInt(stockStr);
                if (stock > 0) {
                    break;
                } else {
                    System.out.println("Error: El stock debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Tipo de instrumento
        String tipoInstrumento;
        while (true) {
            System.out.print("Tipo de instrumento (Guitarra, Bajo, Violín, Arpa): ");
            tipoInstrumento = scanner.nextLine();
            if (tipoInstrumento.equalsIgnoreCase("Guitarra") || tipoInstrumento.equalsIgnoreCase("Bajo")
                    || tipoInstrumento.equalsIgnoreCase("Violín") || tipoInstrumento.equalsIgnoreCase("Arpa")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de instrumento válido. Intente nuevamente.");
            }
        }

        // Validación del campo Tipo de cuerda
        String tipoCuerda;
        while (true) {
            System.out.print("Tipo de cuerda (Nylon, acero, tripa): ");
            tipoCuerda = scanner.nextLine();
            if (tipoCuerda.equalsIgnoreCase("Nylon") || tipoCuerda.equalsIgnoreCase("acero")
                    || tipoCuerda.equalsIgnoreCase("tripa")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de cuerda válido. Intente nuevamente.");
            }
        }

        // Validación del campo Número de cuerdas
        int numeroCuerdas;
        while (true) {
            System.out.print("Número de cuerdas: ");
            String numeroCuerdasStr = scanner.nextLine();
            try {
                numeroCuerdas = Integer.parseInt(numeroCuerdasStr);
                if (numeroCuerdas > 0) {
                    break;
                } else {
                    System.out.println("Error: El número de cuerdas debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Material de construcción
        String materialConstruccion;
        while (true) {
            System.out.print("Material de construcción (madera, metal): ");
            materialConstruccion = scanner.nextLine();
            if (materialConstruccion.equalsIgnoreCase("madera") || materialConstruccion.equalsIgnoreCase("metal")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de material válido. Intente nuevamente.");
            }
        }

        // Validación del campo Tipo
        String tipo;
        while (true) {
            System.out.print("Tipo (acustico, electrico): ");
            tipo = scanner.nextLine();
            if (tipo.equalsIgnoreCase("acustico") || tipo.equalsIgnoreCase("electrico")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo válido. Intente nuevamente.");
            }
        }

        // Crear el objeto Cuerda con los datos ingresados
        Cuerda instrumentoCuerda = new Cuerda(codigo, precio, stock, tipoInstrumento, tipoCuerda, numeroCuerdas, materialConstruccion, tipo);

        // Agregar el instrumento a la lista
        boolean agregado = listaInstrumento.agregarInstrumento(instrumentoCuerda);

        if (agregado) {
            System.out.println("El instrumento de cuerda ha sido agregado correctamente.");
        } else {
            System.out.println("Error al agregar el instrumento de cuerda.");
        }
        // Guardar la lista actualizada en el archivo CSV
        guardarListaInstrumentosEnCSV();

        return agregado;
    }


    public boolean agregarInstrumentoPercusion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del instrumento de viento:");
        // Validación del campo Código
        int codigo;
        while (true) {
            System.out.print("Código: ");
            String codigoStr = scanner.nextLine();
            try {
                codigo = Integer.parseInt(codigoStr);
                if (codigo > 0) {
                    break;
                } else {
                    System.out.println("Error: El código debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Precio
        int precio;
        while (true) {
            System.out.print("Precio: ");
            String precioStr = scanner.nextLine();
            try {
                precio = Integer.parseInt(precioStr);
                if (precio > 0) {
                    break;
                } else {
                    System.out.println("Error: El precio debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Stock
        int stock;
        while (true) {
            System.out.print("Stock: ");
            String stockStr = scanner.nextLine();
            try {
                stock = Integer.parseInt(stockStr);
                if (stock > 0) {
                    break;
                } else {
                    System.out.println("Error: El stock debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validacion de Tipo De Instrumento
        String tipoInstrumento;
        while (true) {
            System.out.print("Tipo de instrumento (Bongo, Cajon, Campanas Tubulares, Bombo): ");
            tipoInstrumento = scanner.nextLine();
            if (tipoInstrumento.equalsIgnoreCase("Bongo") || tipoInstrumento.equalsIgnoreCase("Cajon")
                    || tipoInstrumento.equalsIgnoreCase("Campanas Tubulares") || tipoInstrumento.equalsIgnoreCase("Bombo")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de instrumento válido. Intente nuevamente.");
            }
        }


        // Validacion de Tipo De Percusion
        String tipoPercusion;
        while (true) {
            System.out.print("Tipo de Percusion (Membranofono, idiofono): ");
            tipoPercusion = scanner.nextLine();
            if (tipoPercusion.equalsIgnoreCase("Membranofono") || tipoPercusion.equalsIgnoreCase("idiofono")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de Percusion válido. Intente nuevamente.");
            }
        }

        // Validación de Material de construcción
        String materialDeConstruccion;
        while (true) {
            System.out.print("Material de construcción (madera, metal, piel): ");
            materialDeConstruccion = scanner.nextLine();
            if (materialDeConstruccion.equalsIgnoreCase("madera") || materialDeConstruccion.equalsIgnoreCase("metal") ||
                    materialDeConstruccion.equalsIgnoreCase("piel")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de material válido. Intente nuevamente.");
            }
        }

        String altura;
        while (true) {
            System.out.print("Altura (definida, indefinida): ");
            altura = scanner.nextLine();
            if (altura.equalsIgnoreCase("definida") || altura.equalsIgnoreCase("indefinida")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de altura válido. Intente nuevamente.");
            }
        }


        // Crear el objeto Percusion con los datos ingresados
        Percusion instrumentoPercusion = new Percusion(codigo, precio, stock, tipoInstrumento,tipoPercusion, materialDeConstruccion, altura);

        // Agregar el instrumento a la lista
        boolean agregado = listaInstrumento.agregarInstrumento(instrumentoPercusion);

        if (agregado) {
            System.out.println("El instrumento de Percusion ha sido agregado correctamente.");
        } else {
            System.out.println("Error al agregar el instrumento de Percusion.");
        }

        // Guardar la lista actualizada en el archivo CSV
        guardarListaInstrumentosEnCSV();

        return agregado;
    }


    public boolean agregarInstrumentoViento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del instrumento de viento:");
        // Validación del campo Código
        int codigo;
        while (true) {
            System.out.print("Código: ");
            String codigoStr = scanner.nextLine();
            try {
                codigo = Integer.parseInt(codigoStr);
                if (codigo > 0) {
                    break;
                } else {
                    System.out.println("Error: El código debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Precio
        int precio;
        while (true) {
            System.out.print("Precio: ");
            String precioStr = scanner.nextLine();
            try {
                precio = Integer.parseInt(precioStr);
                if (precio > 0) {
                    break;
                } else {
                    System.out.println("Error: El precio debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validación del campo Stock
        int stock;
        while (true) {
            System.out.print("Stock: ");
            String stockStr = scanner.nextLine();
            try {
                stock = Integer.parseInt(stockStr);
                if (stock > 0) {
                    break;
                } else {
                    System.out.println("Error: El stock debe ser un número mayor que cero. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Intente nuevamente.");
            }
        }

        // Validacion de Tipo De Instrumento
        String tipoInstrumento;
        while (true) {
            System.out.print("Tipo de instrumento (Trompeta, Saxofon, Clarinete, Flauta traversa): ");
            tipoInstrumento = scanner.nextLine();
            if (tipoInstrumento.equalsIgnoreCase("Trompeta") || tipoInstrumento.equalsIgnoreCase("Saxofon")
                    || tipoInstrumento.equalsIgnoreCase("Clarinete") || tipoInstrumento.equalsIgnoreCase("Flauta traversa")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de instrumento válido. Intente nuevamente.");
            }
        }

        // Validación de Material de construcción
        String material;
        while (true) {
            System.out.print("Material de construcción (madera, metal, piel): ");
            material = scanner.nextLine();
            if (material.equalsIgnoreCase("madera") || material.equalsIgnoreCase("metal")) {
                break;
            } else {
                System.out.println("Error: Coloque un tipo de material válido. Intente nuevamente.");
            }
        }


        // Crear el objeto Viento con los datos ingresados
        Viento instrumentoViento = new Viento(codigo, precio, stock, tipoInstrumento, material);

        // Agregar el instrumento a la lista
        boolean agregado = listaInstrumento.agregarInstrumento(instrumentoViento);

        if (agregado) {
            System.out.println("El instrumento de viento ha sido agregado correctamente.");
        } else {
            System.out.println("Error al agregar el instrumento de viento.");
        }

        // Guardar la lista actualizada en el archivo CSV
        guardarListaInstrumentosEnCSV();

        return agregado;
    }

    /**
     * Guarda la lista de instrumentos en un archivo CSV.
     */
    public void guardarListaInstrumentosEnCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            writer.writeNext(ENCABEZADO_ARCHIVO);

            for (Instrumento instrumento : listaInstrumento.getInstrumentos()) {
                if (instrumento instanceof Cuerda) {
                    Cuerda cuerda = (Cuerda) instrumento;
                    String[] datos = {
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
                    writer.writeNext(datos);
                } else if (instrumento instanceof Percusion) {
                    Percusion percusion = (Percusion) instrumento;
                    String[] datos = {
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
                    writer.writeNext(datos);
                } else if (instrumento instanceof Viento) {
                    Viento viento = (Viento) instrumento;
                    String[] datos = {
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
                    writer.writeNext(datos);
                }
            }

            System.out.println("La lista de instrumentos ha sido guardada correctamente en el archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de instrumentos en el archivo CSV.");
            e.printStackTrace();
        }
    }


    /**
     * Realiza la venta de un instrumento.
     *
     * @return true si la venta fue realizada correctamente, false en caso contrario.
     */
    @Override
    public boolean venderInstrumento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código del instrumento a vender: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        Instrumento instrumento = listaInstrumento.buscarInstrumento(codigo);

        if (instrumento != null) {
            listaInstrumento.eliminarInstrumento(codigo);
            System.out.println("Instrumento vendido correctamente.");

            // Actualizar el archivo CSV con la lista actualizada de instrumentos
            guardarListaInstrumentosEnCSV();
            return true;
        } else {
            System.out.println("No se encontró el instrumento con el código especificado.");
            return false;
        }
    }

    /**
     * Consulta el inventario de instrumentos disponibles.
     *
     * @return true si la consulta fue exitosa, false en caso contrario.
     */
    @Override
    public boolean consultarInventario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Consultar Inventario -----");
        System.out.println("1. Mostrar todos los instrumentos");
        System.out.println("2. Mostrar instrumentos por tipo");
        System.out.println("3. Buscar instrumento por código");
        System.out.println("4. Volver al menú principal");
        System.out.print("Ingrese la opción deseada: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        switch (opcion) {
            case 1:
                System.out.println("----- Todos los instrumentos -----");
                for (Instrumento instrumento : listaInstrumento.getInstrumentos()) {
                    if (instrumento != null) {
                        System.out.println("Código: " + instrumento.getCodigo());
                        System.out.println("Precio: " + instrumento.getPrecio());
                        System.out.println("Instrumento: " + instrumento.getTipoInstrumento());

                        // Mostrar detalles específicos del instrumento
                        if (instrumento instanceof Cuerda) {
                            Cuerda cuerda = (Cuerda) instrumento;
                            System.out.println("Detalles: Cuerdas: " + cuerda.getNumeroCuerda());
                        } else if (instrumento instanceof Viento) {
                            Viento viento = (Viento) instrumento;
                            System.out.println("Detalles: Material: " + viento.getMaterialDeConstruccion());
                        } else if (instrumento instanceof Percusion) {
                            Percusion percusion = (Percusion) instrumento;
                            System.out.println("Detalles: Tipo de percusión: " + percusion.getTipoPercusion());
                        }

                        System.out.println("------------------------------------");
                    }
                }
                break;
            case 2:
                System.out.println("----- Mostrar instrumentos por tipo -----");
                System.out.println("1. Mostrar instrumentos de cuerda");
                System.out.println("2. Mostrar instrumentos de viento");
                System.out.println("3. Mostrar instrumentos de percusión");
                System.out.print("Ingrese la opción deseada: ");
                int tipoInstrumento = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                switch (tipoInstrumento) {
                    case 1:
                        System.out.println("----- Instrumentos de cuerda -----");
                        for (Instrumento instrumento : listaInstrumento.getInstrumentos()) {
                            if (instrumento instanceof Cuerda) {
                                System.out.println("Código: " + instrumento.getCodigo());
                                System.out.println("Precio: " + instrumento.getPrecio());
                                System.out.println("Instrumento: " + ((Cuerda) instrumento).getTipoInstrumento());

                                Cuerda cuerda = (Cuerda) instrumento;
                                System.out.println("Detalles: Tipo de cuerda: " + cuerda.getTipoCuerda());
                                System.out.println("------------------------------------");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("----- Instrumentos de viento -----");
                        for (Instrumento instrumento : listaInstrumento.getInstrumentos()) {
                            if (instrumento instanceof Viento) {
                                System.out.println("Código: " + instrumento.getCodigo());
                                System.out.println("Precio: " + instrumento.getPrecio());
                                System.out.println("Instrumento: " + ((Viento) instrumento).getTipoInstrumento());

                                Viento viento = (Viento) instrumento;
                                System.out.println("Detalles: Material de construcción: " + viento.getMaterialDeConstruccion());
                                System.out.println("------------------------------------");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("----- Instrumentos de percusión -----");
                        for (Instrumento instrumento : listaInstrumento.getInstrumentos()) {
                            if (instrumento instanceof Percusion) {
                                System.out.println("Código: " + instrumento.getCodigo());
                                System.out.println("Precio: " + instrumento.getPrecio());
                                System.out.println("Instrumento: " + ((Percusion) instrumento).getTipoInstrumento());

                                Percusion percusion = (Percusion) instrumento;
                                System.out.println("Detalles: Tipo de percusión: " + percusion.getTipoPercusion());
                                System.out.println("------------------------------------");
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
                break;
            case 3:
                System.out.print("Ingrese el código del instrumento a buscar: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                Instrumento instrumento = listaInstrumento.buscarInstrumento(codigo);

                if (instrumento != null) {
                    System.out.println("----- Instrumento encontrado -----");
                    System.out.println("Código: " + instrumento.getCodigo());
                    System.out.println("Precio: " + instrumento.getPrecio());
                    System.out.println("Instrumento: " + instrumento.getInstrumento());

                    // Mostrar detalles específicos del instrumento
                    if (instrumento instanceof Cuerda) {
                        Cuerda cuerda = (Cuerda) instrumento;
                        System.out.println("Detalles: Cuerdas: " + cuerda.getNumeroCuerda());
                    } else if (instrumento instanceof Viento) {
                        Viento viento = (Viento) instrumento;
                        System.out.println("Detalles: Material: " + viento.getMaterialDeConstruccion());
                    } else if (instrumento instanceof Percusion) {
                        Percusion percusion = (Percusion) instrumento;
                        System.out.println("Detalles: Tipo de percusión: " + percusion.getTipoPercusion());
                    }

                    System.out.println("------------------------------------");
                } else {
                    System.out.println("No se encontró el instrumento con el código especificado.");
                }
                break;
            case 4:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }

        return true;
    }

    /**
     * Cierra la sesión activa en el sistema.
     *
     * @return true si se cerró la sesión correctamente, false en caso contrario.
     */
    @Override
    public boolean cerrarSesion() {
        System.out.println("Cerrando sesión...");
        guardarListaInstrumentosEnCSV();
        return true;
    }


    /**
     * Inicia el sistema de la tienda de Instrumentos.
     *
     * @return true si se inicio la sesión correctamente, false en caso contrario.
     */
    public void iniciarSistema() {
        sesionActiva = true;

        Scanner scanner = new Scanner(System.in);

        while (sesionActiva) {
            mostrarMenu();
            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    agregarInstrumento();
                    break;
                case 2:
                    venderInstrumento();
                    break;
                case 3:
                    consultarInventario();
                    break;
                case 4:
                    cerrarSesion();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    /**
     * Muestra el menu principal.
     */
    private void mostrarMenu() {
        System.out.println("████████╗ █████╗ ██╗     ██╗     ███████╗██████╗  ");
        System.out.println("╚══██╔══╝██╔══██╗██║     ██║     ██╔════╝██╔══██╗ ");
        System.out.println("   ██║   ███████║██║     ██║     █████╗  ██████╔╝ ");
        System.out.println("   ██║   ██╔══██║██║     ██║     ██╔══╝  ██╔══██╗ ");
        System.out.println("   ██║   ██║  ██║███████╗███████╗███████╗██║  ██║ ");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝ ");
        System.out.println("---------------------- Menú ----------------------");
        System.out.println("1. Agregar instrumento");
        System.out.println("2. Vender instrumento");
        System.out.println("3. Consultar inventario");
        System.out.println("4. Cerrar sesión");
    }

}


