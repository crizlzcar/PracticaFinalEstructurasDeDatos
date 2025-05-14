import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    Scanner sc = new Scanner(System.in);

    private List<EstudianteDiseño> Diseño = new ArrayList<>();
    private List<EstudianteIngenieria> Ingenieria = new ArrayList<>();
    private List<Portatil> Portatiles = new ArrayList<>();
    private List<Tableta> Tabletas = new ArrayList<>();

    public Tableta Menutableta() {
        Tableta tableta = new Tableta();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Seleccione capacidad de almacenamiento:" +
                    "\\n" + //
                    "1. 256GB\n" +
                    "2. 512GB\n" +
                    "3. 1TB\n" +
                    "4. Guardar\n");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor ingrese un dígito numérico...");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            while (opcion < 1 || opcion > 4) {
                System.out.println("Ingrese un número de 1 a 4 para salir:");
                opcion = sc.nextInt();
            }
            switch (opcion) {
                case 1:
                    tableta.setAlmacenamiento("256GB");
                    break;
                case 2:
                    tableta.setAlmacenamiento("512GB");
                    break;
                case 3:
                    tableta.setAlmacenamiento("1TB");
                    break;
                default:
                    System.out.println("Guardando...");
                    break;
            }
        }
        return tableta;
    }

    public List<EstudianteDiseño> registrarPrestamoDiseño(List<EstudianteDiseño> listaEstudiantesDiseño) {
        EstudianteDiseño e = new EstudianteDiseño();
        
        System.out.println("Ingrese la cédula del estudiante:");
        e.setCedula(sc.next());
        System.out.println("Ingrese el nombre del estudiante:");
        e.setNombre(sc.next());
        System.out.println("Ingrese el apellido del estudiante:");
        e.setApellido(sc.next());
        System.out.println("Ingrese el teléfono del estudiante:");
        e.setTelefono(sc.next());
        System.out.println("Ingrese la modalidad de estudio del estudiante:");
        e.setModalidadEstudio(sc.next());
        e.setCantidadAsignaturas(sc.nextInt());
        while (!sc.hasNextInt()) {
            System.out.println("Debe ingresar un número entero");
            sc.next();
        }
        sc.nextLine();
        
        System.out.println("Ingrese el serial del equipo:");
        e.setSerial(sc.nextInt());
        sc.nextLine();
        
        Tableta tableta = Menutableta();
        System.out.println("Ingrese el peso de la tableta:");
        while (!sc.hasNextFloat()) {
            System.out.println("Debe ingresar un número decimal");
            sc.next();
        }
        tableta.setPeso(sc.nextFloat());
        sc.nextLine();
 
        listaEstudiantesDiseño.add(e);
    
        return listaEstudiantesDiseño;
    }

    public void MostrarPrestamoDiseño(List<EstudianteDiseño> listaEstudiantesDiseño, List<Tableta> listaTabletas) {
        if (listaEstudiantesDiseño.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        for (EstudianteDiseño e : listaEstudiantesDiseño) {
            System.out.println("Datos del estudiante:");
            System.out.println("Cédula: " + e.getCedula());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Apellido: " + e.getApellido());
            System.out.println("Teléfono: " + e.getTelefono());
            System.out.println("Modalidad de estudio: " + e.getModalidadEstudio());
            System.out.println("Cantidad de asignaturas: " + e.getCantidadAsignaturas());
            System.out.println("Serial del equipo: " + e.getSerial());
            for (Tableta t : listaTabletas) {
                System.out.println("Datos de la tableta:");
                System.out.println("Serial: " + t.getSerial());
                System.out.println("Marca: " + t.getMarca());
                System.out.println("Tamaño: " + t.getTamaño());
                System.out.println("Precio: " + t.getPrecio());
                System.out.println("Peso: " + t.getPeso());
                System.out.println("Almacenamiento: " + t.getAlmacenamiento());
            }

            System.out.println("--------------------------------------------------");
        }
    }

    public void modificarPrestamo(String cedula, String serial) {
        // Implementar la lógica para modificar el préstamo
        // Aquí puedes agregar el código necesario para modificar el préstamo
        // entre el estudiante y el portátil.
    }

    public void devolverEquipo(String cedula, String serial) {
        // Implementar la lógica para eliminar el préstamo
        // Aquí puedes agregar el código necesario para eliminar el préstamo
        // entre el estudiante y el portátil.
    }

    public void buscarEquipo(String cedula, String serial1, int serial2) {
        // Implementar la lógica para buscar el préstamo
        // Aquí puedes agregar el código necesario para buscar el préstamo
        // entre el estudiante y el portátil.
    }

    public void mostrarInventario(String cedula, String serial1, int Serial2) {
        // Implementar la lógica para mostrar el inventario
        // Aquí puedes agregar el código necesario para mostrar el inventario
        // de los portátiles y tabletas disponibles.
    }

}
