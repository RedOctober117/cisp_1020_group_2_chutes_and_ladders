public class Coords {
  private int x;
  private int y;
  private char[] identifier;

  public Coords(int x, int y, char[] identifier) {
    this.x = x;
    this.y = y;
    this.identifier = identifier;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void setIdentifier(char[] identifier) {
    this.identifier = identifier;
  }

  public char getFirstIdentifier(){
    return identifier[0];
  }

  public static char[] buildIdentifier(char a, char b, char c) {
    char[] array = {a, b, c};
    return array;
  }
}
