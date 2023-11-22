// Orion

import java.util.Random;

public class DiceCode {
    // private static Random randomGenerator = new Random();

    public DiceCode()
    {
        
    }

    public int randomDice() {
        int min = 1;
        int max = 6;

        // Generate a random number between min and max
        Random r = new Random();
        int randomNumber = r.nextInt((max - min) + 1) + min;
        // int randNumber = randomGenerator.nextInt(6);
        switch (randomNumber) {
            case 1:
                diceOne();
                break;
            case 2:
                diceTwo();
                break;
            case 3:
                diceThree();
                break;
            case 4:
                diceFour();
                break;
            case 5:
                diceFive();
                break;
            case 6:
                diceSix();
                break;
        }
        return randomNumber;
    }

    //
    public static void diceOne() {
        System.out.println("    ____________");
        System.out.println("   / *     *   /|");
        System.out.println("  /           / |");
        System.out.println(" /  *     *  /  |");
        System.out.println("------------- * |");
        System.out.println("|           |   |");
        System.out.println("|           |   |");
        System.out.println("|     *     |   |");
        System.out.println("|           | */");
        System.out.println("|           | /");
        System.out.println("-------------");
    }

    public static void diceTwo() {
        System.out.println("    ____________");
        System.out.println("   /           /|");
        System.out.println("  /     *     / |");
        System.out.println(" /           /  |");
        System.out.println("------------- * |");
        System.out.println("|           |   |");
        System.out.println("|           | * |");
        System.out.println("|  *     *  |   |");
        System.out.println("|           | */");
        System.out.println("|           | /");
        System.out.println("-------------");
    }

    public static void diceThree() {
        System.out.println("    ____________");
        System.out.println("   / *     *   /|");
        System.out.println("  /     *     / |");
        System.out.println(" /  *     *  /  |");
        System.out.println("------------- * |");
        System.out.println("|           |   |");
        System.out.println("|     *     |   |");
        System.out.println("|           |   |");
        System.out.println("|  *     *  | */");
        System.out.println("|           | /");
        System.out.println("-------------");
    }

    public static void diceFour() {
        System.out.println("    ____________");
        System.out.println("   /           /|");
        System.out.println("  /     *     / |");
        System.out.println(" /           /  |");
        System.out.println("------------- * |");
        System.out.println("|           |   |");
        System.out.println("|  *     *  |   |");
        System.out.println("|           |   |");
        System.out.println("|  *     *  | */");
        System.out.println("|           | /");
        System.out.println("-------------");
    }

    public static void diceFive() {
        System.out.println("    ____________");
        System.out.println("   /    *      /|");
        System.out.println("  /           / |");
        System.out.println(" /  *     *  / *|");
        System.out.println("-------------*  |");
        System.out.println("|  *     *  |   |");
        System.out.println("|           |   |");
        System.out.println("|     *     |  *|");
        System.out.println("|           |* /");
        System.out.println("|  *     *  | /");
        System.out.println("-------------");
    }

    public static void diceSix() {
        System.out.println("    ____________");
        System.out.println("   /           /|");
        System.out.println("  /  *     *  / |");
        System.out.println(" /           / *|");
        System.out.println("-------------*  |");
        System.out.println("|  *     *  |   |");
        System.out.println("|           |   |");
        System.out.println("|  *     *  |  *|");
        System.out.println("|           |* /");
        System.out.println("|  *     *  | /");
        System.out.println("-------------");
    }

}
