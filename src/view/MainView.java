package view;

import controllers.GUIController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.productviews.ProductView;

public class MainView extends Application {

    public static Stage window;
    public static Scene mainScene;
    public static GUIController controller = new GUIController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Font.loadFont(getClass().getResourceAsStream("/styling/fonts/NotoSans/NotoSans-SemiCondensedBold.ttf"), 20);
        window=primaryStage;
        window.setTitle("Cykelværkstedet");

        //VBox for containing everything on main scene
        VBox allVbox = new VBox(15);

        //VBox for containing buttons
        VBox buttonVbox = new VBox(5);
        buttonVbox.setPadding(new Insets(50, 0, 50, 0));
        buttonVbox.setAlignment(Pos.CENTER);

        //Buttons for buttonVbox
        Button lagerBtn = new Button("LAGER");
        lagerBtn.setId("menu-button");
        lagerBtn.setOnAction(event -> ProductView.productScene());
        Button kasseBtn = new Button("KASSE");
        kasseBtn.setId("menu-button");
        Button ordreBtn = new Button("ORDRER");
        ordreBtn.setId("menu-button");

        //Adding buttons to buttonVbox
        buttonVbox.getChildren().addAll(lagerBtn, kasseBtn, ordreBtn);

        //Adding buttonVbox to allVbox
        allVbox.getChildren().addAll(buttonVbox);

        //Setting mainScene with allVbox
        mainScene = new Scene(allVbox, 250, 350);

        mainScene.getStylesheets().add("styling/default.css");

        window.setScene(mainScene);
        window.show();
    }
}
