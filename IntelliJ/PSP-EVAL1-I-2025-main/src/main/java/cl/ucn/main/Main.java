package cl.ucn.main;

import cl.ucn.config.ConfiguracionSistema;
import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.GerenciadorDescuento;
import cl.ucn.modelo.Producto;
import cl.ucn.proxy.ClienteProxy;
import cl.ucn.proxy.IClienteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;

public class Main extends Application {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bazar");
    private final EntityManager em = emf.createEntityManager();
    private final IClienteDAO clienteProxy = new ClienteProxy(em);
    private final ConfiguracionSistema config = ConfiguracionSistema.getInstance();
    private final GerenciadorDescuento gerenciadorDescuento = new GerenciadorDescuento();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cálculo de Descuentos");

        // Cliente ComboBox setup
        Text clienteLbl = new Text("Cliente: ");
        ComboBox<Cliente> comboBox = new ComboBox<>();

        comboBox.getItems().addAll(clienteProxy.getClientes());
        setupComboBoxCellFactory(comboBox);

        // Client info fields
        Text fechaNacimientoClienteLbl = new Text("Fecha Nacimiento: ");
        TextField fechaNacimientoTxt = new TextField();
        fechaNacimientoTxt.setEditable(true);

        Text anhoRegistroLbl = new Text("Cliente desde: ");
        TextField anhoRegistroTxt = new TextField();
        anhoRegistroTxt.setEditable(true);

        Text fechaActualLbl = new Text("Fecha de Hoy: ");
        TextField fechaActualTxt = new TextField();
        fechaActualTxt.setText(config.getFechaActual());
        fechaActualTxt.setEditable(true);

        // Table setup
        Text tableLbl = new Text("Lista de Productos Comprados");
        TableView<Producto> table = setupProductTable();

        // Discount fields
        Text precioInicialLbl = new Text("Precio Inicial");
        TextField precioInicialTxt = new TextField();
        precioInicialTxt.setEditable(true);

        Text descuentoFidelidadLbl = new Text("Desc. Fidelidad");
        TextField descuentoFidelidadTxt = new TextField();
        descuentoFidelidadTxt.setEditable(true);

        Text descuentoCumpleanhosLbl = new Text("Desc. Cumpleaños");
        TextField descuentoCumpleanhosTxt = new TextField();
        descuentoCumpleanhosTxt.setEditable(true);

        Text descuentoCatergoriaLbl = new Text("Desc. Catergoria");
        TextField descuentoCatergoriaTxt = new TextField();
        descuentoCatergoriaTxt.setEditable(true);

        Text descuentoProductosLbl = new Text("Desc. Productos");
        TextField descuentoProductosTxt = new TextField();
        descuentoProductosTxt.setEditable(true);

        Text precioFinalLbl = new Text("Precio Final");
        TextField precioFinalTxt = new TextField();
        precioFinalTxt.setEditable(true);

        // Calculate button
        Button calcularDescuentoBtn = new Button("Calcular Descuento");
        calcularDescuentoBtn.setOnAction(event -> {
            Cliente clienteSeleccionado = comboBox.getValue();
            if (clienteSeleccionado != null) {
                List<Producto> productos = clienteProxy.getProductosByRut(clienteSeleccionado.getRut());
                List<Integer> precios = gerenciadorDescuento.calcularPrecioFinal(
                        productos,
                        clienteSeleccionado,
                        config.getFechaActual()
                );

                precioInicialTxt.setText(String.valueOf(precios.get(0)));
                descuentoFidelidadTxt.setText(String.valueOf(precios.get(1)));
                descuentoCumpleanhosTxt.setText(String.valueOf(precios.get(2)));
                descuentoCatergoriaTxt.setText(String.valueOf(precios.get(3)));
                descuentoProductosTxt.setText(String.valueOf(precios.get(4)));
                precioFinalTxt.setText(String.valueOf(precios.get(5)));
            }
        });

