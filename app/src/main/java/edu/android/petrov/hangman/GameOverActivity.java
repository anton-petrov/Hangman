package edu.android.petrov.hangman;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class GameOverActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra(GameActivity.POINTS_ID, 0);
        TextView textViewPoints = (TextView) findViewById(R.id.textViewPoints);
        TextView textViewPts = (TextView) findViewById(R.id.textViewPts);
        textViewPoints.setText(String.valueOf(points));
        if (points == 1)
            textViewPts.setText(getResources().getString(R.string.point));
        else
            textViewPts.setText(getResources().getString(R.string.points));


    }

    public void saveScores(View v) {
        //TODO save scores to db
        //start new game

        finish();
    }

}
