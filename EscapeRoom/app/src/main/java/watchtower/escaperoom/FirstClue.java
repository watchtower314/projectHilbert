package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class FirstClue extends AppCompatActivity {
    EditText red1, blue1, red2, blue2;
    Button cont;
    public final int clue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_clue);
        red1 = (EditText)findViewById(R.id.redBox1);
        blue1 = (EditText)findViewById(R.id.blueBox1);
        red2 = (EditText)findViewById(R.id.redBox2);
        blue2 = (EditText)findViewById(R.id.blueBox2);
        cont = (Button)findViewById(R.id.firstContinue);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);

        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        if(clues > clue)
            disableEditText();
        else
            initBoxes();


    }


    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void checkAns(View v) {

        String ans1 = "104950",
                ans2 = "015049",
                ans3 = "495010",
                ans4 = "504901";

        String answer = red1.getText().toString() + blue1.getText().toString() + red2.getText().toString() + blue2.getText().toString();

        if (answer.equals(ans1) || answer.equals(ans2) || answer.equals(ans3) || answer.equals(ans4)) {
            //TODO: popup of correctness
            System.out.println("strings match");
            Game.updateSharedPref(ClueAct.clueButtons[clue],clue+1);
            Game.firstClueEditTexts(red1.getText().toString(), blue1.getText().toString(), red2.getText().toString(), blue2.getText().toString());

            disableEditText();
            cont.setVisibility(View.VISIBLE);

        } else {
            Game.getSnackbar(R.string.firstWrong, (RelativeLayout) findViewById(R.id.activity_marbles));
            red1.setText("");
            red2.setText("");
            blue1.setText("");
            blue2.setText("");
        }


    }

    public void initBoxes()
    {
        red1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        red2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        blue1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        blue2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

    }

    public void disableEditText()
    {
        red1.setText(Game.gamePrefs.getString("red1",""));
        red2.setText(Game.gamePrefs.getString("red2",""));
        blue1.setText(Game.gamePrefs.getString("blue1",""));
        blue2.setText(Game.gamePrefs.getString("blue2",""));
        red1.setEnabled(false);
        red2.setEnabled(false);
        blue1.setEnabled(false);
        blue2.setEnabled(false);
        Button check = (Button)findViewById(R.id.firstCheck);
        check.setText(R.string.correct);
        check.setEnabled(false);
        cont.setVisibility(View.VISIBLE);

    }

    public void nextClue(View v)
    {
        Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}