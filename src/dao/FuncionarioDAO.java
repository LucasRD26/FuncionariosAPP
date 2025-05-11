import java.sql.*;
import java.sql.Date;
import java.util.*;

public class FuncionarioDAO {

    public List<Funcionario> listar() throws DAOException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("id_funcionario"));
                f.setTipoIdentificacion(rs.getInt("tipo_identificacion"));
                f.setNumeroIdentificacion(rs.getString("numero_identificacion"));
                f.setNombres(rs.getString("nombres"));
                f.setApellidos(rs.getString("apellidos"));
                f.setEstadoCivil(rs.getInt("estado_civil"));
                f.setSexo(rs.getString("sexo"));
                f.setDireccion(rs.getString("direccion"));
                f.setTelefono(rs.getString("telefono"));
                f.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                lista.add(f);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al listar funcionarios", e);
        }
        return lista;
    }

    public void crear(Funcionario f) throws DAOException {
        String sql = "INSERT INTO funcionario (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, f.getTipoIdentificacion());
            ps.setString(2, f.getNumeroIdentificacion());
            ps.setString(3, f.getNombres());
            ps.setString(4, f.getApellidos());
            ps.setInt(5, f.getEstadoCivil());
            ps.setString(6, f.getSexo());
            ps.setString(7, f.getDireccion());
            ps.setString(8, f.getTelefono());
            ps.setDate(9, Date.valueOf(f.getFechaNacimiento()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al crear funcionario", e);
        }
    }

    public void actualizar(Funcionario f) throws DAOException {
        String sql = "UPDATE funcionario SET tipo_identificacion=?, numero_identificacion=?, nombres=?, apellidos=?, estado_civil=?, sexo=?, direccion=?, telefono=?, fecha_nacimiento=? WHERE id_funcionario=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, f.getTipoIdentificacion());
            ps.setString(2, f.getNumeroIdentificacion());
            ps.setString(3, f.getNombres());
            ps.setString(4, f.getApellidos());
            ps.setInt(5, f.getEstadoCivil());
            ps.setString(6, f.getSexo());
            ps.setString(7, f.getDireccion());
            ps.setString(8, f.getTelefono());
            ps.setDate(9, Date.valueOf(f.getFechaNacimiento()));
            ps.setInt(10, f.getIdFuncionario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar funcionario", e);
        }
    }

    public void eliminar(int idFuncionario) throws DAOException {
        String sql = "DELETE FROM funcionario WHERE id_funcionario=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar funcionario", e);
        }
    }

    public Funcionario buscarPorId(int idFuncionario) throws DAOException {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setIdFuncionario(rs.getInt("id_funcionario"));
                    f.setTipoIdentificacion(rs.getInt("tipo_identificacion"));
                    f.setNumeroIdentificacion(rs.getString("numero_identificacion"));
                    f.setNombres(rs.getString("nombres"));
                    f.setApellidos(rs.getString("apellidos"));
                    f.setEstadoCivil(rs.getInt("estado_civil"));
                    f.setSexo(rs.getString("sexo"));
                    f.setDireccion(rs.getString("direccion"));
                    f.setTelefono(rs.getString("telefono"));
                    f.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                    return f;
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al buscar funcionario", e);
        }
        return null;
    }
}

