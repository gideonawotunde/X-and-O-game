# X AND O BOARD GAME

This project is a simple board game where players take turns placing their shapes (X or O) 
on a grid board. The game is implemented in Java, using JavaFX for the UI and JUnit for unit 
testing.

Features of the Game
--------------------------
1. Supports 2-player gameplay
2. Tracks game information such as:
   1. Date and time of each game
   2. Player names
   3. Number of turns
   4. Winner's name
3. Displays a high score table with the top 5 players with the most wins
4. Stores game data in a JSON file.

Rules of the Game
--------------------
1. When the game is started, both players have to input their names.
2. The game board consists of 6 cells, where each cell can contain a player's symbol, X or O.
3. The board starts empty.
4. Players take turns placing their symbols in an empty cell.
5. When a player places their symbol, it also goes to the all the neighbouring empty cells(left, right, top, bottom) of the chosen cell, forming a + pattern.
6. The game ends when the board is filled up, ie, no more moves can be made.
7. The last player to make a move wins the game.

