// Bruce

/**
 * Coords is used to represent the locations of the printer in Board. Each Square will hold 4 Coords, representing the possible locations for each player.
 */
public class Coords {
    private int x;
    private int y;

    /**
     * constructor
     * creates a set of coordinates of values x and y
     * 
     * @param x int
     * @param y int
     */
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the x value of the coordinate set
     * @return 
     */
    public int getX() {
        return this.x;
    }

    /**
     * returns the y value of the coordinate set
     * @return 
     */
    public int getY() {
        return this.y;
    }

    /**
     * returns the coordinate set as a string
     * @return 
     */
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}
