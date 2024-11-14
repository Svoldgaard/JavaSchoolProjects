package dk.easv.simplecalculator;

import dk.easv.bll.CalculatorLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtValue1;

    @FXML
    private Label lblOperator;

    @FXML
    private TextField txtValue2;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnCalculate;

    @FXML
    private Label lblResult;

    private CalculatorLogic logic = new CalculatorLogic();



    @FXML
    private void onPlusOperation(ActionEvent actionEvent) {
        lblOperator.setText("+");

    }

    @FXML
    private void onMinusOperation(ActionEvent actionEvent) {
        lblOperator.setText("-");
    }

    @FXML
    private void onMultiplyOperation(ActionEvent actionEvent) {
        lblOperator.setText("*");
    }

    @FXML
    private void onDivideOperation(ActionEvent actionEvent) {
        lblOperator.setText("/");

    }



    @FXML
    private void onCalculate(ActionEvent actionEvent) {

        int value1 = Integer.parseInt(txtValue1.getText());
        int value2 = Integer.parseInt(txtValue2.getText());

        int result = logic.calculateNumbers(value1, value2, lblOperator.getText());

        lblResult.setText(String.valueOf(result));


    }
}
