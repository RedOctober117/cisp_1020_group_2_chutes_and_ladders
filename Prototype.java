import java.util.ArrayList;

public class Prototype {
    public static void main(String[] args) {
        RuleSet rules = new RuleSet("default", 10, 4, 1, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
        Board b1 = new Board(rules);
        System.out.println(b1.getSquares());

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("ABC", 1));
        players.add(new Player("DEF", 2));
        players.add(new Player("GHI", 3));
        players.add(new Player("JKL", 4));

        b1.addPlayers(players);
        // System.out.println(b1.getSquareInformation(1));
        // System.out.println(b1.getSquareReference(1).getPlayers());
        System.out.println(b1.getPlayerCoords(1));
        // int squareIndex = 1;
        // System.out.printf("Square %d:\n", squareIndex);
        // for (Player p : b1.getSquareReference(squareIndex).getPlayers()) {
        //     System.out.println(p);
        // }

        // squareIndex = 100;
        // b1.movePlayer(players.get(0), 99);
        // System.out.printf("Square %d:\n", squareIndex);
        // for (Player p : b1.getSquareReference(squareIndex).getPlayers()) {
        //     System.out.println(p);
        // }

        // squareIndex = 1;
        // System.out.printf("Square %d:\n", squareIndex);
        // for (Player p : b1.getSquareReference(squareIndex).getPlayers()) {
        //     System.out.println(p);
        // }

        b1.movePlayer(players.get(3), 2);
        b1.drawBoard(rules);
        System.out.println(b1.getSquareInformation(1));
        System.out.println(b1.getPlayerCoords(1));
    }
}
