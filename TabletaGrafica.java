import java.util.InputMismatchException;
import java.util.Scanner;

public class TabletaGrafica {

    private String serial;
    private String marca;
    private double tamano;
    private double precio;
    private String almacenamiento;
    private double peso;
    private String disponibilidad;
    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    private boolean disponible; // Nuevo atributo para controlar la disponibilidad

    

    public TabletaGrafica() {
    }

    public TabletaGrafica(String serial, String marca, double tamano, double precio, String almacenamiento, double peso) {
            this.serial = serial;
            this.marca = marca;
            this.tamano = tamano;
            this.precio = precio;
            this.almacenamiento = almacenamiento;
            this.peso = peso;
            this.disponible = true;
        }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Tableta Gráfica:\n" +
                "  Serial: " + serial + "\n" +
                "  Marca: " + marca + "\n" +
                "  Tamaño: " + tamano + " pulgadas\n" +
                "  Precio: $" + precio + "\n" +
                "  Almacenamiento: " + almacenamiento + "\n" +
                "  Peso: " + peso + " kg" +
                (disponible ? "\n  Estado: Disponible" : "\n  Estado: No Disponible");
    }

    public String obtenerAlmacenamientoTableta(Scanner scanner) {
        System.out.println("\n--- Seleccione el almacenamiento de la tableta ---");
        System.out.println("1. 256 GB");
        System.out.println("2. 512 GB");
        System.out.println("3. 1 TB");
        System.out.print("Seleccione una opción: ");
        int opcionAlmacenamiento = -1;
        try {
            opcionAlmacenamiento = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido para la opción de almacenamiento.");
            scanner.next(); // Limpiar el scanner
            return ""; // Retorna cadena vacía para indicar error
        }

        switch (opcionAlmacenamiento) {
            case 1:
                return "256 GB";
            case 2:
                return "512 GB";
            case 3:
                return "1 TB";
            default:
                System.out.println("Opción de almacenamiento inválida. Se asignará 256 GB por defecto.");
                return "256 GB";
        }
    }
}
