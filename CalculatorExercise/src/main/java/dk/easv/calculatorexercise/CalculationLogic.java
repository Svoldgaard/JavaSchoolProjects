/*package dk.easv.calculatorexercise;

import javafx.fxml.FXML;

public class CalculationLogic {


    public void calculationSetup(String calculationType) {
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
        lblOperator.setText(firstNumber + " " + calculationType);
    }

    public int calculate(int firstNumber, int secondNumber, String operation) {
        return switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                yield firstNumber / secondNumber;
            }
            default -> throw new UnsupportedOperationException("Operation not supported: " + operation);
        };
    }
}*/
