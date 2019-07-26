package Yahtzee;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Yahtzee_Controller {
    @FXML
    private Button Roll;
    @FXML
    private Button dice1;
    @FXML
    private Button dice2;
    @FXML
    private Button dice3;
    @FXML
    private Button dice4;
    @FXML
    private Button dice5;
    @FXML
    private Button ones;
    @FXML
    private Button twos;
    @FXML
    private Button threes;
    @FXML
    private Button fours;
    @FXML
    private Button fives;
    @FXML
    private Button sixes;
    @FXML
    private Button ThreeOfAKind;
    @FXML
    private Button FourOfAKind;
    @FXML
    private Button FullHouse;
    @FXML
    private Button ShortStraight;
    @FXML
    private Button LongStraight;
    @FXML
    private Button Yahtzee;
    @FXML
    private Button Chance;
    @FXML
    private Label Score;
    @FXML
    private Label rolls;
    @FXML
    private Label bonuspoints;
    @FXML
    private Label total;
    @FXML
    private Label totaltext;
    @FXML
    private Button newgamebutton;
    @FXML
    private VBox holder;


    Yahtzee_Set dice = new Yahtzee_Set();
    String[] dicecss = new String[]{"onedice","twodice","threedice","fourdice","fivedice","sixdice"};
    String[] lockeddicecss = new String[]{"lockedone","lockedtwo","lockedthree","lockedfour","lockedfive","lockedsix"};
    int rollcount = 4;
    Scoreboard scores = new Scoreboard();
    DiceHandler diceEvent = new DiceHandler();

    boolean newgame = true;
    public void rollDice(ActionEvent event){
        if(newgame){
            newgame = false;
            dice1.addEventHandler(ActionEvent.ACTION,diceEvent);
            dice2.addEventHandler(ActionEvent.ACTION,diceEvent);
            dice3.addEventHandler(ActionEvent.ACTION,diceEvent);
            dice4.addEventHandler(ActionEvent.ACTION,diceEvent);
            dice5.addEventHandler(ActionEvent.ACTION,diceEvent);
            resetGame();
            Roll.setText("Roll");
            dice.rollDice();
            toggleScoreButtons(false);
        }
        if(rollcount != 0) {
            dice.rollDice();
            int[] points = dice.getPoints();
            if(!dice.getDie(0).isLocked()) {
                dice1.getStyleClass().clear();
                dice1.getStyleClass().add(dicecss[dice.getDie(0).getNumber() - 1]);
            }
            if(!dice.getDie(1).isLocked()) {
                dice2.getStyleClass().clear();
                dice2.getStyleClass().add(dicecss[dice.getDie(1).getNumber() - 1]);
            }
            if(!dice.getDie(2).isLocked()) {
                dice3.getStyleClass().clear();
                dice3.getStyleClass().add(dicecss[dice.getDie(2).getNumber() - 1]);
            }
            if(!dice.getDie(3).isLocked()) {
                dice4.getStyleClass().clear();
                dice4.getStyleClass().add(dicecss[dice.getDie(3).getNumber() - 1]);
            }
            if(!dice.getDie(4).isLocked()) {
                dice5.getStyleClass().clear();
                dice5.getStyleClass().add(dicecss[dice.getDie(4).getNumber() - 1]);
            }
            if (!ones.isDisabled()) {
                ones.setText(Integer.toString(points[0]));
            }
            if (!twos.isDisabled()) {
                twos.setText(Integer.toString(points[1]));
            }
            if (!threes.isDisabled()){
                threes.setText(Integer.toString(points[2]));
            }
            if (!fours.isDisabled()) {
                fours.setText(Integer.toString(points[3]));
            }
            if (!fives.isDisabled()) {
                fives.setText(Integer.toString(points[4]));
            }
            if (!sixes.isDisabled()) {
                sixes.setText(Integer.toString(points[5]));
            }
            if (!ThreeOfAKind.isDisabled()) {
                ThreeOfAKind.setText(Integer.toString(points[6]));
            }
            if (!FourOfAKind.isDisabled()) {
                FourOfAKind.setText(Integer.toString(points[7]));
            }
            if (!FullHouse.isDisabled()) {
                FullHouse.setText(Integer.toString(points[8]));
            }
            if (!ShortStraight.isDisabled()) {
                ShortStraight.setText(Integer.toString(points[9]));
            }
            if (!LongStraight.isDisabled()) {
                LongStraight.setText(Integer.toString(points[10]));
            }
            if (!Yahtzee.isDisabled()) {
                Yahtzee.setText(Integer.toString(points[11]));
            }
            if (!Chance.isDisabled()) {
                Chance.setText(Integer.toString(points[12]));
            }
            if(rollcount <= 2){
                Roll.setText("Reroll");
            }
            rollcount--;
            rolls.setText(Integer.toString(rollcount));
            if(rollcount == 0){
                Roll.setDisable(true);
            }
        }
    }
    public void setScore(ActionEvent event){
        if(event.getSource() == ones){
            scores.scorepoint(0,dice.getValueCount(1));
        }
        else if(event.getSource() == twos){
            scores.scorepoint(1,dice.getValueCount(2));
        }
        else if(event.getSource() == threes){
            scores.scorepoint(2,dice.getValueCount(3));
        }
        else if(event.getSource() == fours){
            scores.scorepoint(3,dice.getValueCount(4));
        }
        else if(event.getSource() == fives){
            scores.scorepoint(4,dice.getValueCount(5));
        }
        else if(event.getSource() == sixes){
            scores.scorepoint(5,dice.getValueCount(6));
        }
        else if(event.getSource() == ThreeOfAKind){
            scores.scorepoint(6,dice.getThreeOfAKind());
        }
        else if(event.getSource() == FourOfAKind){
            scores.scorepoint(7,dice.getFourOfAKind());
        }
        else if(event.getSource() == FullHouse){
            scores.scorepoint(8,dice.getFullHouse());
        }
        else if(event.getSource() == ShortStraight){
            scores.scorepoint(9,dice.getShortStraight());
        }
        else if(event.getSource() == LongStraight){
            scores.scorepoint(10,dice.getLongStraight());
        }
        else if(event.getSource() == Yahtzee){
            scores.scorepoint(11,dice.getYahtzee());
        }
        else {
            scores.scorepoint(12,dice.getChance());
        }
        ((Button) event.getSource()).setDisable(true);
        if(scores.checkScores()){
            newgame = true;
            total.setVisible(true);
            totaltext.setVisible(true);
            newgamebutton.setVisible(true);
            holder.setVisible(true);
            total.setText(Integer.toString(scores.total()));
        }
        else {
            dice.unlockDice();
            Score.setText(Integer.toString(scores.total()));
            rolls.setText("3");
            rollcount = 3;
            dice.rollDice();
            Roll.setText("Roll");
            Roll.setDisable(false);
            bonuspoints.setText(Integer.toString(scores.getBonus()));
            rollDice(event);
        }
    }
    public void resetGame(){
        rollcount = 3;
        scores.resetScores();
        Score.setText("0");
        rolls.setText("3");
        dice.unlockDice();
        Roll.setText("Roll");
        bonuspoints.setText("0");

        total.setVisible(false);
        totaltext.setVisible(false);
        newgamebutton.setVisible(false);
        holder.setVisible(false);
        toggleScoreButtons(true);
    }
    public void toggleScoreButtons(boolean state){
        ones.setDisable(state);
        twos.setDisable(state);
        threes.setDisable(state);
        fours.setDisable(state);
        fives.setDisable(state);
        sixes.setDisable(state);
        ThreeOfAKind.setDisable(state);
        FourOfAKind.setDisable(state);
        FullHouse.setDisable(state);
        ShortStraight.setDisable(state);
        LongStraight.setDisable(state);
        Yahtzee.setDisable(state);
        Chance.setDisable(state);
    }

    private class DiceHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            if(event.getSource() == dice1){
                dice.toggleLock(0);
                dice1.getStyleClass().clear();
                if(dice.getDie(0).isLocked()) {
                    dice1.getStyleClass().add(lockeddicecss[dice.getDie(0).getNumber() - 1]);
                }
                else{
                    dice1.getStyleClass().add(dicecss[dice.getDie(0).getNumber() - 1]);
                }
            }
            else if(event.getSource() == dice2){
                dice.toggleLock(1);
                dice2.getStyleClass().clear();
                if(dice.getDie(1).isLocked()) {
                    dice2.getStyleClass().add(lockeddicecss[dice.getDie(1).getNumber() - 1]);
                }
                else{
                    dice2.getStyleClass().add(dicecss[dice.getDie(1).getNumber() - 1]);
                }
            }
            else if(event.getSource() == dice3){
                dice.toggleLock(2);
                dice3.getStyleClass().clear();
                if(dice.getDie(2).isLocked()) {
                    dice3.getStyleClass().add(lockeddicecss[dice.getDie(2).getNumber() - 1]);
                }
                else{
                    dice3.getStyleClass().add(dicecss[dice.getDie(2).getNumber() - 1]);
                }
            }
            else if(event.getSource() == dice4){
                dice.toggleLock(3);
                dice4.getStyleClass().clear();
                if(dice.getDie(3).isLocked()) {
                    dice4.getStyleClass().add(lockeddicecss[dice.getDie(3).getNumber() - 1]);
                }
                else{
                    dice4.getStyleClass().add(dicecss[dice.getDie(3).getNumber() - 1]);
                }
            }
            else{
                dice.toggleLock(4);
                dice5.getStyleClass().clear();
                if(dice.getDie(4).isLocked()) {
                    dice5.getStyleClass().add(lockeddicecss[dice.getDie(4).getNumber() - 1]);
                }
                else{
                    dice5.getStyleClass().add(dicecss[dice.getDie(4).getNumber() - 1]);
                }
            }
        }
    }
}
