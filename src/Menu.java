/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ryan and michael
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

    /**
     * constructor class that creates a Tree Map (playerScores) that allows each
     * player to have a score value associated with it. also uses an array list
     * of players to keep track of how many players the menu should print for
     *
     * @param players
     */
    public Menu(ArrayList<Player> players) {
        this.playerScores = new TreeMap<>();
        this.players = players;
    }

    /**
     * adds a player with a key (playerName) and value (score)
     * @param playerName
     * @param score
     */
    public void addPlayer(String playerName, int score) {
        playerScores.put(playerName, score);
    }
    /**
     * changes the score associated with a player key
     * @param playerName
     * @param score 
     */
    public void changeScore(String playerName, int score) {
        playerScores.replace(playerName, score);
    }

    /**
     * Print current scores for each player
     */
    public void printScores() {
        System.out.println("Current Scores:");
        for (Player player : players) {
            System.out.println("==Player-" + player.getPlayerNumber() + "==: "
                    + (int) player.getTrait(Score.KEY).getTraitValue());
        }
    }

    /**
     * reads from Rules.txt to display the rules of the game to the player
     */
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

    /**
     * reads from Chutes&Ladders.txt to display the spaces that are affected 
     * by chutes/ladders. prints where the space where the chute/ladder starts 
     * as well as where the destination space is.
     */
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

    /**
     * prints a list of accepted commands
     */
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

    /**
     *  prints the menu with an easily readable format for end-user
     */
    public void printMenu() {
        for (Player player : players) {
            System.out.printf(" _______________________\n"
                    + "| %s |\t"
                    + "| %3d |\n", player.getTrait(Identifier.KEY).getTraitValue(),
                    player.getTrait(Score.KEY).getTraitValue());
        }
        System.out.println("Enter a command (-c for commands)");
    }
//        an example of one way to print the menu:
//
//        System.out.printf(" _______________________\n"
//                + "| %s | %s | %s | %s |\n"
//                + "| %3d | %3d | %3d | %3d |\n"
//                + "|(-c for commands)? ");
//                (String) players.get(0).getTrait(Identifier.KEY).getTraitValue(),
//                (String) players.get(1).getTrait(Identifier.KEY).getTraitValue(),
//                (String) players.get(2).getTrait(Identifier.KEY).getTraitValue(),
//                (String) players.get(3).getTrait(Identifier.KEY).getTraitValue(),
//                (int) players.get(0).getTrait(Score.KEY).getTraitValue(),
//                (int) players.get(1).getTrait(Score.KEY).getTraitValue(),
//                (int) players.get(2).getTrait(Score.KEY).getTraitValue(),
//                (int) players.get(3).getTrait(Score.KEY).getTraitValue()

    /**
     * receives an input and calls the appropriate method for each case
     * if the user input is not one of these cases, print "Invalid Command"
     * 
     * @param input 
     */
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
            default:
                System.out.println("Invalid Command");

        }
    }
}
