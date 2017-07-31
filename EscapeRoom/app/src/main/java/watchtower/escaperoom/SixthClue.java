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
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * This cclue is when the users find the phone,
 * - on the back there will be morse code
 * - maybe another clue that users need to call phone
 * -  the morse code will be 4 chars that are by discovering them, users can unlock the phone
 */
public class SixthClue extends AppCompatActivity {

    //Button vib;
    TextView pieNumbers, five;
    EditText pText, iText, eText;
    ImageButton sound;
    Button checkButton;
    public final int clue = 6;
    public final String pie = "Pie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_clue);
        //vib = (Button)findViewById(R.id.vib);
        pieNumbers = (TextView)findViewById(R.id.pieNumbers);
        five = (TextView)findViewById(R.id.five);
        pText = (EditText)findViewById(R.id.p);
        iText = (EditText)findViewById(R.id.i);
        eText = (EditText)findViewById(R.id.e);
        sound = (ImageButton)findViewById(R.id.soundButton);
        checkButton = (Button)findViewById(R.id.sixthCheck);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        System.out.println("got here now");

        if(clues > clue)
            disableEditText();
        else
            initBoxes();

    }

    public void hideKeyboard(View view) {
        Log.d("TKT6","hiding keyboard");
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
        Log.d("TKT6","initBoxes was pressed");
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

    public void nextClue()
    {
        Log.d("TKT6","nextClue was pressed");
        Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }


    public void changeFive(View v)
    {
        //five.setTextColor(getResources().getColor(R.color.red));
        Log.d("TKT6","changeFive was pressed");
        five.setTextColor(ContextCompat.getColor(this, R.color.red));

    }

    public void checkAns(View v)
    {
        Log.d("TKT6", "check pressed");

        if(checkButton.getTag().equals(Game.CHECK_TAG))
        {
            Log.d("TKT6","tag = check");
            String ans = pText.getText().toString() + iText.getText().toString() + eText.getText().toString();
            System.out.println("ans: "+ans);
            if (ans.equalsIgnoreCase(pie)) {
                Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
                setNext();
            }
            else {
                Log.d("TKT6","ans != pie");
                Game.getSnackbar(R.string.firstWrong, (RelativeLayout) findViewById(R.id.bringMePie));
                pText.setText("");
                iText.setText("");
                eText.setText("");
            }
        }
        else
        {
            Log.d("TKT6","tag = next");
            disableEditText();
            nextClue();
        }

    }


    public void disableEditText()
    {
        Log.d("TKT6","disableEditText was called");
        sound.setEnabled(false);
        five.setTextColor(ContextCompat.getColor(this, R.color.red));
        pText.setText(String.valueOf(pie.charAt(0)));
        iText.setText(String.valueOf(pie.charAt(1)));
        eText.setText(String.valueOf(pie.charAt(2)));
        pText.setEnabled(false);
        iText.setEnabled(false);
        eText.setEnabled(false);
        }

    public void setNext()
    {
        Log.d("TKT6","setNext was called");
        checkButton.setTag(Game.NEXT_TAG);
        checkButton.setTextColor(ContextCompat.getColor(this, R.color.blanco));
        checkButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        checkButton.setText(R.string.continuar);
        disableEditText();

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