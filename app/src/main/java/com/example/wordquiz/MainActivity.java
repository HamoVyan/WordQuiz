package com.example.wordquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView word_quiz;
    Button start;
    ImageButton info;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        TextView word_quiz = findViewById(R.id.word_quiz);
        Button start = findViewById(R.id.start);
        ImageButton info = findViewById(R.id.info);
        ConstraintLayout main1 = findViewById(R.id.main1);

        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intent);
                finish();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        /*Language*/
        if ( MainActivity5.Armenian ) {
            start.setText("Սկսել");
        }
        else if ( MainActivity5.Russian ) {
            start.setText("Начинать");
        }
        else if ( MainActivity5.English ) {
            start.setText("Start");
        }
        /*Language*/
    }
}