package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This cclue is when the users find the phone,
 * - on the back there will be morse code
 * - maybe another clue that users need to call phone
 * -  the morse code will be 4 chars that are by discovering them, users can unlock the phone
 */
public class SixthClue extends AppCompatActivity {

    //Button vib;
    TextView pieNumbers;
    String four = "1, 2, 3, 4, ";
    EditText cText, rText, yText, pText, iText, eText;
    String five = "<font color = '#FF9D0808'>5</font>";
    public final int clue = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_clue);
        //vib = (Button)findViewById(R.id.vib);
        pieNumbers = (TextView)findViewById(R.id.pieNumbers);
        pieNumbers.setText(Html.fromHtml(four+five));
        cText = (EditText)findViewById(R.id.c);
        rText = (EditText)findViewById(R.id.r);
        yText = (EditText)findViewById(R.id.y);
        pText = (EditText)findViewById(R.id.p);
        iText = (EditText)findViewById(R.id.i);
        eText = (EditText)findViewById(R.id.e);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        System.out.println("got here now");

        //if(clues > clue)
            //disableEditText();
        //else
            initBoxes();

    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
/*
    public void vibratePhone(View v)
    {
        //Intent intentVibration = new Intent(getApplicationContext(), VibrateService.class);
        //startService(intentVibration);
        Vibrator vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        vib.vibrate(3000);
    }
*/
    public void initBoxes()
    {
        cText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        rText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        yText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        pText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        iText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        eText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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

 /*

    public static void Snackbarring(int message, RelativeLayout activity)
    {
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
                    check.setBackgroundResource(R.drawable.arrowy);
                }
            }

            @Override
            public void onShown(Snackbar snackbar) {
            }
        });
    }
*/

}