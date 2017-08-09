package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class EleventhClue extends AppCompatActivity {
    //// TODO: 8/8/2017 in this clue there will be three boxes, each represent a dip tray, once the users finish the dip with the nachos, the answers to be in the boxes are at the bottom of each dip tray
    //each tray will be in different color, so will be the boxes on the app, so users will know they have to finish it.
    //then, after they write down the right answers, a few letters will be highlighted and that will be where the code to level twelve's clue!!! KEY

    EditText rectangle, square, circle;
    final String REC_ANS="hey", SQ_ANS="soul", CIR_ANS="sister";
    final int clue = 11;
    int ansNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_clue);
        rectangle = (EditText) findViewById(R.id.redTrayButton);
        square = (EditText)findViewById(R.id.blueTrayButton);
        circle = (EditText)findViewById(R.id.yellowTrayButton);
        Log.d("TKT11","onCreate");

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);
        Log.d("TKT11","clues: "+clues);

        if(clues > clue) {
            //nextClue();
            disableEditText();
        }
        else {
            //initBoxes();
            checkFocus();
        }

    }

    public void nextClue()
    {
        Log.d("TKT11","nextClue was pressed");
        Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void disableEditText()
    {
        Log.d("TKT11","disableEditText");
        rectangle.setText(REC_ANS);
        square.setText(SQ_ANS);
        circle.setText(CIR_ANS);
        rectangle.setEnabled(false);
        square.setEnabled(false);
        circle.setEnabled(false);
    }

    public void checkFocus()
    {
        Log.d("TKT11","checkFocus");
        rectangle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    hideKeyboard(v);
                    checkInput(1);
                }
            }
        });
        square.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    hideKeyboard(v);
                    checkInput(2);
                }
            }
        });
        circle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    hideKeyboard(v);
                    checkInput(3);
                }
            }
        });
    }

    public void checkInput(int i)
    {//1: rectangle, 2: square, 3: circle
        Log.d("TKT11","checkInput");
        if(i == 1)
        {
            Log.d("TKT11","i=1");
            if(rectangle.getText().toString().equalsIgnoreCase(REC_ANS))
            { //// TODO: 8/9/2017 set color green and disable editText
                rectangle.setEnabled(false);
                Log.d("TKT11","Rectangle: ansNum: "+ansNum);
                ansNum++;
                checkFinish();
            }
            else
            {
                Log.d("TKT11","wrongRec");
                rectangle.setText("");
                Toast.makeText(EleventhClue.this, R.string.recWrong, Toast.LENGTH_SHORT).show();//check if seen
            }
        }
        else if (i == 2)
        {
            Log.d("TKT11","i=2");
            if(square.getText().toString().equalsIgnoreCase(SQ_ANS))
            { //// TODO: 8/9/2017 set color green and disable editText
                square.setEnabled(false);
                Log.d("TKT11","square: ansNum: "+ansNum);
                ansNum++;
                checkFinish();
            }
            else
            {
                square.setText("");
                Log.d("TKT11","wrongSquare");
                Toast.makeText(EleventhClue.this, R.string.sqWrong, Toast.LENGTH_SHORT).show();//check if seen
            }
        }
            else
            {
                Log.d("TKT11","i=3");
                if(circle.getText().toString().equalsIgnoreCase(CIR_ANS))
                { //// TODO: 8/9/2017 set color green and disable editText(?)
                    circle.setEnabled(false);
                    Log.d("TKT11","circle: ansNum: "+ansNum);
                    ansNum++;
                    checkFinish();
                }
                else
                {
                    circle.setText("");
                    Log.d("TKT11","wringCircle");
                    Toast.makeText(EleventhClue.this, R.string.cirWrong, Toast.LENGTH_SHORT).show();//check if seen
                }
            }
    }

    public void checkFinish()
    {
        Log.d("TKT11","checkFinish");
        if(ansNum == 3) {
            Log.d("TKT11","ansNum = 3");
            Toast.makeText(EleventhClue.this, R.string.wait, Toast.LENGTH_SHORT).show();
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
            new CountDownTimer(2000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    Log.d("TKT11","onFinish timer");
                    nextClue();
                }
            }.start();

        }
    }

    public void hideKeyboard(View view) {
        Log.d("TKT11","hiding keyboard");
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void onBackPressed() {
        Log.d("TKT11","onBackPressed");
        super.onBackPressed();
        finish();

    }
}
