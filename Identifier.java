import java.util.Random;

public class Identifier implements PlayerTrait<String> {
    public static final String KEY = "Identifier";
    static Random rand = new Random();
    static int generatedInt = rand.nextInt(4);

    private String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;

    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getTraitValue() {
        return getIdentifier();
    }

    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }

    @Override
    public String toString() {
        return String.format("{{Trait: %s} {Identifier: %s}}", Identifier.KEY, this.identifier);
    }
}
