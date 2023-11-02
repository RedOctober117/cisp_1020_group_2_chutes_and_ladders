import java.util.ArrayList;

public class RuleSet {
  private final String name;
  private final int dimension;
  private final int playerCount;
  private final int diceCount;
  private final int rollDelta;
  private final ArrayList<Integer> chutes;
  private final ArrayList<Integer> ladders;


  public RuleSet(String name, int dimension, int playerCount, int diceCount, int rollDelta, ArrayList<Integer> chutes, ArrayList<Integer> ladders) {
    this.name = name;
    this.dimension = dimension;
    this.playerCount = playerCount;
    this.diceCount = diceCount;
    this.rollDelta = rollDelta;
    this.chutes = chutes;
    this.ladders = ladders;
  }


  public int getDimension(){
    return this.dimension;
  }
}
