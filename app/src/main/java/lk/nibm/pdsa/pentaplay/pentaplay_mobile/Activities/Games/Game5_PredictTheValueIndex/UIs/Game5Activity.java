package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.UIs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.Objects;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.Helper;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.ISearchAlgorithm;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.PredictTheValueIndex;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.SearchAlgorithm;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;

public class Game5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRound();



        MaterialButton nextRoundBtn = findViewById(R.id.nextButton);
        nextRoundBtn.setOnClickListener(e->{
            initRound();
            showSnackBar("Game Started");
        });

    }

    private  void initRound(){
        PredictTheValueIndex obj = new PredictTheValueIndex();
        System.out.print("ARRAY  ");
        int[] choices = obj.startRound();

        TextView  quiz = (TextView)findViewById(R.id.quizIndex);
        quiz.setText(String.valueOf(obj.getKey()));

        System.out.print(Arrays.toString(choices));
        MaterialButton button1 = findViewById(R.id.button1);
        button1.setText(String.valueOf(choices[0]));
        MaterialButton button2 = findViewById(R.id.button2);
        button2.setText(String.valueOf(choices[1]));
        MaterialButton button3 = findViewById(R.id.button3);
        button3.setText(String.valueOf(choices[2]));
        MaterialButton button4 = findViewById(R.id.button4);
        button4.setText(String.valueOf(choices[3]));

    }



    void showSnackBar(String text){
        Snackbar.make(findViewById(R.id.main), "This is main activity", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }
}