import java.util.ArrayList;
import java.util.TreeMap;

public class Board {
    private static boolean asciiToggle;
    private ArrayList<Square> squares;
    private RuleSet rules;

    public Board(RuleSet rules) {
        this.squares = new ArrayList<Square>();
        this.rules = rules;
        generateSquares();
    }

    private void generateSquares() {
        for (int i = 1; i <= Math.pow(this.rules.getDimension(), 2); i++) {
            this.squares.add(new Square(i, this.rules));
        }
    }

    public ArrayList<Square> getSquares() {
        return this.squares;
    }
    
    public void addPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            squares.get(0).addPlayer(player);
        }
    }

    public void movePlayer(Player player, int squareNumber) {
        for (Square sq : squares) {
            if (sq.getPlayers().contains(player)) {
                sq.removePlayer(player);
            }
        }
        squares.get(squareNumber - 1).addPlayer(player);
    }

    public Square getSquareReference(int squareNumber) {
        return squares.get(squareNumber - 1);
    }

    public String getSquareInformation(int squareNumber) {
        return squares.get(squareNumber - 1).toString();
    }

    public TreeMap<Player, Coords> getPlayerCoords(int squareNumber) {
        return squares.get(squareNumber - 1).getPlayerCoords();
    }

    public void toggleAscii(boolean flip) {
      this.asciiToggle = flip;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void drawBoard(){
        int dimension = this.rules.getDimension();
        final int horizontal_scalar = 6;
        final int vertical_scalar = 3;
        
        String border = "\u001B[35m*\u001B[0m";
        if (!Board.asciiToggle) {
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
                                          if (Board.asciiToggle) {
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
