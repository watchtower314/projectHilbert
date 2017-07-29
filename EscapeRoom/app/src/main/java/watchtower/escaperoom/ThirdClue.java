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

public class ThirdClue extends AppCompatActivity {


    EditText room, sleep, memaw;
    Button cont, c1, c2, c3;
    String ans;
    public final int clue = 3;
    public final String r = "חדר";
    public final String s ="שינה";
    public final String m ="סבתא";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_clue);
        room = (EditText)findViewById(R.id.room);
        sleep = (EditText)findViewById(R.id.sleep);
        memaw = (EditText)findViewById(R.id.memaw);
        cont = (Button)findViewById(R.id.thirdContinue);
        c1 = (Button) findViewById(R.id.checkMark1);
        c2 = (Button) findViewById(R.id.checkMark2);
        c3 = (Button) findViewById(R.id.checkMark3);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);

        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        if(clues > clue)
            disableEditText();
        else
            initBoxes();
    }



    public void disableEditText()
    {
        room.setText(r);
        sleep.setText(s);
        memaw.setText(m);
        room.setTextColor(getResources().getColor(R.color.cyan));
        sleep.setTextColor(getResources().getColor(R.color.cyan));
        memaw.setTextColor(getResources().getColor(R.color.cyan));
        room.setEnabled(false);
        sleep.setEnabled(false);
        memaw.setEnabled(false);
        cont.setVisibility(View.VISIBLE);
        c1.setBackgroundResource(R.drawable.tickc);
        c2.setBackgroundResource(R.drawable.tickc);
        c3.setBackgroundResource(R.drawable.tickc);
        c1.setEnabled(false);
        c2.setEnabled(false);
        c3.setEnabled(false);
    }

    public void checkAns(View v)
    {
        int id = v.getId();

        switch(id)
        {
            case R.id.checkMark1:
            {
                ans = room.getText().toString();
                if(ans.equals(r))
                {
                    room.setEnabled(false);
                    c1.setBackgroundResource(R.drawable.tickc);
                    c1.setEnabled(false);
                    c2.setBackgroundResource(R.drawable.tickcyan);
                    sleep.setEnabled(true);
                    sleep.setHintTextColor(getResources().getColor(R.color.cyan));


                }
                else {
                    System.out.println("in here!!!");
                    err(room);
                }
                break;
            }
            case R.id.checkMark2:
            {
                ans = sleep.getText().toString();
                if(ans.equals(s))
                {
                    sleep.setEnabled(false);
                    c2.setBackgroundResource(R.drawable.tickc);
                    c2.setEnabled(false);
                    c3.setBackgroundResource(R.drawable.tickcyan);
                    memaw.setEnabled(true);
                    memaw.setHintTextColor(getResources().getColor(R.color.cyan));


                }
                else {

                    err(sleep);
                }

                break;
            }
            case R.id.checkMark3:
            {
                ans = memaw.getText().toString();
                if(ans.equals(m))
                {
                    memaw.setEnabled(false);
                    c3.setBackgroundResource(R.drawable.tickc);
                    c3.setEnabled(false);
                    cont.setVisibility(View.VISIBLE);
                    Game.updateSharedPref(ClueAct.clueButtons[clue],clue+1);

                }
                else
                    err(memaw);
                break;
            }

        }




    }

    public void err (EditText t)
    {
        Game.getSnackbar(R.string.firstWrong, (RelativeLayout)findViewById(R.id.memawRoom));
        t.setText("");
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void initBoxes()
    {
        room.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        sleep.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        memaw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

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
