package watchtower.escaperoom;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TwelfthClue extends AppCompatActivity {

    final String KEY="key",RIGHT_ARROW="rightArrow",BOY="boy", FLASHLIGHT="flashlight",BRIGHT="bright", RING="ring",ARROWY="arrowy",MEMAW="memaw",X="x",ASTERIX="asterix";
    int [] starPosition = {0,1,2,3,4};
    int [] emojis = {R.drawable.ring, R.drawable.boyemoji, R.drawable.bright, R.drawable.arrowy, R.drawable.flashlight, R.drawable.key1, R.drawable.memaw12, R.drawable.rightarrow, R.drawable.x1, R.drawable.asterix};
    String [] tags = {RING, BOY, BRIGHT, ARROWY, FLASHLIGHT, KEY, MEMAW, RIGHT_ARROW, X, ASTERIX};
    ImageView [] starButton = new ImageView[5];
    int size = 10;
    int stars = 5;
    String[] ans = {KEY, RIGHT_ARROW, BOY, FLASHLIGHT, BRIGHT};
    int [] backgroundAns = {R.drawable.key1, R.drawable.rightarrow, R.drawable.boyemoji, R.drawable.flashlight, R.drawable.bright};
    int clue = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelfth_clue);
        starButton[0] = (ImageView)findViewById(R.id.star0);
        starButton[1] = (ImageView)findViewById(R.id.star1);
        starButton[2] = (ImageView)findViewById(R.id.star2);
        starButton[3] = (ImageView)findViewById(R.id.star3);
        starButton[4] = (ImageView)findViewById(R.id.star4);
        Log.d("TKT12","onCreate");

        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS,0);
        boolean last = Game.gamePrefs.getBoolean(Game.LAST,true);
        Log.d("TKT12","clues: "+last);
            if(!last)
                disableButtons();



    }

    public void changeEmoji(View v)
    {
        Log.d("TKT12","changeEmoji");
        switch (v.getId())
        {
            case R.id.star0:
            {
                Log.d("TKT12","star0");
                setBackground(0);
                break;
            }
            case R.id.star1:
            {
                Log.d("TKT12","star1");
                setBackground(1);
                break;
            }
            case R.id.star2:
            {
                Log.d("TKT12","star2");
                setBackground(2);
                break;
            }
            case R.id.star3:
            {
                Log.d("TKT12","star3");
                setBackground(3);
                break;
            }
            case R.id.star4:
            {
                Log.d("TKT12","star4");
                setBackground(4);
                break;
            }
        }
    }

    public void setBackground(int i)
    {
        Log.d("TKT12","setBackground, i: "+i);
        int pos = starPosition[i]%size;
        starButton[i].setBackgroundResource(emojis[pos]);
        starButton[i].setTag(tags[pos]);
        if(tags[pos] == ans[i]) {
            Log.d("TKT12","tags[i] == ans[i]");
            if (checkRest()) {
                Log.d("TKT12", "ifCheckRest");
                nextStep();
            }
        }
        starPosition[i]++;

    }

    public void nextStep()
    {
        Log.d("TKT12","nextStep");
        Toast.makeText(TwelfthClue.this, R.string.wait, Toast.LENGTH_SHORT).show();
        //Game.updateLast(true); seems useless
        disableButtons();
        new CountDownTimer(2000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Log.d("TKT12","onFinish");
                backToClues();
            }
        }.start();
    }

    public boolean checkRest()
    {
        Log.d("TKT12","checkRest");
        for(int i=0; i<stars; i++)
        {
            //starButton[i].getResources().getDrawable()
           if(starButton[i].getTag() != ans[i])
            {
                Log.d("TKT12","false, i:"+i);
                return false;
            }

        }
        Log.d("TKT12","checkRest: true");
        return true;

    }

    public void disableButtons()
    {
        Log.d("TKT12","disableButtons");
        for(int i=0; i<stars; i++)
        {
            starButton[i].setBackgroundResource(backgroundAns[i]);
            starButton[i].setEnabled(false);
        }
    }
    public void backToClues()
    {
        Log.d("TKT12","nextClue was pressed");
        Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        Log.d("TKT12","onBackPressed");
        super.onBackPressed();
        finish();

    }

}
