public class EstudianteIngenieria {

    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private int Semestre;
    private double Promedio;
    private String SerialComputador; // Serial del equipo prestado

    public EstudianteIngenieria() {

    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int semestre) {
        Semestre = semestre;
    }

    public double getPromedio() {
        return Promedio;
    }

    public void setPromedio(double promedio) {
        Promedio = promedio;
    }

    public String getSerialComputador() {
        return SerialComputador;
    }

    public void setSerialComputador(String serialComputador) {
        SerialComputador = serialComputador;
    }

    @Override
    public String toString() {
        return "EstudianteIngenieria [Cedula=" + Cedula + ", Nombre=" + Nombre + ", Apellido=" + Apellido
                + ", Telefono=" + Telefono + ", Semestre=" + Semestre + ", Promedio=" + Promedio
                + ", SerialComputador=" + SerialComputador + "]";
    }

}
