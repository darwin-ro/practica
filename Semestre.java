// Semestre.java

import java.util.ArrayList;

public class Semestre {
    private int year;           // Año del semestre
    private int periodo;        // Periodo del semestre (1 o 2)
    private boolean activo;     // Indica si el semestre está activo
    private ArrayList<Curso> cursos; // Lista de cursos en el semestre

    // Constructor que inicializa el semestre con el año y el periodo
    public Semestre(int year, int periodo) {
        this.year = year;
        this.periodo = periodo;
        this.activo = true;         // Inicialmente el semestre está activo
        this.cursos = new ArrayList<Curso>(); // Inicializa la lista de cursos
    }

    // Método para verificar si el semestre está activo
    public boolean isActivo() {
        return activo;
    }

    // Método para cerrar el semestre
    public void cerrarSemestre() {
        this.activo = false;
    }

    // Método para agregar un curso al semestre
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    // Método para eliminar un curso por nombre
    public boolean eliminarCurso(String nombreCurso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getNombre().equalsIgnoreCase(nombreCurso)) {
                cursos.remove(i);
                return true; 
            }
        }
        return false; 
    }

    // Método para mostrar los cursos del semestre
    public void mostrarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            System.out.println("Cursos en el semestre:");
            for (Curso curso : cursos) {
                System.out.println("  - " + curso.getNombre());
            }
        }
    }

    // Método para obtener un curso por nombre
    public Curso getCursoPorNombre(String nombreCurso) {
        for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                return curso;
            }
        }
        return null;  // Devuelve null si el curso no existe
    }

    // Método para obtener el año del semestre
    public int getYear() {
        return year;
    }

    // Método para obtener el periodo del semestre
    public int getPeriodo() {
        return periodo;
    }

    // Método para obtener la lista de cursos
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}
