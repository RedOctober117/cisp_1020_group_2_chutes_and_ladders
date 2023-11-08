public class Identifier implements PlayerTrait<String> {
    
    public static final String KEY = "Identifier";
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

    @Override
    public String getTraitValue() {
        return getIdentifier();
    }

    @Override
    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }

    @Override
    public String toString() {
        return String.format("{{Trait: %s} {Identifier: %s}}", Identifier.KEY, this.identifier);
    }
}
