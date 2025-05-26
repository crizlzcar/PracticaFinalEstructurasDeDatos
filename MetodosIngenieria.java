

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class MetodosIngenieria {

    private final Scanner sc = new Scanner(System.in);

    //Método para validar cadena de texto sin caracteres especiales

    public String validarCadena(String cadena) {
        
        while (true) {
            System.out.println("Ingrese un texto (solo letras y números):");
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



    //Método para validar cadena de texto sin caracteres especiales ni números

    public String validarCadenaSinNumeros(String cadena) {
        
        while (true) {
            System.out.println("Ingrese un texto (solo letras):");
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

    //Método para validar núnmero entero

    public int validarEntero(int i) {
        
        int numero = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(i);
            
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar un número entero válido.");
                sc.next();
            }
        }
        
        return numero;
    }

    //Método para validar double
    
        public double validarDecimal(Double numero) {
            
            boolean entradaValida = false;
            
            while (!entradaValida) {
                System.out.print("Por favor, ingrese un número (puede ser decimal): ");
                
                if (sc.hasNextDouble()) {
                    numero = sc.nextDouble();
                    entradaValida = true;
                } else {
                    System.out.println("Error: Debe ingresar un número válido (ejemplo: 15 o 3.14).");
                    sc.next();
                }
            }
            
            return numero;
        }

    // Método para registrar un estudiante de ingeniería
    public LinkedList<EstudianteIngenieria> registrarEstudianteIngenieria(
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        EstudianteIngenieria estudiante = new EstudianteIngenieria();
        
        System.out.println("Ingrese la cédula del estudiante:");
        estudiante.setCedula(validarCadena(sc.next()));
        
        System.out.println("Ingrese el nombre del estudiante:");
        estudiante.setNombre(validarCadenaSinNumeros(sc.next()));
        
        System.out.println("Ingrese el apellido del estudiante:");
        estudiante.setApellido(validarCadenaSinNumeros(sc.next()));
        
        System.out.println("Ingrese el teléfono del estudiante:");
        estudiante.setTelefono(validarCadena(sc.next()));
        
        System.out.println("Ingrese el semestre del estudiante:");
        estudiante.setSemestre(validarEntero(sc.nextInt()));
        
        System.out.println("Ingrese el promedio del estudiante:");
        estudiante.setPromedio(validarDecimal(sc.nextDouble()));
        
        System.out.println("Ingrese el serial del computador:");
        estudiante.setSerialComputador(validarCadena(sc.next()));

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
        computador.setSerial(validarCadena(sc.next()));
        
        System.out.println("Ingrese la marca del computador:");
        computador.setMarca(validarCadenaSinNumeros(sc.next()));
        
        System.out.println("Ingrese el tamaño de la pantalla (pulgadas):");
        computador.setTamaño(validarDecimal(sc.nextDouble()));
        
        System.out.println("Ingrese el precio del computador:");
        computador.setPrecio(validarDecimal(sc.nextDouble()));
        
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
        String serial = validarCadena(sc.next());
        
        System.out.println("Ingrese la cédula del estudiante:");
        String cedula = validarCadena(sc.next());
        
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
        String cedula = validarCadena(sc.next());
        
        for (EstudianteIngenieria estudiante : listaEstudiantesIngenieria) {
            if (estudiante.getCedula().equals(cedula)) {
                System.out.println("Ingrese el nuevo serial del computador:");
                String nuevoSerial = validarCadena(sc.next());
                
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
        System.out.println("Ingrese el serial del computador a devolver:");
        String serial = validarCadena(sc.next());
        
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
        String serial = validarCadena(sc.next());
        
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