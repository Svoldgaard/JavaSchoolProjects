module dk.easv.calculatorexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.calculatorexercise to javafx.fxml;
    exports dk.easv.calculatorexercise;
}