import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Prototype {
    public static void main(String[] args) throws InterruptedException {
        RuleSet rules = new RuleSet("default", 10, 4, 1, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
        Board b1 = new Board(rules);
        // System.out.println(b1.getSquares());

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("ABC", 1));
        players.add(new Player("DEF", 2));
        players.add(new Player("GHI", 3));
        players.add(new Player("JKL", 4));

        b1.addPlayers(players);

        int delay = 250;

        int count = 1;
        while (count <= Math.pow(rules.getDimension(), 2)) {
            b1.movePlayer(players.get(0), count);
            b1.drawBoard(rules);
            for (Square square : b1.getSquares()) {
                if (square.hasPlayers()) {
                    System.out.printf("Square: %d\n%s\n", square.getNumber(), square.getPlayers());
                }
            }
            count++;
            TimeUnit.MILLISECONDS.sleep(delay);
        }

        count = 2;
        while (count <= Math.pow(rules.getDimension(), 2)) {
            b1.movePlayer(players.get(1), count);
            b1.drawBoard(rules);
            for (Square square : b1.getSquares()) {
                if (square.hasPlayers()) {
                    System.out.printf("Square: %d\n%s\n", square.getNumber(), square.getPlayers());
                }
            }
            count++;
            TimeUnit.MILLISECONDS.sleep(delay);
        }


        count = 2;
        while (count <= Math.pow(rules.getDimension(), 2)) {
            b1.movePlayer(players.get(2), count);
            b1.drawBoard(rules);
            for (Square square : b1.getSquares()) {
                if (square.hasPlayers()) {
                    System.out.printf("Square: %d\n%s\n", square.getNumber(), square.getPlayers());
                }
            }
            count++;
            TimeUnit.MILLISECONDS.sleep(delay);
        }

        count = 2;
        while (count <= Math.pow(rules.getDimension(), 2)) {
            b1.movePlayer(players.get(3), count);
            b1.drawBoard(rules);
            for (Square square : b1.getSquares()) {
                if (square.hasPlayers()) {
                    System.out.printf("Square: %d\n%s\n", square.getNumber(), square.getPlayers());
                }
            }
            count++;
            TimeUnit.MILLISECONDS.sleep(delay);
        }

        // System.out.println(b1.getSquareInformation(91));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(90));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(71));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(70));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(51));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(50));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(31));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(30));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(11));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(10));
        // System.out.println();
        // System.out.println();
        

        // System.out.println(b1.getSquareInformation(100));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(81));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(80));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(61));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(60));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(41));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(40));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(21));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(20));
        // System.out.println();
        // System.out.println(b1.getSquareInformation(1));
    }
}
