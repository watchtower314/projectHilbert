package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);

        if(clues > clue) {
            checkButton5.setTag(Game.ARROWY_TAG);
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
        if(checkButton5.getTag().equals(Game.BLUE_TICK)) {
            String ans = book.getText().toString();
            if (ans.equalsIgnoreCase(BOOK))
            {
                //TODO: check what happens when pressing check
                Log.d("TKT5", "ans = book");
                checkButton5.setBackgroundResource(R.drawable.tickc);
                Game.updateSharedPref(ClueAct.clueButtons[clue], clue + 1);
                //Snackbarring(R.string.wait, (RelativeLayout) findViewById(R.id.findMyPhone));
                Toast.makeText(FifthClue.this, R.string.wait, Toast.LENGTH_SHORT).show();
                new CountDownTimer(2000,1000)
                {

                    @Override
                    public void onTick(long l) {
                        Log.d("TKT5", "ticking");
                    }

                    @Override
                    public void onFinish() {
                        Log.d("TKT5", "onFinish");
                        checkButton5.setTag(Game.ARROWY_TAG);
                        checkButton5.setBackgroundResource(R.drawable.arrowy);
                    }
                }.start();

                book.setEnabled(false);
            }
            else
                {
                Log.d("TKT5", "ans != book");
                    Toast.makeText(FifthClue.this, R.string.firstWrong, Toast.LENGTH_SHORT).show();
                    book.setText("");
            }

        }
        else
        {
            Log.d("Tkt5","tag = arrowy");
            nextClue();
        }
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


    /*
    public void escapeThis(View v)
    {this function is for redoing the level during debugging, instead of reinstalling the app
        checkButton5.setTag(Game.BLUE_TICK);
        checkButton5.setBackgroundResource(R.drawable.tickcyan);
        book.setEnabled(true);
        book.setText("");
        initBoxes();

    }
    */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}
