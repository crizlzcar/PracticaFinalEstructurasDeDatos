import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MetodosDiseño {
    private final Scanner sc = new Scanner(System.in);

    // Método para validar cadena de texto sin caracteres especiales
    public String validarCadena(String mens) {
        String cadena;
        while (true) {
            System.out.println(mens);
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
    public double validarDecimal(String m) {
        double numero = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(m);
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

    private int validarEntero(String mensaje) {
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

        // Uso consistente de validarCadena
        estudiante.setCedula(validarCadena("Ingrese la cédula del estudiante:"));

        // Uso consistente de validarCadenaSinNumeros
        estudiante.setNombre(validarCadenaSinNumeros("Ingrese el nombre del estudiante:"));

        estudiante.setApellido(validarCadenaSinNumeros("Ingrese el apellido del estudiante:"));

        estudiante.setTelefono(validarCadena("Ingrese el teléfono del estudiante:"));

        String modalidad = modalidadEstudio();
        estudiante.setModalidadEstudio(modalidad);
        
        estudiante.setCantidadAsignaturas(validarEntero("Ingrese la cantidad de asignaturas del estudiante:"));

        estudiante.setSerialEquipo(validarCadena("Ingrese el serial de la tableta:"));

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
            
            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer después de nextInt()
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, por favor ingrese 1 o 2.");
                sc.nextLine();
                continue;
            }

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

        tableta.setSerial(validarCadena("Ingrese el serial de la tableta:"));

        tableta.setMarca(validarCadenaSinNumeros("Ingrese la marca de la tableta:"));

        tableta.setTamano(validarDecimal("Ingrese el tamaño de la tableta (en pulgadas):"));

        tableta.setPrecio(validarDecimal("Ingrese el precio de la tableta:"));

        String almacenamiento = tableta.obtenerAlmacenamientoTableta(sc);
        tableta.setAlmacenamiento(almacenamiento);

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
            
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, por favor ingrese 1 o 2.");
                sc.nextLine();
                continue;
            }

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
    public LinkedList<TabletaGrafica> registrarPrestamoTabletaGrafica(LinkedList<TabletaGrafica> listaTabletas,
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        String serial = validarCadena("Ingrese el serial de la tableta a prestar:");

        String cedula = validarCadena("Ingrese la cédula del estudiante:");

        for (TabletaGrafica tableta : listaTabletas) {
            if (tableta.getSerial().equalsIgnoreCase(serial) && tableta.isDisponible()) {
                for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
                    if (estudiante.getCedula().equalsIgnoreCase(cedula)) { // Usar equalsIgnoreCase para consistencia
                        tableta.setDisponible(false);
                        System.out.println("Tableta prestada a " + estudiante.getNombre());
                        return listaTabletas;
                    }
                }
                System.out.println("Estudiante no encontrado.");
                return listaTabletas;
            }
        }
        System.out.println("Tableta no disponible o serial incorrecto.");
        return listaTabletas;
    }

    // Método para modificar préstamo de tableta gráfica por serial o cédula
    public LinkedList<TabletaGrafica> modificarPrestamoTabletaGrafica(LinkedList<TabletaGrafica> lista,
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        String cedula = validarCadena("Ingrese la cédula del estudiante a modificar:");

        for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
            if (estudiante.getCedula().equalsIgnoreCase(cedula)) {
                String nuevoSerial = validarCadena("Ingrese el nuevo serial de la tableta:");

                for (TabletaGrafica tableta : lista) {
                    if (tableta.getSerial().equals(nuevoSerial)) {
                        tableta.setDisponible(true);
                        System.out.println("Préstamo modificado exitosamente.");
                        return lista;
                    }
                }
                System.out.println("Serial no encontrado.");
                return lista;
            }
        }
        System.out.println("Estudiante no encontrado.");
        return lista;
    }

    // Método para devolver una tableta gráfica
    public LinkedList<TabletaGrafica> devolverTabletaGrafica(LinkedList<TabletaGrafica> lista) {
        String serial = validarCadena("Ingrese el serial de la tableta a devolver:");

        Iterator<TabletaGrafica> iterator = lista.iterator();
        while (iterator.hasNext()) {
            TabletaGrafica tableta = iterator.next();
            if (tableta.getSerial().equals(serial)) {
                tableta.setDisponible(true);
                System.out.println("Tableta devuelta y disponible.");
                return lista;
            }
        }
        System.out.println("Serial no encontrado.");
        return lista;
    }

    // Método para buscar una tableta gráfica por serial
    public TabletaGrafica buscarTabletaGrafica(LinkedList<TabletaGrafica> lista) {
        String serial = validarCadena("Ingrese el serial de la tableta a buscar:");

        for (TabletaGrafica tableta : lista) {
            if (tableta.getSerial().equals(serial)) {
                System.out.println("Tableta encontrada: " + tableta);
                return tableta;
            }
        }
        System.out.println("Serial no encontrado.");
        return null;
    }

    // Método para cerrar el Scanner al finalizar la aplicación
    public void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}