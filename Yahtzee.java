package Yahtzee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;

public class Yahtzee extends Application {
    private Stage mainStage;
    private BorderPane mainLayout;
    private Button Roll;
    private TextArea text;
    private ImageView img1,img2,img3,img4,img5;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        try{
            FXMLLoader loader = new FXMLLoader(Yahtzee.class.getResource("/Yahtzee/Game.fxml"));
            mainLayout =  loader.load();
            Scene scene = new Scene(mainLayout);
            mainStage.setResizable(false);
            mainStage.setScene(scene);
            mainStage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
