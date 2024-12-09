public class Materia implements java.io.Serializable {
    private int semestre;
    private String nombre;

    public Materia(int semestre, String nombre) {
        this.semestre = semestre;
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre; // Muestra el nombre de la materia
    }
}
