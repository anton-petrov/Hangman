package edu.android.petrov.hangman;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class GameActivity extends ActionBarActivity {

    private static final String TAG_GAME = "GAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


    }

    /**
     * Retrieving the letter from the user
     * @param v (button clicked)
     */
    public void introLetter(View v) {

        EditText edit = (EditText) findViewById(R.id.editTextLetter);
        String letter = edit.getText().toString();
        Log.d(TAG_GAME, "The letter is " + letter);

    }

//    @Override
//    protected void onResume() {
//
//    }
//
//    @Override
//    protected void onPause() {
//
//    }

}
