# Trait System

```java
public interface PlayerTrait<E> {
    public E getTraitValue();
    public void setTraitValue(E value);
}

public class Identifier implements PlayerTrait<String> {
    private String identifier;

    public Identifier(String identifier) {}

    public void setIdentifier(String ident) {}
    public String getIdentifier() {}

    public String getTraitValue() {
        return getIdentifier();
    }

    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }

public class Player {
    private ArrayList<PlayerTrait> traits;

    public void addTrait(PlayerTrait trait) {}
    public void removeTrait(PlayerTrait trait) {}
}

public static void main(String[] args) {
    Player p1 = new Player(1);
    p1.addTrait(new Identifier("ABC"));
}
}
```


## Class Layout
### Game Classes
- Bruce: Load Class -> Not sure the full scope yet. Needs to work with RuleSet to allow user to choose the rule set at least
- Bruce: Board Class -> Print the board and player tokens
- Michael: Menu Class -> Print current scores for each player
- Levi: Player Class -> Maintain player 3-letter identifier and store Coords, Score object
- Ryan: Coords Class -> Store and manipulate x and y values
- Ryan: Score Class -> Calculate and maintain player score
- Orion: Dice Class -> Roll dice and display art for result
- ChutesAndLadders Class -> Main game logic

### IO Classes
- Bruce, Michael: FileParser Interface -> Common methods for parsing any files
- Bruce, Michael: Scoreboard Class -> Implement FileParser; Write and read score files from given rule set
- Bruce, Michael: RuleSet Class -> Implement FileParser; Read (and maybe write?) and represent ruleset files

### Error Handling
- Bruce: `UnknownCommandException` -> Print command list and wait for new input

### Interfaces
- Bruce: File parser interface

#### Player
Instance vars:
- Identifier: String 
- Coordinates: Coords

#### Coords
Instance vars:
- playerX: int
- playerY: int

#### Score
Instance vars:
- Score Data: HashMap<PlayerNumber, Integer>

#### Dice
Methods:
- RollDice(num_of_dice): int 
- AnimateDice(num_of_dice, roll): void 

#### Event
- source: int
- destination: int

## Design Concepts

### UI
```txt
*************************
* ABC * DEF * GHI * JKL *
*  40 *   1 *  65 *  34 *
*************************

 _______________________
| ABC | DEF | GHI | JKL |
|  23 |  01 |  34 |  32 |
|(-c for commands)? _               
```

### Scoring
Scoring for each rule set resides in a separate file
RW file for storing all scores and identifiers, sorted ASC by score
Score is lower is better

Scoring based on total number of rolls to reach sq99, add and deduct points for chutes and ladders respectively

```txt
ABD 12
EFG 22
```

### Custom Rule Set Builder
Rule sets are read from text files

format:
```txt
[rule-set]
name=default
dimension=10
players=4
dice=1
100-roll-delta=*
chutes=16,6;47,26;49,11;56,53;62,19;64,60;93,73;95,75;98,78;
```

Convert chutes and ladders squares into hashmaps with the sqaure as the key and the 4 cord possibilities as the values

### Rule Set Parser
Read the ruleset doc and provide the info to relevant objects.

### Commands
`-c` -> List commands
`-s` -> List scores from file
`-r` -> Roll 
`-rr` -> Reset to menu (prompt for confirmation first)
`-rn` -> Rename Player (will not interact with scores file, only active players)
`-z` -> Zoom in on player (prompt for player identifier, then expand that square, showing the token of each present player)


