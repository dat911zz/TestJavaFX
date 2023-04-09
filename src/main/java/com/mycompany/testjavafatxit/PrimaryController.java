package com.mycompany.testjavafatxit;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToSampler() throws IOException{
        Platform.runLater(new Runnable() {
            public void run() {             
                try {
                    new Sampler().start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
