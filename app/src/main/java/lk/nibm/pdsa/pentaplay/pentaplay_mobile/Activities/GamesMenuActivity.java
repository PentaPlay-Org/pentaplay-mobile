package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities;

import androidx.appcompat.app.AppCompatActivity;

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

        binding.btnEightQueens.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Game1Activity.class)));

        binding.btnTicTacToe.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Game2Activity.class)));

        binding.btnIdentifyShortestPath.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Game3Activity.class)));

        binding.btnRememberPosition.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Game4Activity.class)));

        binding.btnPredictPosition.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), Game5Activity.class)));

    }
}