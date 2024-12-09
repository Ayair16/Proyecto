import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivo {

    // Leer archivo de texto y filtrar por semestre
    public static List<Materia> leerMateriasPorSemestre(String ruta, int semestre) throws IOException {
        List<Materia> materias = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",", 2);
            int semestreMateria = Integer.parseInt(datos[0].trim());
            String nombreMateria = datos[1].trim();
            if (semestreMateria == semestre) {
                materias.add(new Materia(semestreMateria, nombreMateria));
            }
        }
        br.close();
        return materias;
    }

    // Guardar materias en un archivo binario
    public static void guardarMateriasEnBinario(String ruta, List<Materia> materias) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
        oos.writeObject(materias);
        oos.close();
    }

    // Leer materias desde un archivo binario
    public static List<Materia> leerMateriasDesdeBinario(String ruta) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
        List<Materia> materias = (List<Materia>) ois.readObject();
        ois.close();
        return materias;
    }
}

