package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.UIs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.Logics.Board;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.Logics.Cell;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.GamesMenuActivity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Firebase.FirebaseHandler;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Player;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame2Binding;

public class Game2Activity extends AppCompatActivity {
    private ImageView[][] boardCells = new ImageView[3][3];
    private Board board = new Board();
    private ActivityGame2Binding binding;
    private FirebaseHandler firebaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGame2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseApp.initializeApp(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseHandler = new FirebaseHandler();

        loadBoard();

        binding.btnReset.setOnClickListener(v -> {
            reset();
        });
        binding.homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Game2Activity.this, GamesMenuActivity.class);
            startActivity(intent);
        });
    }

    private void reset() {
        board = new Board();
        binding.textViewResult.setText("");
        loadBoard();
    }

    private void mapBoardToUi() {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                switch (board.getBoard()[i][j]) {
                    case Board.PLAYER:
                        boardCells[i][j].setImageResource(R.drawable.circle);
                        boardCells[i][j].setEnabled(false);
                        break;
                    case Board.COMPUTER:
                        boardCells[i][j].setImageResource(R.drawable.cross);
                        boardCells[i][j].setEnabled(false);
                        break;
                    default:
                        boardCells[i][j].setImageResource(0);
                        boardCells[i][j].setEnabled(true);
                        break;
                }
            }
        }
    }

    private void loadBoard() {
        GridLayout layout_board = findViewById(R.id.layout_board);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardCells[i][j] = new ImageView(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                params.width = 250;
                params.height = 230;
                params.bottomMargin = 5;
                params.topMargin = 5;
                params.leftMargin = 5;
                params.rightMargin = 5;
                boardCells[i][j].setLayoutParams(params);
                boardCells[i][j].setBackgroundColor(getResources().getColor(R.color.primary));
                boardCells[i][j].setOnClickListener(new CellClickListener(i, j));
                layout_board.addView(boardCells[i][j]);
            }
        }
    }

    private void storeBoardData() {
        Map<String, Object> boardMap = board.toMap();
        Map<String, Object> jsonObject = convertBoardToMap(boardMap);

        Player player = new Player("PlayerName2");

        firebaseHandler.store(player, jsonObject);
    }

    private class CellClickListener implements View.OnClickListener {
        private int i;
        private int j;

        CellClickListener(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void onClick(View v) {
            if (!board.isGameOver()) {
                Cell cell = new Cell(i, j);
                board.placeMove(cell, Board.PLAYER);
                board.minimax(0, Board.COMPUTER);
                Cell computersMove = board.getComputersMove();
                if (computersMove != null) {
                    board.placeMove(computersMove, Board.COMPUTER);
                }
                mapBoardToUi();
            }

            // Display results
            if (board.hasComputerWon()) {
                binding.textViewResult.setText("Computer Won");
            } else if (board.hasPlayerWon()) {
                binding.textViewResult.setText("Player Won");
                storeBoardData();
            } else if (board.isGameOver()) {
                binding.textViewResult.setText("Game Tied");
            }
        }
    }

    private Map<String, Object> convertBoardToMap(Map<String, Object> board) {
        Map<String, Object> boardData = new HashMap<>();
        try {
            for (Map.Entry<String, Object> entry : board.entrySet()) {
                String position = entry.getKey();
                String value = entry.getValue().toString();
                boardData.put(position, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
        return boardData;
    }

}