package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game1_EightQueensPuzzle.UIs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;

public class Game1Activity extends AppCompatActivity {

    private ChessBoard chessBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        chessBoard = findViewById(R.id.chessBoard);

        TextView queenCount = findViewById(R.id.queenCount);

        chessBoard.setUpGame(queenCount);
    }

    public void clearBoardButtonClick(View view) {
        chessBoard.clearBoard();
        chessBoard.invalidate();
    }
}

