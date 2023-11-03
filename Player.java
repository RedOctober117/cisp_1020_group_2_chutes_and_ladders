import java.util.Random;

public class Player implements Comparable {

    public static final String ASCII_RESET = "\u001B[37m";
    public static final String[] ASCII_CODES = {"\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"};
    static Random rand = new Random();
    static int generatedInt = rand.nextInt(4);

    private String identifier;
    private int index;
    private String generatedColor;

    public Player(String ident, int index) {
        this.generatedColor = ASCII_CODES[generatedInt++];
        this.identifier =  generatedColor + ident + ASCII_RESET;
        this.index = index;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getIndex() {
        return this.index;
    }

    public String getColor() {
        return this.generatedColor;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player obj = (Player) o;
            if (obj.getIndex() == index && obj.getIdentifier().equals(identifier)) {
                return true;
            }
        }
        return false;
    } 

    @Override
    public int compareTo(Object o) {
        if (o instanceof Player) {
            Player obj = (Player)o;
            if (this.index < obj.getIndex()) {
                return -1;
            } else if (this.index > obj.getIndex()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("{{Identifier: \"%s\"} {Index: %d}}", this.identifier, this.index);
    }
}
