import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Prototype {
    public static void main(String[] args) throws InterruptedException {
        RuleSet rules = new RuleSet("default", 10, 4, 1, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
        Board b1 = new Board(rules);
        // System.out.println(b1.getSquares());

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.add(new Player(2));
        players.add(new Player(3));
        players.add(new Player(4));
        b1.addPlayers(players);
        players.get(0).addTrait(new Identifier("DBC"));
        // System.out.println(players.get(0));
        
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
        
        for (PlayerTrait<?> trait : players.get(0).getTraits()) {
            if (trait instanceof Identifier) {
                players.get(0).removeTrait((Identifier)trait);
                break;
            }
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
