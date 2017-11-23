package view.productviews;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Product;
import view.MainView;

/**
 * Created by jeppe on 20-11-2017.
 */
public class ProductView {
    public static Stage productWindow;
    public static Scene productScene;

    public static void productScene(){

        //Hbox for search and dropdown
        HBox searchHbox = new HBox(15);
        //Setting up searchfield
        TextField searchTextField = new TextField();
        searchTextField.setId("searchbox");
        searchTextField.setPromptText("Søg...");
        //Setting up dropdown
        ComboBox<String> filterComboBox = new ComboBox<>(FXCollections.observableArrayList("Aktive", "Udgået", "Alle", "Kategori"));
        filterComboBox.setId("filter-dropdown");
        //Adding searchbox and dropdown to Hbox
        searchHbox.getChildren().addAll(searchTextField, filterComboBox);

        //Vbox for list, search and dropdown
        VBox listVbox = new VBox(15);
        //Creating TableView for products
        TableView<Product> productTableView = new TableView<>();
        //Creating columns for productListView
        TableColumn<Product, Integer> productIdColumn = new TableColumn<>("ID");
        TableColumn<Product, String> productNameColumn = new TableColumn<>("Produktnavn");
        TableColumn<Product, String> productNumberColumn = new TableColumn<>("Produktnummer");
        TableColumn<Product, String> eanNumberColumn = new TableColumn<>("EAN-nummer");
        TableColumn<Product, Double> wholeSaleColumn = new TableColumn<>("Kostpris");
        TableColumn<Product, Double> retailPriceColumn = new TableColumn<>("Udsalgspris");
        //Setting cell values to columns
        productIdColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getProductID()));
        productNameColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getProductName()));
        productNumberColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getProductNumber()));
        eanNumberColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getEanNumber()));
        wholeSaleColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getWholeSale()));
        retailPriceColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getRetailPrice()));
        //Setting width of columns
        productIdColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.10));
        productNameColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.25));
        productNumberColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.20));
        eanNumberColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.25));
        wholeSaleColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.10));
        retailPriceColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.10));
        //Adding columns to tableview
        productTableView.getColumns().addAll(productIdColumn, productNameColumn, productNumberColumn, eanNumberColumn, wholeSaleColumn, retailPriceColumn);
        //Adding searchHbox and tableview
        listVbox.getChildren().addAll(searchHbox, productTableView);

        //Vbox for right side buttons
        VBox buttonVbox = new VBox(15);
        buttonVbox.setPadding(new Insets(40, 0, 0, 0));
        //Creating buttons
        Button productButton = new Button("OPRET PRODUKT");
        Button detailsButton = new Button("DETALJER");
        //Specifying setOnAction for buttons
        productButton.setOnAction(e -> CreateProductView.createProductScene());
        //Setting ID for buttons
        productButton.setId("lager-button");
        detailsButton.setId("lager-button");
        //Adding buttons to vbox
        buttonVbox.getChildren().addAll(productButton, detailsButton);

        //Hbox for everything
        HBox allHbox = new HBox(15);
        allHbox.setPadding(new Insets(20, 0, 0, 0));
        allHbox.getChildren().addAll(listVbox, buttonVbox);
        allHbox.setAlignment(Pos.TOP_CENTER);

        productScene = new Scene(allHbox, 1240, 500);
        productScene.getStylesheets().add("styling/default.css");

        productWindow = new Stage();

        productWindow.initOwner(MainView.window);

        productWindow.setScene(productScene);
        productWindow.setTitle("LAGER");
        productWindow.show();

    }
}