        // ComboBox event handler
        comboBox.setOnAction(event -> {
            Cliente selectedCliente = comboBox.getSelectionModel().getSelectedItem();
            if (selectedCliente != null) {
                Cliente cliente = clienteProxy.getCliente(selectedCliente.getRut());
                List<Producto> productos = clienteProxy.getProductosByRut(cliente.getRut());
                fechaNacimientoTxt.setText(cliente.getFechaNacimiento());
                anhoRegistroTxt.setText(String.valueOf(cliente.getAnhoRegistro()));
                fillTableView(table, productos);
                clearDiscountFields(precioInicialTxt, descuentoFidelidadTxt,
                        descuentoCumpleanhosTxt, descuentoCatergoriaTxt,
                        descuentoProductosTxt, precioFinalTxt);
            }
        });

        // Layout setup
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(clienteLbl, 0, 0);
        gridPane.add(comboBox, 1, 0);
        gridPane.add(tableLbl, 0, 3);
        gridPane.add(fechaNacimientoClienteLbl, 2, 0);
        gridPane.add(fechaNacimientoTxt, 3, 0);
        gridPane.add(anhoRegistroLbl, 2, 1);
        gridPane.add(anhoRegistroTxt, 3, 1);
        gridPane.add(fechaActualLbl, 0, 2);
        gridPane.add(fechaActualTxt, 1, 2);

        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10));
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        gridPane2.add(precioInicialLbl, 0, 0);
        gridPane2.add(descuentoFidelidadLbl, 1, 0);
        gridPane2.add(descuentoCumpleanhosLbl, 2, 0);
        gridPane2.add(descuentoCatergoriaLbl, 3, 0);
        gridPane2.add(descuentoProductosLbl, 4, 0);
        gridPane2.add(precioFinalLbl, 6, 0);

        gridPane2.add(precioInicialTxt, 0, 1);
        gridPane2.add(descuentoFidelidadTxt, 1, 1);
        gridPane2.add(descuentoCumpleanhosTxt, 2, 1);
        gridPane2.add(descuentoCatergoriaTxt, 3, 1);
        gridPane2.add(descuentoProductosTxt, 4, 1);
        gridPane2.add(precioFinalTxt, 6, 1);

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setTop(gridPane);
        root.setCenter(table);
        root.setBottom(gridPane2);

        VBox container = new VBox();
        container.setPrefSize(100, 100);
        container.getChildren().add(root);
        container.getChildren().add(calcularDescuentoBtn);

        primaryStage.setScene(new Scene(container, 800, 800));
        primaryStage.show();
    }

    private void setupComboBoxCellFactory(ComboBox<Cliente> comboBox) {

        for(Cliente cliente : clienteProxy.getClientes()){
//            comboBox.getItems().add(cliente);
            System.out.println(cliente.getRut());
        }
        comboBox.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                setText(empty || cliente == null ? null : cliente.getNombre());
            }
        });
        comboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                setText(empty || cliente == null ? null : cliente.getNombre());
            }
        });
    }

    private TableView<Producto> setupProductTable() {
        TableView<Producto> table = new TableView<>();
        TableColumn<Producto, String> idCol = new TableColumn<>("Id");
        TableColumn<Producto, String> nombreCol = new TableColumn<>("Nombre");
        TableColumn<Producto, String> catCol = new TableColumn<>("Categoria");
        TableColumn<Producto, String> precioCol = new TableColumn<>("Precio");

        idCol.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        precioCol.setCellValueFactory(new PropertyValueFactory<>("precioProducto"));

        table.getColumns().addAll(idCol, nombreCol, catCol, precioCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        return table;
    }

    private void clearDiscountFields(TextField... fields) {
        for (TextField field : fields) {
            field.setText("");
        }
    }

    private void fillTableView(TableView<Producto> tableView, List<Producto> productos) {
        tableView.getItems().clear();
        tableView.getItems().addAll(productos);
    }

    @Override
    public void stop() {
        em.close();
        emf.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}