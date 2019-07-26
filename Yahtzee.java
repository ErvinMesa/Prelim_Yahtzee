package Yahtzee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Yahtzee extends Application {
    private BorderPane mainLayout;
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
