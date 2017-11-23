package view;

import controllers.GUIController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {

    public static Stage window;
    public static Scene mainScene;
    public static GUIController controller = new GUIController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;
        window.setTitle("Cykelværkstedet");

        //VBox for containing everything on main scene
        VBox allVbox = new VBox(15);

        //VBox for containing buttons
        VBox buttonVbox = new VBox(10);
        buttonVbox.setPadding(new Insets(50, 0, 50, 0));
        buttonVbox.setAlignment(Pos.CENTER);

        //Buttons for buttonVbox
        Button lagerBtn = new Button("Lager");
        Button kasseBtn = new Button("Kasse");
        Button ordreBtn = new Button("Ordrer");

        //Adding buttons to buttonVbox
        buttonVbox.getChildren().addAll(lagerBtn, kasseBtn, ordreBtn);

        //Adding buttonVbox to allVbox
        allVbox.getChildren().addAll(buttonVbox);

        //Setting mainScene with allVbox
        mainScene = new Scene(allVbox, 300, 400);

        window.setScene(mainScene);
        window.show();
    }
}
