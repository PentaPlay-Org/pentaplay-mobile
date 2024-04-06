package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game4_RememberTheValueIndex.UIs;

import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game4_RememberTheValueIndex.Logics.RememberTheValueIndex;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;

public class Game4Activity extends AppCompatActivity {

    private int[] sortedNumbers;
    private int index;

    private int number1Index;
    private int number2Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RememberTheValueIndex rememberTheValueIndex = new RememberTheValueIndex();
        int[] sortedArray = rememberTheValueIndex.myMethod();
        sortedNumbers = sortedArray;
        index = 0;

        displayNextNumber();
    }

    private void displayNextNumber() {
        if (index < sortedNumbers.length && index < 20) {
            int number = sortedNumbers[index];
            TextView textView = findViewById(R.id.TextView2);
            textView.setText("Index: " + index + ", Number: " + number);

            index++;
            if (index == 20) {
                // Show TextView3 and TextView4
                findViewById(R.id.TextView3).setVisibility(View.VISIBLE);
                findViewById(R.id.TextView4).setVisibility(View.VISIBLE);
                findViewById(R.id.textView).setVisibility(View.VISIBLE);
                // Hide TextView2
                textView.setVisibility(View.GONE);
                displayRandomNumbersFromFirst20();
            } else {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(this::displayNextNumber, 2000); // Delay for 2 seconds
            }
        }
    }


    private void displayRandomNumbersFromFirst20() {
        Random rand = new Random();
        number1Index = rand.nextInt(20); // Generate random index for first random number
        do {
            number2Index = rand.nextInt(20); // Generate random index for second random number
        } while (number1Index == number2Index); // Ensure the second random index is different from the first

        // Get the random numbers from the sortedNumbers array
        int number1 = sortedNumbers[number1Index];
        int number2 = sortedNumbers[number2Index];

        TextView textView3 = findViewById(R.id.TextView3);
        textView3.setText("" + number1);

        TextView textView4 = findViewById(R.id.TextView4);
        textView4.setText("" + number2);
    }

    public void onSubmit(View view) {
        EditText editText1 = findViewById(R.id.editTextText1);
        EditText editText2 = findViewById(R.id.editTextText2);

        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);

        int input1, input2;
        try {
            input1 = Integer.parseInt(editText1.getText().toString());
            input2 = Integer.parseInt(editText2.getText().toString());
        } catch (NumberFormatException e) {
            // Handle invalid inputs
            return;
        }

        if (input1 == number2Index && input2 == number1Index) {
            textView5.setVisibility(View.GONE);
            textView6.setVisibility(View.VISIBLE);
        } else {
            textView5.setVisibility(View.VISIBLE);
            textView6.setVisibility(View.GONE);
        }
    }


}