package watchtower.escaperoom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ClueAct extends AppCompatActivity {
    public static Button [] clueButtons;
    EditText pass1;
    EditText pass2;
    EditText pass3;
    EditText pass4;
    EditText pass5, password;
    Button submit, submitPass;
    public RelativeLayout screen;
    public final int clue = 0;
    public final String EIGHT_CODE = "photo magnet";



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
        if(clues == 8) {
            clueButtons[8].setBackgroundResource(R.drawable.androidlockyellow);
            clueButtons[8].setEnabled(true);
            clueButtons[8].setTag(Game.YELLOW_LOCK);
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
        Log.d("TKT_clue", "is evable: " + v.isEnabled());
        if(v.isEnabled())
        {
            if(v.getTag().toString().equalsIgnoreCase(Game.YELLOW_LOCK))
            {
                // // TODO: 8/3/2017 problem with this 
                //popup a window with space to write code in it
                Log.d("TKT ClueAct","tag = yellowLock");
                Log.d("TKT ClueAct", "tag: "+v.getTag().toString());
                showDialogMessage();
            }
            else {
                int id = v.getId();
                Game.getClue(id, this);
            }
        }
            else
            {
                Log.d("TKT ClueAct","access denied");
            //System.out.println("ACCESS DENIED");
            //Game.getSnackbar(R.string.accessDenied, (RelativeLayout)findViewById(R.id.activity_clue));
            }

    }

    public void showDialogMessage()
    {
        Log.d("TKT ClueAct","showDialogMessage was called");
        //setContentView(R.layout.enter_password);


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.enter_password);
        dialog.setTitle("titulo");
        dialog.setCanceledOnTouchOutside(false);

        TextView textView = (TextView)dialog.findViewById(R.id.dialogTitle);
        //textView.setText("הכניסו את הקוד שמצאתם ברמזז הקודם");
        final EditText editText = (EditText)dialog.findViewById(R.id.passwordText);
        //editText.setHint("Code");


        Button button = (Button)dialog.findViewById(R.id.submitPassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT_clue", "onClick submit");
                //dialog.dismiss();
                if(editText.getText().toString().equalsIgnoreCase(EIGHT_CODE))
                {
                    Log.d("TKT_clue", "pass = EIGHT_CODE");
                    clueButtons[8].setTag("");
                    clueButtons[8].setBackgroundResource(R.drawable.androidunlockg1);
                    dialog.dismiss();
                }
                else
                {
                    Log.d("TKT_clue", "pass = EIGHT_CODE");
                    dialog.dismiss();
                    Game.getSnackbar(R.string.wrongPassword, screen);

                }

            }

        });
        dialog.show();
    }



    public void checkIfCodeCorrect(View v)
    {

    }
}
