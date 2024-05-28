package com.example.wordquiz;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private TextView word1, word2, word3, word4, word5, word6, word7, word8, word9, word10;
    private TextView timer, team1, team2, points_value, points;
    LinearLayout linearlayout;
    private CountDownTimer countDownTimer;
    int initialTimeSeconds = 5;
    private SharedPreferences sharedPreferences;
    private int count;
    private int clickcount = 0;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<String> words_cwa = new ArrayList<>();
    ArrayList<String> words_cwr = new ArrayList<>();
    ArrayList<String> words_cwe = new ArrayList<>();
    ArrayList<String> famouse_peples_arm = new ArrayList<>();
    ArrayList<String> famouse_peples_rus = new ArrayList<>();
    ArrayList<String> famouse_peples_eng = new ArrayList<>();
    ArrayList<String> city_countries_arm = new ArrayList<>();
    ArrayList<String> city_countries_rus = new ArrayList<>();
    ArrayList<String> city_countries_eng = new ArrayList<>();
    ArrayList<String> pantomime_arm = new ArrayList<>();
    ArrayList<String> pantomime_rus = new ArrayList<>();
    ArrayList<String> pantomime_eng = new ArrayList<>();
    ArrayList<String> films_arm = new ArrayList<>();
    ArrayList<String> films_rus = new ArrayList<>();
    ArrayList<String> films_eng = new ArrayList<>();
    ArrayList<String> all_arm = new ArrayList<>();
    ArrayList<String> all_rus = new ArrayList<>();
    ArrayList<String> all_eng = new ArrayList<>();
    Map<String, Object> data;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        TextView word1 = findViewById(R.id.word1);
        TextView word2 = findViewById(R.id.word2);
        TextView word3 = findViewById(R.id.word3);
        TextView word4 = findViewById(R.id.word4);
        TextView word5 = findViewById(R.id.word5);
        TextView word6 = findViewById(R.id.word6);
        TextView word7 = findViewById(R.id.word7);
        TextView word8 = findViewById(R.id.word8);
        TextView word9 = findViewById(R.id.word9);
        TextView word10 = findViewById(R.id.word10);
        TextView team1 = findViewById(R.id.team1);
        TextView team2 = findViewById(R.id.team2);
        TextView points_value = findViewById(R.id.points_value);
        timer = findViewById(R.id.timer);
        TextView points = findViewById(R.id.points);
        LinearLayout linearlayout = findViewById(R.id.linearlayout);
        ConstraintLayout main2 = findViewById(R.id.main2);


        /*Sections*/
        if ( MainActivity5.is_common_words_selected ) {
            if ( MainActivity5.Armenian ) {
                db.collection("Common Words-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        words_cwa.add((String) data.get("cwa"));
                                    }
                                    word1.setText(getRandomArray(words_cwa));
                                    word2.setText(getRandomArray(words_cwa));
                                    word3.setText(getRandomArray(words_cwa));
                                    word4.setText(getRandomArray(words_cwa));
                                    word5.setText(getRandomArray(words_cwa));
                                    word6.setText(getRandomArray(words_cwa));
                                    word7.setText(getRandomArray(words_cwa));
                                    word8.setText(getRandomArray(words_cwa));
                                    word9.setText(getRandomArray(words_cwa));
                                    word10.setText(getRandomArray(words_cwa));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.Russian ) {
                db.collection("Common Words-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        words_cwr.add((String) data.get("cwr"));
                                    }
                                    word1.setText(getRandomArray(words_cwr));
                                    word2.setText(getRandomArray(words_cwr));
                                    word3.setText(getRandomArray(words_cwr));
                                    word4.setText(getRandomArray(words_cwr));
                                    word5.setText(getRandomArray(words_cwr));
                                    word6.setText(getRandomArray(words_cwr));
                                    word7.setText(getRandomArray(words_cwr));
                                    word8.setText(getRandomArray(words_cwr));
                                    word9.setText(getRandomArray(words_cwr));
                                    word10.setText(getRandomArray(words_cwr));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.English ) {
                db.collection("Common Words-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        words_cwe.add((String) data.get("cwe"));
                                    }
                                    word1.setText(getRandomArray(words_cwe));
                                    word2.setText(getRandomArray(words_cwe));
                                    word3.setText(getRandomArray(words_cwe));
                                    word4.setText(getRandomArray(words_cwe));
                                    word5.setText(getRandomArray(words_cwe));
                                    word6.setText(getRandomArray(words_cwe));
                                    word7.setText(getRandomArray(words_cwe));
                                    word8.setText(getRandomArray(words_cwe));
                                    word9.setText(getRandomArray(words_cwe));
                                    word10.setText(getRandomArray(words_cwe));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        } else if ( MainActivity5.is_famous_peoples_selected ) {
            if ( MainActivity5.Armenian ) {
                db.collection("Famous Peoples-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        famouse_peples_arm.add((String) data.get("fpa"));
                                    }
                                    word1.setText(getRandomArray(famouse_peples_arm));
                                    word2.setText(getRandomArray(famouse_peples_arm));
                                    word3.setText(getRandomArray(famouse_peples_arm));
                                    word4.setText(getRandomArray(famouse_peples_arm));
                                    word5.setText(getRandomArray(famouse_peples_arm));
                                    word6.setText(getRandomArray(famouse_peples_arm));
                                    word7.setText(getRandomArray(famouse_peples_arm));
                                    word8.setText(getRandomArray(famouse_peples_arm));
                                    word9.setText(getRandomArray(famouse_peples_arm));
                                    word10.setText(getRandomArray(famouse_peples_arm));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.Russian ) {
                db.collection("Famous Peoples-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        famouse_peples_rus.add((String) data.get("fpr"));
                                    }
                                    word1.setText(getRandomArray(famouse_peples_rus));
                                    word2.setText(getRandomArray(famouse_peples_rus));
                                    word3.setText(getRandomArray(famouse_peples_rus));
                                    word4.setText(getRandomArray(famouse_peples_rus));
                                    word5.setText(getRandomArray(famouse_peples_rus));
                                    word6.setText(getRandomArray(famouse_peples_rus));
                                    word7.setText(getRandomArray(famouse_peples_rus));
                                    word8.setText(getRandomArray(famouse_peples_rus));
                                    word9.setText(getRandomArray(famouse_peples_rus));
                                    word10.setText(getRandomArray(famouse_peples_rus));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.English ) {
                db.collection("Famous Peoples-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        famouse_peples_eng.add((String) data.get("fpe"));
                                    }
                                    word1.setText(getRandomArray(famouse_peples_eng));
                                    word2.setText(getRandomArray(famouse_peples_eng));
                                    word3.setText(getRandomArray(famouse_peples_eng));
                                    word4.setText(getRandomArray(famouse_peples_eng));
                                    word5.setText(getRandomArray(famouse_peples_eng));
                                    word6.setText(getRandomArray(famouse_peples_eng));
                                    word7.setText(getRandomArray(famouse_peples_eng));
                                    word8.setText(getRandomArray(famouse_peples_eng));
                                    word9.setText(getRandomArray(famouse_peples_eng));
                                    word10.setText(getRandomArray(famouse_peples_eng));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        } else if ( MainActivity5.is_city_countries_selected ) {
            if ( MainActivity5.Armenian ) {
                db.collection("City Countries-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        city_countries_arm.add((String) data.get("cca"));
                                    }
                                    word1.setText(getRandomArray(city_countries_arm));
                                    word2.setText(getRandomArray(city_countries_arm));
                                    word3.setText(getRandomArray(city_countries_arm));
                                    word4.setText(getRandomArray(city_countries_arm));
                                    word5.setText(getRandomArray(city_countries_arm));
                                    word6.setText(getRandomArray(city_countries_arm));
                                    word7.setText(getRandomArray(city_countries_arm));
                                    word8.setText(getRandomArray(city_countries_arm));
                                    word9.setText(getRandomArray(city_countries_arm));
                                    word10.setText(getRandomArray(city_countries_arm));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.Russian ) {
                db.collection("City Countries-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        city_countries_rus.add((String) data.get("ccr"));
                                    }
                                    word1.setText(getRandomArray(city_countries_rus));
                                    word2.setText(getRandomArray(city_countries_rus));
                                    word3.setText(getRandomArray(city_countries_rus));
                                    word4.setText(getRandomArray(city_countries_rus));
                                    word5.setText(getRandomArray(city_countries_rus));
                                    word6.setText(getRandomArray(city_countries_rus));
                                    word7.setText(getRandomArray(city_countries_rus));
                                    word8.setText(getRandomArray(city_countries_rus));
                                    word9.setText(getRandomArray(city_countries_rus));
                                    word10.setText(getRandomArray(city_countries_rus));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.English ) {
                db.collection("City Countries-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        city_countries_eng.add((String) data.get("cce"));
                                    }
                                    word1.setText(getRandomArray(city_countries_eng));
                                    word2.setText(getRandomArray(city_countries_eng));
                                    word3.setText(getRandomArray(city_countries_eng));
                                    word4.setText(getRandomArray(city_countries_eng));
                                    word5.setText(getRandomArray(city_countries_eng));
                                    word6.setText(getRandomArray(city_countries_eng));
                                    word7.setText(getRandomArray(city_countries_eng));
                                    word8.setText(getRandomArray(city_countries_eng));
                                    word9.setText(getRandomArray(city_countries_eng));
                                    word10.setText(getRandomArray(city_countries_eng));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        } else if ( MainActivity5.is_pantomime_selected ) {
            if ( MainActivity5.Armenian ) {
                db.collection("Pantomime-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        pantomime_arm.add((String) data.get("pa"));
                                    }
                                    word1.setText(getRandomArray(pantomime_arm));
                                    word2.setText(getRandomArray(pantomime_arm));
                                    word3.setText(getRandomArray(pantomime_arm));
                                    word4.setText(getRandomArray(pantomime_arm));
                                    word5.setText(getRandomArray(pantomime_arm));
                                    word6.setText(getRandomArray(pantomime_arm));
                                    word7.setText(getRandomArray(pantomime_arm));
                                    word8.setText(getRandomArray(pantomime_arm));
                                    word9.setText(getRandomArray(pantomime_arm));
                                    word10.setText(getRandomArray(pantomime_arm));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.Russian ) {
                db.collection("Pantomime-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        pantomime_rus.add((String) data.get("pr"));
                                    }
                                    word1.setText(getRandomArray(pantomime_rus));
                                    word2.setText(getRandomArray(pantomime_rus));
                                    word3.setText(getRandomArray(pantomime_rus));
                                    word4.setText(getRandomArray(pantomime_rus));
                                    word5.setText(getRandomArray(pantomime_rus));
                                    word6.setText(getRandomArray(pantomime_rus));
                                    word7.setText(getRandomArray(pantomime_rus));
                                    word8.setText(getRandomArray(pantomime_rus));
                                    word9.setText(getRandomArray(pantomime_rus));
                                    word10.setText(getRandomArray(pantomime_rus));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.English ) {
                db.collection("Pantomime-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        pantomime_eng.add((String) data.get("pe"));
                                    }
                                    word1.setText(getRandomArray(pantomime_eng));
                                    word2.setText(getRandomArray(pantomime_eng));
                                    word3.setText(getRandomArray(pantomime_eng));
                                    word4.setText(getRandomArray(pantomime_eng));
                                    word5.setText(getRandomArray(pantomime_eng));
                                    word6.setText(getRandomArray(pantomime_eng));
                                    word7.setText(getRandomArray(pantomime_eng));
                                    word8.setText(getRandomArray(pantomime_eng));
                                    word9.setText(getRandomArray(pantomime_eng));
                                    word10.setText(getRandomArray(pantomime_eng));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        } else if ( MainActivity5.is_films_selected ) {
            if ( MainActivity5.Armenian ) {
                db.collection("Films-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        films_arm.add((String) data.get("fa"));
                                    }
                                    word1.setText(getRandomArray(films_arm));
                                    word2.setText(getRandomArray(films_arm));
                                    word3.setText(getRandomArray(films_arm));
                                    word4.setText(getRandomArray(films_arm));
                                    word5.setText(getRandomArray(films_arm));
                                    word6.setText(getRandomArray(films_arm));
                                    word7.setText(getRandomArray(films_arm));
                                    word8.setText(getRandomArray(films_arm));
                                    word9.setText(getRandomArray(films_arm));
                                    word10.setText(getRandomArray(films_arm));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.Russian ) {
                db.collection("Films-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        films_rus.add((String) data.get("fr"));
                                    }
                                    word1.setText(getRandomArray(films_rus));
                                    word2.setText(getRandomArray(films_rus));
                                    word3.setText(getRandomArray(films_rus));
                                    word4.setText(getRandomArray(films_rus));
                                    word5.setText(getRandomArray(films_rus));
                                    word6.setText(getRandomArray(films_rus));
                                    word7.setText(getRandomArray(films_rus));
                                    word8.setText(getRandomArray(films_rus));
                                    word9.setText(getRandomArray(films_rus));
                                    word10.setText(getRandomArray(films_rus));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.English ) {
                db.collection("Films-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        films_eng.add((String) data.get("fe"));
                                    }
                                    word1.setText(getRandomArray(films_eng));
                                    word2.setText(getRandomArray(films_eng));
                                    word3.setText(getRandomArray(films_eng));
                                    word4.setText(getRandomArray(films_eng));
                                    word5.setText(getRandomArray(films_eng));
                                    word6.setText(getRandomArray(films_eng));
                                    word7.setText(getRandomArray(films_eng));
                                    word8.setText(getRandomArray(films_eng));
                                    word9.setText(getRandomArray(films_eng));
                                    word10.setText(getRandomArray(films_eng));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        } else if ( MainActivity5.is_all_selected ) {
            if ( MainActivity5.Armenian ) {
                db.collection("All-arm").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        all_arm.add((String) data.get("aa"));
                                    }
                                    word1.setText(getRandomArray(all_arm));
                                    word2.setText(getRandomArray(all_arm));
                                    word3.setText(getRandomArray(all_arm));
                                    word4.setText(getRandomArray(all_arm));
                                    word5.setText(getRandomArray(all_arm));
                                    word6.setText(getRandomArray(all_arm));
                                    word7.setText(getRandomArray(all_arm));
                                    word8.setText(getRandomArray(all_arm));
                                    word9.setText(getRandomArray(all_arm));
                                    word10.setText(getRandomArray(all_arm));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.Russian ) {
                db.collection("All-rus").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        all_rus.add((String) data.get("ar"));
                                    }
                                    word1.setText(getRandomArray(all_rus));
                                    word2.setText(getRandomArray(all_rus));
                                    word3.setText(getRandomArray(all_rus));
                                    word4.setText(getRandomArray(all_rus));
                                    word5.setText(getRandomArray(all_rus));
                                    word6.setText(getRandomArray(all_rus));
                                    word7.setText(getRandomArray(all_rus));
                                    word8.setText(getRandomArray(all_rus));
                                    word9.setText(getRandomArray(all_rus));
                                    word10.setText(getRandomArray(all_rus));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else if ( MainActivity5.English ) {
                db.collection("All-eng").get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG,  "" + document.getData());
                                        data = document.getData();
                                        all_eng.add((String) data.get("ae"));
                                    }
                                    word1.setText(getRandomArray(all_eng));
                                    word2.setText(getRandomArray(all_eng));
                                    word3.setText(getRandomArray(all_eng));
                                    word4.setText(getRandomArray(all_eng));
                                    word5.setText(getRandomArray(all_eng));
                                    word6.setText(getRandomArray(all_eng));
                                    word7.setText(getRandomArray(all_eng));
                                    word8.setText(getRandomArray(all_eng));
                                    word9.setText(getRandomArray(all_eng));
                                    word10.setText(getRandomArray(all_eng));
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                    Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }
        /*Sections*/



        /*Colors*/
        int black = ContextCompat.getColor(this, R.color.black);
        int white = ContextCompat.getColor(this, R.color.white);
        int pure_gold = ContextCompat.getColor(this, R.color.pure_gold);
        int dark_emerald_green = ContextCompat.getColor(this, R.color.dark_emerald_green);
        int dark_emerald_green_dark = ContextCompat.getColor(this, R.color.dark_emerald_green_dark);
        /*Colors*/

        /*Words*/
        word1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word1.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word1.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word1.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word1.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word1.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word2.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word2.getBackground()).getColor();
                    if (color1 == dark_emerald_green) {
                        word2.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if (MainActivity5.is_common_words_selected) {
                            pageChanging1();
                        } else if (MainActivity5.is_famous_peoples_selected) {
                            pageChanging2();
                        } else if (MainActivity5.is_city_countries_selected) {
                            pageChanging3();
                        } else if (MainActivity5.is_pantomime_selected) {
                            pageChanging4();
                        } else if (MainActivity5.is_films_selected) {
                            pageChanging5();
                        } else if (MainActivity5.is_all_selected) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word2.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word2.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if (MainActivity5.is_common_words_selected) {
                        pageChanging1();
                    } else if (MainActivity5.is_famous_peoples_selected) {
                        pageChanging2();
                    } else if (MainActivity5.is_city_countries_selected) {
                        pageChanging3();
                    } else if (MainActivity5.is_pantomime_selected) {
                        pageChanging4();
                    } else if (MainActivity5.is_films_selected) {
                        pageChanging5();
                    } else if (MainActivity5.is_all_selected) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng));
                word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng));
                word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng));
                word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng));
                word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng));
                word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng));
                word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng));
                word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng));
                word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng));
                word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng));
                word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng));
                word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if (MainActivity5.Armenian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if (MainActivity5.Russian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if (MainActivity5.English) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if (MainActivity5.Armenian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if (MainActivity5.Russian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if (MainActivity5.English) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if (MainActivity5.Armenian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if (MainActivity5.Russian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if (MainActivity5.English) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if (MainActivity5.Armenian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if (MainActivity5.Russian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if (MainActivity5.English) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if (MainActivity5.Armenian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if (MainActivity5.Russian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Films_Russian();
                    }
                } else if (MainActivity5.English) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if (MainActivity5.Armenian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        All_Armenian();
                    }
                } else if (MainActivity5.Russian) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        All_Russian();
                    }
                } else if (MainActivity5.English) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30 || clickcount == 40) {
                        All_English();
                    }
                }
            }
        });

        word3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word3.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word3.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word3.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word3.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word3.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word4.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word4.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word4.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word4.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word4.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word5.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word5.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word5.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word5.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word5.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word6.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word6.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word6.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word6.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word6.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word7.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word7.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word7.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word7.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word7.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word8.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word8.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word8.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word8.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word8.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word9.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word9.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word9.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word9.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word9.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });

        word10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (word10.getBackground() instanceof ColorDrawable) {
                    int color1 = ((ColorDrawable) word10.getBackground()).getColor();
                    if ( color1 == dark_emerald_green ) {
                        word10.setBackgroundColor(dark_emerald_green_dark);
                        clickcount++;
                        points_value.setText(String.valueOf(clickcount));
                        if ( MainActivity5.is_common_words_selected ) {
                            pageChanging1();
                        } else if ( MainActivity5.is_famous_peoples_selected ) {
                            pageChanging2();
                        } else if ( MainActivity5.is_city_countries_selected ) {
                            pageChanging3();
                        } else if ( MainActivity5.is_pantomime_selected ) {
                            pageChanging4();
                        } else if ( MainActivity5.is_films_selected ) {
                            pageChanging5();
                        } else if ( MainActivity5.is_all_selected ) {
                            pageChanging6();
                        }
                    } else if (color1 == dark_emerald_green_dark) {
                        word10.setBackgroundColor(dark_emerald_green);
                        clickcount--;
                        points_value.setText(String.valueOf(clickcount));
                    }
                } else {
                    word10.setBackgroundColor(dark_emerald_green_dark);
                    clickcount++;
                    points_value.setText(String.valueOf(clickcount));
                    if ( MainActivity5.is_common_words_selected ) {
                        pageChanging1();
                    } else if ( MainActivity5.is_famous_peoples_selected ) {
                        pageChanging2();
                    } else if ( MainActivity5.is_city_countries_selected ) {
                        pageChanging3();
                    } else if ( MainActivity5.is_pantomime_selected ) {
                        pageChanging4();
                    } else if ( MainActivity5.is_films_selected ) {
                        pageChanging5();
                    } else if ( MainActivity5.is_all_selected ) {
                        pageChanging6();
                    }
                }
            }

            private void Common_Words_Armenian() {
                word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_Russian() {
                word1.setText(getRandomArray(words_cwr)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwr)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwr)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwr)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwr)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwr)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwr)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwr)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwr)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwr)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Common_Words_English() {
                word1.setText(getRandomArray(words_cwe)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(words_cwe)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(words_cwe)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(words_cwe)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(words_cwe)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(words_cwe)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(words_cwe)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(words_cwe)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(words_cwe)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(words_cwe)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Armenian() {
                word1.setText(getRandomArray(famouse_peples_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_Russian() {
                word1.setText(getRandomArray(famouse_peples_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Famouse_Peoples_English() {
                word1.setText(getRandomArray(famouse_peples_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(famouse_peples_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(famouse_peples_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(famouse_peples_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(famouse_peples_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(famouse_peples_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(famouse_peples_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(famouse_peples_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(famouse_peples_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(famouse_peples_eng)); word10.setBackgroundColor(dark_emerald_green);
            }


            private void City_Countries_Armenian() {
                word1.setText(getRandomArray(city_countries_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_Russian() {
                word1.setText(getRandomArray(city_countries_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void City_Countries_English() {
                word1.setText(getRandomArray(city_countries_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(city_countries_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(city_countries_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(city_countries_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(city_countries_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(city_countries_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(city_countries_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(city_countries_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(city_countries_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(city_countries_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Armenian() {
                word1.setText(getRandomArray(pantomime_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_Russian() {
                word1.setText(getRandomArray(pantomime_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Pantomime_English() {
                word1.setText(getRandomArray(pantomime_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(pantomime_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(pantomime_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(pantomime_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(pantomime_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(pantomime_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(pantomime_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(pantomime_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(pantomime_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(pantomime_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Armenain() {
                word1.setText(getRandomArray(films_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_Russian() {
                word1.setText(getRandomArray(films_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void Films_English() {
                word1.setText(getRandomArray(films_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(films_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(films_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(films_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(films_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(films_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(films_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(films_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(films_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(films_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Armenian() {
                word1.setText(getRandomArray(all_arm)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_arm)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_arm)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_arm)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_arm)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_arm)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_arm)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_arm)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_arm)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_arm)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_Russian() {
                word1.setText(getRandomArray(all_rus)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_rus)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_rus)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_rus)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_rus)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_rus)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_rus)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_rus)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_rus)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_rus)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void All_English() {
                word1.setText(getRandomArray(all_eng)); word1.setBackgroundColor(dark_emerald_green);
                word2.setText(getRandomArray(all_eng)); word2.setBackgroundColor(dark_emerald_green);
                word3.setText(getRandomArray(all_eng)); word3.setBackgroundColor(dark_emerald_green);
                word4.setText(getRandomArray(all_eng)); word4.setBackgroundColor(dark_emerald_green);
                word5.setText(getRandomArray(all_eng)); word5.setBackgroundColor(dark_emerald_green);
                word6.setText(getRandomArray(all_eng)); word6.setBackgroundColor(dark_emerald_green);
                word7.setText(getRandomArray(all_eng)); word7.setBackgroundColor(dark_emerald_green);
                word8.setText(getRandomArray(all_eng)); word8.setBackgroundColor(dark_emerald_green);
                word9.setText(getRandomArray(all_eng)); word9.setBackgroundColor(dark_emerald_green);
                word10.setText(getRandomArray(all_eng)); word10.setBackgroundColor(dark_emerald_green);
            }

            private void pageChanging1() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Common_Words_English();
                    }
                }
            }

            private void pageChanging2() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Famouse_Peoples_English();
                    }
                }
            }

            private void pageChanging3() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        City_Countries_English();
                    }
                }
            }

            private void pageChanging4() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Pantomime_English();
                    }
                }
            }

            private void pageChanging5() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Armenain();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        Films_English();
                    }
                }
            }

            private void pageChanging6() {
                if ( MainActivity5.Armenian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Armenian();
                    }
                } else if ( MainActivity5.Russian ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_Russian();
                    }
                } else if ( MainActivity5.English ) {
                    if (clickcount == 10 || clickcount == 20 || clickcount == 30  || clickcount == 40) {
                        All_English();
                    }
                }
            }

        });
        /*Words*/

        String team_1 = getIntent().getStringExtra("keyteam1");
        String team_2 = getIntent().getStringExtra("keyteam2");

        /*Timer*/
        if ( MainActivity5.isTime45Selected ) {
            initialTimeSeconds = 46;
        } else if (  MainActivity5.isTime60Selected ) {
            initialTimeSeconds = 61;
        } else if ( MainActivity5.isTime75Selected ) {
            initialTimeSeconds = 76;
        } else if ( MainActivity5.isTime90Selected ) {
            initialTimeSeconds = 91;
        }
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        count = sharedPreferences.getInt("count", 0);
        countDownTimer = new CountDownTimer(initialTimeSeconds * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) (millisUntilFinished / 1000));
            }
            @Override
            public void onFinish() {
                String point = points_value.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("team1_point", point);
                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();
        /*Timer*/

        /*Language*/
        if ( MainActivity5.Armenian ) {
            if (MainActivity4.team()) {
                team1.setText(team_1);
                team2.setText("");
            } else {
                team1.setText("");
                team2.setText(team_2);
            }
            MainActivity4.toggleText();
            points.setText("միավորներ:");
        } else if ( MainActivity5.English ) {
            if (MainActivity4.team()) {
                team1.setText(team_1);
                team2.setText("");
            } else {
                team1.setText("");
                team2.setText(team_2);
            }
            MainActivity4.toggleText();
            points.setText("points:");
        } else if ( MainActivity5.Russian ) {
            if (MainActivity4.team()) {
                team1.setText(team_1);
                team2.setText("");
            } else {
                team1.setText("");
                team2.setText(team_2);
            }
            MainActivity4.toggleText();
            points.setText("очки:");
        }
        /*Language*/
    }

    /*Timer function*/
    private void updateTimer(int seconds) {
        timer.setText(String.valueOf(seconds));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    /*Timer function*/

    /*Random word's get function*/
    private String getRandomArray(ArrayList<String> arrayList) {
        int size = arrayList.size();
        Random random = new Random();
        Log.d("error", arrayList.get(random.nextInt(size)));
        return arrayList.get(random.nextInt(size));
    }
    /*Random word's get function*/

    /*Random word set*/
    private void RandomWordSet() {
        word1.setText(getRandomArray(words_cwa)); word1.setBackgroundColor(Color.WHITE);
        word2.setText(getRandomArray(words_cwa)); word2.setBackgroundColor(Color.WHITE);
        word3.setText(getRandomArray(words_cwa)); word3.setBackgroundColor(Color.WHITE);
        word4.setText(getRandomArray(words_cwa)); word4.setBackgroundColor(Color.WHITE);
        word5.setText(getRandomArray(words_cwa)); word5.setBackgroundColor(Color.WHITE);
        word6.setText(getRandomArray(words_cwa)); word6.setBackgroundColor(Color.WHITE);
        word7.setText(getRandomArray(words_cwa)); word7.setBackgroundColor(Color.WHITE);
        word8.setText(getRandomArray(words_cwa)); word8.setBackgroundColor(Color.WHITE);
        word9.setText(getRandomArray(words_cwa)); word9.setBackgroundColor(Color.WHITE);
        word10.setText(getRandomArray(words_cwa)); word10.setBackgroundColor(Color.WHITE);
    }
    /*Random word set*/
}

