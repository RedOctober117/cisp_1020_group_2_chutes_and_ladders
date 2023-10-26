// package chutes_and_ladders_rework;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class DrawMenu {
    public static void drawMenu(/* UserInput obj here */){
        System.out.println(" ___________________________________\r\n" + //
                           "| Test 1 | Test 2 | Test 3 | Test 4 |\r\n" + //
                           "|12345678|   01   |   34   |   32   |");
        System.out.print("|? ");
        String userInput = new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
      ArrayList<Coords> playerData = new ArrayList<>();
      playerData.add(new Coords(2, 22, Coords.buildIdentifier('a', 'b', 'c')));
      playerData.add(new Coords(4, 22, Coords.buildIdentifier('d', 'e', 'c')));
      playerData.add(new Coords(2, 23, Coords.buildIdentifier('g', 'b', 'c')));
      playerData.add(new Coords(4, 23, Coords.buildIdentifier('j', 'b', 'c')));

      DrawBoard.drawBoard(playerData);
      System.out.println(playerData);
      // drawMenu();
    }
}
