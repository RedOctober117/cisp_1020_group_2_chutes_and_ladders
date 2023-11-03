import java.util.HashMap;
import java.util.Map;


public class Menu {
    private Map<String, Integer> playerScores;

    public Menu() {
        this.playerScores = new HashMap<>();
    }

    // Add a player and their score
    public void addPlayer(String playerName, int score) {
        playerScores.put(playerName, score);
    }

    // Print current scores for each player
    public void printScores() {
        System.out.println("Current Scores:");
        for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        
        // Add players and their scores
        menu.addPlayer("==Player-1==", 0);
        menu.addPlayer("==Player-2==", 0);
        menu.addPlayer("==Player-3==", 0);
        menu.addPlayer("==Player-4==" , 0);

        // Print the current scores
        menu.printScores();
    }
}