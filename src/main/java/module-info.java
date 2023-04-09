module com.mycompany.testjavafatxit {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires org.kordamp.bootstrapfx.core;
    
    opens com.mycompany.testjavafatxit to javafx.fxml;
    exports com.mycompany.testjavafatxit;
}
