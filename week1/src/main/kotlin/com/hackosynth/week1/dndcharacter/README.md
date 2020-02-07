## Dnd Character
In the game Dungeons & Dragons (DnD), each player starts by making a character.
This character has, among other things, six abilities:
strength, dexterity, constitution, intelligence, wisdom and charisma.
Theses six abilities are generated randomly.
You do this by rolling four 6-sided dice, removing the lowest die and summing up the remaining three.
This is done once for each ability.
<br>
<br>
Your character's initial hitpoints are 10 + your character's constitution modifier.
The constitution modifier is found by subtracting 10 from the character's constitution, divide by 2 and rounded down.
<br>
<br>
Write a random character generator that follows the rules above.
<br>
<br>
For example, the six throws of four dice may look like this:
- 5, 3, 1, 6: You discard the 1 and sum 5 + 3 + 6 = 14, which you assign to strength.
- 3, 2, 5, 3: You discard the 2 and sum 3 + 5 + 3 = 11, which you assign to dexterity.
- 1, 1, 1, 1: You discard the 1 and sum 1 + 1 + 1 = 3, which you assign to constitution.
- 2, 1, 6, 6: You discard the 1 and sum 2 + 6 + 6 = 14, which you assign to intelligence.
- 3, 5, 3, 4: You discard the 3 and sum 5 + 3 + 4 = 12, which you assign to wisdom.
- 6, 6, 6, 6: You discard the 6 and sum 6 + 6 + 6 = 18, which you assign to charisma.
<br>
<!-- end of the list -->
Because the constitution is 3, the constitution modifier is -4 and the hitpoints are 6.
