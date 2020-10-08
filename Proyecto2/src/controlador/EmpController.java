package controlador;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Empresa;

public class EmpController implements Initializable {

    @FXML
    private Button btnAtras;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtDescuento;
    @FXML
    private TableView<Empresa> tabla;
    @FXML
    private TableColumn<Empresa, Integer> colId;
    @FXML
    private TableColumn<Empresa, String> colNombre;
    @FXML
    private TableColumn<Empresa, String> colTelefono;
    @FXML
    private TableColumn<Empresa, String> colContacto;
    @FXML
    private TableColumn<Empresa, Integer> colDescuento;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnNuevo;
    @FXML
    private TableColumn<Empresa, String> colDireccion;

    /**
     * Initializes the controller class.
     */
    @Override
    /*
    esta funcion permite mostrar  los datos  de la empresa*/
    
    public void initialize(URL url, ResourceBundle rb) {
        mostrarEmpresas();
    }

   /*esta funcion permite  actualizar los datos registrados  en la emprea*/

    @FXML
    private void actualizar(ActionEvent event) {
        int posicion = 0;
        try {
            Empresa empresa = new Empresa(txtContacto.getText(), Integer.parseInt(txtDescuento.getText()),
                    txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), "empresa");
            for (Cliente cliente : SesionController.clientes) {
                if (Integer.parseInt(txtId.getText()) == cliente.getId()) {
                    posicion = SesionController.clientes.indexOf(cliente);
                    break;
                }
            }
            empresa.setId(Integer.parseInt(txtId.getText()));
            SesionController.clientes.set(posicion, empresa);
            Cliente.sigIdCliente--;
            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO", "ACTUALIZAR REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR, NO SE PUDO ACTUALIZAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }
/*Evento eliminar   un registro  de los empleados*/
    @FXML
    private void eliminar(ActionEvent event) {
        int posicion = 0;
        try {
            for (Cliente c : SesionController.clientes) {
                if (Integer.parseInt(txtId.getText()) == c.getId()) {
                    posicion = SesionController.clientes.indexOf(c);
                    break;
                }
            }
            SesionController.clientes.remove(posicion);
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO", "ElIMINAR REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, NO SE PUDO ELIMINAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

    public ObservableList<Empresa> getEmpresas() {
        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList();

        for (Cliente c : SesionController.clientes) {
            if (c.getTipoCliente().equals("empresa")) {
                Empresa e = (Empresa) c;
                listaEmpresas.add(e);
            }
        }
        return listaEmpresas;
    }
/*esta funcion permite agregar nuevos clientes a la empresa*/
    public void mostrarEmpresas() {
        ObservableList<Empresa> list = getEmpresas();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colContacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        colDescuento.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tabla.setItems(list);
    }
/*permite cerrar la ventanilla de  gestion empresas*/
    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
            Parent root = loader.load();
            ClienteController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    /* Este evento permite regresar a la ventanilla gestion glientes*/
    private void atras(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
            Parent root = loader.load();
            ClienteController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {

        }
    }

    @FXML
    /*permite modificar los reistros de los clinetes empresa*/
    private void click(MouseEvent event) {
        Empresa empresa = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(empresa.getId()));
        txtNombre.setText(empresa.getNombre());
        txtContacto.setText(empresa.getContacto());
        txtDescuento.setText(String.valueOf(empresa.getDescuento()));
        txtDireccion.setText(empresa.getDireccion());
        txtTelefono.setText(empresa.getTelefono());
    }

    /* permite limpiar los campos  para poder ingresar nuevos datos}*/
    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtContacto.setText("");
        txtDescuento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }

    @FXML
    /*permite agregar un nuevo cliente al registro de la empresa*/
    private void nuevo(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    /*registra    un nuevo cliente empresarial al registro*/
    private void registrarEmpresa(ActionEvent event) {
        try {
            Empresa empresa = new Empresa(txtContacto.getText(), Integer.parseInt(txtDescuento.getText()),
                    txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), "empresa");
            SesionController.clientes.add(empresa);
            JOptionPane.showMessageDialog(null, "REGISTRO OK!", "NUEVO REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, DATOS NO VALIDOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }
}
