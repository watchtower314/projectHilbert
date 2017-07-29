package watchtower.escaperoom;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class ClueAct extends AppCompatActivity {
    public static Button [] clueButtons;
    EditText pass1;
    EditText pass2;
    EditText pass3;
    EditText pass4;
    EditText pass5;
    Button submit;
    public final int clue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        initButtons();
        int clues = Game.gamePrefs.getInt("currentClue",0);
        System.out.println("clues now: "+clues);
        if(clues != clue)
            setScreen(clues);
    }

    public void setScreen(int clues)
    {
        for(int i = 0; i < clues; i++)
        {
            System.out.println("TXT: i: "+i);
            //open access to these buttons
            clueButtons[i].setBackgroundResource(R.drawable.androidunlockg1);
            clueButtons[i].setEnabled(true);
        }
        disableEditText();
    }
    public void initButtons()
    {
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
        InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        String password = "M5439";

        String ans = pass1.getText().toString()+pass2.getText().toString()+pass3.getText().toString()+pass4.getText().toString()+pass5.getText().toString();


        System.out.println("password: "+password);
        System.out.println("ans: "+ans);
            if(!ans.equals(password)) {
               Game.getSnackbar(R.string.error, (RelativeLayout)findViewById(R.id.activity_clue));
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
        System.out.println("is evable: " + v.isEnabled());
        if(v.isEnabled())
        {
            int id = v.getId();
            System.out.println("cluses are probably: "+Game.gamePrefs.getInt("currentClue",0));
            System.out.println("id: "+id);
            Game.getClue(id, this);
        }
        else
        {
            //System.out.println("ACCESS DENIED");
            //Game.getSnackbar(R.string.accessDenied, (RelativeLayout)findViewById(R.id.activity_clue));
        }

    }
}
