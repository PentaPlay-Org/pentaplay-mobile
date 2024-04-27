package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.UIs;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game2_TicTacToe.UIs.Game2Activity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game5_PredictTheValueIndex.Logics.PredictTheValueIndex;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.GamesMenuActivity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.WelcomeActivity;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Firebase.FirebaseHandler;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Player;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame2Binding;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame5Binding;

public class Game5Activity extends AppCompatActivity {

    private ActivityGame5Binding binding;
    int[] choices;
    int selectedIndex = -1;
    boolean isDisabled = false;
    private FirebaseHandler firebaseHandler;
    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityGame5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Game5Activity.this, WelcomeActivity.class);
            startActivity(intent);
        });

        playerName = getIntent().getStringExtra("PlayerName");

        FirebaseApp.initializeApp(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseHandler = new FirebaseHandler();

        initRound();



        MaterialButton nextRoundBtn = findViewById(R.id.nextButton);
        nextRoundBtn.setOnClickListener(e->{
            if(isDisabled) return;
            initRound();
        });

    }

    private  void initRound(){
        isDisabled = false;
        onSelected(-1 , true);
        PredictTheValueIndex obj = new PredictTheValueIndex();
        //ProgressBar loader = findViewById(R.id.loader);
        /*
        loader.setVisibility(View.VISIBLE);
        isDisabled = true;
        */
        this.choices = obj.startRound();
        /*
        new Handler().postDelayed(() -> {
            loader.setVisibility(View.GONE);
            isDisabled = false;
        }, 3000);
        */

        TextView  quiz = (TextView)findViewById(R.id.quizIndex);
        quiz.setText(String.valueOf(obj.getKey()));

        System.out.print(Arrays.toString(choices));
        MaterialButton button1 = findViewById(R.id.button1);
        button1.setOnClickListener(e->{
            onAnswer(0 , obj);
        });
        button1.setText(String.valueOf(choices[0]));

        MaterialButton button2 = findViewById(R.id.button2);
        button2.setOnClickListener(e->{
            onAnswer(1 , obj);
        });
        button2.setText(String.valueOf(choices[1]));

        MaterialButton button3 = findViewById(R.id.button3);
        button3.setOnClickListener(e->{
            onAnswer(2 , obj);
        });
        button3.setText(String.valueOf(choices[2]));

        MaterialButton button4 = findViewById(R.id.button4);
        button4.setOnClickListener(e->{
            onAnswer(3 , obj);
        });
        button4.setText(String.valueOf(choices[3]));
    }

    void onSelected(int index , boolean isCorrect){
        MaterialButton button = getButton(selectedIndex);
        setButtonTheme(button , "#FFFFFF" , "#000000");
        selectedIndex = index;
        String bg = isCorrect?"#5356FF":"#ff3333";
        button = getButton(selectedIndex);
            setButtonTheme(button , bg , "#FFFFFF");
    }

    void onAnswer(int index , PredictTheValueIndex obj){
        if(isDisabled)return;

        boolean isCorrect = obj.checkAnswer(this.choices[index]);
        onSelected(index , isCorrect);
        if(isCorrect){
            showSnackBar("Awesome !!  Correct answer");
            Player currentPlayer = new Player(playerName, "Predict the value index");
            Map<String, Object> answerMap = new HashMap<>();
            answerMap.put("playerName", playerName);
            answerMap.put("gameCode", "Predict the value index");
            answerMap.put("answer", choices[index]);
            if (currentPlayer != null) {
                firebaseHandler.store(currentPlayer, answerMap);
            }
        }else{
            showSnackBar("Ohh !!  Wrong answer");
        }
        isDisabled = true;
        new Handler().postDelayed(this::initRound, 1000);
    }



    void showSnackBar(String text){
        Snackbar.make(findViewById(R.id.main), text, Snackbar.LENGTH_LONG)
                .setAction("CLOSE", view -> {})
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }

    MaterialButton getButton(int index){
        switch (index){
            case 0:
                return findViewById(R.id.button1);
            case 1:
                return findViewById(R.id.button2);
            case 2:
                return findViewById(R.id.button3);
            case 3:
                return findViewById(R.id.button4);
            default:
                return  null;
        }
    }

    void setButtonTheme(MaterialButton button , String backgroundColor , String textColor){
        if(button == null) return;
        button.setBackgroundTintList(ColorStateList
                .valueOf(Color.parseColor(backgroundColor)));
        button.setTextColor(Color.parseColor(textColor));
    }
}