import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    LinkedList<EstudianteDiseño> listaEstudiantesDiseño = new LinkedList<>();
    LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria = new LinkedList<>();
    LinkedList<ComputadorPortatil> listaPortatiles = new LinkedList<>();
    LinkedList<TabletaGrafica> listaTabletas = new LinkedList<>();
    MetodosIngenieria metodos = new MetodosIngenieria();
    MetodosDiseño metodosDiseño = new MetodosDiseño();
    Scanner sc = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        boolean bandera = true;

        while (bandera) {
            System.out.println("\n--- GESTIÓN PRÉSTAMO EQUIPOS ELECTRÓNICOS SAN JUAN DE DIOS ---");
            System.out.println("1. ESTUDIANTES DE INGENIERIA");
            System.out.println("2. ESTUDIANTES DE DISEÑO");
            System.out.println("3. IMPRIMIR INVENTARIO TOTAL");
            System.out.println("4. SALIR DEL PROGRAMA");

            int opcion = leerOpcionNumerica("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    mostrarSubmenuIngenieria();
                    break;
                case 2:
                    mostrarSubmenuDiseño();
                    break;
                case 3:
                    imprimirInventarioTotal(listaPortatiles, listaTabletas);
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    public void imprimirInventarioTotal(List<ComputadorPortatil> listaPortatiles, List<TabletaGrafica> listaTabletas) {
        System.out.println("\n--- INVENTARIO TOTAL ---");
        System.out.println("Computadores Portátiles:");
        for (ComputadorPortatil computador : listaPortatiles) {
            System.out.println(computador);
        }
        System.out.println("Tabletas Gráficas:");
        for (TabletaGrafica tableta : listaTabletas) {
            System.out.println(tableta);
        }
    }

    public void mostrarSubmenuIngenieria() {
        boolean bandera = true;

        while (bandera) {
            System.out.println("\n--- ESTUDIANTES DE INGENIERIA ---");
            System.out.println("1. Registrar préstamo de Computador Portátil");
            System.out.println("2. Modificar préstamo de Computador Portátil");
            System.out.println("3. Devolución de Computador Portátil");
            System.out.println("4. Buscar Computador Portátil");
            System.out.println("5. Volver al menú principal");

            int opcion = leerOpcionNumerica("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    System.out.println("PRESTAMO COMPUTADOR PORTATIL");
                    metodos.registrarComputadorPortatil(listaPortatiles);
                    metodos.registrarEstudianteIngenieria(listaEstudiantesIngenieria);
                    metodos.prestarComputadorPortatil(listaPortatiles, listaEstudiantesIngenieria);
                    break;
                case 2:
                    System.out.println("MODIFICAR PRESTAMO COMPUTADOR PORTATIL");
                    metodos.modificarPrestamoComputadorPortatil(listaPortatiles, listaEstudiantesIngenieria);
                    break;
                case 3:
                    System.out.println("DEVOLVER COMPUTADOR PORTATIL");
                    metodos.devolverComputadorPortatil(listaPortatiles);
                    break;
                case 4:
                    System.out.println("BUSCAR PC");
                    metodos.buscarComputadorPortatil(listaPortatiles);
                    break;
                case 5:
                    bandera = false;
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    public void mostrarSubmenuDiseño() {
        boolean bandera = true;

        while (bandera) {
            System.out.println("\n--- ESTUDIANTES DE DISEÑO ---");
            System.out.println("1. Registrar préstamo de Tableta Gráfica");
            System.out.println("2. Modificar préstamo de Tableta Gráfica");
            System.out.println("3. Devolución de Tableta Gráfica");
            System.out.println("4. Buscar Tableta Gráfica");
            System.out.println("5. Volver al menú principal");

            int opcion = leerOpcionNumerica("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    System.out.println("PRESTAMO TABLETA GRAFICA");
                    metodosDiseño.registrarEstudianteDiseño(listaEstudiantesDiseño);
                    metodosDiseño.registrarTabletaGrafica(listaTabletas);
                    metodosDiseño.registrarPrestamoTabletaGrafica(listaTabletas, listaEstudiantesDiseño);
                    break;
                case 2:
                    System.out.println("MODIFICAR PRESTAMO TABLETA GRAFICA");
                    metodosDiseño.modificarPrestamoTabletaGrafica(listaTabletas, listaEstudiantesDiseño);
                    break;
                case 3:
                    System.out.println("DEVOLVER TABLETA GRAFICA");
                    metodosDiseño.devolverTabletaGrafica(listaTabletas);
                    break;
                case 4:
                    System.out.println("BUSCAR TABLETA GRAFICA");
                    metodosDiseño.buscarTabletaGrafica(listaTabletas);
                    break;
                case 5:
                    bandera = false;
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }


    private int leerOpcionNumerica(String mensaje) {
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
}