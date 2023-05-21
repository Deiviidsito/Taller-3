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
        int codigo; // Declara una variable llamada "codigo" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Código: "); // Muestra en la consola el mensaje "Código: ".
            String codigoStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en una variable llamada "codigoStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                codigo = Integer.parseInt(codigoStr); // Intenta convertir la cadena "codigoStr" a un número entero y asignarlo a la variable "codigo".

                if (codigo > 0) { // Comprueba si el valor de "codigo" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El código debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el código debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }

        // Validación del campo Precio
        int precio; // Declara una variable llamada "precio" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Precio: "); // Muestra en la consola el mensaje "Precio: ".
            String precioStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en una variable llamada "precioStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                precio = Integer.parseInt(precioStr); // Intenta convertir la cadena "precioStr" a un número entero y asignarlo a la variable "precio".

                if (precio > 0) { // Comprueba si el valor de "precio" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El precio debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el precio debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }


        // Validación del campo Stock
        int stock; // Declara una variable llamada "stock" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Stock: "); // Muestra en la consola el mensaje "Stock: ".
            String stockStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en una variable llamada "stockStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                stock = Integer.parseInt(stockStr); // Intenta convertir la cadena "stockStr" a un número entero y asignarlo a la variable "stock".

                if (stock > 0) { // Comprueba si el valor de "stock" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El stock debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el stock debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }

        // Validación del campo Tipo de instrumento
        String tipoInstrumento; // Declara una variable llamada "tipoInstrumento" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Tipo de instrumento (Guitarra, Bajo, Violin, Arpa): "); // Muestra en la consola el mensaje "Tipo de instrumento (Guitarra, Bajo, Violín, Arpa): ".
            tipoInstrumento = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "tipoInstrumento".

            if (tipoInstrumento.equalsIgnoreCase("Guitarra") || tipoInstrumento.equalsIgnoreCase("Bajo")
                    || tipoInstrumento.equalsIgnoreCase("Violin") || tipoInstrumento.equalsIgnoreCase("Arpa")) {
                break; // Si el tipo de instrumento ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de instrumento válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de instrumento válido.
            }
        }

        // Validación del campo Tipo de cuerda
        String tipoCuerda; // Declara una variable llamada "tipoCuerda" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Tipo de cuerda (Nylon, acero, tripa): "); // Muestra en la consola el mensaje "Tipo de cuerda (Nylon, acero, tripa): ".
            tipoCuerda = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "tipoCuerda".

            if (tipoCuerda.equalsIgnoreCase("Nylon") || tipoCuerda.equalsIgnoreCase("acero")
                    || tipoCuerda.equalsIgnoreCase("tripa")) {
                break; // Si el tipo de cuerda ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de cuerda válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de cuerda válido.
            }
        }

        // Validación del campo Número de cuerdas
        int numeroCuerdas; // Declara una variable llamada "numeroCuerdas" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Número de cuerdas: "); // Muestra en la consola el mensaje "Número de cuerdas: ".
            String numeroCuerdasStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en una variable llamada "numeroCuerdasStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                numeroCuerdas = Integer.parseInt(numeroCuerdasStr); // Intenta convertir la cadena "numeroCuerdasStr" a un número entero y asignarlo a la variable "numeroCuerdas".

                if (numeroCuerdas > 0) { // Comprueba si el valor de "numeroCuerdas" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El número de cuerdas debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el número de cuerdas debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }

        // Validación del campo Material de construcción
        String materialConstruccion; // Declara una variable llamada "materialConstruccion" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Material de construcción (madera, metal): "); // Muestra en la consola el mensaje "Material de construcción (madera, metal): ".
            materialConstruccion = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "materialConstruccion".

            if (materialConstruccion.equalsIgnoreCase("madera") || materialConstruccion.equalsIgnoreCase("metal")) {
                break; // Si el material de construcción ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de material válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de material válido.
            }
        }

        // Validación del campo Tipo
        String tipo; // Declara una variable llamada "tipo" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Tipo (acustico, electrico): "); // Muestra en la consola el mensaje "Tipo (acustico, electrico): ".
            tipo = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "tipo".

            if (tipo.equalsIgnoreCase("acustico") || tipo.equalsIgnoreCase("electrico")) {
                break; // Si el tipo ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo válido.
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
        int codigo; // Declara una variable llamada "codigo" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Código: "); // Muestra en la consola el mensaje "Código: ".
            String codigoStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "codigoStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                codigo = Integer.parseInt(codigoStr); // Intenta convertir la cadena "codigoStr" a un número entero y asignarlo a la variable "codigo".

                if (codigo > 0) { // Comprueba si el valor de "codigo" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El código debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el código debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }


        // Validación del campo Precio
        int precio; // Declara una variable llamada "precio" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Precio: "); // Muestra en la consola el mensaje "Precio: ".
            String precioStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "precioStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                precio = Integer.parseInt(precioStr); // Intenta convertir la cadena "precioStr" a un número entero y asignarlo a la variable "precio".

                if (precio > 0) { // Comprueba si el valor de "precio" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El precio debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el precio debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }


        // Validación del campo Stock
        int stock; // Declara una variable llamada "stock" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Stock: "); // Muestra en la consola el mensaje "Stock: ".
            String stockStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "stockStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                stock = Integer.parseInt(stockStr); // Intenta convertir la cadena "stockStr" a un número entero y asignarlo a la variable "stock".

                if (stock > 0) { // Comprueba si el valor de "stock" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El stock debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el stock debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }


        // Validacion de Tipo De Instrumento
        String tipoInstrumento; // Declara una variable llamada "tipoInstrumento" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Tipo de instrumento (Bongo, Cajon, Campanas Tubulares, Bombo): "); // Muestra en la consola el mensaje "Tipo de instrumento (Bongo, Cajon, Campanas Tubulares, Bombo): ".
            tipoInstrumento = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "tipoInstrumento".

            if (tipoInstrumento.equalsIgnoreCase("Bongo") || tipoInstrumento.equalsIgnoreCase("Cajon")
                    || tipoInstrumento.equalsIgnoreCase("Campanas Tubulares") || tipoInstrumento.equalsIgnoreCase("Bombo")) {
                break; // Si el tipo de instrumento ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de instrumento válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de instrumento válido.
            }
        }



        // Validacion de Tipo De Percusion
        String tipoPercusion; // Declara una variable llamada "tipoPercusion" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Tipo de Percusion (Membranofono, idiofono): "); // Muestra en la consola el mensaje "Tipo de Percusion (Membranofono, idiofono): ".
            tipoPercusion = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "tipoPercusion".

            if (tipoPercusion.equalsIgnoreCase("Membranofono") || tipoPercusion.equalsIgnoreCase("idiofono")) {
                break; // Si el tipo de percusión ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de Percusion válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de percusión válido.
            }
        }


        // Validación de Material de construcción
        String materialDeConstruccion; // Declara una variable llamada "materialDeConstruccion" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Material de construcción (madera, metal, piel): "); // Muestra en la consola el mensaje "Material de construcción (madera, metal, piel): ".
            materialDeConstruccion = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "materialDeConstruccion".

            if (materialDeConstruccion.equalsIgnoreCase("madera") || materialDeConstruccion.equalsIgnoreCase("metal") ||
                    materialDeConstruccion.equalsIgnoreCase("piel")) {
                break; // Si el material de construcción ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de material válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de material válido.
            }
        }

        // Validación de Altura
        String altura; // Declara una variable llamada "altura" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Altura (definida, indefinida): "); // Muestra en la consola el mensaje "Altura (definida, indefinida): ".
            altura = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "altura".

            if (altura.equalsIgnoreCase("definida") || altura.equalsIgnoreCase("indefinida")) {
                break; // Si la altura ingresada coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de altura válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de altura válido.
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
        int codigo; // Declara una variable llamada "codigo" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Código: "); // Muestra en la consola el mensaje "Código: ".
            String codigoStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "codigoStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                codigo = Integer.parseInt(codigoStr); // Intenta convertir la cadena "codigoStr" a un número entero y asignarlo a la variable "codigo".

                if (codigo > 0) { // Comprueba si el valor de "codigo" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El código debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el código debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }


        // Validación del campo Precio
        int precio; // Declara una variable llamada "precio" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Precio: "); // Muestra en la consola el mensaje "Precio: ".
            String precioStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "precioStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                precio = Integer.parseInt(precioStr); // Intenta convertir la cadena "precioStr" a un número entero y asignarlo a la variable "precio".

                if (precio > 0) { // Comprueba si el valor de "precio" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El precio debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el precio debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }


        // Validación del campo Stock
        int stock; // Declara una variable llamada "stock" de tipo entero.

        while (true) { // Inicia un bucle infinito.
            System.out.print("Stock: "); // Muestra en la consola el mensaje "Stock: ".
            String stockStr = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "stockStr" de tipo cadena (String).

            try { // Inicia un bloque try-catch para manejar excepciones.
                stock = Integer.parseInt(stockStr); // Intenta convertir la cadena "stockStr" a un número entero y asignarlo a la variable "stock".

                if (stock > 0) { // Comprueba si el valor de "stock" es mayor que cero.
                    break; // Si es mayor que cero, sale del bucle.
                } else {
                    System.out.println("Error: El stock debe ser un número mayor que cero. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que el stock debe ser un número mayor que cero.
                }
            } catch (NumberFormatException e) { // Captura la excepción si la conversión a entero falla.
                System.out.println("Error: Solo se permiten números. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que solo se permiten números.
            }
        }

        // Validacion de Tipo De Instrumento
        String tipoInstrumento; // Declara una variable llamada "tipoInstrumento" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Tipo de instrumento (Trompeta, Saxofon, Clarinete, Flauta traversa): "); // Muestra en la consola el mensaje "Tipo de instrumento (Trompeta, Saxofon, Clarinete, Flauta traversa): ".
            tipoInstrumento = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "tipoInstrumento".

            if (tipoInstrumento.equalsIgnoreCase("Trompeta") || tipoInstrumento.equalsIgnoreCase("Saxofon")
                    || tipoInstrumento.equalsIgnoreCase("Clarinete") || tipoInstrumento.equalsIgnoreCase("Flauta traversa")) {
                break; // Si el tipo de instrumento ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de instrumento válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de instrumento válido.
            }
        }


        // Validación de Material de construcción
        String material; // Declara una variable llamada "material" de tipo cadena (String).

        while (true) { // Inicia un bucle infinito.
            System.out.print("Material de construcción (madera, metal, piel): "); // Muestra en la consola el mensaje "Material de construcción (madera, metal, piel): ".
            material = scanner.nextLine(); // Lee la entrada del usuario y la guarda en la variable "material".

            if (material.equalsIgnoreCase("madera") || material.equalsIgnoreCase("metal")) {
                break; // Si el material ingresado coincide con alguno de los valores permitidos (ignorando mayúsculas y minúsculas), se sale del bucle.
            } else {
                System.out.println("Error: Coloque un tipo de material válido. Intente nuevamente."); // Muestra en la consola un mensaje de error indicando que se debe ingresar un tipo de material válido.
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
            // Abre un flujo de escritura para el archivo CSV utilizando un objeto FileWriter y lo asocia con un objeto CSVWriter.

            writer.writeNext(ENCABEZADO_ARCHIVO);
            // Escribe la linea de encabezado en el archivo CSV utilizando el objeto CSVWriter.

            for (Instrumento instrumento : listaInstrumento.getInstrumentos()) {
                // Itera sobre cada instrumento en la lista de instrumentos.

                if (instrumento instanceof Cuerda) {
                    // Verifica si el instrumento es una instancia de la clase Cuerda.

                    Cuerda cuerda = (Cuerda) instrumento;
                    // Realiza un casting del instrumento a la clase Cuerda para acceder a sus métodos específicos.

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
                    // Crea un arreglo de cadenas con los datos del instrumento Cuerda.

                    writer.writeNext(datos);
                    // Escribe una línea en el archivo CSV con los datos del instrumento Cuerda.

                } else if (instrumento instanceof Percusion) {
                    // Verifica si el instrumento es una instancia de la clase Percusion.

                    Percusion percusion = (Percusion) instrumento;
                    // Realiza un casting del instrumento a la clase Percusion para acceder a sus métodos específicos.

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
                    // Crea un arreglo de cadenas con los datos del instrumento Percusion.

                    writer.writeNext(datos);
                    // Escribe una línea en el archivo CSV con los datos del instrumento Percusion.

                } else if (instrumento instanceof Viento) {
                    // Verifica si el instrumento es una instancia de la clase Viento.

                    Viento viento = (Viento) instrumento;
                    // Realiza un casting del instrumento a la clase Viento para acceder a sus métodos específicos.

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
                    // Crea un arreglo de cadenas con los datos del instrumento Viento.

                    writer.writeNext(datos);
                    // Escribe una línea en el archivo CSV con los datos del instrumento Viento.
                }
            }

            System.out.println("La lista de instrumentos ha sido guardada correctamente en el archivo CSV.");
            // Imprime un mensaje indicando que la lista de instrumentos se ha guardado correctamente en el archivo CSV.

        } catch (IOException e) {
            System.out.println("Error al guardar la lista de instrumentos en el archivo CSV.");
            e.printStackTrace();
            // En caso de que ocurra una excepción durante la escritura del archivo CSV, se muestra un mensaje de error y se imprime la traza de la excepción.
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

        int codigo;
        while (true) {
            System.out.print("Ingrese el código del instrumento a vender: ");
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
        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            if (opcion > 0) {
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

                int tipoInstrumento;

                do {
                    System.out.print("Ingrese la opción deseada (1-3): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida (1-3): ");
                        scanner.next();
                    }
                    tipoInstrumento = scanner.nextInt();
                } while (tipoInstrumento < 1 || tipoInstrumento > 3);

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
                int codigo;
                do {
                    System.out.print("Ingrese el código del instrumento a buscar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Ingrese un número válido.");
                        System.out.print("Ingrese el código del instrumento a buscar: ");
                        scanner.next();
                    }
                    codigo = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                } while (codigo <= 0);

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
            } else {
                System.out.println("Error: Solo se permiten números positivos. Por favor, ingrese una opción válida.");
            }
        } else {
            System.out.println("Error: Solo se permiten números. Por favor, ingrese una opción válida.");
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
        guardarListaInstrumentosEnCSV(); // Guarda el archivo csv.
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
            String opcionStr = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(opcionStr);
                if (opcion >= 1 && opcion <= 4) {
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
                    }
                } else {
                    System.out.println("Error: La opción ingresada está fuera del rango válido. Por favor, seleccione una opción válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Solo se permiten números. Por favor, ingrese una opción válida.");
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


