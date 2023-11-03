public class Coords {
  private int x;
  private int y;

  public Coords(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
  
  @Override
  public String toString() {
    return String.format("(%d, %d)", this.x, this.y);
  }
}
