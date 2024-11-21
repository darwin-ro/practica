import java.util.Scanner;

public class Universidad {
    private Semestre semestreActivo;  // El semestre actualmente activo
    private Scanner scanner;  // Para leer la entrada del usuario

    public Universidad() {
        this.scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú principal
    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestionar Semestre");
            System.out.println("2. Gestionar Cursos");
            System.out.println("3. Gestionar Estudiantes");
            System.out.println("4. Ver Información");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 5);
        System.out.println("Programa terminado.");
    }

    // Lee y convierte la opción seleccionada en un número entero
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida.");
            return -1;
        }
    }

    // Procesa las opciones del menú principal
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 : gestionarSemestre();
                break;
            case 2 : gestionarCursos();
                break;
            case 3 : gestionarEstudiantes();
                break;
            case 4 : mostrarInformacion();
                break;
            case 5 : System.out.println("Saliendo...");
                break;
            default : System.out.println("Opción no válida.");
            
        }
    }

    // Gestiona el submenú de semestre
    private void gestionarSemestre() {
        System.out.println("\n--- Gestión de Semestre ---");
        System.out.println("1. Crear un nuevo semestre");
        System.out.println("2. Cerrar el semestre actual");
        System.out.println("3. Volver al menú principal");
        int opcion = leerOpcion();

        switch (opcion) {
            case 1 : crearSemestre();
                break;
            case 2 : cerrarSemestre();
                break;
            case 3 : System.out.println("Regresando al menú principal...");
                break;
            default : System.out.println("Opción no válida.");
        }
    }

    // Crea un nuevo semestre
    private void crearSemestre() {
        if (semestreActivo != null && semestreActivo.isActivo()) {
            System.out.println("Ya hay un semestre activo.");
            return;
        }
        System.out.print("Año del semestre: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Periodo (1 o 2): ");
        int periodo = Integer.parseInt(scanner.nextLine());
        semestreActivo = new Semestre(year, periodo);
        System.out.println("Semestre creado.");
    }

    // Cierra el semestre activo
    private void cerrarSemestre() {
        if (semestreActivo != null && semestreActivo.isActivo()) {
            semestreActivo.cerrarSemestre();
            System.out.println("Semestre cerrado.");
        } else {
            System.out.println("No hay semestre activo.");
        }
    }

    // Gestiona el submenú de cursos
    private void gestionarCursos() {
        if (semestreActivo == null || !semestreActivo.isActivo()) {
            System.out.println("No hay semestre activo.");
            return;
        }
        System.out.println("\n--- Gestión de Cursos ---");
        System.out.println("1. Agregar un curso");
        System.out.println("2. Eliminar un curso");
        System.out.println("3. Volver al menú principal");
        int opcion = leerOpcion();

        switch (opcion) {
            case 1 : agregarCurso();
                break;
            case 2 : eliminarCurso();
                break;
            case 3 : System.out.println("Regresando al menú principal...");
                break;
            default : System.out.println("Opción no válida.");
        }
    }

    // Agrega un curso al semestre activo
    private void agregarCurso() {
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        semestreActivo.agregarCurso(new Curso(nombreCurso));
        System.out.println("Curso agregado.");
    }

    // Elimina un curso del semestre activo
    private void eliminarCurso() {
        System.out.print("Nombre del curso a eliminar: ");
        String nombreCurso = scanner.nextLine();
        if (semestreActivo.eliminarCurso(nombreCurso)) {
            System.out.println("Curso eliminado.");
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    // Gestiona el submenú de estudiantes
    private void gestionarEstudiantes() {
        if (semestreActivo == null || !semestreActivo.isActivo()) {
            System.out.println("No hay semestre activo.");
            return;
        }
        System.out.println("\n--- Gestión de Estudiantes ---");
        System.out.println("1. Agregar un estudiante a un curso");
        System.out.println("2. Eliminar un estudiante de un curso");
        System.out.println("3. Volver al menú principal");
        int opcion = leerOpcion();

        switch (opcion) {
            case 1 : agregarEstudiante();
                break;
            case 2 : eliminarEstudiante();
                break;
            case 3 : System.out.println("Regresando al menú principal...");
                break;
            default : System.out.println("Opción no válida.");
        }
    }

    // Agrega un estudiante a un curso
    private void agregarEstudiante() {
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        Curso curso = semestreActivo.getCursoPorNombre(nombreCurso);

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        System.out.print("Nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        curso.agregarEstudiante(new Estudiante(nombreEstudiante));
        System.out.println("Estudiante agregado.");
    }

    // Elimina un estudiante de un curso
    private void eliminarEstudiante() {
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        Curso curso = semestreActivo.getCursoPorNombre(nombreCurso);

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        System.out.print("Nombre del estudiante a eliminar: ");
        String nombreEstudiante = scanner.nextLine();
        if (curso.eliminarEstudiante(nombreEstudiante)) {
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // Muestra la información del semestre, cursos y estudiantes
    private void mostrarInformacion() {
        if (semestreActivo != null && semestreActivo.isActivo()) {
            System.out.println("Semestre activo: Año " + semestreActivo.getYear() + ", Periodo " + semestreActivo.getPeriodo());
            semestreActivo.mostrarCursos();
            for (Curso curso : semestreActivo.getCursos()) {
                curso.mostrarEstudiantes();
            }
        } else {
            System.out.println("No hay semestre activo.");
        }
    }
}
