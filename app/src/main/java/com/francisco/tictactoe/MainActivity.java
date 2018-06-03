package com.francisco.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activeplay = 0; //0 yellow 1 red
    int [] gameStatus = {2,2,2,2,2,2,2,2,2};

    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {6,4,2}};

    public void dropin(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameStatus[tappedCounter] == 2) {
            gameStatus[tappedCounter] = activeplay;
            counter.setTranslationY(-1000f);
            if (activeplay == 0) {
                counter.setImageResource(R.drawable.yellow);
                counter.animate().translationYBy(1000f).setDuration(300);
                activeplay = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                counter.animate().translationYBy(1000f).setDuration(300);
                activeplay = 0;
            }

            for(int[] winningPosition : winningPositions){
                //Log.e("position", "position 0: "+winningPosition[0]+" position 1: "+winningPosition[1]+ " position 2: "+winningPosition[2]);
                //Log.e("position", "0: "+gameStatus[winningPosition[0]]+ " 1: "+gameStatus[winningPosition[1]]+ " 2: "+gameStatus[winningPosition[2]]);
                Log.e("position", "position 0: "+winningPosition[0]);
                if (gameStatus[winningPosition[0]] == gameStatus[winningPosition[1]] &&
                        gameStatus[winningPosition[1]] == gameStatus[winningPosition[2]] &&
                        gameStatus[winningPosition[0]] !=2){

                    System.out.println(gameStatus[winningPosition[0]]);

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
