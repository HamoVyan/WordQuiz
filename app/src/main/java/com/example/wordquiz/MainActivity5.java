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
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView language, section, time, score;
    RadioButton sec1, sec2, sec3, sec4, sec5, sec6, armenian, russian, english;
    RadioButton time45, time60, time75, time90;
    RadioButton score25, score50, score75, score100;
    Button next;
    ImageButton back;
    public static boolean isTime45Selected = false;
    public static boolean isTime60Selected = false;
    public static boolean isTime75Selected = false;
    public static boolean isTime90Selected = false;
    public static boolean isScore25Selected = false;
    public static boolean isScore50Selected = false;
    public static boolean isScore75Selected = false;
    public static boolean isScore100Selected = false;
    public static boolean is_common_words_selected = false;
    public static boolean is_famous_peoples_selected = false;
    public static boolean is_city_countries_selected = false;
    public static boolean is_pantomime_selected = false;
    public static boolean is_films_selected = false;
    public static boolean is_all_selected = false;

    public static boolean Armenian = false;
    public static boolean Russian = false;
    public static boolean English = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main5);

        TextView section = findViewById(R.id.section);
        TextView language = findViewById(R.id.language);
        Button next = findViewById(R.id.next);
        RadioButton sec1 = findViewById(R.id.sec1);
        RadioButton sec2 = findViewById(R.id.sec2);
        RadioButton sec3 = findViewById(R.id.sec3);
        RadioButton sec4 = findViewById(R.id.sec4);
        RadioButton sec5 = findViewById(R.id.sec5);
        RadioButton sec6 = findViewById(R.id.sec6);
        TextView time = findViewById(R.id.time);
        RadioButton time45 = findViewById(R.id.time45);
        RadioButton time60 = findViewById(R.id.time60);
        RadioButton time75 = findViewById(R.id.time75);
        RadioButton time90 = findViewById(R.id.time90);
        TextView score = findViewById(R.id.score);
        RadioButton score25 = findViewById(R.id.score25);
        RadioButton score50 = findViewById(R.id.score50);
        RadioButton score75 = findViewById(R.id.score75);
        RadioButton score100 = findViewById(R.id.score100);
        ConstraintLayout main5 = findViewById(R.id.main5);
        RadioButton armenian = findViewById(R.id.armenian);
        RadioButton russian = findViewById(R.id.russian);
        RadioButton english = findViewById(R.id.english);
        ImageButton back = findViewById(R.id.back);

        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTime45Selected = time45.isChecked();
                isTime60Selected = time60.isChecked();
                isTime75Selected = time75.isChecked();
                isTime90Selected = time90.isChecked();

                isScore25Selected = score25.isChecked();
                isScore50Selected = score50.isChecked();
                isScore75Selected = score75.isChecked();
                isScore100Selected = score100.isChecked();

                is_common_words_selected = sec1.isChecked();
                is_famous_peoples_selected = sec2.isChecked();
                is_city_countries_selected = sec3.isChecked();
                is_pantomime_selected = sec4.isChecked();
                is_films_selected = sec5.isChecked();
                is_all_selected = sec6.isChecked();

                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
                finish();
            }
        });

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != sec1) {
                        sec1.setChecked(false);
                    }
                    if (buttonView != sec2) {
                        sec2.setChecked(false);
                    }
                    if (buttonView != sec3) {
                        sec3.setChecked(false);
                    }
                    if (buttonView != sec4) {
                        sec4.setChecked(false);
                    }
                    if (buttonView != sec4) {
                        sec4.setChecked(false);
                    }
                    if (buttonView != sec5) {
                        sec5.setChecked(false);
                    }
                    if (buttonView != sec6) {
                        sec6.setChecked(false);
                    }
                }
            }
        };

        sec1.setOnCheckedChangeListener(listener);
        sec2.setOnCheckedChangeListener(listener);
        sec3.setOnCheckedChangeListener(listener);
        sec4.setOnCheckedChangeListener(listener);
        sec5.setOnCheckedChangeListener(listener);
        sec6.setOnCheckedChangeListener(listener);

        CompoundButton.OnCheckedChangeListener listener3 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != time45) {
                        time45.setChecked(false);
                    }
                    if (buttonView != time60) {
                        time60.setChecked(false);
                    }
                    if (buttonView != time75) {
                        time75.setChecked(false);
                    }
                    if (buttonView != time90) {
                        time90.setChecked(false);
                    }
                }
            }
        };

        time45.setOnCheckedChangeListener(listener3);
        time60.setOnCheckedChangeListener(listener3);
        time75.setOnCheckedChangeListener(listener3);
        time90.setOnCheckedChangeListener(listener3);

        CompoundButton.OnCheckedChangeListener listener4 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (buttonView != score25) {
                        score25.setChecked(false);
                    }
                    if (buttonView != score50) {
                        score50.setChecked(false);
                    }
                    if (buttonView != score75) {
                        score75.setChecked(false);
                    }
                    if (buttonView != score100) {
                        score100.setChecked(false);
                    }
                }
            }
        };

        score25.setOnCheckedChangeListener(listener4);
        score50.setOnCheckedChangeListener(listener4);
        score75.setOnCheckedChangeListener(listener4);
        score100.setOnCheckedChangeListener(listener4);


        CompoundButton.OnCheckedChangeListener listener5 = new CompoundButton.OnCheckedChangeListener() {
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

        armenian.setOnCheckedChangeListener(listener5);
        russian.setOnCheckedChangeListener(listener5);
        english.setOnCheckedChangeListener(listener5);


        /*Default selected*/
        sec1.setChecked(true);
        time45.setChecked(true);
        score25.setChecked(true);
        english.setChecked(true);
        /*Default selected*/

        /*Language*/

        armenian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Armenian = armenian.isChecked();
                section.setText("Բաժին");
                sec1.setText("Ընդհանուր բառեր");
                sec2.setText("Հայտնի մարդիկ");
                sec3.setText("Երկիր-քաղաքներ");
                sec4.setText("Մնջախաղ");
                sec5.setText("Ֆիլմեր");
                sec6.setText("Բոլորը");
                time.setText("Ժամանակ");
                score.setText("Հաղթական միավոր");
                next.setText("Հաջորդը");
                next.setTextSize(23);
                language.setText("Լեզու");
                armenian.setText("Հայերեն");
                russian.setText("Ռուսերեն");
                english.setText("Անգլերեն");
            }
        });

        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Russian = russian.isChecked();
                section.setText("Раздел");
                sec1.setText("Слова");
                sec2.setText("Известные люди");
                sec3.setText("Города-страны");
                sec4.setText("Пантомима");
                sec5.setText("Фильмы");
                sec6.setText("Всё");
                time.setText("Продолжительность раунда");
                score.setText("Победный счет");
                next.setText("Следующий");
                next.setTextSize(18);
                language.setText("Язык");
                armenian.setText("Армянский");
                russian.setText("Русский");
                english.setText("Английский");
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                English = english.isChecked();
                section.setText("Section");
                sec1.setText("Common words");
                sec2.setText("Famous people");
                sec3.setText("City-countries");
                sec4.setText("Pantomime");
                sec5.setText("Films");
                sec6.setText("All");
                time.setText("Time");
                score.setText("Score");
                language.setText("Language");
                armenian.setText("Armenian");
                russian.setText("Russian");
                english.setText("English");
                next.setText("Next");
                next.setTextSize(30);
            }
        });
        /*Language*/
    }
}