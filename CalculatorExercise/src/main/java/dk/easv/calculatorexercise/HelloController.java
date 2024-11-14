package dk.easv.calculatorexercise;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Label lblOperator;

    @FXML
    private TextField textField;

    @FXML
    private TextField savedNumbers;

    @FXML
    private String firstNumber = "";

    @FXML
    private String currentNumber = "";

    @FXML
    private String calculationType;

    @FXML
    private void onClear(ActionEvent actionEvent) {
        if (textField != null) textField.clear();
        if (savedNumbers != null) savedNumbers.setText("");
        if (lblOperator != null) lblOperator.setText("");
        firstNumber = "";
        currentNumber = "";
        calculationType = null;
    }

    @FXML
    private void onProcent(ActionEvent actionEvent) {
        calculationSetup("‰");
    }

    @FXML
    private void onDivide(ActionEvent actionEvent) {
        calculationSetup("/");
    }

    @FXML
    private void onMultiply(ActionEvent actionEvent) {
        calculationSetup("*");
    }

    @FXML
    private void onMinus(ActionEvent actionEvent) {
        calculationSetup("-");
    }

    @FXML
    private void onPlus(ActionEvent actionEvent) {
        calculationSetup("+");
    }

    @FXML
    private void onKomma(ActionEvent actionEvent) {
        addNumber("."); // Allow decimal input
    }

    @FXML
    private void onEquals(ActionEvent actionEvent) {
        calculate(actionEvent);
    }

    @FXML
    private void onNumber1(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void onNumber2(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    void onNumber3(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void onNumber4(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void onNumber5(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void onNumber6(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void onNumber7(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void onNumber8(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void onNumber9(ActionEvent event) {
        addNumber("9");
    }

    @FXML
    public void onNumber0(ActionEvent actionEvent) {
        addNumber("0");
    }

    @FXML
    public void calculationSetup(String calculationType) {
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
        lblOperator.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void calculate(ActionEvent event) {
        if (firstNumber.isEmpty() || currentNumber.isEmpty() || calculationType == null) {
            return;
        }

        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);
        int calculatedNumber = 0;

        switch (calculationType) {
            case "+" -> calculatedNumber = firstNumberInt + secondNumberInt;
            case "-" -> calculatedNumber = firstNumberInt - secondNumberInt;
            case "*" -> calculatedNumber = firstNumberInt * secondNumberInt;
            case "/" -> {
                if (secondNumberInt == 0) {
                    // Handle division by zero
                    textField.setText("Error");
                    return;
                }
                calculatedNumber = firstNumberInt / secondNumberInt;
            }
        }

        savedNumbers.setText(firstNumber + " " + calculationType + " " + currentNumber + " = " + calculatedNumber);
        textField.setText(String.valueOf(calculatedNumber));


        firstNumber = String.valueOf(calculatedNumber);
        currentNumber = "";
        calculationType = null;
    }

    @FXML
    public void updateTextField() {
        textField.setText(currentNumber);
    }

    @FXML
    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }
}
