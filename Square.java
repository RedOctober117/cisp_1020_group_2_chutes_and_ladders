import java.util.ArrayList;
import java.util.TreeMap;

public class Square {

  private static ArrayList<Integer> indexCollection1;
  private static ArrayList<Integer> indexCollection2;

  private int squareNumber;
  private ArrayList<Player> players;
  private ArrayList<Coords> coords;

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

  public int getNumber() {
    return this.squareNumber;
  }

  public Coords getPlayerCoord(int playerNumber) {
    return coords.get(playerNumber);
  }

  public boolean hasPlayers() {
    return !players.isEmpty();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }
  
  public void removePlayer(Player player) {
    players.remove(player);
  }

  public ArrayList<Player> getPlayers() {
    return this.players;
  }

  private void generateCoords(RuleSet rules) {
    for (int i = 0; i < 4; i++) {
      this.coords.add(new Coords(squareToX(this.squareNumber, i + 1, rules.getDimension()), squareToY(this.squareNumber, i + 1, rules.getDimension())));
    }
  }

  public TreeMap<Player, Coords> getPlayerCoords() {
    TreeMap<Player, Coords> playerCoordsPairing = new TreeMap<>();
    for (Player player : players) {
      playerCoordsPairing.put(player, coords.get(player.getPlayerNumber() - 1));
    }
    return playerCoordsPairing;
  }

  private static int squareToX(int squareNumber, int playerIndex, int boardDimension) {
    int effective_space = squareNumber;
    if (effective_space > boardDimension) {
      if (effective_space % boardDimension == 0 & (effective_space / boardDimension) % 2 == 0) {
        effective_space = 1;
      }
      
      if (effective_space % boardDimension == 0) {
        effective_space = boardDimension;
      } else {
        if ((int)Math.floor((effective_space / boardDimension)) % 2 == 0) {
          effective_space = effective_space - boardDimension * ((int)Math.floor(effective_space / boardDimension));
        } else {
          effective_space = (((int)(effective_space / boardDimension) * boardDimension) + boardDimension) - (effective_space - 1);
        }
      }
    }

    if (playerIndex == 1 | playerIndex == 3) {
      return effective_space * 6 - 4;
    } else {
      return effective_space * 6 - 2;
    }
  }

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

  private static int squareToY(int squareNumber, int playerIndex, int boardDimension) {
    int sector = boardDimension - ((int)Math.floor(squareNumber / boardDimension));
    if (squareNumber % boardDimension == 0 | sector == 0) {
      sector++;
    }

    if (playerIndex == 1 | playerIndex == 2) {
      return Square.indexCollection1.get(sector - 1);
    }
    return Square.indexCollection2.get(sector - 1);
  }

  @Override
  public String toString(){
    return String.format("#%s\n%s %s\n%s %s", this.squareNumber, coords.get(0), coords.get(1), coords.get(2), coords.get(3));
  }
}
