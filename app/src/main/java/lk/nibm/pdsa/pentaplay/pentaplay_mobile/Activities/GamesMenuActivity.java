package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game1_EightQueensPuzzle.UIs.Game1Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.UIs.Game2Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game3_IdentifyShortestPath.UIs.Game3Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game4_RememberTheValueIndex.UIs.Game4Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.UIs.Game5Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGamesMenuBinding;

public class GamesMenuActivity extends AppCompatActivity {

    private ActivityGamesMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGamesMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String playerName = getIntent().getStringExtra("PlayerName");
        binding.playerName.setText(playerName);

        binding.btnEightQueens.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Game1Activity.class);
            intent.putExtra("PlayerName", playerName);
            startActivity(intent);
        });

        binding.btnTicTacToe.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Game2Activity.class);
            intent.putExtra("PlayerName", playerName);
            startActivity(intent);
        });

        binding.btnIdentifyShortestPath.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Game3Activity.class);
            intent.putExtra("PlayerName", playerName);
            startActivity(intent);
        });

        binding.btnRememberPosition.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Game4Activity.class);
            intent.putExtra("PlayerName", playerName);
            startActivity(intent);
        });

        binding.btnPredictPosition.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Game5Activity.class);
            intent.putExtra("PlayerName", playerName);
            startActivity(intent);
        });

    }
}