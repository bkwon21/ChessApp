package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

/**
 * Queen
 * <p>
 * This class represents a queen piece in a game of chess. The queen can move
 * any number of squares in any direction. It cannot jump over other pieces.
 * It can capture an enemy piece on any square in any direction. It cannot
 * place itself on a square occupied by a friendly piece. It cannot place its
 * own king in check. It is worth 7 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Queen extends Piece{
    private static final String TAG = "Piece-Queen";

    /**
     * Queen constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * queen to 7. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Queen(int player) {
        super(player);
        this._value = 9;
        this._type = "Queen";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the queen.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<MoveAction> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<MoveAction> valid = new ArrayList<>();

        // todo: consolidate this code into less for loops

        // search for moves up
        for (int i = 0; i < 8; i++) {
            if (isValid(x, y+i)) {
                if (board[x][y+i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x, y+i));
                } else if (board[x][y+i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x, y+i));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves down
        for (int i = 0; i < 8; i++) {
            if (isValid(x, y-i)) {
                if (board[x][y-i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x, y-i));
                } else if (board[x][y-i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x, y-i));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y)) {
                if (board[x+i][y].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x+i, y));
                } else if (board[x+i][y].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x+i, y));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y)) {
                if (board[x-i][y].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x-i, y));
                } else if (board[x-i][y].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x-i, y));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves up-right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y+i)) {
                if (board[x+i][y+i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x+i, y+i));
                } else if (board[x+i][y+i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x+i, y+i));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves up-left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y+i)) {
                if (board[x-i][y+i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x-i, y+i));
                } else if (board[x-i][y+i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x-i, y+i));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves down-right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y-i)) {
                if (board[x+i][y-i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x+i, y-i));
                } else if (board[x+i][y-i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x+i, y-i));
                    break;
                } else {
                    break;
                }
            }
        }

        // search for moves down-left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y-i)) {
                if (board[x-i][y-i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x-i, y-i));
                } else if (board[x-i][y-i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x-i, y-i));
                    break;
                } else {
                    break;
                }
            }
        }

        return valid;
    }
}
