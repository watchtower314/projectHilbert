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

public class FifthClue extends AppCompatActivity {

    EditText book;
    Button checkAns, cont;
    public final int clue = 5;
    public final String BOOK = "The Princess Bride";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_clue);
        book = (EditText)findViewById(R.id.bookName);
        checkAns = (Button)findViewById(R.id.checkAnswer);
        cont = (Button)findViewById(R.id.fifthContinue);

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
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void checkAns(View v)
    {
        String ans = book.getText().toString();
        System.out.println("ans: "+ans);
        if(ans.equalsIgnoreCase(BOOK))
        {
            System.out.println("books equals");
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
            disableEditText();
        }
        else
        {
            Game.getSnackbar(R.string.firstWrong, (RelativeLayout)findViewById(R.id.findMyPhone));
            book.setText("");
        }
    }


    public void disableEditText()
    {
        book.setText(BOOK);
        book.setEnabled(false);
        checkAns.setBackgroundResource(R.drawable.tickc);
        checkAns.setEnabled(false);
        cont.setVisibility(View.VISIBLE);

    }


    public void initBoxes()
    {
                    book.setOnFocusChangeListener(new View.OnFocusChangeListener() {
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
