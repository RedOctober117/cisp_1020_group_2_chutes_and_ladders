import java.util.ArrayList;

public class Prototype {
    public static void main(String[] args) {
        RuleSet rules = new RuleSet("default", 10, 4, 1, 0, new ArrayList<Square>(), new ArrayList<Square>());
        Board b1 = new Board(rules);
        System.out.println(b1.getSquares());
        System.out.println(b1.getSquareInformation(1));
    }
}
