import java.util.ArrayList;
import java.util.TreeMap;

public class Square {
  private int squareNumber;
  private ArrayList<Player> players;
  private ArrayList<Coords> coords;

  public Square(int squareNumber, RuleSet rules) {
    this.squareNumber = squareNumber;
    this.coords = new ArrayList<Coords>();
    this.players = new ArrayList<Player>();
    generateCoords(rules);
  }

  public int getNumber() {
    return this.squareNumber;
  }

  public ArrayList<Coords> getCoords() {
    return this.coords;
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
      this.coords.add(new Coords(square_to_x(this.squareNumber, i + 1, rules.getDimension()), square_to_y(this.squareNumber, i + 1, rules.getDimension())));
    }
  }

  public TreeMap<Player, Coords> getPlayerCoords() {
    TreeMap<Player, Coords> playerCoordsPairing = new TreeMap<>();
    for (Player player : players) {
      playerCoordsPairing.put(player, coords.get(player.getIndex() - 1));
    }
    return playerCoordsPairing;
  }

  public String getSquareCoordinates() {
    return String.format("%s %s\n%s %s", coords.get(0), coords.get(1), coords.get(2), coords.get(3));
  }

  private static int square_to_x(int squareNumber, int playerIndex, int boardDimension) {
    int effective_space = squareNumber;
    if (effective_space > boardDimension) {
      if (effective_space % boardDimension == 0 & (effective_space / boardDimension) % 2 == 0) {
        effective_space = 1;
      }
        if (effective_space % boardDimension == 0) {
          effective_space = boardDimension;
        } else {
          if ((int)(effective_space / boardDimension) % 2 == 0) {
            effective_space = effective_space - boardDimension * (int)(effective_space / boardDimension);
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

  private static int square_to_y(int squareNumber, int playerIndex, int boardDimension) {
    ArrayList<Integer> indexCollection1 = new ArrayList<>();
    int indexCounter = 1;
    while (indexCounter < boardDimension * 3) {
      indexCollection1.add(indexCounter);
      indexCounter += 3;
    }

    ArrayList<Integer> indexCollection2 = new ArrayList<>();
    indexCounter = 2;
    while (indexCounter < boardDimension * 3) {
      indexCollection2.add(indexCounter);
      indexCounter += 3;
    }

    int sector = boardDimension - ((int)(squareNumber / boardDimension));
    if (squareNumber % boardDimension == 0) {
      sector++;
    }
    
    if (sector == 0) {
      sector++;
    }

    if (playerIndex == 1 | playerIndex == 2) {
      return indexCollection1.get(sector - 1);
    } else {
      return indexCollection2.get(sector - 1);
    }
  }

  @Override
  public String toString(){
    return String.format("#%s", this.squareNumber);
  }
}
