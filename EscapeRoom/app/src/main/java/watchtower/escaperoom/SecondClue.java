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

public class SecondClue extends AppCompatActivity {

    EditText m, h, r;
    Button check, continuar;
    public final int clue = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_clue);
        m = (EditText)findViewById(R.id.m);
        h = (EditText)findViewById(R.id.h);
        r = (EditText)findViewById(R.id.r);
        check = (Button)findViewById(R.id.secondCheck);
        continuar = (Button)findViewById(R.id.secondContinue);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        if(clues > clue)
            disableView();
        else
            initBoxes();
    }


    public void checkAns(View v)
    {
        String tomorrow = "מחר";
        String ans = m.getText().toString()+ h.getText().toString() + r.getText().toString();
        System.out.println("ans: "+ans);
        if(tomorrow.equals(ans))
        {
            System.out.println("truee dat");

            check.setText(R.string.correct);
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
            disableView();
        }
        else
        {
            Game.getSnackbar(R.string.firstWrong, (RelativeLayout) findViewById(R.id.activity_wall_picture));
            m.setText("");
            h.setText("");
            r.setText("");
        }


    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void disableView()
    {
        check.setEnabled(false);
        continuar.setVisibility(View.VISIBLE);
        m.setText("מ");
        h.setText("ח");
        r.setText("ר");
        m.setEnabled(false);
        h.setEnabled(false);
        r.setEnabled(false);

    }

    public void nextClue(View v)
    {
        //Intent intent = new Intent(this, ThirdClue.class);
        //startActivity(intent);
        System.out.println("nextPressed");
        Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void initBoxes()
    {
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
