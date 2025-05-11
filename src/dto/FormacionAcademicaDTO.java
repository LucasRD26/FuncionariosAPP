import java.time.LocalDate;

public class FormacionAcademicaDTO {
    private int id;
    private String universidad;
    private String nivelEstudio;
    private String titulo;
    private LocalDate fechaGraduacion;

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUniversidad() {
        return universidad;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    public String getNivelEstudio() {
        return nivelEstudio;
    }
    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }
    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }
}

