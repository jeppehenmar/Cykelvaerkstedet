package view.productviews;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by jeppe on 20-11-2017.
 */
public class CreateProductView {
    private static Stage createProductWindow;
    private static Scene createProductScene;

    public static void createProductScene(){
        VBox leftFieldsVbox = new VBox(10);
        //Creating left textfields
        TextField productIdTextField = new TextField();
        TextField productNameTextField = new TextField();
        TextField productNumberTextField = new TextField();
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
        //Adding left textfields and labels to left Vbox
        leftFieldsVbox.getChildren().addAll(productIdText, productIdTextField, productNameText, productNameTextField, productNumberText, productNumberTextField);

        VBox rightFieldsVbox = new VBox(10);
        //Creating right textfields
        TextField eanNumberTextField = new TextField();
        TextField wholeSaleTextField = new TextField();
        TextField retailPriceTextField = new TextField();
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

        //Creating Hbox for bottom buttons
        HBox buttonsHbox = new HBox(15);
        //Setting alignment of buttonsHbox
        buttonsHbox.setAlignment(Pos.CENTER);
        //Setting padding for buttonsHbox
        buttonsHbox.setPadding(new Insets(40, 0, 0, 0));
        //Creating buttons
        Button saveButton = new Button("GEM");
        Button cancelButton = new Button("ANNULLÉR");
        //Setting id's for buttons
        saveButton.setId("lager-button");
        cancelButton.setId("lager-button");
        //Specifying setOnAction for buttons
        cancelButton.setOnAction(e -> createProductWindow.close());
        //Adding buttons to vbox
        buttonsHbox.getChildren().addAll(saveButton, cancelButton);

        //Creating vbox for everything
        VBox allVbox = new VBox(15);
        allVbox.setPadding(new Insets(50, 0, 50, 0));
        //Adding everything to allVbox
        allVbox.getChildren().addAll(textFieldsHbox, buttonsHbox);

        createProductScene = new Scene(allVbox, 500, 400);
        createProductScene.getStylesheets().add("styling/default.css");

        createProductWindow = new Stage();

        createProductWindow.initModality(Modality.APPLICATION_MODAL);
        createProductWindow.initOwner(ProductView.productWindow);

        createProductWindow.setScene(createProductScene);
        createProductWindow.setTitle("Nyt produkt");
        createProductWindow.show();
    }
}
