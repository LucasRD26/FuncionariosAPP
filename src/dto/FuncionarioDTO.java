import java.time.LocalDate;
import java.util.List;

public class FuncionarioDTO {
    private int idFuncionario;
    private TipoDocumentoDTO tipoDocumento;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private EstadoCivilDTO estadoCivil;
    private String sexo;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private List<GrupoFamiliarDTO> grupoFamiliar;
    private List<FormacionAcademicaDTO> formacionAcademica;

    // Getters y Setters
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
    public EstadoCivilDTO getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivilDTO estadoCivil) {
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
    public List<GrupoFamiliarDTO> getGrupoFamiliar() {
        return grupoFamiliar;
    }
    public void setGrupoFamiliar(List<GrupoFamiliarDTO> grupoFamiliar) {
        this.grupoFamiliar = grupoFamiliar;
    }
    public List<FormacionAcademicaDTO> getFormacionAcademica() {
        return formacionAcademica;
    }
    public void setFormacionAcademica(List<FormacionAcademicaDTO> formacionAcademica) {
        this.formacionAcademica = formacionAcademica;
    }
}

