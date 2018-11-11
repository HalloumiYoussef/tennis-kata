# tennis-kata

The aim of the program is to display the scores of a tennis match (Game, Set & Tie-Break).

Score scenarios:
- The game starts with a score of 0 point for each player
- Each time a player win a point, the Game score changes as follow: 0 -> 15 -> 30 -> 40-> Win game
- If the 2 players reach the score 40, the DEUCE rule is activated
- If the score is DEUCE , the player who  win the point take the ADVANTAGE
- If the player who has the ADVANTAGE win the  point, he win the game
- If the player who has the ADVANTAGE looses the point, the score is DEUCE
- If the 2 players reach the score of 6 Games , the Tie-Break rule is activated

Winning rules:
- If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set
- If a player wins a Game and reach the Set score of 6 and the other player has a Set score of 5, a new Game must be played and the first player who reach the score of 7 wins the set
- The Tie-Break ends as soon as a player gets a least 7 points and 2 points more than his opponent
- The player who wins the Tie-Break wins the Set and the match



