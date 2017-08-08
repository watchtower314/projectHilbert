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

public class SecondClue extends AppCompatActivity {

    EditText m, h, r;
    Button checkButton2;
    public final int clue = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_clue);

        m = (EditText)findViewById(R.id.m);
        h = (EditText)findViewById(R.id.h);
        r = (EditText)findViewById(R.id.r);
        checkButton2 = (Button)findViewById(R.id.secondCheck);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);
        if(clues > clue)
            disableEditText();
        else
            initBoxes();
    }


    public void checkAns(View v)
    {

        Log.d("TKT2","checkAns was pressed");
        if(checkButton2.getTag().equals(Game.CHECK_TAG))
        {
            Log.d("TKT2","tag = check");
            String tomorrow = "מחר";
            String ans = m.getText().toString() + h.getText().toString() + r.getText().toString();
            if (tomorrow.equals(ans)) {
                Log.d("TKT2", "ans = tomorrow");
                Game.updateSharedPref(ClueAct.clueButtons[clue], clue + 1);
                disableEditText();
            } else {
                Log.d("TKT2", "ans != tomorrow");
                Toast.makeText(SecondClue.this, R.string.firstWrong, Toast.LENGTH_SHORT).show();
                m.setText("");
                h.setText("");
                r.setText("");
            }
        }
        else
        {
            Log.d("TKT2","tag = next");
            nextClue();
        }


    }

    public void hideKeyboard(View view) {
        Log.d("TKT2","hiding keyboard");
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void disableEditText()
    {
        Log.d("TKT2","disableView was called");
        checkButton2.setTag(Game.NEXT_TAG);
        checkButton2.setTextColor(ContextCompat.getColor(this, R.color.blanco));
        checkButton2.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        checkButton2.setText(R.string.continuar);
        m.setText("מ");
        h.setText("ח");
        r.setText("ר");
        m.setEnabled(false);
        h.setEnabled(false);
        r.setEnabled(false);

    }

    public void nextClue()
    {
        Log.d("TKT2","nextClue pressed");
        Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void initBoxes()
    {
        Log.d("TKT2","initBoxes was called");
        m.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        h.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        r.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
