import java.sql.*;
import java.sql.Date;
import java.util.*;

public class GrupoFamiliarDAO {

    public List<GrupoFamiliar> listarPorFuncionario(int idFuncionario) throws DAOException {
        List<GrupoFamiliar> lista = new ArrayList<>();
        String sql = "SELECT * FROM grupo_familiar WHERE id_funcionario=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    GrupoFamiliar gf = new GrupoFamiliar();
                    gf.setId(rs.getInt("id"));
                    gf.setIdFuncionario(rs.getInt("id_funcionario"));
                    gf.setNombre(rs.getString("nombre"));
                    gf.setParentesco(rs.getString("parentesco"));
                    gf.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    lista.add(gf);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al listar grupo familiar", e);
        }
        return lista;
    }

    public void crear(GrupoFamiliar gf) throws DAOException {
        String sql = "INSERT INTO grupo_familiar (id_funcionario, nombre, parentesco, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, gf.getIdFuncionario());
            ps.setString(2, gf.getNombre());
            ps.setString(3, gf.getParentesco());
            ps.setDate(4, Date.valueOf(gf.getFechaNacimiento()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al crear grupo familiar", e);
        }
    }

    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM grupo_familiar WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar grupo familiar", e);
        }
    }
}

