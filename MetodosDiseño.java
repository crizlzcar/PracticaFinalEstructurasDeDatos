import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Iterator;

public class MetodosDiseño {
    private final Scanner sc = new Scanner(System.in);

    // Método para registrar un estudiante de diseño
    public LinkedList<EstudianteDiseño> registrarEstudianteDiseño(
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        EstudianteDiseño estudiante = new EstudianteDiseño();

        System.out.println("Ingrese la cédula del estudiante:");
        estudiante.setCedula(sc.next());
        sc.nextLine(); // Limpiar buffer después de next()

        System.out.println("Ingrese el nombre del estudiante:");
        estudiante.setNombre(sc.nextLine());

        System.out.println("Ingrese el apellido del estudiante:");
        estudiante.setApellido(sc.nextLine());

        System.out.println("Ingrese el teléfono del estudiante:");
        estudiante.setTelefono(sc.next());

        // Selección de modalidad de estudio
        String modalidad = modalidadEstudio();
        estudiante.setModalidadEstudio(modalidad);

        while (true) {
            try {
                System.out.println("Ingrese la cantidad de asignaturas del estudiante:");
                estudiante.setCantidadAsignaturas(sc.nextInt());
                sc.nextLine(); // Limpiar buffer después de nextInt()
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número válido.");
                sc.nextLine(); // Limpiar buffer en caso de error
            }
        }

        System.out.println("Ingrese el serial de la tableta:");
        estudiante.setSerialEquipo(sc.next());

        listaEstudiantesDiseño.add(estudiante);
        return listaEstudiantesDiseño;
    }

    // Método para seleccionar modalidad de estudio
    public String modalidadEstudio() {
        System.out.println("Seleccione la modalidad de estudio:");
        System.out.println("1. Presencial");
        System.out.println("2. Virtual");
        int opcion;
        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, intente nuevamente.");
            sc.nextLine();
            return modalidadEstudio();
        }
        sc.nextLine(); // Limpiar buffer
        switch (opcion) {
            case 1:
                return "Presencial";
            case 2:
                return "Virtual";
            default:
                System.out.println("Opción no válida, intente nuevamente.");
                return modalidadEstudio();
        }
    }

    // Método para registrar una tableta gráfica
    public LinkedList<TabletaGrafica> registrarTabletaGrafica(
            LinkedList<TabletaGrafica> listaTabletas) {
        TabletaGrafica tableta = new TabletaGrafica();

        System.out.println("Ingrese el serial de la tableta:");
        tableta.setSerial(sc.next());
        sc.nextLine(); // Limpiar buffer

        System.out.println("Ingrese la marca de la tableta:");
        tableta.setMarca(sc.nextLine());

        System.out.println("Ingrese el tamaño de la tableta (en pulgadas):");
        tableta.setTamano(sc.nextDouble());
        sc.nextLine();

        System.out.println("Ingrese el precio de la tableta:");
        tableta.setPrecio(sc.nextDouble());
        sc.nextLine();

        String almacenamiento = tableta.obtenerAlmacenamientoTableta(sc);
        tableta.setAlmacenamiento(almacenamiento);

        System.out.println("Ingrese el peso de la tableta (en kg):");
        tableta.setPeso(sc.nextDouble());
        sc.nextLine();

        tableta.setDisponible(seleccionarDisponibilidadTableta());

        listaTabletas.add(tableta);
        return listaTabletas;
    }

    // Método para seleccionar disponibilidad de la tableta gráfica
    public boolean seleccionarDisponibilidadTableta() {
        System.out.println("¿Está disponible? 1. Disponible 2. No disponible");
        int opcion;
        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, intente nuevamente.");
            sc.nextLine();
            return seleccionarDisponibilidadTableta();
        }
        switch (opcion) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Opción no válida, intente nuevamente.");
                sc.nextLine();
                return seleccionarDisponibilidadTableta();
        }
    }

    // Método para registrar préstamo de tableta gráfica
    public LinkedList<TabletaGrafica> registrarPrestamoTabletaGrafica(LinkedList<TabletaGrafica> listaTabletas,
            LinkedList<EstudianteDiseño> listaEstudiantesDiseño) {
        System.out.println("Ingrese el serial de la tableta a prestar:");
        String serial = sc.next();

        System.out.println("Ingrese la cédula del estudiante:");
        String cedula = sc.next();

        for (TabletaGrafica tableta : listaTabletas) {
            if (tableta.getSerial().equalsIgnoreCase(serial) && tableta.isDisponible()) {
                for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
                    if (estudiante.getCedula().equals(cedula)) {
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
        System.out.println("Ingrese la cédula del estudiante a modificar:");
        String cedula = sc.next();

        for (EstudianteDiseño estudiante : listaEstudiantesDiseño) {
            if (estudiante.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println("Ingrese el nuevo serial de la tableta:");
                String nuevoSerial = sc.next();

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

    // Método para eliminar una tableta gráfica
    public LinkedList<TabletaGrafica> devolverTabletaGrafica(LinkedList<TabletaGrafica> lista) {
        System.out.println("Ingrese el serial de la tableta a devolver:");
        String serial = sc.next();

        Iterator<TabletaGrafica> iterator = lista.iterator();
        while (iterator.hasNext()) {
            TabletaGrafica tableta = iterator.next();
            if (tableta.getSerial().equals(serial)) {
                iterator.remove();
                System.out.println("Tableta devuelta.");
                return lista;
            }
        }
        System.out.println("Serial no encontrado.");
        return lista;
    }

    // Método para buscar una tableta gráfica por serial
    public TabletaGrafica buscarTabletaGrafica(LinkedList<TabletaGrafica> lista) {
        System.out.println("Ingrese el serial de la tableta a buscar:");
        String serial = sc.next();

        for (TabletaGrafica tableta : lista) {
            if (tableta.getSerial().equals(serial)) {
                System.out.println("Tableta encontrada: " + tableta);
                return tableta;
            }
        }
        System.out.println("Serial no encontrado.");
        return null;
    }
}
