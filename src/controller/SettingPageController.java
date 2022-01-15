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

    @FXML
    private Label errorLBL;

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private Label label111;

    @FXML
    private TextField newPlayer2;

    @FXML
    private TextField newPlayer1;
    @FXML
    private Button setBTN1;

    static int round ;
    static String newName1 , newName2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLBL.setText("");

        setBTN.setOnAction(event -> {
            if (setRoundNumber()) {
                setNewNames();
                setRoundNumber();
                closePage();
            }


    });
        setBTN1.setOnAction(event -> {
            setNewNames();
            closePage();
        });


    }
    public boolean setRoundNumber(){
        String r = roundField.getText();
        round = Integer.parseInt(r);
        if (round<=0){
            errorLBL.setText("please inter a positive number");
            return false;
        }
        return true;
    }
    public void closePage(){
        ((Stage)setBTN.getScene().getWindow()).close();
    }
    public void setNewNames(){
        newName1=newPlayer1.getText();
        newName2=newPlayer2.getText();
    }


}
