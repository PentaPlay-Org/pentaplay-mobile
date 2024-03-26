package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.Logics;

import java.util.Scanner;

public class TicTacToeGame {

    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char HUMAN_PLAYER = 'X';
    private static final char COMPUTER_PLAYER = 'O';

    private char[][] board;

    public TicTacToeGame() {
        board = new char[SIZE][SIZE];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void playGame(Scanner scanner) {
        resetBoard(); // Reset the board before starting a new game
        boolean humanTurn = true;
        boolean gameOver = false;

        while (!gameOver) {
            displayBoard();
            if (humanTurn) {
                makeMove(scanner, HUMAN_PLAYER);
            } else {
                makeComputerMove();
            }

            if (isWinner(HUMAN_PLAYER)) {
                displayBoard();
                System.out.println("You win!");
                gameOver = true;
            } else if (isWinner(COMPUTER_PLAYER)) {
                displayBoard();
                System.out.println("Computer wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                displayBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            }

            humanTurn = !humanTurn;
        }
    }

    private void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    private void makeMove(Scanner scanner, char player) {
        int row, col;
        do {
            System.out.print("Enter row (0-2) and column (0-2) for player " + player + ": ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));
        board[row][col] = player;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    private boolean isWinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Row win
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Column win
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void makeComputerMove() {
        int[] move = findBestMove();
        board[move[0]][move[1]] = COMPUTER_PLAYER;
    }

    private int[] findBestMove() {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = COMPUTER_PLAYER;
                    int score = minimax(0, false);
                    board[i][j] = EMPTY;
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(int depth, boolean isMaximizing) {
        if (isWinner(HUMAN_PLAYER)) {
            return -10;
        }
        if (isWinner(COMPUTER_PLAYER)) {
            return 10;
        }
        if (isBoardFull()) {
            return 0;
        }
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = COMPUTER_PLAYER;
                        int score = minimax(depth + 1, false);
                        board[i][j] = EMPTY;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = HUMAN_PLAYER;
                        int score = minimax(depth + 1, true);
                        board[i][j] = EMPTY;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

}
