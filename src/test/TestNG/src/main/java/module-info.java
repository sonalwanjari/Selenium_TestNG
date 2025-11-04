module org.example.testng {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.testng to javafx.fxml;
    exports org.example.testng;
}