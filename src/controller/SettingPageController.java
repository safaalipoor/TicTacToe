package controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingPageController implements Initializable {
    @FXML
    private Button setBTN;

    @FXML
    private Label label;

    @FXML
    private TextField roundField;

    static int round ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setBTN.setOnAction(event -> {
            setRoundNumber();
            closePage();



    });

    }
    public void setRoundNumber(){
        String r = roundField.getText();
        round = Integer.parseInt(r);
    }
    public void closePage(){
        ((Stage)setBTN.getScene().getWindow()).close();
    }
}
