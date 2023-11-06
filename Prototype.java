import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.io.Console;

public class Prototype {
    public static void main(String[] args) throws InterruptedException {
        RuleSet rules = new RuleSet("default", 7, 4, 1, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
        Board b1 = new Board(rules);

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.add(new Player(2));
        players.add(new Player(3));
        players.add(new Player(4));
        b1.addPlayers(players);
        players.get(0).addTrait(Identifier.KEY, new Identifier("DBC"));
        players.get(0).addTrait(Color.KEY, new Color());
        players.get(1).addTrait(Identifier.KEY, new Identifier("ABX"));
        players.get(1).addTrait(Color.KEY, new Color());
        players.get(2).addTrait(Identifier.KEY, new Identifier("GHF"));
        players.get(2).addTrait(Color.KEY, new Color());
        players.get(3).addTrait(Identifier.KEY, new Identifier("JDG"));
        players.get(3).addTrait(Color.KEY, new Color());
        
        int delay = 250;

        int count = 1;
        if (true) {
            while (count < Math.pow(rules.getDimension(), 2) + 1) {
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
        }
    }
}
