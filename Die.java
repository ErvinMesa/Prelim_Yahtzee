package Yahtzee;

import java.util.Random;
public class Die {
    private int number;
    private boolean lock = false;
    private Random rand = new Random();
    public Die(){
        number = rand.nextInt(6)+1;
    }
    public Die(int number){
        this.number = number;
    }
    public void roll(){
        number = rand.nextInt(6)+1;
    }
    public int getNumber(){
        return number;
    }
    public boolean equalsTo(Die die){
        return die.getNumber() == number;
    }
    public void lock(){
        lock = true;
    }
    public void unlock(){
        lock = false;
    }
    public boolean isLocked(){
        return lock;
    }
}
