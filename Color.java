import java.util.Random;

public class Color implements PlayerTrait<String> {
    
    public static final String KEY = "Color";

    public static final String ASCII_RESET = "\u001B[37m";
    public static final String[] ASCII_CODES = {"\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"};

    static Random rand = new Random();
    static int generatedInt = rand.nextInt(4);

    private String generatedColor;

    public Color() {
        this.generatedColor = ASCII_CODES[generatedInt++];
    }

    public String getColor() {
        return this.generatedColor;
    }

    public String getTraitValue() {
        return getColor();
    }

    public void setTraitValue(String color) {}
}
