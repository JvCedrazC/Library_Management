module com.example.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biblioteca to javafx.fxml;
    exports com.example.biblioteca;
}