package com.example.thehighorlowgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score=180;
   int randomno;

    public void randomGenerator(){
        // create instance of Random class
        Random rand = new Random();

        //Generate random integers in range 0 to 999
        randomno = rand.nextInt(21);

    }

    public void guess(View view){

    EditText guess1=(EditText) findViewById(R.id.editText);
    TextView score2=(TextView) findViewById(R.id.textView2);
    String ed_text=guess1.getText().toString();
    if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null){

        Toast.makeText(this, "Please enter a number ", Toast.LENGTH_SHORT).show();
        Log.i("Random Number",Integer.toString(randomno));

    }
    else{


        Log.i("Info","Button pressed");
        Log.i("Number entered",guess1.getText().toString());
        int guess3=Integer.parseInt(guess1.getText().toString());
        Log.i("Random Number",Integer.toString(randomno));

        if(guess3>randomno){
            Toast.makeText(this, "High!", Toast.LENGTH_SHORT).show();
            score-=20;
            score2.setText(Integer.toString(score));

        }
        else if(guess3<randomno){
            Toast.makeText(this, "Low", Toast.LENGTH_SHORT).show();
            score-=20;
            score2.setText(Integer.toString(score));
        }
        else{
            Toast.makeText(this, "You Got it!", Toast.LENGTH_SHORT).show();
            score+=20;
            score2.setText(Integer.toString(score));
            randomGenerator();
        }

        if(score<=0){

            Toast.makeText(this, "Game Over, please try again", Toast.LENGTH_SHORT).show();
            score=180;
            score2.setText(Integer.toString(score));

            randomGenerator();
        }
    }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomGenerator();
    }
}
