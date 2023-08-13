package ticTacToe;

import ticTacToe.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();
        PlayingPiece pieceX = new PlayingPieceX();
        Player player1 = new Player("shapnesh", pieceX);

        PlayingPiece pieceO = new PLayingPieceO();
        Player player2 = new Player("shoppy", pieceO);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame() {
        boolean isFinished = false;
        while (!isFinished) {
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<List<Integer>> freeCells = gameBoard.getFreeCells();
            if (freeCells.isEmpty()) {
                isFinished = true;
                break;
            }

            System.out.println("It's your turn : " + playerTurn.getName());
            System.out.println("Please Enter the row number");
            Scanner scanner = new Scanner(System.in);
            int r = scanner.nextInt();
            System.out.println("Please Enter the column number");
            int c = scanner.nextInt();

            boolean isPiecePlaced = gameBoard.placePiece(r, c, playerTurn.getPlayingPiece());
            if (!isPiecePlaced) {
                System.out.println("Incorrect Position, Please Try Again...");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean isWinnerFound = checkForWin(r, c, playerTurn.getPlayingPiece());
            if (isWinnerFound) return playerTurn.getName();
        }
        return "Match Tie!!";
    }

    private boolean checkForWin(int r, int c, PlayingPiece playingPiece) {
        boolean rows = false;
        boolean columns = false;
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < gameBoard.size; i++) {
            boolean allSame = true;
            for (int j = 0; j < gameBoard.size; j++) {
                if (gameBoard.board[i][j] != playingPiece) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                rows = true;
                break;
            }
        }

        for (int i = 0; i < gameBoard.size; i++) {
            boolean allSame = true;
            for (int j = 0; j < gameBoard.size; j++) {
                if (gameBoard.board[j][i] != playingPiece) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                columns = true;
                break;
            }
        }

        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[j][j] != playingPiece) {
                diagonal1 = false;
            }
            if (gameBoard.board[j][gameBoard.size-1-j] != playingPiece) {
                diagonal2 = false;
            }
        }

        return rows || columns || diagonal1 || diagonal2;
    }
}
