package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game3_IdentifyShortestPath.UIs;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities.Games.Game3_IdentifyShortestPath.Logics.IdentifyShortestPath;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame2Binding;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityGame3Binding;

public class Game3Activity extends AppCompatActivity {

    private ActivityGame3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityGame3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[]  cities = {"A","B","C","D","E","F","G","H","I","J"};

        IdentifyShortestPath obj = new IdentifyShortestPath();
        int nearestDistance = obj.findShortestPath();
//        printGraph(obj.graph , cities);
//        System.out.println("Distance between "+cities[obj.source] + " To " + cities[obj.destination] + " " + nearestDistance);

        binding.quizTextview.setText("Find Nearest Distance between "+cities[obj.source] + " To " + cities[obj.destination]);
        binding.submitBtn.setOnClickListener(e->{
           try {
               if(Integer.parseInt(binding.answerInput.getText().toString()) == nearestDistance){
                   Toast toast = new Toast(this);
                   toast.setText("Awesome !!!!!!  Correct answer ");
                   toast.show();
               }else{
                   Toast toast = new Toast(this);
                   toast.setText("Wrong !  Please try again ");
                   toast.show();
               }
           }catch (NumberFormatException ex){
               Toast toast = new Toast(this);
               toast.setText("Please Enter a number");
               toast.show();
           }
        });

        // Create a LinearLayout to hold the city labels and graph visualization
        LinearLayout mainLayout = binding.gridviewLayout;
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // Create a TextView for the city labels row
        TextView cityLabels = new TextView(this);
        cityLabels.setText("\t\t");
        for (String city : cities) {
            cityLabels.append(city + "\t");
        }
        cityLabels.setTextSize(20);
        cityLabels.setWidth(100);
        mainLayout.addView(cityLabels);

        // Dynamically create TextViews for each row of the graph
        for (int i = 0; i < obj.graph.length-1; i++) {
            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView cityLabel = new TextView(this);
            cityLabel.setText(cities[i] + "\t");
            cityLabel.setWidth(100);
            cityLabel.setTextSize(20);
            rowLayout.addView(cityLabel);

            for (int j = 0; j < obj.graph[i].length; j++) {
                TextView cellText = new TextView(this);
                cellText.setText(String.valueOf(obj.graph[i][j]));  // Use String.valueOf() for clarity
                cellText.setTextSize(18);
                cellText.setWidth(100);  // Adjust width as needed for better formatting
                rowLayout.addView(cellText);
            }
            mainLayout.addView(rowLayout);
        }
    }


    public static void printGraph(int[][] graph , String[] cities) {
        System.out.print("\t");
        for (String city : cities) {
            System.out.print(city + "\t");
        }
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            System.out.print(cities[i] + "\t");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }




}