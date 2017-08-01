package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        Log.d("TKT3","disableEditText was called");
        room.setText(r);
        sleep.setText(s);
        memaw.setText(m);
        room.setTextColor(ContextCompat.getColor(this, R.color.cyan));//getResources().getColor(R.color.cyan));
        sleep.setTextColor(ContextCompat.getColor(this, R.color.cyan));
        memaw.setTextColor(ContextCompat.getColor(this, R.color.cyan));
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
        Log.d("TKT3","checkAns was pressed");
        int id = v.getId();
        switch(id)
        {
            case R.id.checkMark1:
            {
                Log.d("TKT3","checkMark1 was pressed");
                ans = room.getText().toString();
                if(ans.equals(r))
                {
                    Log.d("TKT3","ans = room");
                    room.setEnabled(false);
                    c1.setBackgroundResource(R.drawable.tickc);
                    c1.setEnabled(false);
                    c2.setBackgroundResource(R.drawable.tickcyan);
                    sleep.setEnabled(true);
                    sleep.setHintTextColor(ContextCompat.getColor(this, R.color.cyan));


                }
                else {
                    Log.d("TKT3","ans != room");
                    c1.setBackgroundResource(R.drawable.x1);
                    Snackbarring(R.string.firstWrong, (RelativeLayout)findViewById(R.id.memawRoom), 1);
                    //err(room);
                }
                break;
            }
            case R.id.checkMark2:
            {
                Log.d("TKT3","checkMark2 was pressed");
                ans = sleep.getText().toString();
                if(ans.equals(s))
                {
                    Log.d("TKT3","ans = sleep");
                    sleep.setEnabled(false);
                    c2.setBackgroundResource(R.drawable.tickc);
                    c2.setEnabled(false);
                    c3.setBackgroundResource(R.drawable.tickcyan);
                    memaw.setEnabled(true);
                    memaw.setHintTextColor(ContextCompat.getColor(this, R.color.cyan));


                }
                else {
                    Log.d("TKT3","ans != sleep");
                    //err(sleep);
                    c2.setBackgroundResource(R.drawable.x1);
                    Snackbarring(R.string.firstWrong, (RelativeLayout)findViewById(R.id.memawRoom), 2);
                }

                break;
            }
            case R.id.checkMark3:
            {
                Log.d("TKT3","checkMark3 was pressed");
                ans = memaw.getText().toString();
                if(ans.equals(m))
                {
                    Log.d("TKT3","ans = memaw");
                    memaw.setEnabled(false);
                    c3.setBackgroundResource(R.drawable.tickc);
                    c3.setEnabled(false);
                    cont.setVisibility(View.VISIBLE);
                    Game.updateSharedPref(ClueAct.clueButtons[clue],clue+1);

                }
                else {
                    Log.d("TKT3","ans != sleep");
                    //err(memaw);
                    c3.setBackgroundResource(R.drawable.x1);
                    Snackbarring(R.string.firstWrong, (RelativeLayout)findViewById(R.id.memawRoom), 3);
                }
                break;
            }

        }
    }

    public void Snackbarring(int message, RelativeLayout activity, final int tick)
    {

        Log.d("TKT7", "snackbarring was called");
        Snackbar error = Snackbar.make(activity, message, Snackbar.LENGTH_LONG);
        View errorView = error.getView();
        errorView.setBackgroundColor(Color.DKGRAY);
        TextView textView = (TextView)errorView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        error.show();

        error.setCallback(new Snackbar.Callback() {

            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                if (event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                    if(tick == 1)
                        c1.setBackgroundResource(R.drawable.tickcyan);
                    else
                        if(tick == 2)
                            c2.setBackgroundResource(R.drawable.tickcyan);
                        else
                            c3.setBackgroundResource(R.drawable.tickcyan);

                }
            }

            @Override
            public void onShown(Snackbar snackbar) {
            }
        });
    }

    public void err (EditText t)
    {
        Log.d("TKT3","err was called");
        Game.getSnackbar(R.string.firstWrong, (RelativeLayout)findViewById(R.id.memawRoom));
        t.setText("");
    }

    public void hideKeyboard(View view) {
        Log.d("TKT3","hiding keyboard");

        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
       /* if(view.getId() == R.id.checkMark1 || view.getId() == R.id.checkMark2 || view.getId() == R.id.checkMark3) {
            checkAns(view);
        }
        */
    }


    public void initBoxes()
    {
        Log.d("TKT3","intiBoxes was called");
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
        /*
        c1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        c2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        c3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
*/

    }


    public void nextClue(View v)
    {
        Log.d("TKT3","nextClue was pressed");
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
