package com.example.wordquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity7 extends AppCompatActivity {

    Button exit;
    TextView win;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main7);

        TextView win = findViewById(R.id.win);
        Button exit = findViewById(R.id.exit);
        ConstraintLayout main7 = findViewById(R.id.main7);

        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);

        boolean team1_win = getIntent().getBooleanExtra("team1_win", true);
        boolean team2_win = getIntent().getBooleanExtra("team2_win", true);
        if ( team1_win ) {
            win.setText("Team 1 won");
        } else if ( team2_win ) {
            win.setText("Team 2 won");
        }

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });
    }
}