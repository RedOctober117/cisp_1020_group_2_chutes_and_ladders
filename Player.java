import java.util.ArrayList;

public class Player implements Comparable<Object> {
    private int index;
    private ArrayList<PlayerTrait<?>> traits;

    public Player(int index) {
        this.index = index;
        this.traits = new ArrayList<>();
    }

    public int getIndex() {
        return this.index;
    }

    public void addTrait(PlayerTrait<?> trait) {
        this.traits.add(trait);
    }

    public void removeTrait(PlayerTrait<?> trait) {
        this.traits.remove(trait);
    }

    public ArrayList<PlayerTrait<?>> getTraits() {
        return this.traits;
    }

    public String listTraits() {
        String traitString = "";
        for (PlayerTrait<?> trait : this.traits) {
            traitString += trait.toString();
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
        return String.format("{{Index: %d} %s}", getIndex(), listTraits());
    }
}
