// package chutes_and_ladders_rework;

import java.util.Scanner;

public class DrawMenu {
    public static void drawMenu(/* UserInput obj here */){
        System.out.println(" ___________________________________\r\n" + //
                           "| Test 1 | Test 2 | Test 3 | Test 4 |\r\n" + //
                           "|12345678|   01   |   34   |   32   |");
        System.out.print("|? ");
        String userInput = new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        drawMenu();
    }
}