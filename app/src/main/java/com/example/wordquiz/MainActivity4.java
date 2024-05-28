package com.example.wordquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wordquiz.Pattern.Global_data;
import com.example.wordquiz.models.ConfigSingltonre;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    TextView best_score, score, team1, team2, team1_score, team2_score, textView;
    Button play;
    ImageView crown;
    ImageButton back;
    RecyclerView RecView1,RecView2;
    private static boolean team = true;
    int count = 0;
    boolean team1_win = false;
    boolean team2_win = false;
    private int win_score_4 = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);

        count++;

        Button play = findViewById(R.id.play);
        TextView best_score = findViewById(R.id.best_score);
        TextView score = findViewById(R.id.score);
        TextView team1 = findViewById(R.id.team1);
        TextView team2 = findViewById(R.id.team2);
        RecyclerView RecView1 = findViewById(R.id.RecView1);
        RecyclerView RecView2 = findViewById(R.id.RecView2);
        TextView team1_score = findViewById(R.id.team1_score);
        TextView team2_score = findViewById(R.id.team2_score);
        ImageView crown = findViewById(R.id.crown);
        ConstraintLayout main4 = findViewById(R.id.main4);
        ImageButton back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
            }
        });


        int black = ContextCompat.getColor(this, R.color.black);
        int white = ContextCompat.getColor(this, R.color.white);
        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);

        /*Points*/
        String val1 = getIntent().getStringExtra("team1_point");
        Global_data.getInstance().getData().add(val1);
        List<Item> items1 = new ArrayList<>();
        List<Item> items2 = new ArrayList<>();
        List<String> Data =  Global_data.getInstance().getData();

        if (Data != null) {
            for (int i = 0; i < Data.size(); i++) {
                String item = Data.get(i);
                if (item != null) {
                    if (i % 2 == 1) {
                        items1.add(new Item(item, "name.surname@email.com", R.drawable.photo));
                    } else {
                        items2.add(new Item(item, "name.surname@email.com", R.drawable.photo));
                    }
                }
            }
        }

        int Sumof1 = 0;
        int Sumof2 = 0;
        for(Item item : items1)
        {
            Sumof1 += Integer.valueOf( item.point1);
        }
        for(Item item : items2)
        {
            Sumof2 += Integer.valueOf( item.point1);
        }
        team1_score.setText(String.valueOf(Sumof1));
        team2_score.setText(String.valueOf(Sumof2));

        RecView1.setLayoutManager(new LinearLayoutManager(this));
        RecView1.setAdapter(new MyAdapter(getApplicationContext(), items1));
        RecView2.setLayoutManager(new LinearLayoutManager(this));
        RecView2.setAdapter(new MyAdapter(getApplicationContext(), items2));

        String win_score = best_score.getText().toString();
        int win_score_int = Integer.parseInt(win_score);
        String score1 = team1_score.getText().toString();
        int score1_int = Integer.parseInt(score1);
        String score2 = team2_score.getText().toString();
        int score2_int = Integer.parseInt(score2);

        if ( MainActivity5.isScore25Selected ) {
            win_score_4 = 25;
        } else if ( MainActivity5.isScore50Selected ) {
            win_score_4 = 50;
        } else if ( MainActivity5.isScore75Selected ) {
            win_score_4 = 75;
        } else if ( MainActivity5.isScore100Selected ) {
            win_score_4 = 100;
        }

        int itemCount1 = RecView1.getAdapter().getItemCount();
        int itemCount2 = RecView2.getAdapter().getItemCount();

        if ( itemCount1 == itemCount2 ) {
            if ( "25".equals(best_score.getText().toString()) ) {
                if ( score1_int == 25 || score1_int > 25 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team1_win = true;
                    intent.putExtra("team1_win", team1_win);
                } else if ( score2_int == 25 || score2_int > 25 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team2_win = true;
                    intent.putExtra("team2_win", team2_win);
                }
            } else if ( "50".equals(best_score.getText().toString()) ) {
                if ( score1_int == 50 || score1_int > 50 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team1_win = true;
                    intent.putExtra("team1_win", team1_win);
                } else if ( score2_int == 50 || score2_int > 50 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team2_win = true;
                    intent.putExtra("team2_win", team2_win);
                }
            } else if ( "75".equals(best_score.getText().toString()) ) {
                if ( score1_int == 75 || score1_int > 75 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team1_win = true;
                    intent.putExtra("team1_win", team1_win);
                } else if ( score2_int == 75 || score2_int > 75 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team2_win = true;
                    intent.putExtra("team2_win", team2_win);
                }
            } else if ( "100".equals(best_score.getText().toString()) ) {
                if ( score1_int == 100 || score1_int > 100 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team1_win = true;
                    intent.putExtra("team1_win", team1_win);
                } else if ( score2_int == 100 || score2_int > 100 ) {
                    Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                    startActivity(intent);
                    team2_win = true;
                    intent.putExtra("team2_win", team2_win);
                }
            }
        } else {}


        if ( "25".equals(best_score.getText().toString()) ) {
            if ( score1_int == 25 || score1_int > 25 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team1_win = true;
                intent.putExtra("team1_win", team1_win);
            } else if ( score2_int == 25 || score2_int > 25 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team2_win = true;
                intent.putExtra("team2_win", team2_win);
            }
        } else if ( "50".equals(best_score.getText().toString()) ) {
            if ( score1_int == 50 || score1_int > 50 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team1_win = true;
                intent.putExtra("team1_win", team1_win);
            } else if ( score2_int == 50 || score2_int > 50 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team2_win = true;
                intent.putExtra("team2_win", team2_win);
            }
        } else if ( "75".equals(best_score.getText().toString()) ) {
            if ( score1_int == 75 || score1_int > 75 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team1_win = true;
                intent.putExtra("team1_win", team1_win);
            } else if ( score2_int == 75 || score2_int > 75 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team2_win = true;
                intent.putExtra("team2_win", team2_win);
            }
        } else if ( "100".equals(best_score.getText().toString()) ) {
            if ( score1_int == 100 || score1_int > 100 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team1_win = true;
                intent.putExtra("team1_win", team1_win);
            } else if ( score2_int == 100 || score2_int > 100 ) {
                Intent intent = new Intent(MainActivity4.this, MainActivity7.class);
                startActivity(intent);
                team2_win = true;
                intent.putExtra("team2_win", team2_win);
            }
        }
        /*Points*/

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team_1 = team1.getText().toString();
                String team_2 = team2.getText().toString();
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                intent.putExtra("keyteam1", team_1);
                intent.putExtra("keyteam2", team_2);
                startActivity(intent);
                finish();
            }
        });

        /*Score*/
        if ( MainActivity5.isScore25Selected ) {
            best_score.setText("25");
            best_score.setTranslationX(3);
        } else if ( MainActivity5.isScore50Selected ) {
            best_score.setText("50");
            best_score.setTranslationX(3);
        } else if ( MainActivity5.isScore75Selected ) {
            best_score.setText("75");
            best_score.setTranslationX(3);
        } else if ( MainActivity5.isScore100Selected ) {
            best_score.setText("100");
        }
        /*Score*/

        /*Language*/
        if ( MainActivity5.Armenian ) {
            score.setText("Միավորներ");
            score.setTextSize(40);
            score.setTranslationY(50);
            team1.setText(ConfigSingltonre.getInstance().getTeam1Txt2());
            team2.setText(ConfigSingltonre.getInstance().getTeam2Txt2());
            play.setText("Խաղալ");
            play.setTextSize(25);
        } else if ( MainActivity5.English ) {
            score.setText("Score");
            team1.setText(ConfigSingltonre.getInstance().getTeam1Txt1());
            team2.setText(ConfigSingltonre.getInstance().getTeam2Txt1());
            play.setText("Play");
        } else if ( MainActivity5.Russian ) {
            score.setText("Счет");
            score.setTextSize(40);
            score.setTranslationY(50);
            score.setTranslationX(50);
            team1.setText(ConfigSingltonre.getInstance().getTeam1Txt3());
            team2.setText(ConfigSingltonre.getInstance().getTeam2Txt3());
            play.setText("Играть");
        }
        /*Language*/

        /*Team name changing*/
        team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                builder.setTitle("Enter your team name");

                final EditText input = new EditText(MainActivity4.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ConfigSingltonre.getInstance().setTeam1Txt1(input.getText().toString());
                        ConfigSingltonre.getInstance().setTeam1Txt2(input.getText().toString());
                        ConfigSingltonre.getInstance().setTeam1Txt3(input.getText().toString());

                        String newText = input.getText().toString();
                        if (newText.length() <= 9) {
                            team1.setText(newText);
                        } else {
                            Toast.makeText(MainActivity4.this, "Text length must be max 9 letters", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                final AlertDialog dialog = builder.create();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

                dialog.show();
                input.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                builder.setTitle("Enter your team name");

                final EditText input = new EditText(MainActivity4.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ConfigSingltonre.getInstance().setTeam2Txt1(input.getText().toString());
                        ConfigSingltonre.getInstance().setTeam2Txt2(input.getText().toString());
                        ConfigSingltonre.getInstance().setTeam2Txt3(input.getText().toString());

                        String newText = input.getText().toString();
                        if (newText.length() <= 9) {
                            team2.setText(newText);
                        } else {
                            Toast.makeText(MainActivity4.this, "Text length must be max 9 letters", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                final AlertDialog dialog = builder.create();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

                dialog.show();
                input.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        /*Team name changing*/
    }
    public static boolean team() {
        return team;
    }

    public static void toggleText() {
        team = !team;
    }
}