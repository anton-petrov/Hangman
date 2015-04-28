package edu.android.petrov.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNewGame(View v) {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
    }

    public void startNewMultiplayerGame(View v) {
        Intent gameIntent = new Intent(this, MultiplayerActivity.class);
        startActivity(gameIntent);
    }

    public void openScores(View v) {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
    }

    public void exitGame(View view) {
        finish();
    }
}
