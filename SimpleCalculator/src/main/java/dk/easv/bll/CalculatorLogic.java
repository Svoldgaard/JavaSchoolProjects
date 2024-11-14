package dk.easv.bll;

public class CalculatorLogic {

    public int calculateNumbers(int number1, int number2, String operator) {

        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            default:
                return -999999;




        }
    }
}
