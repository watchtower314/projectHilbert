package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

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
        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("this is clues: " +clues);
        System.out.println("got here now");

        if(clues > clue)
            disableEditText();
        else
            initBoxes();

    }



    public void initEditText()
    {
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
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



    public void initBoxes()
    {

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
        System.out.println("got here now");

        for(int i=0; i<numbers.length; i++)
        {


            numbers[i].setText(phoneNumber.charAt(i)+"");
            numbers[i].setEnabled(false);
        }

        pressForClue.setText(R.string.callMeMaybe);
        pressForClue.setTextColor(getResources().getColor(R.color.cyan));
        pressForClue.setEnabled(false);
        cont.setVisibility(View.VISIBLE);

    }

    public void checkInput(View v)
    {
        for(int i=0; i<numbers.length; i++)
        {
            ans+=numbers[i].getText().toString();
        }
        System.out.println("phoneNum: "+phoneNumber);
        System.out.println("ans: "+ans);

        if(ans.equals(phoneNumber))
        {

            disableEditText();
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
        }
        else
        {
            Game.getSnackbar(R.string.firstWrong, (RelativeLayout)findViewById(R.id.callMe));
            for(int i = 0; i<numbers.length; i++)
            {
                numbers[i].setText("");
            }
        }
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
