module dk.easv.multiplewindows {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.multiplewindows to javafx.fxml;
    exports dk.easv.multiplewindows;
    exports dk.easv.multiplewindows.controller;
    opens dk.easv.multiplewindows.controller to javafx.fxml;
}