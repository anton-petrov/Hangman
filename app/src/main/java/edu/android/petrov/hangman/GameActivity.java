package edu.android.petrov.hangman;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class GameActivity extends ActionBarActivity {

    String hiddenWord = "word";
    int failsCount = 0;
    int guessedLettersCount = 0;
    int userPoints = 0;

    final Random random = new Random();

    private static final String TAG_GAME = "GAME";
    public static final String POINTS_ID = "POINTS_ID";
    public static final String HANGMAN_SCORES = "HANGMAN_TOP_SCORES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        startGame();
    }

    /**
     * Start a new game
     */
    void startGame() {
        clearScreen();
        setRandomWord();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startGame();
    }

    public void setRandomWord() {
        String words = getResources().getString(R.string.words);

        String[] arrayWords = words.split(" ");

        Log.d(TAG_GAME, "words count = " + arrayWords.length);

        hiddenWord = arrayWords[random.nextInt(arrayWords.length - 1)];
    }

    /**
     * Retrieving the letter from the user
     *
     * @param v (button clicked)
     */
    public void introduceLetter(View v) {

        EditText editTextLetter = (EditText) findViewById(R.id.editTextLetter);
        String letter = editTextLetter.getText().toString();
        editTextLetter.setText("");

        Log.d(TAG_GAME, "The letter is " + letter);

        if (letter.length() == 1) {
            checkLetter(letter);
        } else {
            Toast.makeText(this, getResources().getString(R.string.please_intro_letter), Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Checking if the letter introduced matches any letter in the word to guess
     *
     * @param letter, letter introduced by the user
     */
    public void checkLetter(String letter) {

        char charIntroduced = letter.toUpperCase().charAt(0);
        boolean isLetterGuessed = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            char wordLetter = hiddenWord.toUpperCase().charAt(i);

            Log.d(TAG_GAME, "The letter we are checking is " + wordLetter);

            if (wordLetter == charIntroduced) {

                Log.d(TAG_GAME, "There was one match");
                isLetterGuessed = true;
                guessedLettersCount++;
                showLettersAtIndex(i, charIntroduced);
            }
        }

        // ошибка! выбрали букву, которой нет в слове
        if (!isLetterGuessed) {
            letterFailed(charIntroduced);
        }

        // угадали слово!
        if (guessedLettersCount == hiddenWord.length()) {
            userPoints++;
            clearScreen();
            setRandomWord();
        }
    }

    public void clearScreen() {

        TextView textViewFailed = (TextView) findViewById(R.id.textViewFailed);
        textViewFailed.setText("");

        guessedLettersCount = 0;
        failsCount = 0;
        userPoints = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for (int i = 0; i < layoutLetters.getChildCount(); i++) {
            TextView currentTextVew = (TextView) layoutLetters.getChildAt(i);
            currentTextVew.setText("_");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangman_start);
    }

    public void letterFailed(char letterFailed) {

        TextView textViewFailed = (TextView) findViewById(R.id.textViewFailed);
        String previousFail = textViewFailed.getText().toString();
        textViewFailed.setText(previousFail + letterFailed);

        failsCount++;

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        switch (failsCount) {
            case 1:
                imageView.setImageResource(R.drawable.hangman1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.hangman2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.hangman3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.hangman4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.hangman5);
                break;
            case 6:
                Intent gameOverIntent = new Intent(this, GameOverActivity.class);
                gameOverIntent.putExtra(POINTS_ID, userPoints);
                startActivity(gameOverIntent);
                break;
        }
//      imageView.setImage
    }

    /**
     * Displaying a letter guessed by the user
     *
     * @param position      of the letter
     * @param letterGuessed
     */
    public void showLettersAtIndex(int position, char letterGuessed) {

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));
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
