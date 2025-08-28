# Chess Game

This is a classic chess game developed in Java with a user-friendly graphical interface using JavaFX.

---
## Features ✨

* **Full Chess Logic:** All standard chess rules are implemented, including piece movements, captures, and special moves.
* **Interactive GUI:** A visually appealing and intuitive graphical user interface built with JavaFX makes it easy to play.
* **Special Moves:**
    * **Castling:** Players can perform both kingside and queenside castling.
    * **En Passant:** The en passant rule for pawns is correctly implemented.
    * **Pawn Promotion:** When a pawn reaches the opposite end of the board, it can be promoted to a Queen, Rook, Bishop, or Knight.
* **Game State Detection:** The game automatically detects and announces:
    * **Check:** When a king is under attack.
    * **Checkmate:** When a player wins the game.
    * **Stalemate:** When the game is a draw.
* **Player Turn Indicator:** A visual indicator shows whose turn it is to move.
* **Game Controls:**
    * **Restart:** Players can restart the game at any time.
    * **Exit:** A button to exit the game is available.

---
## How to Play 훈

1.  **Start the Game:** Run the `HelloApplication` class to launch the game's start screen.
2.  **Select a Piece:** Click on one of your pieces to select it. The available moves for that piece will be highlighted.
3.  **Move a Piece:** Click on one of the highlighted squares to move the selected piece.
4.  **Pawn Promotion:** If you move a pawn to the last rank, a dialog box will appear, allowing you to choose a new piece to promote it to.
5.  **Win the Game:** The game ends when one player checkmates the other, or when the game is a stalemate.

---
## Technologies Used 💻

* **Java:** The core logic of the game is written in Java.
* **JavaFX:** The graphical user interface is built using JavaFX.
* **FXML:** The layout of the UI is defined in FXML files.
