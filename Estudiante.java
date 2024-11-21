public class Estudiante {
    private String nombre;  // Almacena el nombre del estudiante

    // Constructor para inicializar el estudiante con su nombre
    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el nombre del estudiante
    public String getNombre() {
        return nombre;
    }

    // Método para mostrar la información del estudiante
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
    }
}
