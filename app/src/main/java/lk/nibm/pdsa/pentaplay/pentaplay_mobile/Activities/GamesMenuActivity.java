package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.UIs.Game5Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;

public class GamesMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_menu);
        startActivity(new Intent(this , Game5Activity.class));
    }
}