//Bruce

import java.util.Random;

/**
 * Color is a player trait to provide ASCII color codes for varius use cases.
 * Color provides 8 color options and the reset value.
 */
public class Color implements PlayerTrait<String> {

    public static final String KEY = "Color";

    public static final String ASCII_RESET = "\u001B[37m";
    public static final String[] ASCII_CODES = { "\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m",
            "\u001B[35m", "\u001B[36m", "\u001B[37m" };

    static Random rand = new Random();
    static int generatedInt = rand.nextInt(4);

    private String generatedColor;

    /**
     * picks from an array of ascii codes which correspond to different colors
     * these colors are applied to each player's piece
     */
    public Color() {
        this.generatedColor = ASCII_CODES[generatedInt++];
    }

    /**
     * returns the value of the randomly selected color
     * 
     * @return
     */
    public String getColor() {
        return this.generatedColor;
    }

    /**
     * returns the value of the color as a trait
     * 
     * @return
     */
    @Override
    public String getTraitValue() {
        return getColor();
    }

    /**
     * sets the value of the color as a trait
     * 
     * @param color
     */
    @Override
    public void setTraitValue(String color) {
    }
}
