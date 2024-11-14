package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public Label lblValidation;
    @FXML
    private Button btnValidation;

    @FXML
    private TextField ageField;

    @FXML
    private TextField nameField;

    //private Validation validation = new Validation();


    @FXML
    protected void onHelloButtonClick() {

        int age1 = Integer.parseInt(ageField.getText());

        lblValidation.setText("Hello " + nameField.getText() + " your age is " + age1 + " and ");

    }




}