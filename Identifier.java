import java.util.Random;

public class Identifier implements PlayerTrait<String> {

    public static final String KEY = "Identifier";

    // public static final String ASCII_RESET = "\u001B[37m";
    // public static final String[] ASCII_CODES = {"\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"};
    static Random rand = new Random();
    static int generatedInt = rand.nextInt(4);

    private String identifier;
    // private String generatedColor;

    public Identifier(String identifier) {
        // this.generatedColor = ASCII_CODES[generatedInt++];
        // this.identifier =  generatedColor + identifier + ASCII_RESET;
        this.identifier = identifier;

    }

    public void setIdentifier(String identifier) {
        // this.identifier = generatedColor + identifier + ASCII_RESET;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    // public String getColor() {
    //     return this.generatedColor;
    // }

    public String getTraitValue() {
        return getIdentifier();
    }

    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }

    @Override
    public String toString() {
        // return String.format("{{Trait: %s} {Identifier: %s} {Color: %sCOLOR_ME%s}}", getClass(), this.identifier, this.generatedColor, ASCII_RESET);
        return String.format("{{Trait: %s} {Identifier: %s}}", Identifier.KEY, this.identifier);
    }
}
