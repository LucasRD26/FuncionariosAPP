import java.sql.*;
import java.util.*;

public class TipoDocumentoDAO {

    public List<TipoDocumento> listar() throws DAOException {
        List<TipoDocumento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_documento";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoDocumento td = new TipoDocumento();
                td.setId(rs.getInt("id"));
                td.setTipo(rs.getString("tipo"));
                lista.add(td);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al listar tipo de documento", e);
        }
        return lista;
    }

    public TipoDocumento buscarPorId(int id) throws DAOException {
        String sql = "SELECT * FROM tipo_documento WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TipoDocumento td = new TipoDocumento();
                    td.setId(rs.getInt("id"));
                    td.setTipo(rs.getString("tipo"));
                    return td;
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al buscar tipo de documento", e);
        }
        return null;
    }
}

