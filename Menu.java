import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<EstudianteDiseño> listaEstudiantesDiseño = new ArrayList<>();
    List<EstudianteIngenieria> listaEstudiantesIngenieria = new ArrayList<>();
    List<Portatil> listaPortatiles = new ArrayList<>();
    List<Tableta> listaTabletas = new ArrayList<>();
    Metodos metodos = new Metodos();
    Scanner sc = new Scanner(System.in);

    public void menuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("Bienvenido al sistema de préstamo de equipos");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Prestar tableta");
            System.out.println("2. Mostrar lista de estudiantes");
            System.out.println("3. Gestionar Portatiles");
            System.out.println("4. Gestionar Tabletas");
            System.out.println("5. Salir");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor ingrese un dígito numérico...");
                sc.next();
            }

            opcion = sc.nextInt();
            sc.nextLine();

            while (opcion < 1 || opcion > 5) {
                System.out.println("Ingrese un número de 1 a 5:");
                opcion = sc.nextInt();
            }


            switch (opcion) {
                case 1:
                    metodos.registrarPrestamoDiseño(listaEstudiantesDiseño);

                    break;

                case 2:
                    metodos.MostrarPrestamoDiseño(listaEstudiantesDiseño, listaTabletas);
                    break;

                default:
                    break;
            }
        } while (opcion != 5);

    }

}
