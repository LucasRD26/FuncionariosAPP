import java.time.LocalDate;
import java.util.List;

public class Funcionario {
    private int idFuncionario;
    private int tipoIdentificacion; // FK a TipoDocumento
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private int estadoCivil; // FK a EstadoCivil
    private String sexo;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;

    // Relaciones opcionales (no obligatorias para el CRUD básico)
    private List<GrupoFamiliar> grupoFamiliar;
    private List<FormacionAcademica> formacionAcademica;

    // Getters y Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }
    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public List<GrupoFamiliar> getGrupoFamiliar() {
        return grupoFamiliar;
    }
    public void setGrupoFamiliar(List<GrupoFamiliar> grupoFamiliar) {
        this.grupoFamiliar = grupoFamiliar;
    }
    public List<FormacionAcademica> getFormacionAcademica() {
        return formacionAcademica;
    }
    public void setFormacionAcademica(List<FormacionAcademica> formacionAcademica) {
        this.formacionAcademica = formacionAcademica;
    }
}

