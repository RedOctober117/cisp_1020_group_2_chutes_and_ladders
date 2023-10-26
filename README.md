## Class Layout
### Error Handling
`UnknownCommandException` -> Print command list and wait for new input

### Interfaces
File parser interface

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
dimension=8
players=4
99-roll-delta=*
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
