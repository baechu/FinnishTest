package com.example.android.finnishtest;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Used for calculating the final score
    private int checkScore(boolean q1, boolean q2, boolean q31, boolean q32, boolean q33, boolean q34, boolean q4, boolean q5) {
        int userScore = 0;

        //Adds 1 point if the answer for the Q1 is correct
        if (q1) {
            userScore += 1;
        }

        //Adds 1 point if the answer for the Q2 is correct
        if (q2) {
            userScore += 1;
        }

        //Adds 1 point if the answers for the Q3 are correct
        if (q31 && q33 && !q32 && !q34) {
            userScore += 1;
        }

        //Adds 1 point if the answer for the Q4 is correct
        if (q4) {
            userScore += 1;
        }

        //Adds 1 point if the answer for the Q5 is correct
        if (q5) {
            userScore += 1;
        }

        return userScore;
    }

    //Used for handling the action of pressing the submit button. Calculates the score and returns a toast message with user's score
    public void userSubmit(View view){

        RadioButton secondLanguage = (RadioButton) findViewById(R.id.q1_swedish);
        boolean question1 = secondLanguage.isChecked();

        RadioButton northCity = (RadioButton) findViewById(R.id.q2_utsjoki);
        boolean question2 = northCity.isChecked();

        CheckBox white = (CheckBox) findViewById(R.id.q3_white);
        boolean question3a = white.isChecked();

        CheckBox red = (CheckBox) findViewById(R.id.q3_red);
        boolean question3b = red.isChecked();

        CheckBox blue = (CheckBox) findViewById(R.id.q3_blue);
        boolean question3c = blue.isChecked();

        CheckBox yellow = (CheckBox) findViewById(R.id.q3_yellow);
        boolean question3d = yellow.isChecked();

        RadioButton firstCapital = (RadioButton) findViewById(R.id.q4_turku);
        boolean question4 = firstCapital.isChecked();

        RadioButton relatedLanguage = (RadioButton) findViewById(R.id.q5_estonian);
        boolean question5 = relatedLanguage.isChecked();

        int yourScore = checkScore(question1, question2, question3a, question3b, question3c, question3d, question4, question5);

          Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.result) + yourScore + getResources().getString(R.string.points);
        int duration = Toast.LENGTH_LONG;
         Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        }
    }
