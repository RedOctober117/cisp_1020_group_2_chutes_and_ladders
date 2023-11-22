// Bruce + Levi

import java.util.Random;

/**
 * Identifierr provides a way to store the players name. It holds their name as
 * a string, and a 3 letter substring as their Identifier, similar to arcade
 * cabinets.
 */
public class Identifier implements PlayerTrait<String> {
    public static final String KEY = "Identifier";
    static Random rand = new Random();
    static int generatedInt = rand.nextInt(4);
    private Name n;
    private Player p;

    private String identifier;

    /**
     * at the start of the game each player enters their name
     * the identifier is the first three letters of their name
     * it is a trait unique to each player
     * 
     * @param identifier
     */
    public Identifier(String identifier) {
        this.identifier = identifier;

    }

    /**
     * changes the value of the identifier
     * 
     * @param identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * returns the value of the identifier
     * 
     * @return
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * returns the value of the identifier as a trait
     * 
     * @return
     */
    @Override
    public String getTraitValue() {
        while (identifier.length() < 3) {
            identifier = identifier + "#"; // This can be whatever chracter works best. # is a placeholder
        }
        return (getIdentifier().substring(0, 3)).toUpperCase();
    }

    /**
     * changes the value of the identifier as a trait
     * 
     * @param identifier
     */
    @Override
    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }

    /**
     * returns the value identifier key as well as the string associated with it
     * 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("{{Trait: %s} {Identifier: %s}}", Identifier.KEY, this.identifier);
    }
}
