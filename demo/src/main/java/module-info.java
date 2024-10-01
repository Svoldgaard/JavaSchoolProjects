module dk.svoldgaard.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.svoldgaard.demo to javafx.fxml;
    exports dk.svoldgaard.demo;
}