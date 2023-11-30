# Chutes and Ladders
## Design Process
Chutes and Ladders began with generalizing the math required to draw the board and the players. Previously, the math was brute forced and only worked with a single dimension. Players also maintained their own position via an x and y. The foundation of Chutes and Ladders v2 came about with discovery of the math for dynamically generating the Board and the possible player positions for each square. Now, players no longer know their own position; they are instead associated with a Square, cooresponding to the game square they are on. The pregenerated coords and the players index determines where the player is printed on the board itself. 

The basic structure was as follows:
```
Board
    ⤷ List of n Squares, where n = board dimension ^ 2
        ⤷ List of n Coords, where n = 4
        ⤷ List of n Players, where 0 <= n <= 4
```

To prevent Player from ballooning to unreasonable scale, PlayerTrait was created. PlayerTrait allows for the creation of arbitrary player attributes, anything from a name to a status effect.

Following the creating and finalization of the preceding classes, the rest of the team was assigned to various tasks to build upon the foundation I laid out. The breakdown is as follows:
```
Michael
    ⤷ ScoreManager
    ⤷ Menu
    ⤷ Events
Ryan
    ⤷ Menu
    ⤷ Score
    ⤷ Game
Levi
    ⤷ Game
    ⤷ Identifier
    ⤷ Name
Orion
    ⤷ DiceCode
Bruce
    ⤷ Coord
    ⤷ Player
    ⤷ Square
    ⤷ Board
    ⤷ Identifier
    ⤷ Color
    ⤷ PlayerTrait
    ⤷ RuleSet
```
Most classes were built in parallel, with Game, of course, being finalized last. With the functional completion of Game, I went back in and cleaned up the UX and implemented the auto play function. 


## Trait System
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

First, notice the first line's `<String>`. The PlayerTrait system works for all types, so for whatever data you're wanting to store and retrieve, make sure that type is put in those `<>`. **IMPORTANT:** Types can only be wrapper classes. You will need to cast to the appropriate type when you retrieve a value. Also notice that all regular style methods are still made (`setIdentifier(), getIdentifier()`), but we use wrapper methods so that retrieving those values outside the class is uniform across all Traits. Also take note of the `KEY`. `KEY`s are used any time you want to access (add or remove) a trait. ***NEVER*** type `KEY`s by hand, ***ALWAYS*** use the static variable. Traits are stored in HashMaps, so duplicate traits must be avoided. If you need a trait to compose multiple objects, consider a wrapper trait that uses a List as its type.

Let's now look at how we might retrieve a trait:
```java
public class Whatever {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.addTrait(Identifier.KEY, new Identifier("ABC"));            
        System.out.println(p1.getTrait(Identifier.KEY).getTraitValue()); // prints "ABC"
        }
    }
}
```

Below is another breakdown, including the `PlayerTrait` class:

```java
public interface PlayerTrait<E> {
    public E getTraitValue();
    public void setTraitValue(E value);
}

public class Identifier implements PlayerTrait<String> {
    public static final String KEY = "Identifier";

    private String identifier;

    public Identifier(String identifier) {/* snip */}

    public void setIdentifier(String ident) {/* snip */}

    public String getIdentifier() {/* snip */}

    public String getTraitValue() {
        return getIdentifier();
    }

    public void setTraitValue(String identifier) {
        setIdentifier(identifier);
    }
}

public class Player {
    private HashMap<String, PlayerTrait<?>> traits;

    public void addTrait(String key, PlayerTrait trait) {/* snip */}
    public void removeTrait(String key) {/* snip */}
}

public static void main(String[] args) {
    Player p1 = new Player();
    p1.addTrait(Identifier.KEY, new Identifier("ABC"));
}
```


## Class Layout
### Game Classes
- Board Class -> Print the board and player tokens
- Menu Class -> Print current scores for each player
- Player Class -> Maintain player index and map of PlayerTraits
- Coords Class -> Store and manipulate x and y values
- Dice Class -> Roll dice and display art for result
- Events -> Basic class to hold the squares of a chute or ladder
- RuleSet -> Maintain game rules
- ChutesAndLadders Class -> Main game logic

### IO Classes
- FileParser Interface -> Common methods for parsing any files
- ScoreManager -> Write and read score files from given rule set
- RuleSet Class -> Implement FileParser; Read (and maybe write?) and represent ruleset files

### Interfaces
- PlayerTrait -> Unified interface for player attributes

### PlayerTraits
- Color -> ASCII codes to add some color to the player objects
- Identifier -> Maintain a three letter nickname for players, reminiscent of arcade cabinets
- Score -> Store player score (the square they're on)
- Name -> Store player's name

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
