package edu.android.petrov.hangman;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ScoresActivity extends ActionBarActivity {

    public static final String SCORES = "SCORES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        SharedPreferences preferences = getSharedPreferences(GameActivity.HANGMAN_SCORES, MODE_PRIVATE);
        String scores = preferences.getString(SCORES, "---");
        TextView textViewScores = (TextView) findViewById(R.id.textViewScores);
        textViewScores.setText(scores);
    }

}
