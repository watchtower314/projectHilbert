package watchtower.escaperoom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class TenthClue extends AppCompatActivity {

    //pattern is this: 012
    //                 345
    //                 678

    final int clue = 10;
    PatternLockView patternLockView;
    String finalPattern;
    final String ANS_PATTERN = "342758061";//this is the same as 453869172, only here the dots are starting from 0, so each dot number is decreased by 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_clue);
        Log.d("TKT10","OnCreate:finalPattern "+finalPattern);
        Paper.init(this);
        patternLockView = (PatternLockView)findViewById(R.id.lockPattern);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE,0);
        Log.d("TKT10","clues: "+clues);
        if(clues > clue)
            disableView();
        else
            lockPatternRun();


    }

    public void disableView()
    {
        patternLockView.setEnabled(false);
    }

    public void lockPatternRun()
    {
        patternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
                progressPattern.get(0);
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                finalPattern = PatternLockUtils.patternToString(patternLockView, pattern);
                Log.d("TKT10","OnComplete:finalPattern "+finalPattern);
                if(finalPattern.equals(ANS_PATTERN))
                {

                    Toast.makeText(TenthClue.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    nextClue();
                    Log.d("TKT10", "finalPattern = ANS_PATTERN");
                }
                else {
                    Game.vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                    Game.vib.vibrate(500);
                    Toast.makeText(TenthClue.this, R.string.firstWrong, Toast.LENGTH_SHORT).show();
                    pattern.clear();
                    Log.d("TKT10", "finalPattern != ANS_PATTERN");
                }

            }

            @Override
            public void onCleared() {
                Log.d("TKT10","OnCleared");
            }
        });
    }

    public void nextClue()
    {
        Log.d("TKT10","nextClue was called");
        disableView();
        Game.updateSharedPref(ClueAct.clueButtons[clue], clue + 1);
        final Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        new CountDownTimer(2000,1000){
            public void onTick(long millisUntilFinish)
            {
                Log.d("TKT10", "Time remaining: "+millisUntilFinish/1000);
            }
            public void onFinish()
            {
                Log.d("TKT10", "finished");
                startActivity(intent);
                finish();
            }
        }.start();



    }


    @Override
    public void onBackPressed() {
        Log.d("TKT10","onBackPressed");
        super.onBackPressed();
        finish();

    }
}
