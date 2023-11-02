// package chutes_and_ladders_rework;

import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares;

    public Board(RuleSet rules) {
        this.squares = new ArrayList<Square>();
        generateSquares(rules);
    }

    public void movePlayer(Player player, int squareNumbr) {
        for (Square sq : squares) {
            if (sq.getPlayers().contains(player)) {
                sq.removePlayer(player);
            }
        }
        squares.get(squareNumbr - 1).addPlayer(player);
    }

    public void addPlayers(ArrayList<Player> players) {
        for (Player player : players) {
            squares.get(0).addPlayer(player);
        }
    }

    private void generateSquares(RuleSet rules) {
        for (int i = 1; i <= Math.pow(rules.getDimension(), 2); i++) {
            this.squares.add(new Square(i, rules));
        }
    }

    public ArrayList<Square> getSquares() {
        return this.squares;
    }

    public Square getSquareReference(int index) {
        return squares.get(index - 1);
    }

    public String getSquareInformation(int index) {
        return squares.get(index - 1).getSquareCoordinates();
    }

    public static void drawBoard(ArrayList<Player> playerData){
        int dimension = 8;
        int horizontal_scalar = 6;
        int vertical_scalar = 3;

        int scaled_horizontal_dimension = (dimension * horizontal_scalar) + 1;
        int scaled_vertical_dimension = (dimension * vertical_scalar) + 1;

        int x = 0;
        int y = 0;

        while (y < scaled_vertical_dimension) {
            if (y % 3 == 0 || y == 0) {
                while (true) {
                    if (x == scaled_horizontal_dimension) {
                        break;
                    }
                    System.out.print("*");
                    x++;
                }
            } else {
                while (true) {
                    if (x == scaled_horizontal_dimension) {
                        break;
                    }
                    if (x % horizontal_scalar == 0 || x == 0) {
                        System.out.print("*");
                        x++;
                    } else {
                        // another nested if here to loop through player cords
                        for (Coords player : playerData) {
                            if (player.getX() == x && player.getY() == y) {
                                System.out.printf("%c", player.getFirstIdentifier());
                                x++;
                                break;
                            }
                        }
                        System.out.print(" ");
                        x++;
                    }
                }
            }
            System.out.println("");
            x = 0;
            y++;
        }
    }
}
