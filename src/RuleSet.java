// Bruce

import java.util.ArrayList;

/**
 * RuleSet is designed to handle the rules of the game. The original design was
 * intended to store all relavant rules, and make it easy to create new rule
 * sets, but that functionality has since moved elsewhere. Parts of this class
 * are still required for the game to work, however.
 */
public class RuleSet {
  private final String name;
  private final int dimension;
  private final int playerCount;
  private final int diceCount;
  private final int rollDelta;
  private final ArrayList<Events> chutes;
  private final ArrayList<Events> ladders;

  /**
   * Constructor for a RuleSet
   * 
   * @param name        name of the ruleset
   * @param dimension   the dimsnsion of the board
   * @param playerCount (DEPRECIATED) the number of players
   * @param diceCount   (DEPRECIATED) number of dice
   * @param rollDelta   (DEPRECIATED) whether or not a player has to roll exactly
   *                    on to the last square
   * @param chutes      ArrayList of all chutes, as Event objects
   * @param ladders     ArrayList of all ladders, as Event objects
   */
  public RuleSet(String name, int dimension, int playerCount, int diceCount, int rollDelta, ArrayList<Events> chutes,
      ArrayList<Events> ladders) {
    this.name = name;
    this.dimension = dimension;
    this.playerCount = playerCount;
    this.diceCount = diceCount;
    this.rollDelta = rollDelta;
    this.chutes = chutes;
    this.ladders = ladders;
  }

  /**
   * Return the dimension of the board
   * @return int
   */
  public int getDimension() {
    return this.dimension;
  }

  /**
   * (DEPRECIATED)
   * Return the number of players
   * @return int
   */
  public int getPlayerCount() {
    return this.playerCount;
  }
}
