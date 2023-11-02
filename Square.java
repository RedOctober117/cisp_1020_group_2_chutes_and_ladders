import java.util.ArrayList;

public class Square {
  private int number;
  private ArrayList<Coords> coords;

  public Square(int number, RuleSet rules) {
    this.number = number;
    this.coords = new ArrayList<Coords>();
    generateCoords(rules);
  }

  private void generateCoords(RuleSet rules) {
    for (int i = 0; i < 4; i++) {
      this.coords.add(new Coords(square_to_x(this.number, i + 1, rules.getDimension()), square_to_y(this.number, i + 1, rules.getDimension())));
    }
  }

  public Coords getCoords(int index) {
    return this.coords.get(index);
  }

  public String getSquareCoordinates() {
    return String.format("%s %s\n%s %s", coords.get(0), coords.get(1), coords.get(2), coords.get(3));
  }

  private static int square_to_x(int number, int playerIndex, int boardDimension) {
    int effective_space = number;
    if (number > boardDimension) {
      if ((int)(number / boardDimension) % boardDimension == 0) {
        effective_space = boardDimension;
      } else {
        if ((int)(number / boardDimension) % 2 == 0) {
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

  private static int square_to_y(int number, int playerIndex, int boardDimension) {
    ArrayList<Integer> indexCollection1 = new ArrayList<>();
    int indexCounter = 0;
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

    int sector = boardDimension - ((int)(number / boardDimension));

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
    return String.format("#%s", this.number);
  }
}
