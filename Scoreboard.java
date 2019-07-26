package Yahtzee;

public class Scoreboard {
    int[] scores = new int[13];
    boolean[] scored = new boolean[13];
    int bonuspoints;
    public Scoreboard(){

    }
    public void scorepoint(int criteria,int point){
        if(!scored[criteria]) {
            scores[criteria] = point;
            scored[criteria] = true;
        }
        else
            System.out.println("The criteria is already scored!");
    }
    public int total(){
        int sum = 0;
        for(int i = 0;i < 13;i++){
            sum+=scores[i];
            if(i == 5){
                if(sum >= 63)
                    sum+=35;
                bonuspoints = sum;
            }
        }
        return sum;
    }
    public int getBonus(){
        return bonuspoints;
    }
    public boolean checkScores(){
        for(boolean val: scored){
            if(!val)
                return false;
        }
        return true;
    }
    public void resetScores(){
        scored = new boolean[13];
        scores = new int[13];
    }
}
