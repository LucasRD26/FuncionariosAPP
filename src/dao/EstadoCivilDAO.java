import java.sql.*;
import java.util.*;

public class EstadoCivilDAO {

    public List<EstadoCivil> listar() throws DAOException {
        List<EstadoCivil> lista = new ArrayList<>();
        String sql = "SELECT * FROM estado_civil";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                EstadoCivil ec = new EstadoCivil();
                ec.setId(rs.getInt("id"));
                ec.setNombre(rs.getString("nombre"));
                lista.add(ec);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al listar estado civil", e);
        }
        return lista;
    }

    public EstadoCivil buscarPorId(int id) throws DAOException {
        String sql = "SELECT * FROM estado_civil WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    EstadoCivil ec = new EstadoCivil();
                    ec.setId(rs.getInt("id"));
                    ec.setNombre(rs.getString("nombre"));
                    return ec;
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al buscar estado civil", e);
        }
        return null;
    }
}
