package edu.android.petrov.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class GameOverActivity extends ActionBarActivity {

    int userPoints;

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

        userPoints = points;
    }

    public void saveScore(View v) {

        SharedPreferences preferences = getSharedPreferences(GameActivity.HANGMAN_SCORES,
                Context.MODE_PRIVATE);

        EditText editText = (EditText) findViewById(R.id.editTextName);
        String name = editText.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();

        String previousScores = preferences.getString(ScoresActivity.SCORES, "");

        editor.putString(ScoresActivity.SCORES, name + " " + userPoints + "\n\n" + previousScores);

        editor.commit();

        finish();
    }

}
