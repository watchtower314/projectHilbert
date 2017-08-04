package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FifthClue extends AppCompatActivity {

    EditText book;
    static Button checkButton5;
    public final int clue = 5;
    public final String BOOK = "The Princess Bride";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_clue);
        book = (EditText)findViewById(R.id.bookName);
        checkButton5 = (Button)findViewById(R.id.checkAnswer);
        //cont = (Button)findViewById(R.id.fifthContinue);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        System.out.println("got here now");

        if(clues > clue) {
            checkButton5.setTag("arrowy");
            disableEditText();

        }
        else
            initBoxes();
    }


    public void hideKeyboard(View view) {
        Log.d("TKT5","hiding keyboard");
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void checkAns(View v)
    {
        Log.d("TKT5","checkAns was pressed");
        if(checkButton5.getTag().equals("bluetick")) {
            String ans = book.getText().toString();
            if (ans.equalsIgnoreCase(BOOK))
            {
                //TODO: check what happens when pressing check
                Log.d("TKT5", "ans = book");
                checkButton5.setBackgroundResource(R.drawable.tickc);
                Game.updateSharedPref(ClueAct.clueButtons[clue], clue + 1);
                Snackbarring(R.string.wait, (RelativeLayout) findViewById(R.id.findMyPhone));
                checkButton5.setTag("arrowy");
                disableEditText();
            }
            else
                {
                Log.d("TKT5", "ans != book");
                Game.getSnackbar(R.string.firstWrong, (RelativeLayout) findViewById(R.id.findMyPhone));
                book.setText("");
            }

        }
        else
        {
            Log.d("Tkt5","tag = arrowy");
            nextClue();
        }
    }


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
                    checkButton5.setBackgroundResource(R.drawable.arrowy);
                }
            }

            @Override
            public void onShown(Snackbar snackbar) {
            }
        });
    }

    public void disableEditText()
    {
        Log.d("TKT5","disableEditText was called");
        book.setText(BOOK);
        book.setEnabled(false);
        checkButton5.setBackgroundResource(R.drawable.arrowy);
    }


    public void initBoxes()
    {
        Log.d("TKT5","initBoxes was called");
                    book.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
        Log.d("TKT5","nextClue was pressed");
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
