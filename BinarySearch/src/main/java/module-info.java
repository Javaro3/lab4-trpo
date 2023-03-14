module com.example.binarysearch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.binarysearch to javafx.fxml;
    exports com.example.binarysearch;
}