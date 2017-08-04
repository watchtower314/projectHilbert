package watchtower.escaperoom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SeventhClue extends AppCompatActivity {

    static Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, emergencia, cancel;
    static RelativeLayout screen;
    public final int clue = 7, code = 3012; //TODO: change this to shira's bday
    int count = 0, ans = 0;
    static boolean flag = false;
    boolean showMessage = true;
    int mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_clue);
        screen = (RelativeLayout)findViewById(R.id.circles);
        ///check = (Button) findViewById(R.id.sixthContinue);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS, 0);
        int clues = Game.gamePrefs.getInt("currentClue", 0);
        Log.d("TKT7", "onCreate");
        initButtons();
        mess = R.string.wait;

        if (clues > clue) {
            showMessage = false;
            screen.setBackgroundResource(R.drawable.passcode4);
            timer(2500);
        }

        //else
            //initButtons();
    }


    public void initButtons()
    {
        Log.d("TKT7", "initButtons was called");
        uno = (Button)findViewById(R.id.oneButton);
        dos = (Button)findViewById(R.id.twoButton);
        tres = (Button)findViewById(R.id.threeButton);
        cuatro = (Button)findViewById(R.id.fourButton);
        cinco = (Button)findViewById(R.id.fiveButton);
        seis = (Button)findViewById(R.id.sixButton);
        siete = (Button)findViewById(R.id.sevenButton);
        ocho = (Button)findViewById(R.id.eightButton);
        nueve = (Button)findViewById(R.id.nineButton);
        cero = (Button)findViewById(R.id.zeroButton);
        emergencia = (Button)findViewById(R.id.emergency);
        cancel = (Button)findViewById(R.id.cancel);
    }


    public void numberPressed(View v)
    {
        Log.d("TKT7","numberPressed was pressed");
        switch (v.getId())
        {
            case R.id.oneButton:
            {
               Log.d("TKT7","one was pressed");
               ans = ans*10+1;
               passcodeProgress(++count);
               break;
            }
            case R.id.twoButton:
            {
                Log.d("TKT7","two was pressed");
                ans = ans*10+2;
                passcodeProgress(++count);
                break;
            }
            case R.id.threeButton:
            {
                Log.d("TKT7","three was pressed");
                ans = ans*10+3;
                passcodeProgress(++count);
                break;
            }
            case R.id.fourButton:
            {
                Log.d("TKT7","four was pressed");
                ans = ans*10+4;
                passcodeProgress(++count);
                break;
            }
            case R.id.fiveButton:
            {
                Log.d("TKT7","five was pressed");
                ans = ans*10+5;
                passcodeProgress(++count);
                break;
            }
            case R.id.sixButton:
            {
                Log.d("TKT7","six was pressed");
                ans = ans*10+6;
                passcodeProgress(++count);
                break;
            }
            case R.id.sevenButton:
            {
                Log.d("TKT7","seven was pressed");
                ans = ans*10+7;
                passcodeProgress(++count);
                break;
            }
            case R.id.eightButton:
            {
                Log.d("TKT7","eight was pressed");
                ans = ans*10+8;
                passcodeProgress(++count);
                break;
            }
            case R.id.nineButton:
            {
                Log.d("TKT7","nine was pressed");
                ans = ans*10+9;
                passcodeProgress(++count);
                break;
            }
            case R.id.zeroButton:
            {
                Log.d("TKT7","zero was pressed");
                ans = ans*10+0;
                passcodeProgress(++count);
                break;
            }
            case R.id.emergency:
            {
                Log.d("TKT7","emergency was pressed");
                passcodeProgress(222);
                break;
            }
            case R.id.cancel:
            {
                Log.d("TKT7","cancel was pressed");
                passcodeProgress(111);
                break;
            }
        }
    }

    public void passcodeProgress(int i)
    {
        Log.d("TKT7", "i: "+i);
        Log.d("TKT7", "ans: "+ans);
        Log.d("TKT7", "1count: "+count);
        if(i == 4)
        {
            screen.setBackgroundResource(R.drawable.passcode4);
            Log.d("TKT7" ,"flag1: "+flag);

            if(ans == code)
            {
                Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
                Log.d("TKT7" ,"ans = code");
                timer(1000);

            }
            else
            {
                Log.d("TKT7" ,"ans != code");
                count = 0;
                ans = 0;
                new CountDownTimer(500,1000){
                    public void onTick(long millisUntilFinish)
                    {
                        Log.d("TKT7", "Time remaining: "+millisUntilFinish/1000);
                    }
                    public void onFinish()
                    {
                        Log.d("TKT7", "finished");
                        vibratePhone();
                        screen.setBackgroundResource(R.drawable.iphonescreen);
                    }
                }.start();


            }
        }
        else {
            if (i == 1) {
                screen.setBackgroundResource(R.drawable.passcode1);
                cancel.setTag(Game.DELETE);
            }
            else if (i == 2)
                screen.setBackgroundResource(R.drawable.passcode2);
            else if (i == 3)
                screen.setBackgroundResource(R.drawable.passcode3);
            else
                if(i == 222) {
                    if(emergencia.getTag().toString().equalsIgnoreCase(Game.EMER)) {
                        Log.d("TKT7", "emergency");
                        Snackbarring(R.string.emergencia, screen);
                    }
                }
            else
                if(i == 111 && cancel.getTag().toString().equals(Game.DELETE))
                {
                    if(count == 3)
                    {
                        screen.setBackgroundResource(R.drawable.passcode2);
                        Log.d("TKT7", "passcode2");
                    }
                    else
                    {
                        if (count == 2) {
                            screen.setBackgroundResource(R.drawable.passcode1);
                            Log.d("TKT7", "passcode1");
                        }
                        else {
                            screen.setBackgroundResource(R.drawable.iphonescreen);
                            cancel.setTag(Game.CANCEL);
                            Log.d("TKT7", "iphonescreen");
                        }
                    }

                    Log.d("TKT7", "2count: "+count);
                    count--;
                    Log.d("TKT7", "count--: "+count);
                    ans/=10;
                    Log.d("TKT7", "ans/=10: "+ans);

                }

        }


    }


    public void timer(long mls)
    {
        hangOn();
        Log.d("TKT7", "in timer");
        new CountDownTimer(mls,1000){

            public void onTick(long millisUntilFinish)
            {
                Log.d("TKT7", "Time remaining: "+millisUntilFinish/1000);

            }
            public void onFinish()
            {
                Log.d("TKT7", "finished");
                disableEditText();
            }
        }.start();
    }


    public void disableEditText()
    {
        Log.d("TKT7", "disableEditText was called");
        uno.setEnabled(false);
        dos.setEnabled(false);
        tres.setEnabled(false);
        cuatro.setEnabled(false);
        cinco.setEnabled(false);
        seis.setEnabled(false);
        siete.setEnabled(false);
        ocho.setEnabled(false);
        nueve.setEnabled(false);
        cero.setEnabled(false);
        cancel.setEnabled(false);
        nextClue();

    }

    public void vibratePhone()
    {
        //Intent intentVibration = new Intent(getApplicationContext(), VibrateService.class);
        //startService(intentVibration);
        Log.d("TKT7", "phone vibrating");
        Vibrator vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(500);
    }


    public static void Snackbarring(int message, RelativeLayout activity)
    {
        Log.d("TKT7", "snackbarring was called");
        Snackbar error = Snackbar.make(activity, message, Snackbar.LENGTH_LONG);
        View errorView = error.getView();
        errorView.setBackgroundColor(Color.DKGRAY);
        TextView textView = (TextView)errorView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        textView.setTextSize(20);
        error.show();

        error.setCallback(new Snackbar.Callback() {

            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                if (event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                    if(!flag) {
                        flag = true;
                        Snackbarring(R.string.jk, screen);
                    }

                }
            }

            @Override
            public void onShown(Snackbar snackbar) {
            }
        });
    }


    public void hangOn()
    {
        Log.d("TKT7", "hangOn message is shows");
        AlertDialog.Builder message = new AlertDialog.Builder(this);
        message.setMessage(R.string.wait).create();
        message.show();
    }

    public void nextClue()
    {
        Log.d("TKT7", "nextClue was called");
        Intent intent = new Intent(this, EighthClue.class);
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

    public void nextStep(View v)
    {
        Log.d("TKT7", "nextStep was pressed");
        String tag = v.getTag().toString();
        if(tag.equals("bluetick"))
        {
            Log.d("TKT7", "tag = bluetick");
            ///check.setBackgroundResource(R.drawable.tickc);
            //Snackbarring(R.string.wait, (RelativeLayout)findViewById(R.id.circles));
            ///check.setTag("next");
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
        }
        else
        {
            Log.d("TKT7", "tag = next");
            nextClue();
        }

    }



}
