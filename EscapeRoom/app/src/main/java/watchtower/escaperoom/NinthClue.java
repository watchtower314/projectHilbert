package watchtower.escaperoom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class NinthClue extends AppCompatActivity{


    long [] knocks = new long [3];
    int [][] pushed = new int [5][6];
    final int [] [] intendedPush = {{1,1,1,1,0,1},
                                    {0,0,0,1,0,1},
                                    {1,1,1,1,0,1},
                                    {0,0,0,1,0,1},
                                    {1,1,1,1,0,1}};
    Button lock, nine1,nine2, nine3, nine4, nine5, nine6, nine7, nine8, nine9, nine10, nine11, nine12, nine13, nine14, nine15, nine16, nine17, nine18, nine19, nine20, nine21, nine22, nine23, nine24, nine25, nine26, nine27, nine28, nine29, nine30;
    ImageButton knock;
    Context c;
    final int clue = 9;
    int count = 0;
    RelativeLayout otherScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_clue);
        Log.d("TKT9","onCreate");
        c = this;
        lock = (Button)findViewById(R.id.lockButtonDoor);
        knock = (ImageButton)findViewById(R.id.knockKnockKnock);
        otherScreen = (RelativeLayout)findViewById(R.id.matchPatternLayout);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS, 0);
        int clues = Game.gamePrefs.getInt("currentClue", 0);
        if(clues > clue)
            disableEditText();
        //initButtons();
        //knocks[0] = System.currentTimeMillis();
    }


    public void initButtons(Dialog dialog)
    {
        otherScreen = (RelativeLayout)dialog.findViewById(R.id.matchPatternLayout);
        nine1 = (Button)dialog.findViewById(R.id.nine1);
        nine2 = (Button)dialog.findViewById(R.id.nine2);
        nine3 = (Button)dialog.findViewById(R.id.nine3);
        nine4 = (Button)dialog.findViewById(R.id.nine4);
        nine5 = (Button)dialog.findViewById(R.id.nine5);
        nine6 = (Button)dialog.findViewById(R.id.nine6);
        nine7 = (Button)dialog.findViewById(R.id.nine7);
        nine8 = (Button)dialog.findViewById(R.id.nine8);
        nine9 = (Button)dialog.findViewById(R.id.nine9);
        nine10 = (Button)dialog.findViewById(R.id.nine10);
        nine11 = (Button)dialog.findViewById(R.id.nine11);
        nine12 = (Button)dialog.findViewById(R.id.nine12);
        nine13 = (Button)dialog.findViewById(R.id.nine13);
        nine14 = (Button)dialog.findViewById(R.id.nine14);
        nine15 = (Button)dialog.findViewById(R.id.nine15);
        nine16 = (Button)dialog.findViewById(R.id.nine16);
        nine17 = (Button)dialog.findViewById(R.id.nine17);
        nine18 = (Button)dialog.findViewById(R.id.nine18);
        nine19 = (Button)dialog.findViewById(R.id.nine19);
        nine20 = (Button)dialog.findViewById(R.id.nine20);
        nine21 = (Button)dialog.findViewById(R.id.nine21);
        nine22 = (Button)dialog.findViewById(R.id.nine22);
        nine23 = (Button)dialog.findViewById(R.id.nine23);
        nine24 = (Button)dialog.findViewById(R.id.nine24);
        nine25 = (Button)dialog.findViewById(R.id.nine25);
        nine26 = (Button)dialog.findViewById(R.id.nine26);
        nine27 = (Button)dialog.findViewById(R.id.nine27);
        nine28 = (Button)dialog.findViewById(R.id.nine28);
        nine29 = (Button)dialog.findViewById(R.id.nine29);
        nine30 = (Button)dialog.findViewById(R.id.nine30);
    }
    public boolean colorButton(Button b, int row, int col)
    {
        Log.d("TKT9","colorButton");
        ColorDrawable currColor = (ColorDrawable) b.getBackground();
        if(currColor.getColor() == ContextCompat.getColor(c,R.color.gray)) {
            b.setBackgroundColor(ContextCompat.getColor(this, R.color.black_overlay));
            pushed[row][col] = 1;
            count++;
            Log.d("TKT9","count = "+count);
            Log.d("TKT9","color changed to black_overlay");
        }
        else {
            b.setBackgroundColor(ContextCompat.getColor(c, R.color.gray));
            pushed[row][col] = 0;
            count--;
            Log.d("TKT9","color changed to gray");
        }
        if(count == 19)
            return(checkFinish());
        else
            return false;
    }
    public boolean checkFinish()
    {
        Log.d("TKT9","checkFinish");
        for(int i=0; i<pushed.length; i++)
        {
            for(int j=0; j<pushed[0].length; j++)
            {
                Log.d("TKT9","i: "+i+", j: "+j);
                Log.d("TKT9","pushed[i][j]: "+pushed[i][j]+", intendedPushed[i][j]: "+intendedPush[i][j]);
                if(pushed[i][j] != intendedPush[i][j]) {
                    Log.d("TKT9","return false");
                    return false;//pattern is not 31
                }
            }
        }
        Log.d("TKT9","return true");
        return true;//pattern is 31
    }

    public void unlockDoor(View v)
    {
            Log.d("TKT9","showDialogMessage was called");
            //setContentView(R.layout.enter_password)
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.pattern_match);
            dialog.setCanceledOnTouchOutside(false);//// TODO: 8/6/2017 consider losing


        //FIRST LINE
        //NINE1--------------------------------------------------

        initButtons(dialog);
            nine1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TKT9", "onClick button nine1");
                    if(colorButton(nine1, 0,0))
                    {
                        nextClue(dialog);
                    }
                }
            });
        //NINE2---------------------------------------------------
        nine2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine2");
                if(colorButton(nine2, 0,1))
                {
                    nextClue(dialog);
                }
            }
        });


        //NINE3-----------------------------------------------------
        nine3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine3");
                if(colorButton(nine3, 0,2))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE4-----------------------------------------------------
        nine4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine4");
                if(colorButton(nine4, 0,3))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE5-----------------------------------------------------
        nine5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine5");
                if(colorButton(nine5, 0,4))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE6--------------------------------------------------
        nine6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine6");
                if(colorButton(nine6, 0,5))
                {
                    nextClue(dialog);
                }
            }
        });


        //2nd LINE================================================================
        //NINE7---------------------------------------------------
        nine7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine7");
                if(colorButton(nine7, 1,0))
                {
                    nextClue(dialog);
                }
            }
        });


        //NINE8-----------------------------------------------------
        nine8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine8");
                if(colorButton(nine8, 1,1))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE9-----------------------------------------------------
        nine9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine9");
                if(colorButton(nine9, 1,2))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE10-----------------------------------------------------
        nine10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine10");
                if(colorButton(nine10, 1,3))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE11--------------------------------------------------
        nine11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine11");
                if(colorButton(nine11, 1,4))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE12---------------------------------------------------
        nine12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine12");
                if(colorButton(nine12, 1,5))
                {
                    nextClue(dialog);
                }
            }
        });

        //3rd LINE================================================================
        //NINE13-----------------------------------------------------
        nine13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine13");
                if(colorButton(nine13, 2,0))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE14-----------------------------------------------------
        nine14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine14");
                if(colorButton(nine14, 2,1))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE15-----------------------------------------------------
        nine15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine15");
                if(colorButton(nine15, 2,2))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE11--------------------------------------------------
        nine16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine16");
                if(colorButton(nine16, 2,3))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE17---------------------------------------------------
        nine17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine17");
                if(colorButton(nine17, 2,4))
                {
                    nextClue(dialog);
                }
            }
        });


        //NINE18-----------------------------------------------------
        nine18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine18");
                if(colorButton(nine18, 2,5))
                {
                    nextClue(dialog);
                }
            }
        });


        //4th LINE================================================================

        //NINE19-----------------------------------------------------
        nine19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine19");
                if(colorButton(nine19, 3,0))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE20-----------------------------------------------------
        nine20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine20");
                if(colorButton(nine20, 3,1))
                {
                    nextClue(dialog);
                }
            }
        });


        //NINE21--------------------------------------------------
        nine21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine21");
                if(colorButton(nine21, 3,2))
                {
                    nextClue(dialog);
                }
            }
        });

        //NINE22---------------------------------------------------
        nine22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine22");
                if(colorButton(nine22, 3,3))
                {
                    nextClue(dialog);
                }
            }
        });


        //NINE23-----------------------------------------------------
        nine23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine23");
                if(colorButton(nine23, 3,4))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });

        //NINE24-----------------------------------------------------
        nine24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine24");
                if(colorButton(nine24, 3,5))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });

        //5th LINE================================================================

        //NINE25-----------------------------------------------------
        nine25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine25");
                if(colorButton(nine25, 4,0))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });

        //NINE26-----------------------------------------------------
        nine26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine26");
                if(colorButton(nine26, 4,1))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });

        //NINE27-----------------------------------------------------
        nine27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine27");
                if(colorButton(nine27, 4,2))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });

        //NINE28-----------------------------------------------------
        nine28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine28");
                if(colorButton(nine28, 4,3))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });


        //NINE29-----------------------------------------------------
        nine29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine29");
                if(colorButton(nine29, 4,4))
                {
                    nextClue(dialog);
                    //// TODO: 8/6/2017 go to clue screen
                }
            }
        });

        //NINE30-----------------------------------------------------
        nine30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TKT9", "onClick button nine30");
                if(colorButton(nine30, 4,5))
                {
                    nextClue(dialog);             //// TODO: 8/6/2017 go to clue screen
                }
            }
        });
        dialog.show();

    }

    public void knockKnockKnockPenny(View v)
    {
        Log.d("TKT9","knockKnockKnockPenny");

            Log.d("TKT9","countB4: "+count);
            knocks[count++] = System.currentTimeMillis();
            Log.d("TKT9","countAF: "+count);
            if(count == 3)
            {
                Log.d("TKT9","count = 3");
                count = 0;
                checkIntervals();
            }

    }

    public boolean checkIntervals()
    {
        Log.d("TKT9","checkInterval");
        long epsilon = 30;
        long firstInterval = knocks[1]-knocks[0];
        long secondInterval = knocks[2]-knocks[1];
        Log.d("TKT9","firstInterval: "+firstInterval);
        Log.d("TKT9","secondInterval: "+secondInterval);
        Log.d("TKT9","f-s: "+(firstInterval-secondInterval));
        if( Math.abs(firstInterval-secondInterval)<epsilon)
        {
            new CountDownTimer(1500,1000){
                public void onTick(long millisUntilFinish)
                {
                    Log.d("TKT9", "Time remaining: "+millisUntilFinish/1000);
                }
                public void onFinish()
                {
                    Log.d("TKT9", "finished");
                    knock.setEnabled(false);
                    lock.setVisibility(View.VISIBLE);
                }
            }.start();

            return true;
        }
        return false;



    }

    public void nextClue(final Dialog dialog)
    {
        Log.d("TKT9","nextClue was called");
        disableEditText();
        Game.updateSharedPref(ClueAct.clueButtons[clue], clue + 1);
        final Intent intent = new Intent(this, ClueAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        new CountDownTimer(2000,1000){
            public void onTick(long millisUntilFinish)
            {
                Log.d("TKT9", "Time remaining: "+millisUntilFinish/1000);
            }
            public void onFinish()
            {
                Log.d("TKT9", "finished");
                dialog.dismiss();
                startActivity(intent);
                finish();
            }
        }.start();



    }

    public void disableEditText()
    {
        lock.setVisibility(View.VISIBLE);
        lock.setEnabled(false);
        lock.setBackgroundResource(R.drawable.androidunlockg1);
        knock.setEnabled(false);
        /*
        nine1.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine2.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine3.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine4.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine6.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine10.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine12.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine13.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine14.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine15.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine16.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine18.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine22.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine24.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine25.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine26.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine27.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine28.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        nine30.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        */

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }


}
