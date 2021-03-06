package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Producto;

public class GridProductoController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatos();
    }    

    @FXML
    private void regresar(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductoVista.fxml"));
            Parent root = loader.load();
            ProductoController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarDatos(){
        int f=0;
        int c=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("- PRODUCTOS");
         Text esp0 = new Text("_________________");
         grid.add(ini, c, f);
         grid.add(esp0, c, 1);
        f=2;
        for (Producto p : SesionController.productos) {
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(p.getId()));
                c=0;
                f++;
                grid.add(id, c, f);
                c++;
                grid.add(txtId, c, f);
                
                Text nombreC = new Text("NOMBRE: ");
                Text txtNombre = new Text(p.getNombre());
                c=0;
                f++;
                grid.add(nombreC, c, f);
                c++;
                grid.add(txtNombre, c, f);
                
                Text descripcion = new Text("DESCRIPCION: ");
                Text txtDescripcion = new Text(p.getDescripcion());
                c=0;
                f++;
                grid.add(descripcion, c, f);
                c++;
                grid.add(txtDescripcion, c, f);
                
                Text precio = new Text("PRECIO: ");
                Text txtPrecio = new Text(String.valueOf(p.getPrecio()));
                c=0;
                f++;
                grid.add(precio, c, f);
                c++;
                grid.add(txtPrecio, c, f);
                
                Text cantidad = new Text("CANTIDAD: ");
                Text txtCantidad = new Text(String.valueOf(p.getCantidad()));
                c=0;
                f++;
                grid.add(cantidad, c, f);
                c++;
                grid.add(txtCantidad, c, f);
                Text esp1 = new Text("_________________");
                c=0;
                f++;
                grid.add(esp1, c, f);
            
        }
    }
    public void closeWindows(){
        
    }
    
    
}
