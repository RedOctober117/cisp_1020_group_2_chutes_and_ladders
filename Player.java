import java.util.HashMap;

// Hashmap traits, make trait keys constant strings to enforce uniformity

public class Player implements Comparable<Object> {
    private int playerNumber;
    private HashMap<String, PlayerTrait<?>> traits;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        this.traits = new HashMap<>();
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public void addTrait(String key, PlayerTrait<?> trait) {
        this.traits.put(key, trait);
    }

    public void removeTrait(String key) {
        this.traits.remove(key);
    }

    public boolean searchTraits(String key) {
        return traits.containsKey(key);
    }

    public PlayerTrait<?> getTrait(String key) {
        return traits.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player obj = (Player) o;
            if (obj.getPlayerNumber() == playerNumber) {
                return true;
            }
        }
        return false;
    } 

    @Override
    public int compareTo(Object o) {
        if (o instanceof Player) {
            Player obj = (Player)o;
            if (this.playerNumber < obj.getPlayerNumber()) {
                return -1;
            } else if (this.playerNumber > obj.getPlayerNumber()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("{{Player Number: %d} {Traits: %d}}", getPlayerNumber(), this.traits.size());
    }
}
