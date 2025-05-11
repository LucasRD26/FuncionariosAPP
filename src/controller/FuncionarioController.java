import java.util.List;

public class FuncionarioController {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
    }

    public List<Funcionario> listarFuncionarios() throws DAOException {
        return funcionarioDAO.listar();
    }

    public void crearFuncionario(Funcionario funcionario) throws DAOException {
        funcionarioDAO.crear(funcionario);
    }

    public void actualizarFuncionario(Funcionario funcionario) throws DAOException {
        funcionarioDAO.actualizar(funcionario);
    }

    public void eliminarFuncionario(int idFuncionario) throws DAOException {
        funcionarioDAO.eliminar(idFuncionario);
    }

    public Funcionario buscarFuncionarioPorId(int idFuncionario) throws DAOException {
        return funcionarioDAO.buscarPorId(idFuncionario);
    }
}

