package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.Logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    public static final String PLAYER = "O";
    public static final String COMPUTER = "X";

    String[][] board = new String[3][3];
    private Cell computersMove;

    public List<Cell> availableCells() {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null || board[i][j].isEmpty()) {
                    cells.add(new Cell(i, j));
                }
            }
        }
        return cells;
    }

    public boolean isGameOver() {
        return hasComputerWon() || hasPlayerWon() || availableCells().isEmpty();
    }

    public boolean hasComputerWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && COMPUTER.equals(board[0][0])) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && COMPUTER.equals(board[0][2]))) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && COMPUTER.equals(board[i][0])) ||
                    (board[0][i] == board[1][i] && board[0][i] == board[2][i] && COMPUTER.equals(board[0][i]))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPlayerWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && PLAYER.equals(board[0][0])) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && PLAYER.equals(board[0][2]))) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && PLAYER.equals(board[i][0])) ||
                    (board[0][i] == board[1][i] && board[0][i] == board[2][i] && PLAYER.equals(board[0][i]))) {
                return true;
            }
        }
        return false;
    }


    //minmax is a decision rule used in ai for minimizing the possible loss for a worst case scenario.
    public int minimax(int depth, String player) {
        if (hasComputerWon()) return +1;
        if (hasPlayerWon()) return -1;

        if (availableCells().isEmpty()) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < availableCells().size(); i++) {
            Cell cell = availableCells().get(i);
            if (player.equals(COMPUTER)) {
                placeMove(cell, COMPUTER);
                int currentScore = minimax(depth + 1, PLAYER);
                max = Math.max(currentScore, max);

                if (currentScore >= 0) {
                    if (depth == 0) computersMove = cell;
                }

                if (currentScore == 1) {
                    board[cell.getI()][cell.getJ()] = "";
                    break;
                }

                if (i == availableCells().size() - 1 && max < 0) {
                    if (depth == 0) computersMove = cell;
                }

            } else if (player.equals(PLAYER)) {
                placeMove(cell, PLAYER);
                int currentScore = minimax(depth + 1, COMPUTER);
                min = Math.min(currentScore, min);

                if (min == -1) {
                    board[cell.getI()][cell.getJ()] = "";
                    break;
                }
            }
            board[cell.getI()][cell.getJ()] = "";
        }

        return player.equals(COMPUTER) ? max : min;
    }

    public void placeMove(Cell cell, String player) {
        board[cell.getI()][cell.getJ()] = player;
    }

    public Cell getComputersMove() {
        return computersMove;
    }

    public void setComputersMove(Cell move) {
        this.computersMove = move;
    }

    public String[][] getBoard() {
        return board;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("PLAYER", PLAYER);
        map.put("COMPUTER", COMPUTER);

        List<List<String>> boardList = new ArrayList<>();
        for (String[] row : board) {
            boardList.add(Arrays.asList(row));
        }
        map.put("board", boardList);

        return map;
    }

    public static Board fromMap(Map<String, Object> map) {
        Board board = new Board();
        board.board = ((List<List<String>>) map.get("board")).stream()
                .map(row -> row.toArray(new String[0]))
                .toArray(String[][]::new);

        Map<String, Integer> moveMap = (Map<String, Integer>) map.get("computersMove");
        if (moveMap != null) {
            int i = moveMap.get("i");
            int j = moveMap.get("j");
            board.computersMove = new Cell(i, j);
        }

        return board;
    }

}
