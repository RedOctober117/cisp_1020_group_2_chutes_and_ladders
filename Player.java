public class Player implements Comparable {
    private String identifier;
    private int index;

    public Player(String ident, int index) {
        this.identifier = ident;
        this.index = index;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int getIndex() {
        return this.index;
    }

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
