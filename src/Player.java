// Bruce + Levi

import java.util.HashMap;

public class Player implements Comparable<Object>
{
    private HashMap<String, PlayerTrait<?>> traits;
    private static int lastPlayerNum = 0; 
    private final int PLAYERNUM;
    private int playerPos = 0;

    /**
     * Creates a Player object. Only needs a name for input
     * Also ensures that every player has an individual number 
     */
    public Player() 
    {
        lastPlayerNum++;
        PLAYERNUM = lastPlayerNum;
        this.traits = new HashMap<>();
    }    
    
    /**
     * Returns a given player's number
     * @return 
     */
    public int getPlayerNumber() {
        return PLAYERNUM;
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
            if (obj.getPlayerNumber() == PLAYERNUM) {
                return true;
            }
        }
        return false;
    } 

    @Override
    public int compareTo(Object o) {
        if (o instanceof Player) {
            Player obj = (Player)o;
            if (this.PLAYERNUM < obj.getPlayerNumber()) {
                return -1;
            } else if (this.PLAYERNUM > obj.getPlayerNumber()) {
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
