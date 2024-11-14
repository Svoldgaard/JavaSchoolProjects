module dk.easv.simplecalculatorexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.simplecalculatorexercise to javafx.fxml;
    exports dk.easv.simplecalculatorexercise;
}