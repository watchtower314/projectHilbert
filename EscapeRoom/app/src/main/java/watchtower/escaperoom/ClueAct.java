package watchtower.escaperoom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClueAct extends AppCompatActivity {
    public static Button [] clueButtons;
    EditText pass1;
    EditText pass2;
    EditText pass3;
    EditText pass4;
    EditText pass5;
    Button submit;
    public RelativeLayout screen;
    public final int clue = 0;
    public final String EIGHT_CODE = "photo magnet";//// TODO: 8/9/2017 set code 
    int clues;
    boolean first, last;
    final int level7 = 7, level12=12;
    final String FINAL_CODE = "";//// TODO: 8/9/2017 set code




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState !=null)
            Log.d("TKT_clue", "not null");
        else
        {
            Log.d("TKT_clue", "null");
            super.onCreate(savedInstanceState);
            Log.d("TKT_clue", "clue was onCreated");
        }
        setContentView(R.layout.activity_clue);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        screen = (RelativeLayout)findViewById(R.id.activity_clue);
        initButtons();
        clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);
        first = Game.gamePrefs.getBoolean(Game.FIRST, true);
        last = Game.gamePrefs.getBoolean(Game.LAST, true);
        Log.d("TKT_clue","clues now: "+clues);
        Log.d("TKT_clue","first: "+first);
        Log.d("TKT_clue","last: "+last);
        if(clues != clue)
            setScreen(clues);

    }

    public void lastClueAlert(int mensaje)
    {//shown right before entering 12th clue
        Log.d("TKT_clue", "hangOn message is shows");
        AlertDialog.Builder message = new AlertDialog.Builder(this);
        message.setMessage(mensaje).create();
        message.show();

    }

    public void setScreen(int clues)
    {
        Log.d("TKT_clue","clues: "+clues);
        Log.d("TKT_clues","setScreens ");
        for(int i = 0; i < clues; i++)
        {
            Log.d("TKT_clues","i: "+i);
            //open access to these buttons
            clueButtons[i].setBackgroundResource(R.drawable.androidunlockg1);
            clueButtons[i].setEnabled(true);
        }
        if(clues == 8 )
        {//&& !Game.gamePrefs.getBoolean("eightPassed",false)) {
            //// TODO: 8/5/2017 check if there is no problem here
            Log.d("TKT_clue"," clue == 8, eight isn't passed");
            clueButtons[8].setBackgroundResource(R.drawable.androidlockyellow);
            clueButtons[8].setEnabled(true);
            clueButtons[8].setTag(Game.YELLOW_LOCK_TAG);
        }
        if(clues == 12 && first)
        {//shown before enterinf level 12
            //show alert
            Log.d("TKT_clues","clue == 12, first: "+first);
            lastClueAlert(R.string.lastClue);
            Game.updateFirst();
        }
        else
            if(clues == 12 && last)
            {
                Log.d("TKT_clues","clues == 12, last: "+last);
                showDialogMessage(level12, R.string.finished);
            }

        disableEditText();
    }

    public void initButtons()
    {
        Log.d("TKT_clue","initButtons");
        clueButtons = new Button [] {(Button)findViewById(R.id.first), (Button)findViewById(R.id.second), (Button)findViewById(R.id.third),
                (Button)findViewById(R.id.fourth), (Button)findViewById(R.id.fifth), (Button)findViewById(R.id.sixth),
                (Button)findViewById(R.id.seventh), (Button)findViewById(R.id.eighth), (Button)findViewById(R.id.ninth),
                (Button)findViewById(R.id.tenth), (Button)findViewById(R.id.eleventh), (Button)findViewById(R.id.twelfth)};

        pass1 = (EditText)findViewById(R.id.pass1);
        pass2 = (EditText)findViewById(R.id.pass2);
        pass3 = (EditText)findViewById(R.id.pass3);
        pass4 = (EditText)findViewById(R.id.pass4);
        pass5 = (EditText)findViewById(R.id.pass5);
        submit = (Button)findViewById(R.id.submit);
    }

    public void checkPassword(View v)
    {
        Log.d("TKT_clue","checkPassword");
        InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        String password = "M5439";

        String ans = pass1.getText().toString()+pass2.getText().toString()+pass3.getText().toString()+pass4.getText().toString()+pass5.getText().toString();


        System.out.println("password: "+password);
        System.out.println("ans: "+ans);
            if(!ans.equals(password)) {
               //Game.getSnackbar(R.string.error, (RelativeLayout)findViewById(R.id.activity_clue));
                Toast.makeText(ClueAct.this, R.string.firstWrong, Toast.LENGTH_SHORT).show();
                pass1.setText("");
                pass2.setText("");
                pass3.setText("");
                pass4.setText("");
                pass5.setText("");
            }
            else
            {

                submit.setEnabled(false);
                Game.updateSharedPref(clueButtons[clue], clue+1);
                clues = 1;
                setScreen(clues);
                disableEditText();


            }

    }

    public void disableEditText()
    {
        pass1.setText("M");
        pass2.setText("5");
        pass3.setText("4");
        pass4.setText("3");
        pass5.setText("9");
        pass1.setEnabled(false);
        pass2.setEnabled(false);
        pass3.setEnabled(false);
        pass4.setEnabled(false);
        pass5.setEnabled(false);
        submit.setEnabled(false);
    }

    public void goToClue(View v)
    {
        Log.d("TKT_clue", "is enable: " + v.isEnabled());
        if(v.isEnabled())
        {
            if(v.getTag().toString().equalsIgnoreCase(Game.YELLOW_LOCK_TAG))
            {
                // // TODO: 8/3/2017 problem with this 
                //popup a window with space to write code in it
                Log.d("TKT ClueAct","tag = yellowLock");
                Log.d("TKT ClueAct", "tag: "+v.getTag().toString());
                showDialogMessage(level7, R.string.enterPassword);
            }
            else {
                Log.d("TKT_clue","tag isn't yellow");
                int id = v.getId();
                Game.getClue(id, this);
            }
        }

    }

    public void showDialogMessage(final int level, int message)
    {
        Log.d("TKT ClueAct","showDialogMessage was called");
        //setContentView(R.layout.enter_password);


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.enter_password);
        //dialog.setTitle("titulo");
        dialog.setCanceledOnTouchOutside(false);



        final TextView textView = (TextView)dialog.findViewById(R.id.dialogTitle);
        //TextView textView = (TextView)dialog.findViewById(R.id.dialogTitle);
        textView.setText(message);
        final EditText editText = (EditText)dialog.findViewById(R.id.passwordText);
        editText.setHint("Code");



        final Button button = (Button)dialog.findViewById(R.id.submitPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT_clue", "onClick submit");
                if (v.getTag().equals(Game.CHECK_TAG)) {
                    Log.d("TKT_clue","tag = check");
                    if (level == level7 && editText.getText().toString().equalsIgnoreCase(EIGHT_CODE)) {
                        Log.d("TKT_clue", "pass = EIGHT_CODE");
                        enterYellow7(dialog);

                    } else if (level == level12 && editText.getText().toString().equalsIgnoreCase(FINAL_CODE)) {
                        Log.d("TKT_clue", "pass = TWELFTH");
                        finale(dialog, button, textView, editText);
                    } else {
                        Log.d("TKT_clue", "pass = EIGHT_CODE");
                        dialog.dismiss();
                        Toast.makeText(ClueAct.this, R.string.wrongPassword, Toast.LENGTH_SHORT).show();


                    }

                }
                else
                {
                    Log.d("TKT_clue","tag = next");
                    dialog.dismiss();
                }
            }

        });
        dialog.show();
    }

    public void enterYellow7(Dialog dialog)
    {
        Log.d("TKT_clue", "pass = EIGHT_CODE");
        clueButtons[8].setTag(Game.READY_TAG);
        clueButtons[8].setBackgroundResource(R.drawable.androidunlockg1);
        Game.updateEightNineClues();
        Game.updateSharedPref(ClueAct.clueButtons[8], 9);
        dialog.dismiss();
    }
    public void finale(Dialog dialog, Button button, TextView textView, EditText editText)
    {
        button.setBackgroundResource(R.drawable.tickc);
        textView.setText(R.string.theEnd);
        editText.setVisibility(View.GONE);
        button.setText("");
        Game.updateLast();
        button.setTag(Game.NEXT_TAG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        int k = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);
        Log.d("TKT_clue","onRestart, clues: "+k);
        first = Game.gamePrefs.getBoolean(Game.FIRST, true);
        last = Game.gamePrefs.getBoolean(Game.LAST, true);
        setScreen(k);
    }
}
