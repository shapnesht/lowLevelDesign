package ticTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.println("-------------");
            for (int j = 0; j < size; j++) {
                System.out.print("| ");
                if (board[i][j] != null) System.out.print(board[i][j].pieceType + " ");
                else System.out.print("  ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public List<List<Integer>> getFreeCells() {
        List<List<Integer>> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) freeCells.add(List.of(i, j));
            }
        }
        return freeCells;
    }

    public boolean placePiece(int r, int c, PlayingPiece playingPiece) {
        if (board[r][c] != null) {
            return false;
        }
        board[r][c] = playingPiece;
        return true;
    }
}
