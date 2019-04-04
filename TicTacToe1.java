import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class TicTacToe1 extends Application {

    boolean player = false;
    Button[][] arrayButton = new Button[3][3];


    public static void main(String[] args) {
        launch(args);
    }

    public Boolean checkWinner(){
        boolean winning = false;
        for(int i=0; i<3; i++){
            if(!arrayButton[i][0].getText().equals("") && arrayButton[i][0].getText().equals(arrayButton[i][1].getText()) &&
                    arrayButton[i][0].getText().equals(arrayButton[i][2].getText())){
                System.out.println("Winning Yes");
                return true;
            }
        }

        for(int i=0; i<3; i++){
            if(!arrayButton[i][0].getText().equals("") && arrayButton[0][i].getText().equals(arrayButton[1][i].getText()) &&
                    arrayButton[0][i].getText().equals(arrayButton[2][i].getText())){
                System.out.println("Winnin Yes");
                return true;
            }
        }


        if (!arrayButton[0][0].getText().equals("") && arrayButton[0][0].getText().equals(arrayButton[1][1].getText()) &&
                arrayButton[0][0].getText().equals(arrayButton[2][2].getText())){
            System.out.println("Winnin Yes");
            return true;
        }
        if (!arrayButton[0][2].getText().equals("") && arrayButton[0][2].getText().equals(arrayButton[1][1].getText()) &&
                arrayButton[0][2].getText().equals(arrayButton[2][0].getText())){
            System.out.println("Winnin Yes");
            return true;
        }
        return false;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TicTacToe Game");
        Label winMessage = new Label("");
        GridPane gameGrid = new GridPane();
        gameGrid.setAlignment(Pos.TOP_LEFT);
        gameGrid.setHgap(10);
        gameGrid.setVgap(10);
        gameGrid.setPadding(new Insets(25, 25, 5, 25));

        GridPane labelGridCont = new GridPane();
        labelGridCont.setHgap(10);
        labelGridCont.setVgap(10);
        labelGridCont.setAlignment(Pos.TOP_LEFT);
        labelGridCont.setPadding(new Insets(5, 25, 5, 25));

        GridPane resetBtnGridCont = new GridPane();
        resetBtnGridCont.setHgap(10);
        resetBtnGridCont.setVgap(10);
        resetBtnGridCont.setAlignment(Pos.TOP_LEFT);
        resetBtnGridCont.setPadding(new Insets(5, 25, 5, 25));

        GridPane gameContainerGrid = new GridPane();
        gameContainerGrid.setHgap(10);
        gameContainerGrid.setVgap(10);
        gameContainerGrid.setAlignment(Pos.CENTER);
        gameContainerGrid.setPadding(new Insets(25, 25, 25, 25));



//        Scene gameScene = new Scene(gameGrid, 300, 275);
        Scene gameScene = new Scene(gameContainerGrid, 300, 275);
        // Creating buttons
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                Button btn = new Button();
                gameGrid.add(btn, j, i);
                arrayButton[i][j] = btn;
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(player) {
                            btn.setText("X");
                            btn.setDisable(true);
                            player = !player;
                        }
                        else {
                            btn.setText("O");
                            btn.setDisable(true);
                            player = !player;
                        }
                        if (checkWinner()){
                            if(!player){
                                winMessage.setText("X player has won");
                            }
                            else  winMessage.setText("O player has won");
                        }
                    }
                });
            }
        }

        Button reset = new Button("reset");


//        gameGrid.add(winMessage, 1, 4);
//        gameGrid.add(reset,2, 5);

        gameContainerGrid.add(gameGrid, 1,0);
        labelGridCont.add(winMessage, 0,0);
        gameContainerGrid.add(labelGridCont, 1,2);
        resetBtnGridCont.add(reset, 0,0);
        gameContainerGrid.add(resetBtnGridCont,1,3);

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(Button[] row_btn: arrayButton){
                    for(Button btn: row_btn){
                        btn.setText("");
                        btn.setDisable(false);
                    }
                }
            }
        });

        primaryStage.setScene(gameScene);
        primaryStage.show();

    }
}