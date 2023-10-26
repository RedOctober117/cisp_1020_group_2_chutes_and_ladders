// package chutes_and_ladders_rework;

import java.util.ArrayList;
import java.util.HashMap;

public class DrawBoard {
    public static void drawBoard(ArrayList<Coords> playerData){
        int dimension = 8;
        int horizontal_scalar = 6;
        int vertical_scalar = 3;

        int scaled_horizontal_dimension = (dimension * horizontal_scalar) + 1;
        int scaled_vertical_dimension = (dimension * vertical_scalar) + 1;

        int x = 0;
        int y = 0;

        while(y < scaled_vertical_dimension) {
            if(y % 3 == 0 || y == 0) {
                while(true) {
                    if(x == scaled_horizontal_dimension) {
                        break;
                    }
                    System.out.print("*");
                    x++;
                }
            } else {
                while(true) {
                    if(x == scaled_horizontal_dimension) {
                        break;
                    }
                    if(x % horizontal_scalar == 0 || x == 0) {
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
