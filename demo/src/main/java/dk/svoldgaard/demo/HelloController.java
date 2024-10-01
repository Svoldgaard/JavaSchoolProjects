package dk.svoldgaard.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    //private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {

        //welcomeText.setText("Welcome to JavaFX Application!");


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionaireWindow.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Question Window");
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();

    }
}
