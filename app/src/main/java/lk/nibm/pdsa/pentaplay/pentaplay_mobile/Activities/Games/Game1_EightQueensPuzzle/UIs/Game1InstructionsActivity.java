package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game1_EightQueensPuzzle.UIs;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;

public class Game1InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game1_instructions);

    }

    public void startButtonClick(View view) {
        Intent intent = new Intent(this, Game1Activity.class );
        startActivity(intent);
    }

}