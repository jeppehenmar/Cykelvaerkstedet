package view.productviews;

import controllers.GUIController;
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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Constants;
import models.Product;
import view.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeppe on 20-11-2017.
 */
public class ProductView {
    public static Stage productWindow;
    public static Scene productScene;
    public static TableView productTableView;

    public static void productScene(GUIController controller){
        List<Product> productList = controller.getProductList();
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
        //Creating observableArrayList for TableView
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(productList);
        //Creating TableView for products
        productTableView = new TableView();
        productTableView.itemsProperty().setValue(productObservableList);
        //Creating columns for productListView
        TableColumn<Product, Integer> productIdColumn = new TableColumn<>("ID");
        TableColumn<Product, String> productNameColumn = new TableColumn<>("Produktnavn");
        TableColumn<Product, String> productNumberColumn = new TableColumn<>("Produktnummer");
        TableColumn<Product, String> eanNumberColumn = new TableColumn<>("EAN-nummer");
        TableColumn<Product, Double> wholeSaleColumn = new TableColumn<>("Kostpris");
        TableColumn<Product, Double> retailPriceColumn = new TableColumn<>("Udsalgspris");
        TableColumn<Product, Integer> inStockColumn = new TableColumn<>("Beholdning");
        //Setting cell values to columns
        productIdColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getProductID()));
        productNameColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getProductName()));
        productNumberColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getProductNumber()));
        eanNumberColumn.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getEanNumber()));
        wholeSaleColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getWholeSale()));
        retailPriceColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getRetailPrice()));
        inStockColumn.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue().getInStock()));
        //Setting width of columns
        productIdColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.05));
        productNameColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.25));
        productNumberColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.25));
        eanNumberColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.15));
        wholeSaleColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.1));
        retailPriceColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.1));
        inStockColumn.prefWidthProperty().bind(productTableView.widthProperty().multiply(0.098));
        //Setting text alignment for selected columns
        productIdColumn.setStyle("-fx-alignment: CENTER");
        //eanNumberColumn.setStyle("-fx-alignment: CENTER");
        wholeSaleColumn.setStyle("-fx-alignment: CENTER");
        retailPriceColumn.setStyle("-fx-alignment: CENTER");
        inStockColumn.setStyle("-fx-alignment: CENTER");
        //Adding columns to tableview
        productTableView.getColumns().addAll(productIdColumn, productNameColumn, productNumberColumn, eanNumberColumn, wholeSaleColumn, retailPriceColumn, inStockColumn);
        //Adding searchHbox and tableview
        listVbox.getChildren().addAll(searchHbox, productTableView);

        //Vbox for right side delete button
        VBox deleteButtonVbox = new VBox(10);
        deleteButtonVbox.setPadding(new Insets(250, 0, 0, 0));
        //Creating button
        Button deleteButton = new Button("SLET");
        //Specifying setOnAction for deleteButton
        deleteButton.setOnAction(e -> {
            Stage popUpWindow = new Stage();
            VBox allVbox = new VBox(10);
            allVbox.setPadding(new Insets(0, 0, 25, 0));
            HBox textHbox = new HBox(10);
            textHbox.setAlignment(Pos.CENTER);
            Text popUpText = new Text("Vil du slette det valgte produkt permanent?");
            popUpText.setId("popup-text");
            textHbox.getChildren().addAll(popUpText);
            HBox buttonHbox = new HBox(10);
            buttonHbox.setAlignment(Pos.CENTER);
            Button yesButton = new Button("JA");
            yesButton.setId("lager-button");
            yesButton.setOnAction(event -> {
                controller.deleteProduct((Product)productTableView.getSelectionModel().getSelectedItem());
                productObservableList.remove(productTableView.getSelectionModel().getSelectedItem());
                productTableView.refresh();
                popUpWindow.close();
            });
            Button noButton = new Button("NEJ");
            noButton.setId("lager-button");
            noButton.setOnAction(event -> popUpWindow.close());
            buttonHbox.getChildren().addAll(yesButton, noButton);
            allVbox.getChildren().addAll(textHbox, buttonHbox);
            allVbox.setAlignment(Pos.CENTER);
            Scene popUpScene = new Scene(allVbox, 400, 155);
            popUpScene.getStylesheets().add("styling/default.css");
            popUpWindow.initModality(Modality.APPLICATION_MODAL);
            popUpWindow.initOwner(productWindow);
            popUpWindow.setScene(popUpScene);
            popUpWindow.setTitle("placeholder");
            popUpWindow.show();

        });
        //Setting ID for button
        deleteButton.setId("warning-button");
        //Add button to Vbox
        deleteButtonVbox.getChildren().addAll(deleteButton);

        //Vbox for right side buttons
        VBox buttonVbox = new VBox(15);
        buttonVbox.setPadding(new Insets(40, 0, 0, 0));
        //Creating buttons
        Button productButton = new Button("OPRET PRODUKT");
        Button detailsButton = new Button("DETALJER");
        //Specifying setOnAction for buttons
        productButton.setOnAction(e -> CreateProductView.createProductScene());
        detailsButton.setOnAction(event -> UpdateProductView.updateProductScene((Product)productTableView.getSelectionModel().getSelectedItem()));
        //Setting ID for buttons
        productButton.setId("lager-button");
        detailsButton.setId("lager-button");
        //Adding buttons to vbox
        buttonVbox.getChildren().addAll(productButton, detailsButton, deleteButtonVbox);

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
