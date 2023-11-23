// Levi + Ryan + Bruce

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mangl
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    static boolean AUTO_PLAY = false;
    static final int CYCLE_DELAY = 350;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        // Variable declarations
        Scanner in = new Scanner(System.in);
        int turnCount = 1;
        boolean finish = false;
        int endGame;

        // Creating an array list of chutes and an array list of ladders
        File inputFileCnL = new File("Chutes&Ladders.txt");
        Scanner CnL = new Scanner(inputFileCnL);
        ArrayList<Events> chutes = new ArrayList<>();
        while (CnL.hasNextInt()) {
            int start = CnL.nextInt();
            int dest = CnL.nextInt();
            chutes.add(new Events(start, dest));
        }
        CnL.nextLine();
        ArrayList<Events> ladders = new ArrayList<>();
        while (CnL.hasNextInt()) {
            int start = CnL.nextInt();
            int dest = CnL.nextInt();
            ladders.add(new Events(start, dest));
        }

        System.out.print("Does your system support ASCII codes? y/N: ");
        String ascii_prompt = in.nextLine();
        if (ascii_prompt.equalsIgnoreCase("y")) {
            Board.toggleAscii(true);
            Board.clearScreen();
            System.out.println("Enabled ASCII");
        }

        // Entering the player count
        System.out.print("Enter the number of players: (Up to 4 players): ");
        int playerCount = inputValidInt();
        while (playerCount < 1 || playerCount > 4) {
            if (playerCount < 1) {
                System.out.println("Error: Can't have less than 1 player. Please enter a whole number between 1 and 4");
                playerCount = inputValidInt();
            } else if (playerCount > 4) {
                System.out
                        .println("Error: Can't have more than 4 players. Please enter a whole number between 1 and 4");
                playerCount = inputValidInt();
            }
        }

        // Setting up the board and rules
        File rules = new File("Rules.txt");
        Scanner r = new Scanner(rules);
        RuleSet r1 = new RuleSet(r.next(), r.nextInt(), playerCount,
                r.nextInt(), r.nextInt(), chutes, ladders);
        Board b1 = new Board(r1);
        endGame = r1.getDimension() * r1.getDimension();
        ArrayList<Player> players = new ArrayList<>();
        Menu m1 = new Menu(players);

        // Creating players
        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String name = in.next();
            players.get(i).addTrait(Name.KEY, new Name(name));
            players.get(i).addTrait(Identifier.KEY,
                    new Identifier((String) players.get(i).getTrait(Name.KEY).getTraitValue()));
            players.get(i).addTrait(Score.KEY, new Score(0));
            if (Board.ASCII_TOGGLE) {
                players.get(i).addTrait(Color.KEY, new Color());
                System.out.println(players.get(i).getTrait(Color.KEY).getTraitValue() + "Identifier: "
                        + players.get(i).getTrait(Identifier.KEY).getTraitValue() + ", Player: "
                        + players.get(i).getPlayerNumber() + Color.ASCII_RESET);
            } else {
                System.out
                        .println("Identifier: " + players.get(i).getTrait(Identifier.KEY).getTraitValue() + ", Player: "
                                + players.get(i).getPlayerNumber());
            }
        }
        in.nextLine();
        // System.out.println();

        /**
         * Here is the main game loop.
         * Anytime it loops, all players roll their die, then check to see what space
         * they've landed on (endGame, ladder, chute)
         */

        if (Board.ASCII_TOGGLE) {
            Board.clearScreen();
            cycleDice();
        }

        b1.drawBoard();
        System.out.println("Let the game begin!");
        m1.printMenu();
        while (!finish) {
            // System.out.println("Turn: " + turnCount);
            for (Player player : players) {
                // System.out.println(player.getTrait(Identifier.KEY).getTraitValue() + " it is
                // your turn."
                // + " Input -m for menu, or -r to roll the dice");
                if (!AUTO_PLAY) {
                    String command = in.nextLine();
                    while (!command.equals("-r")) {
                        m1.recieveCommand(command);
                        if (command.equals("-a")) {
                            break;
                        }
                        System.out.print("|(-c): ");
                        command = in.nextLine();
                        // if (command.equals("-m")) {
                        // m1.printMenu();
                        // m1.recieveCommand(in.nextLine());
                        // System.out.println("\nInput -m for menu, or -r to roll the dice");
                        // command = in.nextLine();
                        // } else {
                        // System.out.println("Invalid input");
                        // command = in.nextLine();
                        // }
                    }
                }
                // interpret the in.nextLine() for enter or commands

                // m1.printScores();
                // b1.clearScreen();
                // drawDice() - Handled in playerMovement()
                // clear screen
                // b1.drawBoard()
                // printScreen()

                player.addTrait(Score.KEY,
                        new Score(playerMovement(player, (int) player.getTrait(Score.KEY).getTraitValue(),
                                b1, chutes, ladders)));
                // System.out.println();

                /*
                 * Checks to see if the player who just moved landed on, or went past endGame
                 * If the player landed on endGame, the game is over and that player wins
                 * If they went past, it move the player back by how many spaces over they
                 * would've gone
                 */
                if ((int) player.getTrait(Score.KEY).getTraitValue() >= endGame) {
                    finish = true;
                    System.out.println(player.getTrait(Name.KEY).getTraitValue() + " you win!");
                    break;
                } else if ((int) player.getTrait(Score.KEY).getTraitValue() > endGame) {
                    int moveBack = (int) player.getTrait(Score.KEY).getTraitValue() % endGame;
                    player.addTrait(Score.KEY, new Score(endGame - moveBack));
                    System.out.println("You went too far and fell back " + moveBack + " spaces.");
                    System.out.println("You're now at " + player.getTrait(Score.KEY).getTraitValue());
                    System.out.println("");
                }
                m1.printMenu();
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(3000);
            }
            // If no players win, displays everyone's current positions at the end of a turn
            if (!finish) {
                // System.out.println("End of turn: " + turnCount);
                turnCount++;
                // System.out.println("Positions: \n");
            }

        }

        // Once a player has landed on endGame, displays the final scores of every
        // player
        System.out.println(" ");
        System.out.println("Final Scores: ");
        m1.printScores();
        ScoreManager scoreManager = new ScoreManager();
        // Write a score
        for (Player player : players) {
            scoreManager.writeScore((String)player.getTrait(Identifier.KEY).getTraitValue(), (int)player.getTrait(Score.KEY).getTraitValue());
        }
        // Display scores in the terminal
        scoreManager.displayScores();
    }

    // Input validation method
    public static int inputValidInt() {
        Scanner in = new Scanner(System.in);
        while (true) {
            if (!in.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a whole number between 1 and 4");
                in.next();
            } else {
                return in.nextInt();
            }
        }
    }

    // Method for moving a player
    // b is used to draw the board, i is used to update the player score
    public static int playerMovement(Player p, int i, Board b, ArrayList<Events> c, ArrayList<Events> l)
            throws InterruptedException {
        // System.out.println("");
        if (Board.ASCII_TOGGLE) {
            Board.clearScreen();
            cycleRandomDice();
        }
        DiceCode d = new DiceCode();
        int movement = d.randomDice();
        // System.out.println("You rolled a " + movement);
        // System.out.println("You moved from " + i + " to " + (i + movement));
        // move player via movePlayer() and get player square with findPlayer() - Should
        // be good, may want to check this
        if ((int) (p.getTrait(Score.KEY).getTraitValue()) + movement <= 100) {
            b.movePlayer(p, (int) p.getTrait(Score.KEY).getTraitValue() + movement);
        } else {
            b.movePlayer(p, Math.abs(100 - ((int) p.getTrait(Score.KEY).getTraitValue() + movement)));
        }

        i += movement;

        for (int j = 0; j < c.size(); j++) {
            if (i == c.get(j).getSource()) {
                // System.out.println("You landed on a chute on space: " + c.get(j).getSource()
                // + ". Go to space: " + c.get(j).getDestination());
                System.out.printf("Player %d landed on a chute!\n", p.getPlayerNumber());
                i = c.get(j).getDestination();
                b.movePlayer(p, c.get(j).getDestination());
            }
        }

        for (int j = 0; j < l.size(); j++) {
            if (i == l.get(j).getSource()) {
                // System.out.println("You landed on a ladder on space: " + l.get(j).getSource()
                // + ". Go to space: " + l.get(j).getDestination());
                System.out.printf("Player %d landed on a ladder!\n", p.getPlayerNumber());
                i = l.get(j).getDestination();
                b.movePlayer(p, l.get(j).getDestination());
            }
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        b.drawBoard();
        return i;
    }

    public static void cycleDice() throws InterruptedException {
        DiceCode.diceOne();
        TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
        Board.clearScreen();
        DiceCode.diceTwo();
        TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
        Board.clearScreen();
        DiceCode.diceThree();
        TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
        Board.clearScreen();
        DiceCode.diceFour();
        TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
        Board.clearScreen();
        DiceCode.diceFive();
        TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
        Board.clearScreen();
        DiceCode.diceSix();
        TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
        Board.clearScreen();
    }

    public static void cycleRandomDice() throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            DiceCode random = new DiceCode();
            random.randomDice();
            TimeUnit.MILLISECONDS.sleep(CYCLE_DELAY);
            Board.clearScreen();
        }
    }
}
