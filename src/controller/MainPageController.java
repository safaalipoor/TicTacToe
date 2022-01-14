package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class MainPageController implements Initializable {
    @FXML
    private FlowPane flowPane;

    @FXML
    private VBox vBox;

    @FXML
    private HBox hBox1;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private HBox hBox2;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private HBox hBox3;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Label label;

    @FXML
    private Button restartBTN;

    @FXML
    private Label Player2;

    @FXML
    private Label Player1;

    @FXML
    private Label point2;

    @FXML
    private Label point1;

    @FXML
    private Label name2;

    @FXML
    private Label name1;
    @FXML
    private Label point2Label;

    @FXML
    private Label point1Label;

    @FXML
    private Button closeBTN;

    @FXML
    private Button settingBTN;

    @FXML
    private Button nextRoundBTN;

    ArrayList<Button> buttons;
    private int turn =0;
    private float pointPlayer1=0;
    private float pointPlayer2=0;
    private int counter = 0 , count = 0;
    private int roundCounter =3;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name1.setText(LoginPageController.n1 + " is X");
        name2.setText(LoginPageController.n2 + " is O");
        point1.setText("0");
        point2.setText("0");

        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,
                button4,button5,button6,button7,button8,button9));


        nextRoundBTN.setOnAction(event -> reStartGame());


        buttons.forEach(button -> {
            setUpButton(button);
            button.setFocusTraversable(false);
        });


        closeBTN.setOnAction(event -> closePage());


        settingBTN.setOnAction(event -> {

            try {
                openSettingPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            setRoundGame();
        });
        restartBTN.setOnAction(event ->
                reStartGame2());


    }
    public void closePage(){
        ((Stage)closeBTN.getScene().getWindow()).close();
    }
    public void reStartGame(){
        for (Button b:buttons) {
            resetButtons(b);
        }
    }
    public void reStartGame2(){
        for (Button b:buttons) {
            resetButtonsWithPoint(b);
        }
    }
    public void resetButtons(Button button){
        button.setDisable(false);
        button.setText("");
        label.setText("Tic-Tac-Toe");
        counter=0;
    }
    public void resetButtonsWithPoint(Button button){
        button.setDisable(false);
        button.setText("");
        label.setText("Tic-Tac-Toe");
        counter=0;
        count=0;
        pointPlayer1=0;
        pointPlayer2=0;
        point1.setText("0");
        point2.setText("0");

    }
    private void setUpButton(Button button){
        button.setOnMouseClicked(event ->{
            setPlayerSymbol(button);
            button.setDisable(true);
            checkGame();
        });
    }
    public void setPlayerSymbol(Button button){
        if (turn % 2 ==0){
            button.setText("X");
            turn =1;
        }
        else {
            button.setText("O");
            turn =0;
        }
    }
    public void checkGame() {
        String x;

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    x = button1.getText() + button2.getText() + button3.getText();
                    break;
                case 1:
                    x = button4.getText() + button5.getText() + button6.getText();
                    break;
                case 2:
                    x = button7.getText() + button8.getText() + button9.getText();
                    break;
                case 3:
                    x = button1.getText() + button5.getText() + button9.getText();
                    break;
                case 4:
                    x = button3.getText() + button5.getText() + button7.getText();
                    break;
                case 5:
                    x = button1.getText() + button4.getText() + button7.getText();
                    break;
                case 6:
                    x = button2.getText() + button5.getText() + button8.getText();
                    break;
                case 7:
                    x = button3.getText() + button6.getText() + button9.getText();
                    break;
                default:
                    x = null;
            }
            String line = x;
            counter++;

                if (count < roundCounter) {
                    if (line.equals("XXX")) {
                        label.setText("X Won!");
                        count++;
                        for (Button b : buttons) {
                            b.setDisable(true);
                        }
                        pointPlayer1 += 1;
                        String p1 = String.valueOf(pointPlayer1);
                        point1.setText(p1);
                        return;

                    } else if (line.equals("OOO")) {
                        label.setText("O Won!");
                        count++;
                        for (Button b : buttons) {
                            b.setDisable(true);
                        }
                        pointPlayer2 += 1;
                        String p2 = String.valueOf(pointPlayer2);
                        point2.setText(p2);
                        return;

                    } else if (counter == 72) {
                        label.setText("Draw!");
                        count++;
                        pointPlayer1 += 0.5;
                        pointPlayer2 += 0.5;
                        String p = String.valueOf(pointPlayer1);
                        String po = String.valueOf(pointPlayer2);
                        point1.setText(p);
                        point2.setText(po);
                    }
                }
                if (count == roundCounter){
                    if (pointPlayer1 > pointPlayer2) {
                        label.setText("Final winner is X !");
                        count=0;
                        for (Button b : buttons) {
                            b.setDisable(true);
                        }

                    } else if (pointPlayer2 > pointPlayer1) {
                        label.setText("Final winner is O !");
                        count=0;
                        for (Button b : buttons) {
                            b.setDisable(true);
                        }


                    } else if (pointPlayer1 == pointPlayer2) {
                        label.setText("Final winners are O and X!");
                        count=0;
                        for (Button b : buttons) {
                            b.setDisable(true);
                        }
                }
            }
        }
    }
    public void openSettingPage() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/SettingPage.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("SettingPage");
        stage.show();
    }
    public void setRoundGame(){
        roundCounter = SettingPageController.round;

    }
}
