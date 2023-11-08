import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Square generates coordinates for the four possible player locations, and
 * stores a reference to 0..4 playeres on the Square
 */
public class Square {

  private static ArrayList<Integer> indexCollection1;
  private static ArrayList<Integer> indexCollection2;

  private int squareNumber;
  private ArrayList<Player> players;
  private ArrayList<Coords> coords;

  /**
   * Construct new Square and generate collection of Y values if indexCollectionX
   * arrays are empty
   * 
   * @param squareNumber The number of the square, not adjusted for indexing, ie.
   *                     board square 1 is passed in as 1
   * @param rules        The RuleSet of the game, used to determine the dimension
   *                     of the board
   */
  public Square(int squareNumber, RuleSet rules) {
    this.squareNumber = squareNumber;
    this.coords = new ArrayList<Coords>();
    this.players = new ArrayList<Player>();
    Square.indexCollection1 = new ArrayList<Integer>();
    Square.indexCollection2 = new ArrayList<Integer>();
    if (indexCollection1.isEmpty() & indexCollection2.isEmpty()) {
      generateYSquares(rules.getDimension());
    }
    generateCoords(rules);
  }

  /**
   * Retrieve Square board number
   * 
   * @return squareNumber
   */
  public int getNumber() {
    return this.squareNumber;
  }

  /**
   * Retrieve Coords for a given player number
   * 
   * @param playerNumber Player number, 1-4
   * @return Coords object cooresponding to playerNumber
   */
  public Coords getPlayerCoord(int playerNumber) {
    return coords.get(playerNumber);
  }

  /**
   * Check if Square contains any Player references
   * 
   * @return True if 1..4 Player references
   */
  public boolean hasPlayers() {
    return !players.isEmpty();
  }

  /**
   * Add Player reference to Square
   * 
   * @param player Player object
   */
  public void addPlayer(Player player) {
    players.add(player);
  }

  /**
   * Remove player reference from Square
   * 
   * @param player Player object
   */
  public void removePlayer(Player player) {
    players.remove(player);
  }

  /**
   * Retrieve ArrayList of players
   * 
   * @return players list
   */
  public ArrayList<Player> getPlayers() {
    return this.players;
  }

  /**
   * Generate Coords for the Square, based upon the squareNumber and RuleSet
   * 
   * @param rules RuleSet object containing board dimensions
   */
  private void generateCoords(RuleSet rules) {
    for (int i = 0; i < 4; i++) {
      this.coords.add(new Coords(squareToX(this.squareNumber, i + 1, rules.getDimension()),
          squareToY(this.squareNumber, i + 1, rules.getDimension())));
    }
  }

  /**
   * Retrieve a collectin pairing Players with their Coords
   * 
   * @return TreeMap of Player, Coords>
   */
  public TreeMap<Player, Coords> getPlayerCoords() {
    TreeMap<Player, Coords> playerCoordsPairing = new TreeMap<>();
    for (Player player : players) {
      playerCoordsPairing.put(player, coords.get(player.getPlayerNumber() - 1));
    }
    return playerCoordsPairing;
  }

  /**
   * Calculate the Coords object for a given Square and playerNumber. For players
   * 1 and 3, x = truncated square value * board scalar - 4. For 2 and 4, x =
   * truncated square value * board scalar - 2. Truncating the square involves
   * taking the floor of the square at the ones position, giving an even 10
   * multiple. Subtract the original square number by the truncated value to get
   * an int between 1-10, then multiply by 6 and subtract 4. For even multiples of
   * the board dimension, convert directly to 1. For odds, convert directly to
   * board dimension.
   * 
   * @param squareNumber   Square board number
   * @param playerNumber   Player number
   * @param boardDimension Board dimension from RuleSet
   * @return
   */
  private static int squareToX(int squareNumber, int playerNumber, int boardDimension) {
    int effective_space = squareNumber;
    if (effective_space > boardDimension) {
      if (effective_space % boardDimension == 0 & (effective_space / boardDimension) % 2 == 0) {
        effective_space = 1;
      }

      if (effective_space % boardDimension == 0) {
        effective_space = boardDimension;
      } else {
        if ((int) Math.floor((effective_space / boardDimension)) % 2 == 0) {
          effective_space = effective_space - boardDimension * ((int) Math.floor(effective_space / boardDimension));
        } else {
          effective_space = (((int) (effective_space / boardDimension) * boardDimension) + boardDimension)
              - (effective_space - 1);
        }
      }
    }

    if (playerNumber == 1 | playerNumber == 3) {
      return effective_space * 6 - 4;
    } else {
      return effective_space * 6 - 2;
    }
  }

  /**
   * Generate ArrayLists of Y values. Ys are calculated by starting at y=1 and
   * y=2, and adding 3 while both lists are less than the board dimension * 3.
   * 
   * @param boardDimension RuleSet board dimension
   */
  private static void generateYSquares(int boardDimension) {
    int indexCounter = 1;
    while (indexCounter < boardDimension * 3) {
      indexCollection1.add(indexCounter);
      indexCounter += 3;
    }

    indexCounter = 2;
    while (indexCounter < boardDimension * 3) {
      indexCollection2.add(indexCounter);
      indexCounter += 3;
    }
  }

  /**
   * Convert Square number to Y. squareNumber is truncated to the floor of the
   * ones place and the subtracted from the boardDimension to calculate the
   * sector. If the square is a multiple of the boardDimension or the sector is 0,
   * add 1 to sector. This is to prevent the boardDimension and squares directly
   * vertical from it from producing an out of bounds error when accessing the
   * array.
   * 
   * @param squareNumber Square board number
   * @param playerNumber Player number, not compensated for array access
   * @param boardDimension Board dimension from RuleSet
   * @return Y value for given Square and player number
   */
  private static int squareToY(int squareNumber, int playerNumber, int boardDimension) {
    int sector = boardDimension - ((int) Math.floor(squareNumber / boardDimension));
    if (squareNumber % boardDimension == 0 | sector == 0) {
      sector++;
    }

    if (playerNumber == 1 | playerNumber == 2) {
      return Square.indexCollection1.get(sector - 1);
    }
    return Square.indexCollection2.get(sector - 1);
  }

  @Override
  public String toString() {
    return String.format("#%s\n%s %s\n%s %s", this.squareNumber, coords.get(0), coords.get(1), coords.get(2),
        coords.get(3));
  }
}
