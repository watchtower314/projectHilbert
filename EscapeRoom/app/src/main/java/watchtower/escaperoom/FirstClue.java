package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstClue extends AppCompatActivity {
    EditText red1, blue1, red2, blue2;
    public final String ANS1 =  "104950", ANS2 = "015049", ANS3 = "495010", ANS4 = "504901";
    Button checkButton1;
    public final int clue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_clue);
        red1 = (EditText)findViewById(R.id.redBox1);
        blue1 = (EditText)findViewById(R.id.blueBox1);
        red2 = (EditText)findViewById(R.id.redBox2);
        blue2 = (EditText)findViewById(R.id.blueBox2);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        checkButton1 = (Button)findViewById(R.id.firstCheck);
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);
        Log.d("TKT1", "onCreate clue1");
        if(clues > clue)
            disableEditText();
        else
            initBoxes();


    }


    public void hideKeyboard(View view) {
        Log.d("TKT1","hiding keyboard");
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void checkAns(View v) {

        Log.d("TKT1","checkAns was pressed");
        if(checkButton1.getTag().equals(Game.CHECK_TAG))
        {
            String answer = red1.getText().toString() + blue1.getText().toString() + red2.getText().toString() + blue2.getText().toString();
            if (answer.equals(ANS1) || answer.equals(ANS2) || answer.equals(ANS3) || answer.equals(ANS4))
            {
                Log.d("TKT1", "ANSWER is correct");
                Game.updateSharedPref(ClueAct.clueButtons[clue], clue + 1);
                Game.firstClueEditTexts(red1.getText().toString(), blue1.getText().toString(), red2.getText().toString(), blue2.getText().toString());
                disableEditText();
                //disableEditText();
            }
            else
                {
                    Log.d("TKT1", "ANSWER is incorrect");
                    Toast.makeText(FirstClue.this, R.string.firstWrong, Toast.LENGTH_SHORT).show();
                    red1.setText("");
                    red2.setText("");
                    blue1.setText("");
                    blue2.setText("");
                }

            }
            else
                {
                Log.d("TKT1", "tag = next");
                nextClue();
            }
    }

    public void initBoxes()
    {
        Log.d("TKT1","initBoxes was called");
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
        Log.d("TKT1","disableEditText was called");
        checkButton1.setTag(Game.NEXT_TAG);
        checkButton1.setTextColor(ContextCompat.getColor(this, R.color.blanco));
        checkButton1.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        checkButton1.setText(R.string.continuar);
        red1.setText(Game.gamePrefs.getString("red1",""));
        red2.setText(Game.gamePrefs.getString("red2",""));
        blue1.setText(Game.gamePrefs.getString("blue1",""));
        blue2.setText(Game.gamePrefs.getString("blue2",""));
        red1.setEnabled(false);
        red2.setEnabled(false);
        blue1.setEnabled(false);
        blue2.setEnabled(false);

    }


    public void nextClue()
    {
        Log.d("TKT1","nextClue was pressed");
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
