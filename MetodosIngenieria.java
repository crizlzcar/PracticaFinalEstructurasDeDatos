

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class MetodosIngenieria {

    private final Scanner sc = new Scanner(System.in);

    // Método para registrar un estudiante de ingeniería
    public LinkedList<EstudianteIngenieria> registrarEstudianteIngenieria(
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        EstudianteIngenieria estudiante = new EstudianteIngenieria();
        
        System.out.println("Ingrese la cédula del estudiante:");
        estudiante.setCedula(sc.next());
        
        System.out.println("Ingrese el nombre del estudiante:");
        estudiante.setNombre(sc.next());
        
        System.out.println("Ingrese el apellido del estudiante:");
        estudiante.setApellido(sc.next());
        
        System.out.println("Ingrese el teléfono del estudiante:");
        estudiante.setTelefono(sc.next());
        
        System.out.println("Ingrese el semestre del estudiante:");
        estudiante.setSemestre(sc.nextInt());
        
        System.out.println("Ingrese el promedio del estudiante:");
        estudiante.setPromedio(sc.nextDouble());
        
        System.out.println("Ingrese el serial del computador:");
        estudiante.setSerialComputador(sc.next());

        listaEstudiantesIngenieria.add(estudiante);
        return listaEstudiantesIngenieria;
    }

    // Método para seleccionar el sistema operativo del computador portátil
    public String seleccionarSistemaOperativo() {
        System.out.println("Seleccione el sistema operativo del computador:");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");
        
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return "Windows 7";
            case 2:
                return "Windows 10";
            case 3:
                return "Windows 11";
            default:
                System.out.println("Opción no válida, intente nuevamente.");
                return seleccionarSistemaOperativo();
        }
    }

    // Método para seleccionar el procesador del computador portátil
    public String seleccionarProcesador() {
        System.out.println("Seleccione el procesador del computador:");
        System.out.println("1. AMD Ryzen");
        System.out.println("2. Intel Core i5");
        
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return "AMD Ryzen";
            case 2:
                return "Intel Core i5";
            default:
                System.out.println("Opción no válida, intente nuevamente.");
                return seleccionarProcesador();
        }
    }

    // Método para seleccionar disponibilidad del computador portátil
    public boolean seleccionarDisponibilidad() {
        System.out.println("¿Está disponible? 1. Disponible 2. No disponible");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Opción no válida, intente nuevamente.");
                sc.nextLine(); // Limpiar buffer
                return seleccionarDisponibilidad();
        }
    }

    // Método para registrar un computador portátil
    public LinkedList<ComputadorPortatil> registrarComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        ComputadorPortatil computador = new ComputadorPortatil();
        
        System.out.println("Ingrese el serial del computador:");
        computador.setSerial(sc.next());
        
        System.out.println("Ingrese la marca del computador:");
        computador.setMarca(sc.next());
        
        System.out.println("Ingrese el tamaño de la pantalla (pulgadas):");
        computador.setTamaño(sc.nextDouble());
        
        System.out.println("Ingrese el precio del computador:");
        computador.setPrecio(sc.nextDouble());
        
        computador.setSistemaOperativo(seleccionarSistemaOperativo());
        computador.setProcesador(seleccionarProcesador());
        computador.setDisponible(seleccionarDisponibilidad());

        lista.add(computador);
        return lista;
    }

    // Método para prestar un computador portátil
    public LinkedList<ComputadorPortatil> prestarComputadorPortatil(LinkedList<ComputadorPortatil> listaPC,
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        System.out.println("Ingrese el serial del computador a prestar:");
        String serial = sc.next();
        
        System.out.println("Ingrese la cédula del estudiante:");
        String cedula = sc.next();
        
        for (ComputadorPortatil computador : listaPC) {
            if (computador.getSerial().equals(serial) && computador.isDisponible()) {
                for (EstudianteIngenieria estudiante : listaEstudiantesIngenieria) {
                    if (estudiante.getCedula().equals(cedula)) {
                        computador.setDisponible(false);
                        System.out.println("Computador prestado a " + estudiante.getNombre());
                        return listaPC;
                    }
                }
                System.out.println("Estudiante no encontrado.");
                return listaPC;
            }
        }
        System.out.println("Computador no disponible o serial incorrecto.");
        return listaPC;
    }

    // Método para modificar préstamo de computador portátil por serial o cédula
    public LinkedList<ComputadorPortatil> modificarPrestamoComputadorPortatil(LinkedList<ComputadorPortatil> lista,
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        System.out.println("Ingrese la cédula del estudiante a modificar:");
        String cedula = sc.next();
        
        for (EstudianteIngenieria estudiante : listaEstudiantesIngenieria) {
            if (estudiante.getCedula().equals(cedula)) {
                System.out.println("Ingrese el nuevo serial del computador:");
                String nuevoSerial = sc.next();
                
                for (ComputadorPortatil computador : lista) {
                    if (computador.getSerial().equals(nuevoSerial)) {
                        computador.setDisponible(true);
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

    // Método para eliminar un computador portátil
    public LinkedList<ComputadorPortatil> devolverComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        System.out.println("Ingrese el serial del computador a eliminar:");
        String serial = sc.next();
        
        Iterator<ComputadorPortatil> iterator = lista.iterator();
        while (iterator.hasNext()) {
            ComputadorPortatil computador = iterator.next();
            if (computador.getSerial().equals(serial)) {
                iterator.remove();
                System.out.println("Computador devuelto.");
                return lista;
            }
        }
        System.out.println("Serial no encontrado.");
        return lista;
    }

    // Método para buscar un computador portátil por serial
    public ComputadorPortatil buscarComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        System.out.println("Ingrese el serial del computador a buscar:");
        String serial = sc.next();
        
        for (ComputadorPortatil computador : lista) {
            if (computador.getSerial().equals(serial)) {
                System.out.println("Computador encontrado: " + computador);
                return computador;
            }
        }
        System.out.println("Serial no encontrado.");
        return null;
    }
}