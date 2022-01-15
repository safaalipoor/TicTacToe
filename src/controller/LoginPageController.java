package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private TextField nameField1;

    @FXML
    private TextField nameField2;

    @FXML
    private Button StartBTN;


    static String n1, n2 ;
    @FXML
    private Label errorLBL;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLBL.setText("");
        StartBTN.setOnAction(event -> {

            setNames();
            try {
                startGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    public void startGame() throws IOException {
        if (!checkField()) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/MainPage.fxml"));
            loader.load();
            Stage stage = new Stage();
            stage.setTitle("Tic Tac Toe");
            stage.setScene(new Scene(loader.getRoot()));
            stage.show();
            ((Stage) StartBTN.getScene().getWindow()).close();
        }
    }
    public void setNames(){
        n1 =nameField1.getText();
        n2=nameField2.getText();
    }
    public boolean checkField(){
        if (nameField1.getText().isEmpty() && nameField2.getText().isEmpty()){
            errorLBL.setText("please enter the name of players");
            return true;

        }
        else if (nameField1.getText().isEmpty()){
            errorLBL.setText("please enter the name of player 1");
            return true;
        }
        else if (nameField2.getText().isEmpty()){
            errorLBL.setText("please enter the name of player 2");
            return true;
        }
        return false;
    }

}
