package com.example.wordquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ImageButton back;
    TextView info1, info2, info3, info4, info5, HowToPlay, language;
    RadioButton armenian, russian, english;
    public static boolean isArmenianSelected = false;
    public static boolean isRussianSelected = false;
    public static boolean isEnglishSelected = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        TextView HowToPlay = findViewById(R.id.HowToPlay);
        ImageButton back = findViewById(R.id.back);
        TextView info1 = findViewById(R.id.info1);
        TextView info2 = findViewById(R.id.info2);
        TextView info3 = findViewById(R.id.info3);
        TextView info4 = findViewById(R.id.info4);
        TextView info5 = findViewById(R.id.info5);
        TextView language = findViewById(R.id.language);
        RadioButton armenian = findViewById(R.id.armenian);
        RadioButton russian = findViewById(R.id.russian);
        RadioButton english = findViewById(R.id.english);
        ConstraintLayout main3 = findViewById(R.id.main3);

        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);

        /*RadioButtons*/
        CompoundButton.OnCheckedChangeListener listener3 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != armenian) {
                        armenian.setChecked(false);
                    }
                    if (buttonView != russian) {
                        russian.setChecked(false);
                    }
                    if (buttonView != english) {
                        english.setChecked(false);
                    }
                }
            }
        };

        armenian.setOnCheckedChangeListener(listener3);
        russian.setOnCheckedChangeListener(listener3);
        english.setOnCheckedChangeListener(listener3);
        english.setChecked(true);
        /*RadioButtons*/

        armenian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HowToPlay.setText("Ինչպես Խաղալ");
                info1.setText("Խաղը նախատեսված է ընկերների հետ խաղալու համար: Խաղացողները բաժանված են 2 թիմի: Խաղացողը պետք է խաղընկերոջը բացատրի էկրանին գրված բառը, յուրաքանչյուր ճիշտ գուշակած բառի համար թիմը կստանա 1 միավոր:");
                info2.setText("Խաղը սկսելուց առաջ խաղացողը պետք է ընտրի`");
                info3.setText("1)Հաղթական միավորների քանակը");
                info4.setText("2)1 փուլի տևողությունը");
                info5.setText("3)Բաժինը");
                language.setText("Ընտրեք լեզուն");
                armenian.setText("Հայերեն");
                russian.setText("Ռուսերեն");
                english.setText("Անգլերեն");

            }
        });

        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HowToPlay.setText("Как Играть");
                info1.setText("Игра предназначена для игры с друзьями. Игроки делятся на 2 команды. Игрок должен объяснить товарищу по команде слово, написанное на экране, за каждое правильно угаданное слово команда получает 1 очко.");
                info2.setText("Перед началом игры игрок должен выбрать:");
                info3.setText("1)Количество выигрышных очков");
                info4.setText("2)Продолжительность 1 раунда");
                info5.setText("3)Раздел");
                language.setText("Выберите язык");
                armenian.setText("Армянский");
                russian.setText("Русский");
                english.setText("Английский");
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HowToPlay.setText("How To Play");
                info1.setText("The game is designed to be played with friends. The players are divided into 2 teams. The player must explain the word written on the screen to his teammate, for each correctly guessed word, the team will get 1 point.");
                info2.setText("Before starting the game, the player must choose:");
                info3.setText("1)Number of winning points");
                info4.setText("2)1 round duration");
                info5.setText("3)The section");
                language.setText("Choose the language");
                armenian.setText("Armenian");
                russian.setText("Russian");
                english.setText("English");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}