import java.sql.*;
import java.sql.Date;
import java.util.*;

public class FormacionAcademicaDAO {

    public List<FormacionAcademica> listarPorFuncionario(int idFuncionario) throws DAOException {
        List<FormacionAcademica> lista = new ArrayList<>();
        String sql = "SELECT * FROM formacion_academica WHERE id_funcionario=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FormacionAcademica fa = new FormacionAcademica();
                    fa.setId(rs.getInt("id"));
                    fa.setIdFuncionario(rs.getInt("id_funcionario"));
                    fa.setUniversidad(rs.getString("universidad"));
                    fa.setNivelEstudio(rs.getString("nivel_estudio"));
                    fa.setTitulo(rs.getString("titulo"));
                    fa.setFechaGraduacion(rs.getDate("fecha_graduacion") != null ? rs.getDate("fecha_graduacion").toLocalDate() : null);
                    lista.add(fa);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al listar formación académica", e);
        }
        return lista;
    }

    public void crear(FormacionAcademica fa) throws DAOException {
        String sql = "INSERT INTO formacion_academica (id_funcionario, universidad, nivel_estudio, titulo, fecha_graduacion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fa.getIdFuncionario());
            ps.setString(2, fa.getUniversidad());
            ps.setString(3, fa.getNivelEstudio());
            ps.setString(4, fa.getTitulo());
            if (fa.getFechaGraduacion() != null) {
                ps.setDate(5, Date.valueOf(fa.getFechaGraduacion()));
            } else {
                ps.setNull(5, Types.DATE);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al crear formación académica", e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM formacion_academica WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar formación académica", e);
        }
    }
}
