/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chattstate.group2;

/**
 *
 * @author ryans
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Map<String, Integer> playerScores;
    private ArrayList<Player> players;

    public Menu(ArrayList<Player> players) {
        this.playerScores = new TreeMap<>();
        this.players = players;
    }

    // Add a player and their score
    public void addPlayer(String playerName, int score) {
        playerScores.put(playerName, score);
    }

    public void changeScore(String playerName, int score) {
        playerScores.replace(playerName, score);
    }

    // Print current scores for each player
    public void printScores() {
        System.out.println("Current Scores:");
        for (Player player : players) {
            System.out.println("==Player-" + player.getPlayerNumber() + "==: " 
                    + (int) player.getTrait(Score.KEY).getTraitValue());
        }
    }

    public void printRules() {
        try {
            File rules = new File("Rules.txt");
            Scanner in = new Scanner(rules);
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException x) {
            System.out.println(x);
        }
    }

    public void printEvents() {
        try {
            File events = new File("Chutes&Ladders.txt");
            Scanner in = new Scanner(events);
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException x) {
            System.out.println(x);
        }
    }

    public void printCommandList() {
        try {
            File commands = new File("Commands.txt");
            Scanner in = new Scanner(commands);
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException x) {
            System.out.println(x);
        }

    }

    public void printMenu() {
        System.out.printf(" _______________________\n"
                + "| %s | %s | %s | %s |\n"
                + "| %3d | %3d | %3d | %3d |\n"
                + "|(-c for commands)? ",
                (String) players.get(0).getTrait(Identifier.KEY).getTraitValue(),
                (String) players.get(1).getTrait(Identifier.KEY).getTraitValue(),
                (String) players.get(2).getTrait(Identifier.KEY).getTraitValue(),
                (String) players.get(3).getTrait(Identifier.KEY).getTraitValue(),
                (int) players.get(0).getTrait(Score.KEY).getTraitValue(),
                (int) players.get(1).getTrait(Score.KEY).getTraitValue(),
                (int) players.get(2).getTrait(Score.KEY).getTraitValue(),
                (int) players.get(3).getTrait(Score.KEY).getTraitValue()
        );
    }

    public void recieveCommand(String input) {
        switch (input) {
            case "-c":
                printCommandList();
                break;
            case "-e":
                printEvents();
                break;
            case "-s":
                printScores();
                break;
               
        }
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Menu menu = new Menu(players);
        players.add(new Player(1));
        players.add(new Player(2));
        players.add(new Player(3));
        players.add(new Player(4));

        players.get(0).addTrait(Identifier.KEY, new Identifier("ABC"));
        players.get(1).addTrait(Identifier.KEY, new Identifier("DEF"));
        players.get(2).addTrait(Identifier.KEY, new Identifier("GHI"));
        players.get(3).addTrait(Identifier.KEY, new Identifier("JKL"));

        players.get(0).addTrait(Score.KEY, new Score(10));
        players.get(1).addTrait(Score.KEY, new Score(10));
        players.get(2).addTrait(Score.KEY, new Score(100));
        players.get(3).addTrait(Score.KEY, new Score(0));

        // Print the current scores
        menu.printMenu();
        menu.printScores();
        menu.printRules();
        menu.printEvents();
        menu.printCommandList();
        menu.recieveCommand("-s");
        menu.recieveCommand("-c");
        menu.recieveCommand("-e");
    }
}
