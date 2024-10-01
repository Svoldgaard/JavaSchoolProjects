package dk.svoldgaard.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestionaireWindow {
    @FXML
    public void openQuestionWindow() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(QuestionaireWindow.class.getResource("QuestionWindow.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Question Window");
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();

    }

    public void getQuestionWindow() throws IOException {
        openQuestionWindow();
    }
}
