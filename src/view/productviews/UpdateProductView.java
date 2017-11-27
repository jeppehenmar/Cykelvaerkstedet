package view.productviews;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Product;

/**
 * Created by jeppe on 20-11-2017.
 */
public class UpdateProductView {

    private static Stage updateProductWindow;
    private static Scene updateProductScene;

    public static void updateProductScene(Product product){
        //Vbox for left textfields and text
        VBox leftFieldsVbox = new VBox(10);
        //Creating left textfields
        TextField productIdTextField = new TextField(Integer.toString(product.getProductID()));
        TextField productNameTextField = new TextField(product.getProductName());
        TextField productNumberTextField = new TextField(product.getProductNumber());
        //Setting prompt text for fields
        productIdTextField.setPromptText("Produkt ID");
        productNameTextField.setPromptText("Produktnavn");
        productNumberTextField.setPromptText("Produktnummer");
        //Creating labels for left textfields
        Text productIdText = new Text("Produkt ID:");
        Text productNameText = new Text("Produktnavn:");
        Text productNumberText = new Text("Produktnummer:");
        //Setting id for labels
        productIdText.setId("product-label");
        productNameText.setId("product-label");
        productNumberText.setId("product-label");
        leftFieldsVbox.getChildren().addAll(productIdText, productIdTextField, productNameText, productNameTextField, productNumberText, productNumberTextField);

        VBox rightFieldsVbox = new VBox(10);
        //Creating right textfields
        TextField eanNumberTextField = new TextField(product.getEanNumber());
        TextField wholeSaleTextField = new TextField(Double.toString(product.getWholeSale()));
        TextField retailPriceTextField = new TextField(Double.toString(product.getRetailPrice()));
        //Setting prompt text for fields
        eanNumberTextField.setPromptText("EAN-nummer");
        wholeSaleTextField.setPromptText("Indkøbspris");
        retailPriceTextField.setPromptText("Salgspris");
        //Creating labels for right textfields
        Text eanNumberText = new Text("EAN-nummer:");
        Text wholeSaleText = new Text("Indkøbspris:");
        Text retailPriceText = new Text("Salgspris:");
        //Setting id for labels
        eanNumberText.setId("product-label");
        wholeSaleText.setId("product-label");
        retailPriceText.setId("product-label");
        //Adding right textfields and labels to right Vbox
        rightFieldsVbox.getChildren().addAll(eanNumberText, eanNumberTextField, wholeSaleText, wholeSaleTextField, retailPriceText, retailPriceTextField);

        //Creating Hbox for all textfields
        HBox textFieldsHbox = new HBox(15);
        //Setting alignment for textfields
        textFieldsHbox.setAlignment(Pos.TOP_CENTER);
        //Adding left and right hboxes to vbox
        textFieldsHbox.getChildren().addAll(leftFieldsVbox, rightFieldsVbox);

        //Hbox for edit button
        HBox editHbox = new HBox(10);
        editHbox.setPadding(new Insets(0, 0, 0, 55));
        //Creating button
        CheckBox editCheckBox = new CheckBox("Lås");
        editCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                productIdTextField.setEditable(oldValue);
                productNameTextField.setEditable(oldValue);
                productNumberTextField.setEditable(oldValue);
                eanNumberTextField.setEditable(oldValue);
                wholeSaleTextField.setEditable(oldValue);
                retailPriceTextField.setEditable(oldValue);
            }
        });
        editHbox.getChildren().addAll(editCheckBox);

        //Creating Hbox for bottom buttons
        HBox buttonsHbox = new HBox(15);
        //Setting alignment of buttonsHbox
        buttonsHbox.setAlignment(Pos.CENTER);
        //Setting padding for buttonsHbox
        buttonsHbox.setPadding(new Insets(20, 0, 0, 0));
        //Creating buttons
        Button saveButton = new Button("GEM");
        Button cancelButton = new Button("ANNULLÉR");
        //Setting id's for buttons
        saveButton.setId("lager-button");
        cancelButton.setId("warning-button");
        //Specifying setOnAction for buttons
        saveButton.setOnAction(e -> {
           product.setProductID(Integer.parseInt(productIdTextField.getText()));
           product.setProductName(productNameTextField.getText());
           product.setProductNumber(productNumberText.getText());
           product.setEanNumber(eanNumberTextField.getText());
           product.setWholeSale(Double.parseDouble(wholeSaleTextField.getText()));
           product.setRetailPrice(Double.parseDouble(retailPriceTextField.getText()));

           ProductView.productTableView.refresh();
           updateProductWindow.close();
        });
        cancelButton.setOnAction(e -> updateProductWindow.close());
        //Adding buttons to vbox
        buttonsHbox.getChildren().addAll(saveButton, cancelButton);

        //Creating vbox for everything
        VBox allVbox = new VBox(15);
        allVbox.setPadding(new Insets(30, 0, 50, 0));
        //Adding everything to allVbox
        allVbox.getChildren().addAll(editHbox, textFieldsHbox, buttonsHbox);

        updateProductScene = new Scene(allVbox, 500, 400);
        updateProductScene.getStylesheets().add("styling/default.css");

        updateProductWindow = new Stage();

        updateProductWindow.initModality(Modality.APPLICATION_MODAL);
        updateProductWindow.initOwner(ProductView.productWindow);

        updateProductWindow.setScene(updateProductScene);
        updateProductWindow.setTitle("Nyt produkt");
        updateProductWindow.show();
    }
}
