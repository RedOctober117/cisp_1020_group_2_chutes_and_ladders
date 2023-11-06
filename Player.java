// import java.util.ArrayList;
import java.util.HashMap;

// Hashmap traits, make trait keys constant strings to enforce uniformity

public class Player implements Comparable<Object> {
    private int index;
    // private ArrayList<PlayerTrait<?>> traits;
    private HashMap<String, PlayerTrait<?>> traits;

    public Player(int index) {
        this.index = index;
        // this.traits = new ArrayList<>();
        this.traits = new HashMap<>();
    }

    public int getIndex() {
        return this.index;
    }

    public void addTrait(String key, PlayerTrait<?> trait) {
        // this.traits.add(trait);
        this.traits.put(key, trait);
    }

    public void removeTrait(String key) {
        // this.traits.remove(trait);
        this.traits.remove(key);
    }

    public HashMap<String, PlayerTrait<?>> getTraits() {
        return this.traits;
    }

    public PlayerTrait<?> getTrait(String key) {
        return traits.get(key);
    }

    // public String listTraits() {
    //     String traitString = "";
    //     for (PlayerTrait<?> trait : this.traits) {
    //         traitString += trait.toString();
    //     }
    //     return traitString;
    // }
    public String listTraits() {
        String traitString = "";
        for (String key : this.traits.keySet()) {
            traitString += key;
        }
        return traitString;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player obj = (Player) o;
            if (obj.getIndex() == index) {
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

    // list traits
    @Override
    public String toString() {
        // return String.format("{{Index: %d} %s}", getIndex(), listTraits());
        return String.format("{{Index: %d} %s}", getIndex(), listTraits());
    }
}
