package com.cs301.chessapp.gamestate.pieces;

import android.util.Log;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.checkmate.Check;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * King class
 *
 * This class represents a king in the game of chess. The king can move one
 * square in any direction.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class King extends Piece {

    private final Check _check;

    /**
     * King constructor
     *
     * This constructor initializes a bishop with a player.
     *
     * @param playerId      the player who owns the king
     */
    public King(int playerId) {
        super(playerId, "King");
        _check = new Check(playerId);
    }

    public King(King other) {
        super(other);
        _check = new Check(getPlayerId());
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the king.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();
        _check.set(gamestate, _row, _col);

//        if (_check._inCheck) {
//            Log.d("King", _playerId + " is in check");
//        }

        for (int i = -1; i <= 1; i++) {
            for (int j = - 1; j <= 1; j++) {
                if (hasValidBounds(_row + i, _col + j) && !_check.isCheck(_row + i, _col + j)) {
                    if (gamestate.getPiece(_row + i, _col + j) == null) {
                        validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + j));
                    } else if (gamestate.getPiece(_row + i, _col + j).getPlayerId() != _playerId) {
                        validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + j));
                    }
                }
            }
        }

        if (_playerId == ChessGameState.PLAYER_1) {

            if (_row == 7 && _col == 4) {
                if (gamestate.getPiece(7, 0) != null && (gamestate.getPiece(7, 0).getName().equals("Rook") && gamestate.getPiece(7, 0).getPlayerId() == _playerId)) {
                    if (gamestate.getPiece(7, 1) == null && gamestate.getPiece(7, 2) == null && gamestate.getPiece(7, 3) == null) {
                        validMoves.add(new ChessMove(player, _row, _col, 7, 0));
                    }
                }

                if (gamestate.getPiece(7, 7) != null && (gamestate.getPiece(7, 7).getName().equals("Rook") && gamestate.getPiece(7, 7).getPlayerId() == _playerId)) {
                    if (gamestate.getPiece(7, 5) == null && gamestate.getPiece(7, 6) == null) {
                        validMoves.add(new ChessMove(player, _row, _col, 7, 7));
                    }
                }
            }
        }

        else if (_playerId == ChessGameState.PLAYER_2) {

            if (_row == 0 && _col == 4) {
                if (gamestate.getPiece(0, 0) != null && (gamestate.getPiece(0, 0).getName().equals("Rook") && gamestate.getPiece(0, 0).getPlayerId() == _playerId)) {
                    if (gamestate.getPiece(0, 1) == null && gamestate.getPiece(0, 2) == null && gamestate.getPiece(0, 3) == null) {
                        validMoves.add(new ChessMove(player, _row, _col, 0, 0));
                    }
                }

                if (gamestate.getPiece(0, 7) != null && (gamestate.getPiece(0, 7).getName().equals("Rook") && gamestate.getPiece(0, 7).getPlayerId() == _playerId)) {
                    if (gamestate.getPiece(0, 5) == null && gamestate.getPiece(0, 6) == null) {
                        validMoves.add(new ChessMove(player, _row, _col, 0, 7));
                    }
                }
            }
        }

        return validMoves;
    }

    public ArrayList<ChessMove> getChecks(ChessGameState gamestate) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();
        return validMoves;
    }

    public boolean inCheck() {
        return _check.inCheck();
    }
}
