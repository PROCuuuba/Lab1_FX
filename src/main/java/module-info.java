module com.example.lab1_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1_fx to javafx.fxml;
    exports com.example.lab1_fx;
}