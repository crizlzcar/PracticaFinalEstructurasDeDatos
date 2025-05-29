import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MetodosDiseño {
    private final Scanner sc = new Scanner(System.in);

    // Método para validar cadena de texto sin caracteres especiales
    public String validarCadena(String mensaje) {
        String cadena;
        while (true) {
            System.out.println(mensaje);
            cadena = sc.nextLine().trim();

            if (cadena.isEmpty()) {
                System.out.println("Error: La cadena no puede estar vacía.");
                continue;
            }

            if (cadena.matches("^[a-zA-Z0-9 ]*$")) {
                return cadena;
            } else {
                System.out.println("Error: No se permiten caracteres especiales.");
            }
        }
    }

    // Método para validar cadena de texto sin caracteres especiales ni números
    public String validarCadenaSinNumeros(String mensaje) {
        String cadena;
        while (true) {
            System.out.println(mensaje);
            cadena = sc.nextLine().trim();

            if (cadena.isEmpty()) {
                System.out.println("Error: La cadena no puede estar vacía.");
                continue;
            }

            if (cadena.matches("^[a-zA-Z ]+$")) {
                return cadena;
            } else {
                System.out.println("Error: No se permiten caracteres especiales ni números.");
            }
        }
    }

    // Método para validar double
    public double validarDecimal(String mensaje) {
        double numero = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            try {
                numero = sc.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido (ejemplo: 15 o 3.14).");
                sc.next();
            } finally {
                sc.nextLine();
            }
        }
        return numero;
    }

    // Método para validar entero
    public int validarEntero(String mensaje) {
        int opcion = -1;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
                return opcion;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese solo números.");
                sc.nextLine();
            }
        }
    }

    // Método para registrar un estudiante de diseño
    public LinkedList<EstudianteDiseño> registrarEstudianteDiseño(
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        EstudianteDiseño estudiante = new EstudianteDiseño();
        System.out.println("\n--- REGISTRO DE ESTUDIANTE DE DISEÑO ---");
        estudiante.setCedula(validarCadena("Ingrese la cédula del estudiante:"));
        estudiante.setNombre(validarCadenaSinNumeros("Ingrese el nombre del estudiante:"));
        estudiante.setApellido(validarCadenaSinNumeros("Ingrese el apellido del estudiante:"));
        estudiante.setTelefono(validarCadena("Ingrese el teléfono del estudiante:"));

        estudiante.setModalidadEstudio(modalidadEstudio());
        
        estudiante.setCantidadAsignaturas(validarEntero("Ingrese la cantidad de asignaturas del estudiante:"));
        estudiante.setSerialEquipo(validarCadena("Ingrese el serial de la tableta a prestar:"));

        listaEstudiantesDiseño.add(estudiante);
        return listaEstudiantesDiseño;
    }

    // Método para seleccionar modalidad de estudio
    public String modalidadEstudio() {
        int opcion;
        while (true) {
            System.out.println("Seleccione la modalidad de estudio:");
            System.out.println("1. Presencial");
            System.out.println("2. Virtual");

            opcion = validarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    return "Presencial";
                case 2:
                    return "Virtual";
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    // Método para registrar una tableta gráfica
    public LinkedList<TabletaGrafica> registrarTabletaGrafica(
            LinkedList<TabletaGrafica> listaTabletas) {
        TabletaGrafica tableta = new TabletaGrafica();
        System.out.println("\n--- REGISTRO DE TABLETA GRÁFICA ---");

        tableta.setSerial(validarCadena("Ingrese el serial de la tableta:"));
        tableta.setMarca(validarCadenaSinNumeros("Ingrese la marca de la tableta:"));
        tableta.setTamano(validarDecimal("Ingrese el tamaño de la tableta (en pulgadas):"));
        tableta.setPrecio(validarDecimal("Ingrese el precio de la tableta:"));
        tableta.setAlmacenamiento(tableta.obtenerAlmacenamientoTableta(sc));
        tableta.setPeso(validarDecimal("Ingrese el peso de la tableta (en kg):"));
        tableta.setDisponible(seleccionarDisponibilidadTableta());

        listaTabletas.add(tableta);
        return listaTabletas;
    }

    // Método para seleccionar disponibilidad de la tableta gráfica
    public boolean seleccionarDisponibilidadTableta() {
        int opcion;
        while (true) {
            System.out.println("¿Está disponible? 1. Disponible 2. No disponible");
            opcion = validarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    // Método para registrar préstamo de tableta gráfica
    public LinkedList<TabletaGrafica> registrarPrestamoTabletaGrafica(
            LinkedList<TabletaGrafica> listaTabletas,
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        String serial = validarCadena("Ingrese el serial de la tableta a prestar:");
        String cedula = validarCadena("Ingrese la cédula del estudiante:");

        for (TabletaGrafica tableta : listaTabletas) {
            if (tableta.getSerial().equalsIgnoreCase(serial)) {
                if (tableta.isDisponible()) {
                    for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
                        if (estudiante.getCedula().equalsIgnoreCase(cedula)) {
                            tableta.setDisponible(false);
                            estudiante.setSerialEquipo(serial);
                            System.out.println("Tableta prestada a " + estudiante.getNombre());
                            return listaTabletas;
                        }
                    }
                    System.out.println("Estudiante no encontrado.");
                    return listaTabletas;
                } else {
                    System.out.println("Tableta no disponible.");
                    return listaTabletas;
                }
            }
        }
        System.out.println("Tableta no encontrada.");
        return listaTabletas;
    }

    // Método para modificar préstamo de tableta gráfica por serial o cédula
    public LinkedList<TabletaGrafica> modificarPrestamoTabletaGrafica(
            LinkedList<TabletaGrafica> listaTabletas,
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        String cedula = validarCadena("Ingrese la cédula del estudiante a modificar:");

        for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
            if (estudiante.getCedula().equalsIgnoreCase(cedula)) {
                String antiguoSerial = estudiante.getSerialEquipo();
                
                // Liberar la tableta anterior
                for (TabletaGrafica tableta : listaTabletas) {
                    if (tableta.getSerial().equalsIgnoreCase(antiguoSerial)) {
                        tableta.setDisponible(true);
                        break;
                    }
                }
                
                String nuevoSerial = validarCadena("Ingrese el nuevo serial de la tableta:");
                
                for (TabletaGrafica tableta : listaTabletas) {
                    if (tableta.getSerial().equalsIgnoreCase(nuevoSerial) && tableta.isDisponible()) {
                        tableta.setDisponible(false);
                        estudiante.setSerialEquipo(nuevoSerial);
                        System.out.println("Préstamo modificado exitosamente.");
                        return listaTabletas;
                    }
                }
                System.out.println("Tableta no disponible o serial incorrecto.");
                return listaTabletas;
            }
        }
        System.out.println("Estudiante no encontrado.");
        return listaTabletas;
    }

    // Método para devolver una tableta gráfica
    public LinkedList<TabletaGrafica> devolverTabletaGrafica(
            LinkedList<TabletaGrafica> listaTabletas,
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        String serial = validarCadena("Ingrese el serial de la tableta a devolver:");

        for (TabletaGrafica tableta : listaTabletas) {
            if (tableta.getSerial().equalsIgnoreCase(serial)) {
                if (!tableta.isDisponible()) {
                    tableta.setDisponible(true);
                    
                    // Limpiar el serial del estudiante
                    for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
                        if (serial.equalsIgnoreCase(estudiante.getSerialEquipo())) {
                            estudiante.setSerialEquipo("");
                            break;
                        }
                    }
                    
                    System.out.println("Tableta devuelta y disponible.");
                } else {
                    System.out.println("La tableta ya estaba disponible.");
                }
                return listaTabletas;
            }
        }
        System.out.println("Serial no encontrado.");
        return listaTabletas;
    }

    // Método para buscar una tableta gráfica por serial
    public TabletaGrafica buscarTabletaGrafica(LinkedList<TabletaGrafica> listaTabletas) {
        String serial = validarCadena("Ingrese el serial de la tableta a buscar:");

        for (TabletaGrafica tableta : listaTabletas) {
            if (tableta.getSerial().equalsIgnoreCase(serial)) {
                System.out.println("Tableta encontrada: " + tableta);
                return tableta;
            }
        }
        System.out.println("Tableta no encontrada.");
        return null;
    }

    // Método para cerrar el Scanner
    public void closeScanner() {
        sc.close();
    }
}

