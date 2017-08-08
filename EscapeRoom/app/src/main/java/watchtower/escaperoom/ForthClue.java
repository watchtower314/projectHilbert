package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForthClue extends AppCompatActivity {

    EditText [] numbers;
    public final int clue = 4;
    Button pressForClue, cont;
    String ans="";
    public final String phoneNumber = "0526670900";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_clue);
        numbers = new EditText[10];
        initEditText();
        pressForClue = (Button)findViewById(R.id.pressForClue);
        cont = (Button)findViewById(R.id.fourthContinue);

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);

        if(clues > clue)
            disableEditText();
        else
            initBoxes();

    }



    public void initEditText()
    {
        Log.d("TKT4","initEditText was called");
        numbers[0] = (EditText)findViewById(R.id.one);
        numbers[1] = (EditText)findViewById(R.id.two);
        numbers[2] = (EditText)findViewById(R.id.three);
        numbers[3] = (EditText)findViewById(R.id.four);
        numbers[4] = (EditText)findViewById(R.id.five);
        numbers[5] = (EditText)findViewById(R.id.six);
        numbers[6] = (EditText)findViewById(R.id.seven);
        numbers[7] = (EditText)findViewById(R.id.eight);
        numbers[8] = (EditText)findViewById(R.id.nine);
        numbers[9] = (EditText)findViewById(R.id.ten);

    }
    public void hideKeyboard(View view) {
        Log.d("TKT4","hiding keyboard");
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



    public void initBoxes()
    {
        Log.d("TKT4","initBoxes was called");
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        hideKeyboard(v);
                    }
                }
            });
        }


    }

    public void disableEditText()
    {
        Log.d("TKT4","disableEditText was pressed");
        for(int i=0; i<numbers.length; i++)
        {
            numbers[i].setText(phoneNumber.charAt(i)+"");
            numbers[i].setEnabled(false);
        }

        pressForClue.setText(R.string.callMeMaybe);
        pressForClue.setTextColor(getResources().getColor(R.color.cyan));//// TODO: 8/6/2017 fix this 
        pressForClue.setEnabled(false);
        cont.setVisibility(View.VISIBLE);

    }

    public void checkInput(View v)
    {
        Log.d("TKT4","checkInput was pressed");
        for(int i=0; i<numbers.length; i++)
        {
            ans+=numbers[i].getText().toString();
        }

        Log.d("TKT4","ans"+ans);
        if(ans.equals(phoneNumber))
        {
            Log.d("TKT4","ans = phoneNumber");
            disableEditText();
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
        }
        else
        {
            Log.d("TKT4","ans != phoneNumber");
            Toast.makeText(ForthClue.this, R.string.firstWrong, Toast.LENGTH_SHORT).show();
            for(int i = 0; i<numbers.length; i++)
            {
                numbers[i].setText("");
            }
            ans="";
        }
    }

    public void nextClue(View v)
    {
        Log.d("TKT4","nextClue was pressed");
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
