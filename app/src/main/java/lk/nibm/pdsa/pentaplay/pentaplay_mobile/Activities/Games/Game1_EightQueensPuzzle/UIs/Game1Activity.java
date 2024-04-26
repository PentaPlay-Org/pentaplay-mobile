package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game1_EightQueensPuzzle.UIs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.UIs.Game2Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.GamesMenuActivity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.WelcomeActivity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame1Binding;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame2Binding;

public class Game1Activity extends AppCompatActivity {

    private ChessBoard chessBoard;
    private ActivityGame1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGame1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chessBoard = findViewById(R.id.chessBoard);

        TextView queenCount = findViewById(R.id.queenCount);

        chessBoard.setUpGame(queenCount);

        binding.homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Game1Activity.this, WelcomeActivity.class);
            startActivity(intent);
        });

    }

    public void clearBoardButtonClick(View view) {
        chessBoard.clearBoard();
        chessBoard.invalidate();
    }
}

