module dk.easv.wordsearch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens dk.easv.wordsearch to javafx.fxml;
    exports dk.easv.wordsearch;
    opens dk.easv.wordsearch.gui to javafx.fxml;
    exports dk.easv.wordsearch.gui;
}