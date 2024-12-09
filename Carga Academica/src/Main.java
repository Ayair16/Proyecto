import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String rutaTexto = "/Users/ayair/Documents/Tareas Itics/materias.txt/";
        String rutaBinario = "/Users/ayair/Documents/Tareas Itics";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del estudiante:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();

        Estudiante estudiante = new Estudiante(nombre, matricula, carrera, semestre);

        System.out.println("\nInformación del estudiante:");
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Matrícula: " + estudiante.getMatricula());
        System.out.println("Carrera: " + estudiante.getCarrera());
        System.out.println("Semestre: " + estudiante.getSemestre());

        try {
            // Leer y mostrar materias del semestre
            System.out.println("\nMaterias del semestre " + semestre + ":");
            List<Materia> materias = GestorArchivo.leerMateriasPorSemestre(rutaTexto, semestre);
            if (materias.isEmpty()) {
                System.out.println("No se encontraron materias para el semestre " + semestre);
            } else {
                materias.forEach(System.out::println);

                // Guardar materias en archivo binario
                System.out.println("\nGuardando materias en archivo binario...");
                GestorArchivo.guardarMateriasEnBinario(rutaBinario, materias);

                // Leer materias desde archivo binario
                System.out.println("\nLeyendo materias desde archivo binario...");
                List<Materia> materiasBinario = GestorArchivo.leerMateriasDesdeBinario(rutaBinario);
                materiasBinario.forEach(System.out::println);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

