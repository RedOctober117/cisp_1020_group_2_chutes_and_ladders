import java.util.ArrayList;
import java.util.TreeMap;

public class Board {
    public static boolean ASCII_TOGGLE;

    private ArrayList<Square> squares;
    private RuleSet rules;

    /**
     * constructor which uses the rules held in a RuleSet object
     * 
     * @param rules 
     */
    public Board(RuleSet rules) {
        this.squares = new ArrayList<>();
        this.rules = rules;
        generateSquares();
    }

    /**
     * generates a number of squares specified by the rules
     */
    private void generateSquares() {
        for (int i = 1; i <= Math.pow(this.rules.getDimension(), 2); i++) {
            this.squares.add(new Square(i, this.rules));
        }
    }

    /**
     * returns the number of squares on the board
     * @return 
     */
    public ArrayList<Square> getSquares() {
        return this.squares;
    }
    
    /**
     * for the number of Player in players, add that many players to the
     * array list squares
     * @param players 
     */
    public void addPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            squares.get(0).addPlayer(player);
        }
    }

    /**
     * scans all squares until it finds a space with the target player on it
     * and then moves them to a different space (squareNumber)
     * @param player
     * @param squareNumber 
     */
    public void movePlayer(Player player, int squareNumber) {
        for (Square sq : squares) {
            if (sq.getPlayers().contains(player)) {
                sq.removePlayer(player);
            }
        }
        squares.get(squareNumber - 1).addPlayer(player);
    }

    /**
     * returns the reference of a certain square
     * 
     * @param squareNumber
     * @return 
     */
    public Square getSquareReference(int squareNumber) {
        return squares.get(squareNumber - 1);
    }
/**
 * returns a toString format of the reference held in squares
 * 
 * @param squareNumber
 * @return 
 */
    public String getSquareInformation(int squareNumber) {
        return squares.get(squareNumber - 1).toString();
    }

    /**
     * returns the coordinates of each player
     * 
     * @param squareNumber
     * @return 
     */
    public TreeMap<Player, Coords> getPlayerCoords(int squareNumber) {
        return squares.get(squareNumber - 1).getPlayerCoords();
    }

    /**
     * toggles ascii on/off with a boolean value
     * 
     * @param flip 
     */
    public static void toggleAscii(boolean flip) {
      ASCII_TOGGLE = flip;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * prints the board to the specifications held in RuleSet
     * adds an appropriate number of players to the board
     * uses a coordinate system for each character
     */
    public void drawBoard(){
        int dimension = this.rules.getDimension();
        final int horizontal_scalar = 6;
        final int vertical_scalar = 3;
        
        String border = "\u001B[35m*\u001B[0m";
        if (!Board.ASCII_TOGGLE) {
          border = "*";
        }
        
        int scaled_horizontal_dimension = (dimension * horizontal_scalar) + 1;
        int scaled_vertical_dimension = (dimension * vertical_scalar) + 1;
        
        int x = 0;
        int y = 0;
        
        // clearScreen();
        String buffer = "";
        while (y < scaled_vertical_dimension) {
            if (y % 3 == 0 || y == 0) {
                while (true) {
                    if (x == scaled_horizontal_dimension) {
                        break;
                    }
                    buffer += border;
                    x++;
                }
            } else {
                while (true) {
                    if (x == scaled_horizontal_dimension) {
                        break;
                    }
                    if (x % horizontal_scalar == 0 || x == 0) {
                        buffer += border;
                        x++;
                    } else {
                        for (Square square : this.squares) {
                            if (square.hasPlayers()) {
                                TreeMap<Player, Coords> playerData = square.getPlayerCoords();
                                for (Player player : playerData.keySet()) {
                                    if (playerData.get(player).getX() == x & playerData.get(player).getY() == y) {
                                        try {
                                          if (Board.ASCII_TOGGLE) {
                                            buffer += String.format("%s%d%s", player.getTrait(Color.KEY).getTraitValue(), player.getPlayerNumber(), Color.ASCII_RESET);
                                            x++;    
                                          } else {
                                            buffer += String.format("%d", player.getPlayerNumber());
                                            x++;    
                                          }
                                        } catch (Exception e) {
                                            buffer += String.format("%d", player.getPlayerNumber());
                                            x++;    
                                        }
                                    }
                                }
                            }
                        }
                        buffer += " ";
                        x++;
                    }
                }
            }
            buffer += "\n";
            x = 0;
            y++;
        }
        System.out.println(buffer);
    }
}
