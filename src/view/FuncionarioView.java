import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

public class FuncionarioView extends JFrame {
    private FuncionarioController controller;
    private JTable table;
    private DefaultTableModel tableModel;

    // Campos de entrada
    private JTextField txtId, txtTipoIdentificacion, txtNumeroIdentificacion, txtNombres, txtApellidos, txtEstadoCivil, txtSexo, txtDireccion, txtTelefono, txtFechaNacimiento;

    public FuncionarioView() {
        controller = new FuncionarioController();
        setTitle("Gestión de Funcionarios");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel de formulario
        JPanel panelForm = new JPanel(new GridLayout(10, 2));
        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        txtId.setEditable(false);
        panelForm.add(txtId);

        panelForm.add(new JLabel("Tipo Identificación (ID):"));
        txtTipoIdentificacion = new JTextField();
        panelForm.add(txtTipoIdentificacion);

        panelForm.add(new JLabel("Número Identificación:"));
        txtNumeroIdentificacion = new JTextField();
        panelForm.add(txtNumeroIdentificacion);

        panelForm.add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        panelForm.add(txtNombres);

        panelForm.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panelForm.add(txtApellidos);

        panelForm.add(new JLabel("Estado Civil (ID):"));
        txtEstadoCivil = new JTextField();
        panelForm.add(txtEstadoCivil);

        panelForm.add(new JLabel("Sexo (M/F/O):"));
        txtSexo = new JTextField();
        panelForm.add(txtSexo);

        panelForm.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelForm.add(txtDireccion);

        panelForm.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelForm.add(txtTelefono);

        panelForm.add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"));
        txtFechaNacimiento = new JTextField();
        panelForm.add(txtFechaNacimiento);

        // Panel de botones
        JPanel panelButtons = new JPanel();
        JButton btnCrear = new JButton("Crear");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar");
        panelButtons.add(btnCrear);
        panelButtons.add(btnActualizar);
        panelButtons.add(btnEliminar);
        panelButtons.add(btnLimpiar);

        // Tabla
        tableModel = new DefaultTableModel(new Object[]{"ID", "Tipo ID", "Número ID", "Nombres", "Apellidos", "Estado Civil", "Sexo", "Dirección", "Teléfono", "Fecha Nacimiento"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout principal
        setLayout(new BorderLayout());
        add(panelForm, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        // Listeners
        btnCrear.addActionListener(e -> crearFuncionario());
        btnActualizar.addActionListener(e -> actualizarFuncionario());
        btnEliminar.addActionListener(e -> eliminarFuncionario());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtId.setText(tableModel.getValueAt(row, 0).toString());
                    txtTipoIdentificacion.setText(tableModel.getValueAt(row, 1).toString());
                    txtNumeroIdentificacion.setText(tableModel.getValueAt(row, 2).toString());
                    txtNombres.setText(tableModel.getValueAt(row, 3).toString());
                    txtApellidos.setText(tableModel.getValueAt(row, 4).toString());
                    txtEstadoCivil.setText(tableModel.getValueAt(row, 5).toString());
                    txtSexo.setText(tableModel.getValueAt(row, 6).toString());
                    txtDireccion.setText(tableModel.getValueAt(row, 7).toString());
                    txtTelefono.setText(tableModel.getValueAt(row, 8).toString());
                    txtFechaNacimiento.setText(tableModel.getValueAt(row, 9).toString());
                }
            }
        });

        cargarFuncionarios();
    }

    private void cargarFuncionarios() {
        try {
            tableModel.setRowCount(0);
            List<Funcionario> lista = controller.listarFuncionarios();
            for (Funcionario f : lista) {
                tableModel.addRow(new Object[]{
                    f.getIdFuncionario(),
                    f.getTipoIdentificacion(),
                    f.getNumeroIdentificacion(),
                    f.getNombres(),
                    f.getApellidos(),
                    f.getEstadoCivil(),
                    f.getSexo(),
                    f.getDireccion(),
                    f.getTelefono(),
                    f.getFechaNacimiento()
                });
            }
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar funcionarios: " + ex.getMessage());
        }
    }

    private void crearFuncionario() {
        try {
            Funcionario f = new Funcionario();
            f.setTipoIdentificacion(Integer.parseInt(txtTipoIdentificacion.getText()));
            f.setNumeroIdentificacion(txtNumeroIdentificacion.getText());
            f.setNombres(txtNombres.getText());
            f.setApellidos(txtApellidos.getText());
            f.setEstadoCivil(Integer.parseInt(txtEstadoCivil.getText()));
            f.setSexo(txtSexo.getText());
            f.setDireccion(txtDireccion.getText());
            f.setTelefono(txtTelefono.getText());
            f.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText()));
            controller.crearFuncionario(f);
            cargarFuncionarios();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Funcionario creado correctamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear funcionario: " + ex.getMessage());
        }
    }

    private void actualizarFuncionario() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un funcionario para actualizar.");
            return;
        }
        try {
            Funcionario f = new Funcionario();
            f.setIdFuncionario(Integer.parseInt(txtId.getText()));
            f.setTipoIdentificacion(Integer.parseInt(txtTipoIdentificacion.getText()));
            f.setNumeroIdentificacion(txtNumeroIdentificacion.getText());
            f.setNombres(txtNombres.getText());
            f.setApellidos(txtApellidos.getText());
            f.setEstadoCivil(Integer.parseInt(txtEstadoCivil.getText()));
            f.setSexo(txtSexo.getText());
            f.setDireccion(txtDireccion.getText());
            f.setTelefono(txtTelefono.getText());
            f.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText()));
            controller.actualizarFuncionario(f);
            cargarFuncionarios();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Funcionario actualizado correctamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar funcionario: " + ex.getMessage());
        }
    }

    private void eliminarFuncionario() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un funcionario para eliminar.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este funcionario?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(txtId.getText());
                controller.eliminarFuncionario(id);
                cargarFuncionarios();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Funcionario eliminado correctamente.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar funcionario: " + ex.getMessage());
            }
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTipoIdentificacion.setText("");
        txtNumeroIdentificacion.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtEstadoCivil.setText("");
        txtSexo.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtFechaNacimiento.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FuncionarioView().setVisible(true);
        });
    }
}

