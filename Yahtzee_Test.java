package Yahtzee;

public class Yahtzee_Test {
    public static void main(String[] args) {
        Yahtzee_Set a = new Yahtzee_Set(3,4,5,6,6);
        a.sortDice();
        a.printSet();
        System.out.println(a.getThreeOfAKind());
        System.out.println(a.getFourOfAKind());
        System.out.println(a.getFullHouse());
        System.out.println(a.getYahtzee());
        System.out.println(a.getShortStraight());
        System.out.println(a.getLongStraight());
    }
}
