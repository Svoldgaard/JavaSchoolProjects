module dk.easv.validationapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.validationapplication to javafx.fxml;
    exports dk.easv.validationapplication;
    exports gui;
    opens gui to javafx.fxml;
}