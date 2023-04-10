package com.mycompany.testjavafatxit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class SecondaryController implements Initializable {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private ChoiceBox<String> tien; 
    
    @FXML
    private ChoiceBox<String> tienchuyen;
    
    @FXML
    private TextField sotien, sotienduoc;

    @FXML
    private Label inputAlert;
    
    private int check;
    private String[] cacloaitien = {"VNĐ", "Dollar", "Yuan"};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tien.getItems().addAll(cacloaitien);
        tienchuyen.getItems().addAll(cacloaitien);
    }    
    
    @FXML
    private void tinhTien() throws IOException {
        try{
            check = Integer.parseInt(sotien.getText());
            
            if(tien.getSelectionModel().getSelectedItem().equals("VNĐ")
                    && tienchuyen.getSelectionModel().getSelectedItem().equals("Dollar"))
                check *= 0.000043;
            else if (tien.getSelectionModel().getSelectedItem().equals("VNĐ")
                    && tienchuyen.getSelectionModel().getSelectedItem().equals("Yuan"))
                check *= 0.00029;
            else if (tien.getSelectionModel().getSelectedItem().equals("Dollar")
                    && tienchuyen.getSelectionModel().getSelectedItem().equals("VNĐ"))
                check *= 23447;
            else if (tien.getSelectionModel().getSelectedItem().equals("Dollar")
                    && tienchuyen.getSelectionModel().getSelectedItem().equals("Yuan"))
                check *= 6.87;
            else if (tien.getSelectionModel().getSelectedItem().equals("Yuan")
                    && tienchuyen.getSelectionModel().getSelectedItem().equals("VNĐ"))
                check *= 3412.61;
            else if (tien.getSelectionModel().getSelectedItem().equals("Yuan")
                    && tienchuyen.getSelectionModel().getSelectedItem().equals("Dollar"))
                check *= 0.15;
            
            sotienduoc.setText(String.valueOf(check));
            inputAlert.setVisible(false);
        }
        catch(NumberFormatException e){
            sotienduoc.setText("0");
            inputAlert.setVisible(true);
        }
    }
    
}