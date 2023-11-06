import java.util.ArrayList;
import java.util.TreeMap;

public class Board {
    private ArrayList<Square> squares;

    public Board(RuleSet rules) {
        this.squares = new ArrayList<Square>();
        generateSquares(rules);
    }

    private void generateSquares(RuleSet rules) {
        for (int i = 1; i <= Math.pow(rules.getDimension(), 2); i++) {
            this.squares.add(new Square(i, rules));
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

    public void movePlayer(Player player, int squareNumbr) {
        for (Square sq : squares) {
            if (sq.getPlayers().contains(player)) {
                sq.removePlayer(player);
            }
        }
        squares.get(squareNumbr - 1).addPlayer(player);
    }

    public Square getSquareReference(int index) {
        return squares.get(index - 1);
    }

    public String getSquareInformation(int index) {
        return squares.get(index - 1).toString();
    }

    public TreeMap<Player, Coords> getPlayerCoords(int squareNumber) {
        return squares.get(squareNumber - 1).getPlayerCoords();
    }

    public void drawBoard(RuleSet rules){
        int dimension = rules.getDimension();
        final int horizontal_scalar = 6;
        final int vertical_scalar = 3;
        
        final String border = "\u001B[35m*\u001B[0m";
        
        int scaled_horizontal_dimension = (dimension * horizontal_scalar) + 1;
        int scaled_vertical_dimension = (dimension * vertical_scalar) + 1;
        
        int x = 0;
        int y = 0;
        
        String buffer = "";
        while (y < scaled_vertical_dimension) {
            if (y % 3 == 0 || y == 0) {
                while (true) {
                    if (x == scaled_horizontal_dimension) {
                        break;
                    }
                    // System.out.print(border);
                    buffer += border;
                    x++;
                }
            } else {
                while (true) {
                    if (x == scaled_horizontal_dimension) {
                        break;
                    }
                    if (x % horizontal_scalar == 0 || x == 0) {
                        // System.out.print(border);
                        buffer += border;
                        x++;
                    } else {
                        for (Square square : this.squares) {
                            if (square.hasPlayers()) {
                                TreeMap<Player, Coords> playerData = square.getPlayerCoords();
                                for (Player player : playerData.keySet()) {
                                    if (playerData.get(player).getX() == x & playerData.get(player).getY() == y) {
                                        // boolean found = false;
                                        // for (PlayerTrait<?> trait : player.getTraits()) {
                                        //     if (trait instanceof Identifier) {
                                        //         Identifier convertedTrait = (Identifier) trait;
                                        //         found = true;
                                        //         System.out.printf("%s%d%s", convertedTrait.getColor(), player.getIndex(), Identifier.ASCII_RESET);
                                        //         x++;
                                        //         break;
                                        //     }
                                        // }
                                        // if (!found){
                                        //     System.out.printf("%d", player.getIndex());
                                        //     x++;
                                        //     break;
                                        // }
                                        try {
                                            // System.out.printf("%s%d%s", player.getTrait(Color.KEY).getTraitValue(), player.getIndex(), Color.ASCII_RESET);
                                            buffer += String.format("%s%d%s", player.getTrait(Color.KEY).getTraitValue(), player.getIndex(), Color.ASCII_RESET);
                                            x++;    
                                        } catch (Exception e) {
                                            // System.out.printf("%d", player.getIndex());
                                            buffer += String.format("%d", player.getIndex());
                                            x++;    
                                        }
                                        // if (!(player.getTrait(Color.COLOR).getTraitValue() == null)) {
                                            // break;
                                        // } else {
                                        // }
                                        // break;
                                        //     }
                                        // }
                                    }
                                }
                            }
                        }
                        // System.out.print(" ");
                        buffer += " ";
                        x++;
                    }
                }
            }
            // System.out.println("");
            buffer += "\n";
            x = 0;
            y++;
        }
        System.out.println(buffer);
    }
}
