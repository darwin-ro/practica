import java.util.Iterator;
import java.util.ArrayList;

public class Curso {
    private String nombre;  // Nombre del curso
    private ArrayList<Estudiante> estudiantes;  // Lista de estudiantes en el curso

    // Constructor que inicializa el curso con el nombre
    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<Estudiante>();
    }

    // Método para obtener el nombre del curso
    public String getNombre() {
        return nombre;
    }

    // Método para agregar un estudiante al curso
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Método para eliminar un estudiante por nombre
    public boolean eliminarEstudiante(String nombreEstudiante) {
        // Use an iterator to remove elements by name
        for (Iterator<Estudiante> iterator = estudiantes.iterator(); iterator.hasNext(); ) {
            Estudiante est = iterator.next();
            if (est.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                iterator.remove();
                return true; // Student removed successfully
            }
        }
        return false; // Student not found
    }
    

    // Método para mostrar la lista de estudiantes en el curso
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en este curso.");
        } else {
            System.out.println("Estudiantes en el curso " + nombre + ":");
            for (Estudiante estudiante : estudiantes) {
                System.out.println("  - " + estudiante.getNombre());
            }
        }
    }

    // Método para obtener la lista de estudiantes (si se requiere en otras clases)
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
