import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MetodosIngenieria {

    private final Scanner sc = new Scanner(System.in);

    // Método para validar cadena de texto sin caracteres especiales
    public String validarCadena(String cadenaInicial) {
        String cadena;
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

    // Método para validar cadena de texto sin caracteres especiales ni números
    public String validarCadenaSinNumeros(String cadenaInicial) {
        String cadena;
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

    // Método para validar número entero
    public int validarEntero(String mensaje) {
        int numero = 0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje);
            
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar un número entero válido.");
                sc.next();
            }
            sc.nextLine();
        }
        return numero;
    }

    // Método para validar double
    public double validarDecimal(String mensaje) {
        double numero = 0.0;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(mensaje);
            
            if (sc.hasNextDouble()) {
                numero = sc.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar un número válido (ejemplo: 15 o 3.14).");
                sc.next();
            }
            sc.nextLine();
        }
        return numero;
    }

    // Método para registrar un estudiante de ingeniería
    public LinkedList<EstudianteIngenieria> registrarEstudianteIngenieria(
                LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        EstudianteIngenieria estudiante = new EstudianteIngenieria();
        System.out.println("Ingrese la cédula del estudiante");
        estudiante.setCedula(validarCadena(sc.next()));
        System.out.println("Ingrese el nombre del estudiante");
        estudiante.setNombre(validarCadenaSinNumeros(sc.next()));
        System.out.println("Ingrese el apellido del estudiante");
        estudiante.setApellido(validarCadenaSinNumeros(sc.next()));
        System.out.println("Ingrese el teléfono del estudiante");
        estudiante.setTelefono(validarCadena(sc.next()));
        System.out.println("Ingrese el semestre del estudiante");
        estudiante.setSemestre(validarEntero(sc.nextInt()));
        
        estudiante.setPromedio(validarDecimal("Ingrese el promedio del estudiante:"));
        
        estudiante.setSerialComputador(validarCadena("Ingrese el serial del computador:"));

        listaEstudiantesIngenieria.add(estudiante);
        return listaEstudiantesIngenieria;
    }

    // Método para seleccionar el sistema operativo del computador portátil
    public String seleccionarSistemaOperativo() {
        System.out.println("Seleccione el sistema operativo del computador:");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");
        
        int opcion = validarEntero("Ingrese su opción: ");
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
        
        int opcion = validarEntero("Ingrese su opción: "); // Usa el método validarEntero
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
        int opcion = validarEntero("Ingrese su opción: ");
        switch (opcion) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.println("Opción no válida, intente nuevamente.");
                return seleccionarDisponibilidad();
        }
    }

    // Método para registrar un computador portátil
    public LinkedList<ComputadorPortatil> registrarComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        ComputadorPortatil computador = new ComputadorPortatil();
        
        computador.setSerial(validarCadena("Ingrese el serial del computador:"));
        
        computador.setMarca(validarCadenaSinNumeros("Ingrese la marca del computador:"));
        
        computador.setTamaño(validarDecimal("Ingrese el tamaño de la pantalla (pulgadas):"));
        
        computador.setPrecio(validarDecimal("Ingrese el precio del computador:"));
        
        computador.setSistemaOperativo(seleccionarSistemaOperativo());
        computador.setProcesador(seleccionarProcesador());
        computador.setDisponible(seleccionarDisponibilidad());

        lista.add(computador);
        return lista;
    }

    // Método para prestar un computador portátil
    public LinkedList<ComputadorPortatil> prestarComputadorPortatil(LinkedList<ComputadorPortatil> listaPC,
                LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        String serial = validarCadena("Ingrese el serial del computador a prestar:");
        
        String cedula = validarCadena("Ingrese la cédula del estudiante:");
        
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
        String cedula = validarCadena("Ingrese la cédula del estudiante a modificar:");
        
        for (EstudianteIngenieria estudiante : listaEstudiantesIngenieria) {
            if (estudiante.getCedula().equals(cedula)) {
                String nuevoSerial = validarCadena("Ingrese el nuevo serial del computador:");
                
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

    // Método para devolver un computador portátil (cambiado el nombre para mayor claridad)
    public LinkedList<ComputadorPortatil> devolverComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        String serial = validarCadena("Ingrese el serial del computador a devolver:");
        
        Iterator<ComputadorPortatil> iterator = lista.iterator();
        while (iterator.hasNext()) {
            ComputadorPortatil computador = iterator.next();
            if (computador.getSerial().equals(serial)) {
                
                computador.setDisponible(true);
                System.out.println("Computador devuelto y disponible.");
                return lista;
                
            }
        }
        System.out.println("Serial no encontrado.");
        return lista;
    }

    // Método para buscar un computador portátil por serial
    public ComputadorPortatil buscarComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        String serial = validarCadena("Ingrese el serial del computador a buscar:");
        
        for (ComputadorPortatil computador : lista) {
            if (computador.getSerial().equals(serial)) {
                System.out.println("Computador encontrado: " + computador);
                return computador;
            }
        }
        System.out.println("Serial no encontrado.");
        return null;
    }

    public void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }
}