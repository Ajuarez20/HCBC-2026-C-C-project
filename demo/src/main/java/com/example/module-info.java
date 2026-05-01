module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;

    opens com.example to javafx.fxml;
    exports com.example;
}