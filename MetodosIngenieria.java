import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MetodosIngenieria {
    private final Scanner sc = new Scanner(System.in);

    // Método para validar cadena de texto sin caracteres especiales
    public String validarCadena(String mensaje) {
        String cadena;
        while (true) {
            System.out.print(mensaje);
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
    public String validarCadenaSinNumeros(String mensaje) {
        String cadena;
        while (true) {
            System.out.print(mensaje);
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
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
        }
    }

    // Método para validar double
    public double validarDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido (ejemplo: 15 o 3.14).");
            }
        }
    }

    // Método para registrar un estudiante de ingeniería
    public LinkedList<EstudianteIngenieria> registrarEstudianteIngenieria(
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        EstudianteIngenieria estudiante = new EstudianteIngenieria();
        System.out.println("\n--- Registro de Estudiante de Ingeniería ---");
        
        estudiante.setCedula(validarCadena("Ingrese la cédula del estudiante: "));
        estudiante.setNombre(validarCadenaSinNumeros("Ingrese el nombre del estudiante: "));
        estudiante.setApellido(validarCadenaSinNumeros("Ingrese el apellido del estudiante: "));
        estudiante.setTelefono(validarCadena("Ingrese el teléfono del estudiante: "));
        estudiante.setSemestre(validarEntero("Ingrese el semestre del estudiante: "));
        estudiante.setPromedio(validarDecimal("Ingrese el promedio del estudiante: "));
        estudiante.setSerialComputador(validarCadena("Ingrese el serial del computador: "));

        listaEstudiantesIngenieria.add(estudiante);
        System.out.println("Estudiante registrado exitosamente!");
        return listaEstudiantesIngenieria;
    }

    // Método para registrar un computador portátil
    public LinkedList<ComputadorPortatil> registrarComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        ComputadorPortatil computador = new ComputadorPortatil();
        System.out.println("\n--- Registro de Computador Portátil ---");
        
        computador.setSerial(validarCadena("Ingrese el serial del computador: "));
        computador.setMarca(validarCadenaSinNumeros("Ingrese la marca del computador: "));
        computador.setTamaño(validarDecimal("Ingrese el tamaño de la pantalla (pulgadas): "));
        computador.setPrecio(validarDecimal("Ingrese el precio del computador: "));
        computador.setSistemaOperativo(computador.obtenerSistemaOperativoComputador(sc));
        sc.nextLine(); // Limpiar buffer
        computador.setProcesador(computador.obtenerProcesadorComputador(sc));
        sc.nextLine(); // Limpiar buffer
        computador.setDisponible(true);

        lista.add(computador);
        System.out.println("Computador registrado exitosamente!");
        return lista;
    }

    // Método para prestar un computador portátil
    public LinkedList<ComputadorPortatil> prestarComputadorPortatil(LinkedList<ComputadorPortatil> listaPC,
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        String serial = validarCadena("Ingrese el serial del computador a prestar: ");
        String cedula = validarCadena("Ingrese la cédula del estudiante: ");
        
        // Buscar computador
        ComputadorPortatil computador = buscarComputadorPorSerial(listaPC, serial);
        if (computador == null || !computador.isDisponible()) {
            System.out.println("Computador no disponible o serial incorrecto.");
            return listaPC;
        }
        
        // Buscar estudiante
        EstudianteIngenieria estudiante = buscarEstudiantePorCedula(listaEstudiantesIngenieria, cedula);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return listaPC;
        }
        
        // Realizar préstamo
        computador.setDisponible(false);
        estudiante.setSerialComputador(serial);
        System.out.println("Computador prestado exitosamente a " + estudiante.getNombre());
        
        return listaPC;
    }

    // Método para modificar préstamo de computador portátil
    public LinkedList<ComputadorPortatil> modificarPrestamoComputadorPortatil(LinkedList<ComputadorPortatil> listaPC,
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        String cedula = validarCadena("Ingrese la cédula del estudiante a modificar: ");
        
        EstudianteIngenieria estudiante = buscarEstudiantePorCedula(listaEstudiantesIngenieria, cedula);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return listaPC;
        }
        
        if (estudiante.getSerialComputador() != null && !estudiante.getSerialComputador().isEmpty()) {
            ComputadorPortatil pcActual = buscarComputadorPorSerial(listaPC, estudiante.getSerialComputador());
            if (pcActual != null) {
                pcActual.setDisponible(true);
            }
        }
        
       
        String nuevoSerial = validarCadena("Ingrese el nuevo serial del computador: ");
        ComputadorPortatil nuevoPC = buscarComputadorPorSerial(listaPC, nuevoSerial);
        
        if (nuevoPC == null || !nuevoPC.isDisponible()) {
            System.out.println("Computador no disponible o serial incorrecto.");
            return listaPC;
        }
        
        nuevoPC.setDisponible(false);
        estudiante.setSerialComputador(nuevoSerial);
        System.out.println("Préstamo modificado exitosamente.");
        
        return listaPC;
    }

    // Método para devolver un computador portátil
    public LinkedList<ComputadorPortatil> devolverComputadorPortatil(LinkedList<ComputadorPortatil> listaPC,
            LinkedList<EstudianteIngenieria> listaEstudiantesIngenieria) {
        String serial = validarCadena("Ingrese el serial del computador a devolver: ");
        
        ComputadorPortatil computador = buscarComputadorPorSerial(listaPC, serial);
        if (computador == null) {
            System.out.println("Serial no encontrado.");
            return listaPC;
        }
        
        if (computador.isDisponible()) {
            System.out.println("Este computador ya está disponible.");
            return listaPC;
        }
        
        // Buscar estudiante que tiene prestado este computador
        EstudianteIngenieria estudiante = buscarEstudiantePorSerialComputador(listaEstudiantesIngenieria, serial);
        if (estudiante != null) {
            estudiante.setSerialComputador("");
        }
        
        computador.setDisponible(true);
        System.out.println("Computador devuelto exitosamente.");
        
        return listaPC;
    }

    // Método para buscar un computador portátil por serial
    public ComputadorPortatil buscarComputadorPortatil(LinkedList<ComputadorPortatil> lista) {
        String serial = validarCadena("Ingrese el serial del computador a buscar: ");
        ComputadorPortatil computador = buscarComputadorPorSerial(lista, serial);
        
        if (computador != null) {
            System.out.println("Computador encontrado:\n" + computador);
        } else {
            System.out.println("Serial no encontrado.");
        }
        
        return computador;
    }

    
    private ComputadorPortatil buscarComputadorPorSerial(LinkedList<ComputadorPortatil> lista, String serial) {
        for (ComputadorPortatil pc : lista) {
            if (pc.getSerial().equalsIgnoreCase(serial)) {
                return pc;
            }
        }
        return null;
    }

    private EstudianteIngenieria buscarEstudiantePorCedula(LinkedList<EstudianteIngenieria> lista, String cedula) {
        for (EstudianteIngenieria est : lista) {
            if (est.getCedula().equalsIgnoreCase(cedula)) {
                return est;
            }
        }
        return null;
    }

    private EstudianteIngenieria buscarEstudiantePorSerialComputador(LinkedList<EstudianteIngenieria> lista, String serial) {
        for (EstudianteIngenieria est : lista) {
            if (est.getSerialComputador() != null && est.getSerialComputador().equalsIgnoreCase(serial)) {
                return est;
            }
        }
        return null;
    }

    public void closeScanner() {
        sc.close();
    }
}