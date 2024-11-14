module dk.easv.officemanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.easv.officemanagement to javafx.fxml;
    exports dk.easv.officemanagement;
    exports dk.easv.officemanagement.Gui;
    opens dk.easv.officemanagement.Gui to javafx.fxml;
}