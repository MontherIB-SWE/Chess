package sql.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class HelloController {
    public static HashMap<Button, ImageView> buttonImageViewMap;
    public Label BlackLabel;
    public Label WhiteLabel;
    public ImageView BlackK;
    public ImageView WhiteK;
    public Circle BLight;
    public Circle WLight;
    @FXML
    private Button
            a1, a2, a3, a4, a5, a6, a7, a8,
            b1, b2, b3, b4, b5, b6, b7, b8,
            c1, c2, c3, c4, c5, c6, c7, c8,
            d1, d2, d3, d4, d5, d6, d7, d8,
            e1, e2, e3, e4, e5, e6, e7, e8,
            f1, f2, f3, f4, f5, f6, f7, f8,
            g1, g2, g3, g4, g5, g6, g7, g8,
            h1, h2, h3, h4, h5, h6, h7, h8;
    @FXML
    static Button[][] buttons = new Button[8][8];
    String enPassant;
    static String player = "White";
    private String lastMove;  // Initialize to null (no previous move at start)
    static Button selectedButton;
    static Button clickedButton;
    @FXML
    private ImageView a11, a22, a33, a44, a55, a66, a77, a88,
            b11, b22, b33, b44, b55, b66, b77, b88,
            c11, c22, c33, c44, c55, c66, c77, c88,
            d11, d22, d33, d44, d55, d66, d77, d88,
            e11, e22, e33, e44, e55, e66, e77, e88,
            f11, f22, f33, f44, f55, f66, f77, f88,
            g11, g22, g33, g44, g55, g66, g77, g88,
            h11, h22, h33, h44, h55, h66, h77, h88;

    @FXML
    public void initialize() {
        buttonImageViewMap = new HashMap<>();
        buttonImageViewMap.put(a1, a11);
        buttonImageViewMap.put(a2, a22);
        buttonImageViewMap.put(a3, a33);
        buttonImageViewMap.put(a4, a44);
        buttonImageViewMap.put(a5, a55);
        buttonImageViewMap.put(a6, a66);
        buttonImageViewMap.put(a7, a77);
        buttonImageViewMap.put(a8, a88);
        buttonImageViewMap.put(b1, b11);
        buttonImageViewMap.put(b2, b22);
        buttonImageViewMap.put(b3, b33);
        buttonImageViewMap.put(b4, b44);
        buttonImageViewMap.put(b5, b55);
        buttonImageViewMap.put(b6, b66);
        buttonImageViewMap.put(b7, b77);
        buttonImageViewMap.put(b8, b88);

        buttonImageViewMap.put(c1, c11);
        buttonImageViewMap.put(c2, c22);
        buttonImageViewMap.put(c3, c33);
        buttonImageViewMap.put(c4, c44);
        buttonImageViewMap.put(c5, c55);
        buttonImageViewMap.put(c6, c66);
        buttonImageViewMap.put(c7, c77);
        buttonImageViewMap.put(c8, c88);

        buttonImageViewMap.put(d1, d11);
        buttonImageViewMap.put(d2, d22);
        buttonImageViewMap.put(d3, d33);
        buttonImageViewMap.put(d4, d44);
        buttonImageViewMap.put(d5, d55);
        buttonImageViewMap.put(d6, d66);
        buttonImageViewMap.put(d7, d77);
        buttonImageViewMap.put(d8, d88);

        buttonImageViewMap.put(e1, e11);
        buttonImageViewMap.put(e2, e22);
        buttonImageViewMap.put(e3, e33);
        buttonImageViewMap.put(e4, e44);
        buttonImageViewMap.put(e5, e55);
        buttonImageViewMap.put(e6, e66);
        buttonImageViewMap.put(e7, e77);
        buttonImageViewMap.put(e8, e88);

        buttonImageViewMap.put(f1, f11);
        buttonImageViewMap.put(f2, f22);
        buttonImageViewMap.put(f3, f33);
        buttonImageViewMap.put(f4, f44);
        buttonImageViewMap.put(f5, f55);
        buttonImageViewMap.put(f6, f66);
        buttonImageViewMap.put(f7, f77);
        buttonImageViewMap.put(f8, f88);

        buttonImageViewMap.put(g1, g11);
        buttonImageViewMap.put(g2, g22);
        buttonImageViewMap.put(g3, g33);
        buttonImageViewMap.put(g4, g44);
        buttonImageViewMap.put(g5, g55);
        buttonImageViewMap.put(g6, g66);
        buttonImageViewMap.put(g7, g77);
        buttonImageViewMap.put(g8, g88);

        buttonImageViewMap.put(h1, h11);
        buttonImageViewMap.put(h2, h22);
        buttonImageViewMap.put(h3, h33);
        buttonImageViewMap.put(h4, h44);
        buttonImageViewMap.put(h5, h55);
        buttonImageViewMap.put(h6, h66);
        buttonImageViewMap.put(h7, h77);
        buttonImageViewMap.put(h8, h88);

        buttons[0] = new Button[]{a1, a2, a3, a4, a5, a6, a7, a8};
        buttons[1] = new Button[]{b1, b2, b3, b4, b5, b6, b7, b8};
        buttons[2] = new Button[]{c1, c2, c3, c4, c5, c6, c7, c8};
        buttons[3] = new Button[]{d1, d2, d3, d4, d5, d6, d7, d8};
        buttons[4] = new Button[]{e1, e2, e3, e4, e5, e6, e7, e8};
        buttons[5] = new Button[]{f1, f2, f3, f4, f5, f6, f7, f8};
        buttons[6] = new Button[]{g1, g2, g3, g4, g5, g6, g7, g8};
        buttons[7] = new Button[]{h1, h2, h3, h4, h5, h6, h7, h8};

        Image image = new Image(Objects.requireNonNull(getClass().getResource("/images/BKing.png")).toExternalForm()); // Load from resources
        BlackK.setImage(image);
        Image image1 = new Image(Objects.requireNonNull(getClass().getResource("/images/WKing.png")).toExternalForm()); // Load from resources
        WhiteK.setImage(image1);
        BLight.setFill(Paint.valueOf("LightGreen"));
        WLight.setFill(Paint.valueOf("LightGreen"));

    }

    @FXML
    protected void onButtonClick(ActionEvent event) throws IOException {  //TODO: promotion of pawn
        clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        int x = buttonId.charAt(0) - 'a';
        int y = buttonId.charAt(1) - '1';
        String position = x + "," + y;
        String[][] boardState = getBoardState();
        String piece = boardState[x][y]; // Get the piece at the clicked position
        if (selectedButton == null && suitablePiece(player, piece)) {
            // First click: Select a piece
            List<String> availableMoves = getAvailableMoves(piece, player, position);
            if (!availableMoves.isEmpty()) {
                selectedButton = clickedButton;
                DisableAllButtons(player);
                highlightMoves(availableMoves);
            }
        } else if (selectedButton != null) {
            // Second click: Attempt to move
            String originalPosition = getPosition(selectedButton); // Store original position
            String movingPiece = getPieceNameFromImage(buttonImageViewMap.get(selectedButton).getImage().getUrl()); // Piece that's moving
            List<String> availableMoves = getAvailableMoves(movingPiece, player, originalPosition);
            if (availableMoves.contains(position)) {
                // Temporarily make the move on the board
                boardState[x][y] = movingPiece;
                boardState[Integer.parseInt(originalPosition.split(",")[0])][Integer.parseInt(originalPosition.split(",")[1])] = null;

                // Check if the move results in self-check
                if (isKingChecked(player, boardState)) {
                    // Undo the temporary move
                    boardState[Integer.parseInt(originalPosition.split(",")[0])][Integer.parseInt(originalPosition.split(",")[1])] = movingPiece;
                    boardState[x][y] = piece;
                    System.out.println("Illegal move: You cannot put yourself in check."); // Or display an error message to the user
                } else {
                    // Move is valid
                    performMove(selectedButton, clickedButton, movingPiece);
                    BLight.setFill(Paint.valueOf("LightGreen"));
                    WLight.setFill(Paint.valueOf("LightGreen"));
                    int fromX = selectedButton.getId().charAt(0) - 'a';
                    int fromY = selectedButton.getId().charAt(1) - '1';
                    int toX = clickedButton.getId().charAt(0) - 'a';
                    int toY = clickedButton.getId().charAt(1) - '1';

                    lastMove = movingPiece + "-" + fromX + "," + fromY + "-" + toX + "," + toY;
                    switchPlayer();


                    if (isKingChecked(player, boardState)) {
                        if (player.equals("Black")) {
                            BLight.setFill(Paint.valueOf("RED"));
                        } else {
                            WLight.setFill(Paint.valueOf("RED"));
                        }
                    }


                    if (!hasLegalMovesToEscapeCheck(player)) {
                        if (!isKingChecked(player, boardState)) {
                            System.out.println("Stalemate");
                            BlackLabel.setText("stalemate");
                            WhiteLabel.setText("stalemate");
                            DisableAllButtons1();
                            return;
                        } else {
                            System.out.println("we have a winner " + (player.equals("White") ? "Black" : "White"));
                            if (player.equals("White")) {
                                BlackLabel.setText("winner");
                            } else {
                                WhiteLabel.setText("winner");
                            }
                            DisableAllButtons1();
                            return;
                        }
                    }

                }

                // Reset and re-enable
                selectedButton = null;
                enableAllButtons();
            } else if (suitablePiece(player, piece)) {
                // Selected another valid piece to move
                selectedButton = clickedButton;
                DisableAllButtons(player);
                highlightMoves(availableMoves);
            } else {
                // Invalid move: clear selection
                selectedButton = null;
                DisableAllButtons(player);
            }
        }
    }

    private void DisableAllButtons1() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    private void resetGameState() {
        // Reset game variables
        player = "White";
        lastMove = null;
        enPassant = null;
        WcastleRight = null;
        BcastleRight = null;
        WcastleLeft = null;
        BcastleLeft = null;
        selectedButton = null;
        moveHistory.clear(); // Clear move history
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private boolean hasLegalMovesToEscapeCheck(String player) {
        String[][] boardState = getBoardState();
        String kingPosition = findKingPosition(player, boardState); // Find the player's king's position
        String[] kingCoords = Objects.requireNonNull(kingPosition).split(",");
        int kingX = Integer.parseInt(kingCoords[0]);
        int kingY = Integer.parseInt(kingCoords[1]);

        // Check if other pieces can block or capture the checking piece
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[0].length; j++) {
                if (boardState[i][j] != null && boardState[i][j].startsWith(String.valueOf(player.charAt(0))) && !boardState[i][j].endsWith("King")) {
                    List<String> availableMoves = getAvailableMoves(boardState[i][j], player, i + "," + j);
                    for (String move : availableMoves) {
                        // Simulate the move
                        String[] moveCoords = move.split(",");
                        int newX = Integer.parseInt(moveCoords[0]);
                        int newY = Integer.parseInt(moveCoords[1]);

                        String temp = boardState[newX][newY]; // Store the captured piece (if any)
                        boardState[newX][newY] = boardState[i][j];
                        boardState[i][j] = null;

                        // Check if the king is still in check
                        if (!isKingChecked(player, boardState)) {
                            // Undo the move
                            boardState[i][j] = boardState[newX][newY];
                            boardState[newX][newY] = temp;

                            return true; // Found a legal move
                        }

                        // Undo the move
                        boardState[i][j] = boardState[newX][newY];
                        boardState[newX][newY] = temp;
                    }
                }
            }
        }

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // Skip the king's current square
                int newKingX = kingX + dx;
                int newKingY = kingY + dy;

                if (isValidPosition(newKingX, newKingY)
                        && boardState[newKingX][newKingY] != null
                        && !boardState[newKingX][newKingY].startsWith(String.valueOf(player.charAt(0)))) {
                    String temp = boardState[newKingX][newKingY];
                    boardState[newKingX][newKingY] = boardState[kingX][kingY];
                    boardState[kingX][kingY] = null;
                    if (!isKingChecked(player, boardState)) {
                        boardState[kingX][kingY] = boardState[newKingX][newKingY];
                        boardState[newKingX][newKingY] = temp;

                        return true; // Found a legal move                   // No need to check further
                    }
                    boardState[kingX][kingY] = boardState[newKingX][newKingY];
                    boardState[newKingX][newKingY] = temp;
                } else if (isValidPosition(newKingX, newKingY) && boardState[newKingX][newKingY] == null) {
                    String temp = boardState[newKingX][newKingY];
                    boardState[newKingX][newKingY] = boardState[kingX][kingY];
                    boardState[kingX][kingY] = null;
                    if (!isKingChecked(player, boardState)) {
                        boardState[kingX][kingY] = boardState[newKingX][newKingY];
                        boardState[newKingX][newKingY] = temp;
                        System.out.println("legal king move");

                        return true; // Found a legal move                   // No need to check further
                    }
                    boardState[kingX][kingY] = boardState[newKingX][newKingY];
                    boardState[newKingX][newKingY] = temp;
                }
            }

        }
        System.out.println("no legal moves");
        return false; // No legal moves to escape check found
    }

    private boolean isKingChecked(String player, String[][] board) {
        String opponent = (player.equals("White")) ? "Black" : "White";

        String kingPosition = findKingPosition(player, board);

        if (kingPosition == null) {
            return false; // King not found, shouldn't happen in a normal game
        }

        int kingX = Integer.parseInt(kingPosition.split(",")[0]);
        int kingY = Integer.parseInt(kingPosition.split(",")[1]);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String piece = board[i][j];
                if (piece != null && piece.startsWith(String.valueOf(opponent.charAt(0)))) {  // Opponent's piece
                    List<String> available = getKnightMoves1(i + "," + j, piece.charAt(0) == 'W' ? "White" : "Black", board);
                    // Optimize for Knights
                    if (piece.endsWith("Knight") && available.contains(kingPosition)) {
                        return true; // Knight check
                    }

                    // Optimized checks for other pieces
                    if (isAttackedBySlidingPiece(kingX, kingY, i, j, board, piece.substring(1), opponent)) {
                        return true; // Rook, Bishop, or Queen check
                    }
                }
            }
        }
        return false; // King is not in check
    }

    private String findKingPosition(String player, String[][] board) {
        String kingPiece = player.charAt(0) + "King";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (kingPiece.equals(board[i][j])) {
                    return i + "," + j;
                }
            }
        }
        return null; // King not found (shouldn't happen in a normal game)
    }

    private boolean isAttackedBySlidingPiece(int kingX, int kingY, int pieceX, int pieceY, String[][] board, String pieceType, String player) {
        return switch (pieceType) {
            case "Rook" -> getRookMoves1(pieceX + "," + pieceY, player, board).contains(kingX + "," + kingY);
            case "Bishop" -> getBishopMoves1(pieceX + "," + pieceY, player, board).contains(kingX + "," + kingY);
            case "Queen" -> getQueenMoves1(pieceX + "," + pieceY, player, board).contains(kingX + "," + kingY);
            case "Pawn" ->
                    getPawnMoves1(pieceX + "," + pieceY, player.charAt(0) == 'W', lastMove, board).contains(kingX + "," + kingY);
            case "King" -> getKingMoves1(pieceX + "," + pieceY, player, board).contains(kingX + "," + kingY);
            default -> false; // Invalid piece type (should not happen)
        };
    }

    private List<String> getQueenMoves1(String position, String player, String[][] board) {
        String[] coordinates = position.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        List<String> result = new ArrayList<>();

        // Check moves in all eight directions
        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

        for (int direction = 0; direction < 8; direction++) {
            for (int step = 1; step < Math.max(board.length, board[0].length); step++) {
                int newX = x + step * dx[direction];
                int newY = y + step * dy[direction];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    String targetPiece = board[newX][newY];

                    if (targetPiece == null) {
                        // Empty square: Add to available moves
                        result.add(newX + "," + newY);
                    } else if (!targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                        // Opponent's piece: Add as a capture move and stop in this direction
                        result.add(newX + "," + newY);
                        break;
                    } else {
                        // Own piece: Stop in this direction
                        break;
                    }
                } else {
                    // Reached the edge of the board: Stop in this direction
                    break;
                }
            }
        }

        return result;
    }

    private List<String> getBishopMoves1(String position, String player, String[][] board) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        List<String> result = new ArrayList<>();

        // Check moves in all four diagonal directions
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, -1, 1};

        for (int direction = 0; direction < 4; direction++) {
            for (int step = 1; step < Math.max(board.length, board[0].length); step++) {
                int newX = x + step * dx[direction];
                int newY = y + step * dy[direction];

                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    String targetPiece = board[newX][newY];

                    if (targetPiece == null) {
                        result.add(newX + "," + newY);
                    } else {
                        // Check if the piece belongs to the opponent
                        if (!targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                            result.add(newX + "," + newY); // Capture move
                        }
                        break; // Stop in this direction, piece blocks further moves
                    }
                } else {
                    break; // Reached the edge of the board
                }
            }
        }

        return result;
    }

    private List<String> getRookMoves1(String position, String player, String[][] board) {
        String[] coordinates = position.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        List<String> result = new ArrayList<>();

        // Check moves in all four directions
        int[] dx = {1, 0, -1, 0}; // Changes in x (right, down, left, up)
        int[] dy = {0, 1, 0, -1}; // Changes in y

        for (int direction = 0; direction < 4; direction++) {
            for (int step = 1; step < Math.max(board.length, board[0].length); step++) {
                int newX = x + step * dx[direction];
                int newY = y + step * dy[direction];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    String targetPiece = board[newX][newY];

                    if (targetPiece == null) {
                        // Empty square: Add to available moves
                        result.add(newX + "," + newY);
                    } else if (!targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                        // Opponent's piece: Add as a capture move and stop in this direction
                        result.add(newX + "," + newY);
                        break;
                    } else {
                        // Own piece: Stop in this direction
                        break;
                    }
                } else {
                    // Reached the edge of the board: Stop in this direction
                    break;
                }
            }
        }

        return result;
    }

    private List<String> getKnightMoves1(String position, String player, String[][] board) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        List<String> result = new ArrayList<>();

        // Possible L-shaped moves for the knight
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};  // Changes in x
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};  // Changes in y

        for (int j = 0; j < 8; j++) {
            int newX = x + dx[j];
            int newY = y + dy[j];

            // Check if the new position is within bounds
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                String targetPiece = board[newX][newY];

                // Check for empty square or enemy piece
                if (targetPiece == null || !targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                    result.add(newX + "," + newY);
                }
            }
        }

        return result;
    }

    private List<String> getPawnMoves1(String position, boolean isWhite, String lastMove, String[][] board) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        List<String> result = new ArrayList<>();

        int direction = isWhite ? -1 : 1;
        int startingRank = isWhite ? 6 : 1;

        // Check one step forward move
        if (x + direction >= 0 && x + direction < board.length && board[x + direction][y] == null) {
            result.add((x + direction) + "," + y);

            // Check two steps forward move from starting position
            if (x == startingRank && board[x + 2 * direction][y] == null) {
                result.add((x + 2 * direction) + "," + y);
            }
        }

        // Check diagonal captures
        if (isValidCapture(x, y - 1, direction, isWhite, board)) {
            result.add((x + direction) + "," + (y - 1));
        }
        if (isValidCapture(x, y + 1, direction, isWhite, board)) {
            result.add((x + direction) + "," + (y + 1));
        }

        if (lastMove != null) {
            lastMove = lastMove.substring(1);
        }
        // Check for en passant
        if (lastMove != null && lastMove.startsWith("P") && Math.abs(lastMove.charAt(5) - lastMove.charAt(9)) == 2 && x == (isWhite ? 3 : 4) && // Pawn is on the 5th rank (for white) or 4th rank (for black)Math.abs(lastMove.charAt(11) - position.charAt(2)) == 1 && // Adjacent columns
                ((y == lastMove.charAt(11) - '0' + 1) || (y == lastMove.charAt(11) - '0' - 1))) { // Same column as the last moved pawn
            result.add((x + direction) + "," + lastMove.charAt(11));
            enPassant = (x + direction) + "," + lastMove.charAt(11);
        }

        return result;
    }

    private List<String> getKingMoves1(String position, String player, String[][] board) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        List<String> result = new ArrayList<>();

        // Possible moves (1 square in each direction)
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int j = 0; j < 8; j++) {
            int newX = x + dx[j];
            int newY = y + dy[j];

            // Boundary check
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                String targetPiece = board[newX][newY];

                // Check for empty square or enemy piece
                if (targetPiece == null || !targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                    result.add(newX + "," + newY);
                }
            }
        }
        if (CanCastleLeft(player)) {                                   // castling
            if (player.equals("White")) {
                result.add(x + "," + (y - 2));
                WcastleLeft = x + "," + (y - 2);
            }
            if (player.equals("Black")) {
                result.add(x + "," + (y - 2));
                BcastleLeft = x + "," + (y - 2);
            }
        }
        if (CanCastleRight(player)) {
            if (player.equals("White")) {
                result.add(x + "," + (y + 2));
                WcastleRight = x + "," + (y + 2);
            }
            if (player.equals("Black")) {
                result.add(x + "," + (y + 2));
                BcastleRight = x + "," + (y + 2);
            }

        }

        return result;
    }

    private void highlightMoves(List<String> moves) {
        for (String move : moves) {
            String[] parts = move.split(",");
            int moveX = Integer.parseInt(parts[0]);
            int moveY = Integer.parseInt(parts[1]);

            Button targetButton = buttons[moveX][moveY];
            targetButton.setDisable(false); // Add the style class
        }
    }

    private String getPosition(Button button) {
        String buttonId = button.getId();
        int x = buttonId.charAt(0) - 'a';
        int y = buttonId.charAt(1) - '1';
        return x + "," + y;
    }

    private boolean suitablePiece(String player, String piece) {
        if (piece == null) {
            return false;
        }
        return player.charAt(0) == piece.charAt(0);
    }

    private void switchPlayer() {
        player = (player.equals("White")) ? "Black" : "White";
    }

    private void performMove(Button fromButton, Button toButton, String piece) throws IOException {
        // 1. Update the Board State:
        String[][] boardState = getBoardState(); // Get the current board state

        int fromX = fromButton.getId().charAt(0) - 'a';
        int fromY = fromButton.getId().charAt(1) - '1';
        int toX = toButton.getId().charAt(0) - 'a';
        int toY = toButton.getId().charAt(1) - '1';

        boardState[toX][toY] = piece;  // Place the piece on the new square
        boardState[fromX][fromY] = null; // Clear the old square

        // 2. Move the Image:
        ImageView fromImageView = buttonImageViewMap.get(fromButton);
        ImageView toImageView = buttonImageViewMap.get(toButton);

        if (fromImageView != null && toImageView != null) {
            Image pieceImage = fromImageView.getImage();
            toImageView.setImage(pieceImage);
            fromImageView.setImage(null);
        }

        if (enPassant != null && enPassant.equals(toX + "," + toY)) {
            int dic = player.equals("White") ? 1 : -1;

            button = buttons[(toX + dic)][toY];
            ImageView imageView = buttonImageViewMap.get(button);
            imageView.setImage(null);
        }

        if (BcastleRight != null && piece.endsWith("King") && BcastleRight.equals(toX + "," + toY)) {
            performMove(buttons[fromX][7], buttons[fromX][5], piece.charAt(0) + "Rook");
        }
        if (WcastleRight != null && piece.endsWith("King") && WcastleRight.equals(toX + "," + toY)) {
            performMove(buttons[fromX][7], buttons[fromX][5], piece.charAt(0) + "Rook");
        }

        if (BcastleLeft != null && piece.endsWith("King") && BcastleLeft.equals(toX + "," + toY)) {
            performMove(buttons[fromX][0], buttons[fromX][3], piece.charAt(0) + "Rook");
        }
        if (WcastleLeft != null && piece.endsWith("King") && WcastleLeft.equals(toX + "," + toY)) {
            performMove(buttons[fromX][0], buttons[fromX][3], piece.charAt(0) + "Rook");
        }

        if (piece.equals("WPawn") && toX == 0) {
            promote = "WPawn";
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Promotion.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 418, 410);
            Stage stage = new Stage();
            stage.setTitle("promote");
            stage.setScene(scene);
            stage.show();


        }
        if (piece.equals("BPawn") && toX == 7) {
            promote = "BPawn";
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Promotion.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 418, 410);
            Stage stage = new Stage();
            stage.setTitle("promote");
            stage.setScene(scene);
            stage.show();


        }


        moveHistory.add(new Move(fromX + "," + fromY, toX + "," + toY, piece));


        // 3. Additional Logic (Optional):
        // - Check for checkmate or stalemate
        // - Handle pawn promotion
        // - Update any game history or m ove logs
        // ...
    }

    static String promote;

    public boolean isSquareAttacked(String position, String player) {

        String[] KPos = position.split(",");
        int x = Integer.parseInt(KPos[0]);
        int y = Integer.parseInt(KPos[1]);
        String enemy = player.equals("White") ? "Black" : "White";
        String[][] board = getBoardState();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && board[i][j].charAt(0) == enemy.charAt(0)) {

                    if (getAvailableMoves2(board[i][j], enemy, i + "," + j).contains(x + "," + y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Button button;
    public String WcastleRight;
    public String BcastleRight;
    public String WcastleLeft;
    public String BcastleLeft;

    public String getPieceNameFromImage(String imageUrl) {
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        return imageName.split("\\.")[0]; // Remove file extension
    }

    private void enableAllButtons() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setDisable(false);
            }
        }
    }

    private void DisableAllButtons(String player) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setDisable(true);
            }
        }
        String[][] board = getBoardState();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].charAt(0) == player.charAt(0)) {
                        buttons[i][j].setDisable(false);
                    }
                }
            }
        }
    }

    private String[][] getBoardState() {
        String[][] state = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ImageView imageView = buttonImageViewMap.get(buttons[i][j]);
                if (imageView != null) {
                    Image image = imageView.getImage();
                    if (image != null) {
                        String imageUrl = image.getUrl();
                        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1); // Extract image name from URL
                        String[] data = imageName.split("\\.");
                        String piece = data[0];
                        state[i][j] = piece;
                    } else {
                        state[i][j] = null;
                    }
                }
            }
        }
        return state;
    }

    public List<String> getAvailableMoves(String piece, String player, String position) {
        List<String> result = new ArrayList<>();
        if (piece.charAt(0) == player.charAt(0)) {
            switch (piece.substring(1)) {
                case "Pawn":
                    result = getPawnMoves(position, player.charAt(0) == 'W', lastMove);
                    break;
                case "Rook":
                    result = getRookMoves(position, player);
                    break;
                case "Knight":
                    result = getKnightMoves(position, player);
                    break;
                case "Bishop":
                    result = getBishopMoves(position, player);
                    break;
                case "Queen":
                    result = getQueenMoves(position, player);
                    break;
                case "King":
                    result = getKingMoves(position, player);
                    break;
                default:
                    return Collections.emptyList(); // Handle invalid piece type
            }

        }
        return result;
    }

    public List<String> getAvailableMoves2(String piece, String player, String position) {
        List<String> result = new ArrayList<>();
        if (piece.charAt(0) == player.charAt(0)) {
            switch (piece.substring(1)) {
                case "Pawn":
                    result = getPawnMoves(position, player.charAt(0) == 'W', lastMove);
                    break;
                case "Rook":
                    result = getRookMoves(position, player);
                    break;
                case "Knight":
                    result = getKnightMoves(position, player);
                    break;
                case "Bishop":
                    result = getBishopMoves(position, player);
                    break;
                case "Queen":
                    result = getQueenMoves(position, player);
                    break;
                case "King":
                    result = getKingMoves2(position, player);
                    break;
                default:
                    return Collections.emptyList(); // Handle invalid piece type
            }

        }
        return result;
    }

    private List<String> getKingMoves2(String position, String player) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        // Possible moves (1 square in each direction)
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int j = 0; j < 8; j++) {
            int newX = x + dx[j];
            int newY = y + dy[j];

            // Boundary check
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                String targetPiece = board[newX][newY];

                // Check for empty square or enemy piece
                if (targetPiece == null || !targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                    result.add(newX + "," + newY);
                }
            }
        }

        return result;
    }

    private List<String> getKingMoves(String position, String player) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        // Possible moves (1 square in each direction)
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int j = 0; j < 8; j++) {
            int newX = x + dx[j];
            int newY = y + dy[j];

            // Boundary check
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                String targetPiece = board[newX][newY];

                // Check for empty square or enemy piece
                if (targetPiece == null || !targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                    result.add(newX + "," + newY);
                }
            }
        }

        if (CanCastleLeft(player)) {                                   // castling
            if (player.equals("White")) {
                result.add(x + "," + (y - 2));
                WcastleLeft = x + "," + (y - 2);
            }
            if (player.equals("Black")) {
                result.add(x + "," + (y - 2));
                BcastleLeft = x + "," + (y - 2);
            }
        }
        if (CanCastleRight(player)) {
            if (player.equals("White")) {
                result.add(x + "," + (y + 2));
                WcastleRight = x + "," + (y + 2);
            }
            if (player.equals("Black")) {
                result.add(x + "," + (y + 2));
                BcastleRight = x + "," + (y + 2);
            }

        }

        return result;
    }

    private List<String> getQueenMoves(String position, String player) {
        String[] coordinates = position.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        // Check moves in all eight directions
        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

        for (int direction = 0; direction < 8; direction++) {
            for (int step = 1; step < Math.max(board.length, board[0].length); step++) {
                int newX = x + step * dx[direction];
                int newY = y + step * dy[direction];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    String targetPiece = board[newX][newY];

                    if (targetPiece == null) {
                        // Empty square: Add to available moves
                        result.add(newX + "," + newY);
                    } else if (!targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                        // Opponent's piece: Add as a capture move and stop in this direction
                        result.add(newX + "," + newY);
                        break;
                    } else {
                        // Own piece: Stop in this direction
                        break;
                    }
                } else {
                    // Reached the edge of the board: Stop in this direction
                    break;
                }
            }
        }

        return result;
    }

    private List<String> getBishopMoves(String position, String player) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        // Check moves in all four diagonal directions
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, -1, 1};

        for (int direction = 0; direction < 4; direction++) {
            for (int step = 1; step < Math.max(board.length, board[0].length); step++) {
                int newX = x + step * dx[direction];
                int newY = y + step * dy[direction];

                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    String targetPiece = board[newX][newY];

                    if (targetPiece == null) {
                        result.add(newX + "," + newY);
                    } else {
                        // Check if the piece belongs to the opponent
                        if (!targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                            result.add(newX + "," + newY); // Capture move
                        }
                        break; // Stop in this direction, piece blocks further moves
                    }
                } else {
                    break; // Reached the edge of the board
                }
            }
        }

        return result;
    }

    private List<String> getKnightMoves(String position, String player) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        // Possible L-shaped moves for the knight
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};  // Changes in x
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};  // Changes in y

        for (int j = 0; j < 8; j++) {
            int newX = x + dx[j];
            int newY = y + dy[j];

            // Check if the new position is within bounds
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                String targetPiece = board[newX][newY];

                // Check for empty square or enemy piece
                if (targetPiece == null || !targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                    result.add(newX + "," + newY);
                }
            }
        }

        return result;
    }

    private List<String> getRookMoves(String position, String player) {
        String[] coordinates = position.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        // Check moves in all four directions
        int[] dx = {1, 0, -1, 0}; // Changes in x (right, down, left, up)
        int[] dy = {0, 1, 0, -1}; // Changes in y

        for (int direction = 0; direction < 4; direction++) {
            for (int step = 1; step < Math.max(board.length, board[0].length); step++) {
                int newX = x + step * dx[direction];
                int newY = y + step * dy[direction];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    String targetPiece = board[newX][newY];

                    if (targetPiece == null) {
                        // Empty square: Add to available moves
                        result.add(newX + "," + newY);
                    } else if (!targetPiece.startsWith(String.valueOf(player.charAt(0)))) {
                        // Opponent's piece: Add as a capture move and stop in this direction
                        result.add(newX + "," + newY);
                        break;
                    } else {
                        // Own piece: Stop in this direction
                        break;
                    }
                } else {
                    // Reached the edge of the board: Stop in this direction
                    break;
                }
            }
        }

        return result;
    }

    private List<String> getPawnMoves(String position, boolean isWhite, String lastMove) {
        String[] i = position.split(",");
        int x = Integer.parseInt(i[0]);
        int y = Integer.parseInt(i[1]);
        String[][] board = getBoardState();
        List<String> result = new ArrayList<>();

        int direction = isWhite ? -1 : 1;
        int startingRank = isWhite ? 6 : 1;

        // Check one step forward move
        if (x + direction >= 0 && x + direction < board.length && board[x + direction][y] == null) {
            result.add((x + direction) + "," + y);

            // Check two steps forward move from starting position
            if (x == startingRank && board[x + 2 * direction][y] == null) {
                result.add((x + 2 * direction) + "," + y);
            }
        }

        // Check diagonal captures
        if (isValidCapture(x, y - 1, direction, isWhite, board)) {
            result.add((x + direction) + "," + (y - 1));
        }
        if (isValidCapture(x, y + 1, direction, isWhite, board)) {
            result.add((x + direction) + "," + (y + 1));
        }

        if (lastMove != null) {
            lastMove = lastMove.substring(1);
        }
        // Check for en passant
        if (lastMove != null && lastMove.startsWith("P") && Math.abs(lastMove.charAt(5) - lastMove.charAt(9)) == 2 && x == (isWhite ? 3 : 4) && // Pawn is on the 5th rank (for white) or 4th rank (for black)Math.abs(lastMove.charAt(11) - position.charAt(2)) == 1 && // Adjacent columns
                ((y == lastMove.charAt(11) - '0' + 1) || (y == lastMove.charAt(11) - '0' - 1))) { // Same column as the last moved pawn
            result.add((x + direction) + "," + lastMove.charAt(11));
            enPassant = (x + direction) + "," + lastMove.charAt(11);
        }


        return result;
    }

    private boolean isValidCapture(int x, int y, int direction, boolean isWhite, String[][] board) {
        return y >= 0 && y < board[0].length && x + direction >= 0 && x + direction < board.length
                && board[x + direction][y] != null
                && (isWhite != (board[x + direction][y].startsWith("W")));
    }

    private boolean CanCastleRight(String player) {
        int kingRow = (player.equals("White")) ? 7 : 0;
        boolean kingsideRookMoved = false;
        boolean kingMoved = false;
        String[][] board = getBoardState();

        for (Move move : moveHistory) {
            if (move.getPiece().startsWith(String.valueOf(player.charAt(0)))) {  // Check the current player's pieces
                if (move.getPiece().endsWith("King")) {
                    kingMoved = true;
                } else if (move.getPiece().endsWith("Rook")) {
                    int rookRow = move.getFromButton().charAt(0) - '0';
                    int rookCol = move.getFromButton().charAt(2) - '0';

                    if (rookRow == kingRow && rookCol == 7) { // Kingside rook
                        kingsideRookMoved = true;
                    }
                }

                // If king or either rook has moved, we can stop checking
                if (kingMoved || kingsideRookMoved) {
                    return false;
                }
            }
        }
        return board[kingRow][5] == null && !isSquareAttacked(kingRow + "," + 5, player) && board[kingRow][6] == null && !isSquareAttacked(kingRow + "," + 6, player) && board[kingRow][7] != null && board[kingRow][7].equals(player.charAt(0) + "Rook");// None of the relevant pieces have moved
    }

    private boolean CanCastleLeft(String player) {
        int kingRow = (player.equals("White")) ? 7 : 0;
        boolean queensideRookMoved = false;
        boolean kingMoved = false;
        String[][] board = getBoardState();
        for (Move move : moveHistory) {
            if (move.getPiece().startsWith(String.valueOf(player.charAt(0)))) {  // Check the current player's pieces
                if (move.getPiece().endsWith("King")) {
                    kingMoved = true;
                } else if (move.getPiece().endsWith("Rook")) {
                    int rookRow = move.getFromButton().charAt(0) - '0';
                    int rookCol = move.getFromButton().charAt(2) - '0';

                    if (rookRow == kingRow && rookCol == 0) { // Queenside rook


                        queensideRookMoved = true;
                    }
                }

                // If king or either rook has moved, we can stop checking
                if (kingMoved || queensideRookMoved) {
                    return false;
                }
            }
        }

        return board[kingRow][3] == null && !isSquareAttacked(kingRow + "," + 3, player) && board[kingRow][2] == null && !isSquareAttacked(kingRow + "," + 2, player) && board[kingRow][1] == null && !isSquareAttacked(kingRow + "," + 1, player) && board[kingRow][0] != null && board[kingRow][0].equals(player.charAt(0) + "Rook");// None of the relevant pieces have moved
    }

    private List<Move> moveHistory = new ArrayList<>();

    public void onRestart(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage1.close();

        resetGameState();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 462, 571);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void onExit() {
        Platform.exit();
        System.exit(0);
    }
}

class Move {
    String fromButton;
    String toButton;
    String piece;

    public Move(String fromButton, String toButton, String piece) {
        this.fromButton = fromButton;
        this.toButton = toButton;
        this.piece = piece;
    }

    public String getPiece() {
        return piece;
    }

    public String getFromButton() {
        return fromButton;
    }
}