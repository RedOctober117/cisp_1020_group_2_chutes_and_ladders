# Trait System
Welcome to the Chutes and Ladders Trait System! The trait system allows for arbitrary "traits" to be added or removed from a given player, at any time!. The system is easy, every trait implements `PlayerTrait`, which enforces the `getTraitValue()` and `setTraitValue()` methods. Let's take a look at an example:

```java
public class Identifier implements PlayerTrait<String> {
    public static final String KEY = "Identifier";

    private String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;    
    }

    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }
    
    public String getTraitValue() {
        return getIdentifier();
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    @Overrider 
    public String toString() {
        return String.format("{{Trait: %s} {Identifier: %s}}", Identifier.KEY, this.identifier");
    }
}
```

First, notice the first lines `<String>`. The PlayerTrait system works for all types, so for whatever data you're wanting to store and retrieve, make sure that type is put in those `<>`. Also notice that all regular style methods are still made (`setIdentifier(), getIdentifier()`), but we use wrapper methods so that retrieving those values outside is uniform across all Traits. Also take note of the `KEY`. `KEY`s are used any time you want to access (add or remove) a trait. ***NEVER*** type `KEY`s by hand, ***ALWAYS*** use the static variable.

Let's now look at how we might retrieve a trait:
```java
public class Whatever {
    public static void main(String[] args) {
        Player p1 = new Player(1);
        p1.addTrait(Identifier.IDENTIFIER, new Identifier("ABC"));            
        System.out.println(p1.getTrait(Identifier.KEY).getTraitValue()); // prints "ABC"
        }
    }
}
```

To remove a trait, the process is the same as above, but **TAKE NOTE**: if you do not `break` after `removeTrait(someTrait)`, the program *will* crash.

Below is another breakdown, including the `PlayerTrait` class:

```java
public interface PlayerTrait<E> {
    public E getTraitValue();
    public void setTraitValue(E value);
}

public class Identifier implements PlayerTrait<String> {
    public static final String IDENTIFIER = "Identifier";

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
}

public class Player {
    private HashMap<String, PlayerTrait<?>> traits;

    public void addTrait(String key, PlayerTrait trait) {}
    public void removeTrait(String key) {}
}

public static void main(String[] args) {
    Player p1 = new Player(1);
    p1.addTrait(Identifier.IDENTIFIER, new Identifier("ABC"));
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

### Rule Set Parser
Read the ruleset doc and provide the info to relevant objects.

### Commands
- `-a` -> Autoplay game
- `-c` -> List commands
- `-e` -> Show event src and dests
- `-r` -> Roll 
- `-rn` -> Rename Player (will not interact with scores file, only active players)
- `-rr` -> Reset to menu (prompt for confirmation first)
- `-s` -> List scores from file
- `-z` -> Zoom in on player (prompt for player identifier, then expand that square, showing the token of each present player)
