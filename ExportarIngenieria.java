import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportarIngenieria {

    MetodosIngenieria m = new MetodosIngenieria();

    public void exportarING(LinkedList<EstudianteIngenieria> lista, LinkedList<ComputadorPortatil> Listapc) {
        if (lista.isEmpty() && Listapc.isEmpty()) {
            System.out.println("La lista está vacía; no se puede exportar el archivo.");
            
            return;
        }

        try (FileWriter escritor = new FileWriter("PrestamosIngenieria.txt")) {
            if (!lista.isEmpty()) {
                escritor.write("=== Estudiantes Ingeniería ===\n");
                for (EstudianteIngenieria estudiante : lista) {
                    escritor.write("Cedula: " + estudiante.getCedula() + "\n");
                    escritor.write("Nombre: " + estudiante.getNombre() + "\n");
                    escritor.write("Apellido: " + estudiante.getApellido() + "\n");
                    escritor.write("Telefono: " + estudiante.getTelefono() + "\n");
                    escritor.write("Semestre: " + estudiante.getSemestre() + "\n");
                    escritor.write("Promedio: " + estudiante.getPromedio() + "\n");
                    escritor.write("Serial: " + estudiante.getSerialComputador() + "\n");
                    escritor.write(
                            "--------------------------------------------------------------------------------------\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error al exportar 'PrestamosIngenieria.txt': " + e.getMessage());
        }

        try (FileWriter escritorPC = new FileWriter("InventarioPC.txt")) {
            if (!lista.isEmpty()) {
                escritorPC.write("=== Inventario de PC ===\n");
                for (ComputadorPortatil pc : Listapc) {
                    escritorPC.write("Serial: " + pc.getSerial() + "\n");
                    escritorPC.write("Marca: " + pc.getMarca() + "\n");
                    escritorPC.write("Tamaño: " + pc.getTamaño() + "\n");
                    escritorPC.write("Precio: " + pc.getPrecio() + "\n");
                    escritorPC.write("Sistema: " + pc.getSistemaOperativo() + "\n");
                    escritorPC.write("Procesador: " + pc.getProcesador() + "\n");
                    escritorPC.write("Disponibilidad: " + pc.getDisponible() + "\n");
                    escritorPC.write(
                            "--------------------------------------------------------------------------------------\n");
                }
            }
            System.out.println("Archivo 'InventarioPC.txt' exportado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar 'InventarioPC.txt': " + e.getMessage());
        }
    }

}
