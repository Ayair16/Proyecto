public class Estudiante {
    private String nombre;
    private String matricula;
    private String carrera;
    private int semestre;

    public Estudiante(String nombre, String matricula, String carrera, int semestre) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}

