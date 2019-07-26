package Yahtzee;

import java.util.Arrays;

public class Yahtzee_Set {
    private Die[] dice;
    private Die[] unsorted = new Die[5];
    private int sum;

    public Yahtzee_Set(int die1, int die2, int die3, int die4, int die5) {
        int[] data = new int[]{die1, die2, die3, die4, die5};
        for (int i = 0; i < 5; i++) {
            unsorted[i] = new Die(data[i]);
        }
        dice = unsorted;
        sortDice();
        sumAll();
    }

    public Yahtzee_Set() {
        for (int i = 0; i < 5; i++) {
            unsorted[i] = new Die();
        }
        dice = unsorted;
    }

    public void rollDice() {
        for (Die die : unsorted) {
            if(!die.isLocked())
                die.roll();
        }
        dice = unsorted;
        sortDice();
        sumAll();
    }
    public void sortDice(){
        int[] counter = new int[6];
        for(Die die: unsorted){
            counter[die.getNumber()-1]++;
        }
        Die[] result = new Die[dice.length];
        for(int i = 1;i<=5;i++){
            counter[i] = counter[i-1] + counter[i];
        }
        for(Die die: unsorted){
            result[--counter[die.getNumber()-1]] = die;
        }
        dice = result;
    }
    public int[] getPoints() {
        //[Ones,Twos,Threes,Fours,Fives,Sixes,3OAK,4OAK,FH,SS,LS,Yahtzee,Chance]
        int[] scores = new int[13];
        for(int i = 0; i < 6; i++) {
            scores[i] = (getValueCount(i+1));
        }
        scores[6] = getThreeOfAKind();
        scores[7] = getFourOfAKind();
        scores[8] = getFullHouse();
        scores[9] = getShortStraight();
        scores[10] = getLongStraight();
        scores[11] = getYahtzee();
        scores[12] = getChance();
        return scores;
    }
    public void sumAll(){
        sum=0;
        for(Die die:dice){
            sum+=die.getNumber();
        }
    }
    public int getThreeOfAKind(){
        return (dice[0].equalsTo(dice[2]) || dice[1].equalsTo(dice[3]) || dice[2].equalsTo(dice[4]))? sum:0;
    }
    public int getFourOfAKind(){
        return (dice[0].equalsTo(dice[3]) || dice[1].equalsTo(dice[4]))? sum:0;
    }
    public int getFullHouse() {
        if (dice[0].equalsTo(dice[2]) && dice[3].equalsTo(dice[4]) ||
                dice[0].equalsTo(dice[1]) && dice[2].equalsTo(dice[4])) {
            return 40;
        }
        return 0;
    }
    public int getShortStraight(){
        boolean init = false;
        boolean[] nums = toBool();
        int count = 0;
        for(int i = 0;i<6;i++){
            if(!init){
                init = nums[i];
            }
            if(init && nums[i]){
                count++;
            }
            else{
                if(count > 3)
                    return 25;
                count = 0;
            }
        }
        return (count > 3)?25:0;
    }
    public int getLongStraight(){
        boolean init = false;
        boolean[] nums = toBool();
        int count = 0;
        for(int i = 0;i<6;i++){
            if(!init){
                init = nums[i];
            }
            if(init && nums[i]){
                count++;
            }
            else{
                if(count >= 5)
                    return 50;
                count = 0;
            }
        }
        return (count >= 5)?50:0;
    }
    public int getYahtzee(){
        return (dice[0].equalsTo(dice[4]))?50:0;
    }
    public int getChance(){
        return sum;
    }
    public Die[] getDice(){
        return dice;
    }

    public int getValueCount(int val) {
        return ((Arrays.stream(dice).filter(s -> (s.getNumber() == val)).toArray().length)*val);
    }
    public boolean[] toBool(){
        boolean[] count = new boolean[6];
        for(Die die:dice){
            count[die.getNumber()-1] = true;
        }
        return count;
    }
    public void printSet() {
        for(Die die:unsorted){
            System.out.print(die.getNumber()+" ");
        }
        System.out.println();
    }
    public Die getDie(int num){
        return unsorted[num];
    }
    public void toggleLock(int num){
        unsorted[num].toggleLock();
    }
    public void unlockDice(){
        for(Die die:unsorted){
            die.unlock();
        }
    }
}
