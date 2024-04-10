package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Player;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.R;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        setListners();
    }

    private void setListners()
    {

        binding.btnEnter.setOnClickListener(v-> {
            if (isValidSignInDetails())
            {
                Player player = new Player(binding.inputName.getText().toString());
                Intent intent = new Intent(WelcomeActivity.this, GamesMenuActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showToast(String message)
    {

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    private Boolean isValidSignInDetails()
    {

        if(binding.inputName.getText().toString().trim().isEmpty())
        {
            showToast("Enter Name");
            return false;
        }else
        {
            return true;
        }

    }


}