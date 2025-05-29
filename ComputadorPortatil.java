import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputadorPortatil {

    private String Serial;
    private String Marca;
    private double Tamaño;
    private double Precio;
    private String SistemaOperativo;
    private String Procesador;
    private boolean Disponible;

    

    public boolean getDisponible() {
        return Disponible;
    }




    public ComputadorPortatil() {
    }


    public String getSerial() {
        return Serial;
    }



    public void setSerial(String serial) {
        Serial = serial;
    }



    public String getMarca() {
        return Marca;
    }



    public void setMarca(String marca) {
        Marca = marca;
    }



    public double getTamaño() {
        return Tamaño;
    }



    public void setTamaño(double tamaño) {
        Tamaño = tamaño;
    }



    public double getPrecio() {
        return Precio;
    }



    public void setPrecio(double precio) {
        Precio = precio;
    }



    public String getSistemaOperativo() {
        return SistemaOperativo;
    }



    public void setSistemaOperativo(String sistemaOperativo) {
        SistemaOperativo = sistemaOperativo;
    }



    public String getProcesador() {
        return Procesador;
    }



    public void setProcesador(String procesador) {
        Procesador = procesador;
    }



    public boolean isDisponible() {
        return Disponible;
    }



    public void setDisponible(boolean disponible) {
        Disponible = disponible;
    }

    @Override
    public String toString() {
        return "Computador Portátil:\n" +
                "  Serial: " + Serial + "\n" +
                "  Marca: " + Marca + "\n" +
                "  Tamaño: " + Tamaño + " pulgadas\n" +
                "  Precio: $" + Precio + "\n" +
                "  Sistema Operativo: " + SistemaOperativo + "\n" +
                "  Procesador: " + Procesador + "\n" +
                "  Disponible: " + (Disponible ? "Sí" : "No") + "\n";
    }



    public String obtenerSistemaOperativoComputador(Scanner scanner) {
        System.out.println("\n--- Seleccione el sistema operativo del computador ---");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");
        System.out.print("Seleccione una opción: ");
        int opcionSistemaOperativo = -1;
        try {
            opcionSistemaOperativo = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido para la opción de sistema operativo.");
            scanner.next(); // Limpiar el scanner
            return "";
        }
        switch (opcionSistemaOperativo) {
            case 1:
                return "Windows 7";
            case 2:
                return "Windows 10";
            case 3:
                return "Windows 11";
            default:
                System.out.println("Opción de sistema operativo inválida. Se asignará Windows 10 por defecto.");
                return "Windows 10";
        }
    }

    public String obtenerProcesadorComputador(Scanner scanner) {
        System.out.println("\n--- Seleccione el procesador del computador ---");
        System.out.println("1. AMD Ryzen");
        System.out.println("2. Intel® Core™ i5");
        System.out.print("Seleccione una opción: ");
        int opcionProcesador = -1;
        try {
            opcionProcesador = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido para la opción de procesador.");
            scanner.next(); // Limpiar el scanner
            return "";
        }

        switch (opcionProcesador) {
            case 1:
                return "AMD Ryzen";
            case 2:
                return "Intel® Core™ i5";
            default:
                System.out.println("Opción de procesador incorrecta. Intente de nuevo.");
                return obtenerProcesadorComputador(scanner);
        }
    }


}
