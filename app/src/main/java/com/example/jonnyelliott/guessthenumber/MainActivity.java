package com.example.jonnyelliott.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int max, min, guess, pressed=0;
    private Button upButton, downButton;
    private TextView guessTextView;
    private boolean gameStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGame();
    }

    private void guessTheNumber(){
        guess =(max+min)/2;
        guessTextView.setText("Higher or Lower:"+String.valueOf(guess));
        System.out.println(guess);
    }

    public void up(View view){
        gameStarted=true;
        min = guess;
        guessTheNumber();
    }

    public void down(View view){
        gameStarted=true;
        max = guess;
        guessTheNumber();
    }

    public void reset(View view){
        if(gameStarted) {
            pressed++;
            switch (pressed) {
                case 1:
                    setButtonsEnabled(false);
                    break;
                case 2:
                    setButtonsEnabled(true);
                    startGame();
                    gameStarted=false;
                    pressed = 0;
                    break;
            }
        }
    }

    public void setButtonsEnabled(boolean bool){
        upButton.setEnabled(bool);
        downButton.setEnabled(bool);
    }

    public void startGame(){
        guess=500;
        max=1000+1;
        min =1;
        upButton = (Button) findViewById(R.id.upButton);
        downButton = (Button)findViewById(R.id.downButton);
        guessTextView = (TextView) findViewById(R.id.guessTextView);
        guessTextView.setText(
                "Welcome to Guess the Number\n" +
                        "Pick a Number in your head and don't tell me!\n" +
                        "Up arrow for higher, down for lower, Press Text for equal\n" +
                        "Max ="+String.valueOf(max-1)+"\n"+
                        "Min ="+String.valueOf(min-1)+"\n"+
                        "Guess ="+String.valueOf(guess)+"\n");
    }


}
