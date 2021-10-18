package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.midterm.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonPaper.setOnClickListener(view -> game("보"));
        binding.buttonRock.setOnClickListener(view -> game("바위"));
        binding.buttonScissors.setOnClickListener(view -> game("가위"));
        binding.buttonRestart.setOnClickListener(view -> restart());
    }

    private void restart(){
    }

    private void game(String yourChoice) {
        int ai = random.nextInt(3);
        String aiChoice;
        switch (ai) {
            case 0:
                aiChoice = "가위";
                binding.scissor.setImageResource(R.drawable.scissors);
                break;
            case 1:
                aiChoice = "바위";
                binding.rock.setImageResource(R.drawable.rock);
                break;
            default:
                aiChoice = "보";
                binding.paper.setImageResource(R.drawable.paper);
        }

        binding.textYou.setText("당신은 " + yourChoice + "를 냈습니다.");
        binding.textAi.setText("AI는 " + aiChoice + "를 냈습니다.");

        String result;

        if (aiChoice.equals(yourChoice)) {
            result = "비겼습니다!";
        } else if ((aiChoice.equals("가위") && yourChoice.equals("바위")) ||
                (aiChoice.equals("바위") && yourChoice.equals("보")) ||
                (aiChoice.equals("보") && yourChoice.equals("가위"))) {
            result = "축하합니다! 당신이 이겼습니다!";
        } else {
            result = "으악 당신이 졌습니다!";
        }
        binding.textResult.setText(result);
        binding.buttonRestart.setVisibility(View.VISIBLE);
        binding.textResult.setVisibility(View.VISIBLE);
        binding.textPercent.setVisibility(View.VISIBLE);
        binding.aiResult.setVisibility(View.VISIBLE);
        binding.yourResult.setVisibility(View.VISIBLE);
        binding.textSubtitle.setVisibility(View.GONE);
        binding.rock.setVisibility(View.GONE);
        binding.paper.setVisibility(View.GONE);
        binding.scissor.setVisibility(View.GONE);
    }

}