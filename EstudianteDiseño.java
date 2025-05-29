public class EstudianteDiseño {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modalidadEstudio;
    private int cantidadAsignaturas;
    private String serialEquipo; // Serial de la tableta prestada

    public EstudianteDiseño() {
        
    }
    public EstudianteDiseño(String cedula, String nombre, String apellido, String telefono, String modalidadEstudio,
            int cantidadAsignaturas, String serialEquipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidadEstudio = modalidadEstudio;
        this.cantidadAsignaturas = cantidadAsignaturas;
        this.serialEquipo = serialEquipo;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public int getCantidadAsignaturas() {
        return cantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        this.cantidadAsignaturas = cantidadAsignaturas;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        this.serialEquipo = serialEquipo;
    }

    @Override
    public String toString() {
        return "Estudiante de Diseño:\n" +
                "  Cédula: " + cedula + "\n" +
                "  Nombre: " + nombre + "\n" +
                "  Apellido: " + apellido + "\n" +
                "  Teléfono: " + telefono + "\n" +
                "  Modalidad: " + modalidadEstudio + "\n" +
                "  Asignaturas: " + cantidadAsignaturas + "\n" +
                "  Serial Equipo: " + serialEquipo;
    }
}


