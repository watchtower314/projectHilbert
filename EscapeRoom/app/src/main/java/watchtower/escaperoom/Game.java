package watchtower.escaperoom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Moore on 7/25/2017.
 */

public class Game {

    protected static SharedPreferences gamePrefs;
    public static SharedPreferences.Editor progressEdit;
    //shared prefs----------------------------------------------
    public static final String GAME_PREFS = "ProgressFile";
    public static final String EIGHT_PASSED = "eightPassed";
    public static int clueNum;
    public static String CURRENT_CLUE = "currentClue";

    //tags------------------------------------------------------
    public static final String CHECK_TAG = "check";//clues: 1, 2, 6
    public static final String NEXT_TAG = "next";//clues: 1, 2, 6
    //clue 7
    public static final String DELETE_TAG = "delete";
    public static final String CANCEL_TAG = "cancel";
    public static final String EMERGENCY_TAG = "emergency";


    //clueAct
    public static final String YELLOW_LOCK_TAG = "yellow";
    public static final String READY_TAG = "ready";

    //clue 5
    public static final String ARROWY_TAG = "arrowy"; //:= arrow yellow
    public static final String BLUE_TICK="bluetick";

    //eight clue
    public static final long dot = 200, dash = 400, letter_gap=100, word_gap=300;
    public static Vibrator vib;// = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    public static MediaPlayer mediaPlayer;


    //public static final String SCREEN = "screen";
    public static void updateSharedPref(Button b, int cNum)
    {
        Log.d("TKT_game","updateSharedPref clue num: "+cNum);
        clueNum = cNum;
       // gamePrefs = getSharedPreferences(GAME_PREFS,0);
        progressEdit = gamePrefs.edit();
        progressEdit.putInt("currentClue",cNum);
        progressEdit.commit();
        b.setBackgroundResource(R.drawable.androidunlockg1);
        b.setEnabled(true);
    }

    public static void updateEightNineClues()
    {
        Log.d("TKT_game","updateEightNineClue");
        progressEdit = gamePrefs.edit();
        progressEdit.putBoolean(EIGHT_PASSED,true);
        progressEdit.commit();
    }

    /*
    public static void whichScreen(int num)
    {

        progressEdit = gamePrefs.edit();
        progressEdit.putInt("screen",num);
        progressEdit.commit();
    }
    */



    public static void getClue(int id, Context context)
    {
        Log.d("TKT_game","getClue");
        switch (id)
        {
            case R.id.first:
            {
                Log.d("TKT_game","first clue");
                Intent intent = new Intent(context, FirstClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.second:
            {
                Log.d("TKT_game","second clue");
                Intent intent = new Intent(context, SecondClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.third:
            {
                Log.d("TKT_game","third clue");
                Intent intent = new Intent(context, ThirdClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.fourth:
            {
                Log.d("TKT_game","fourth clue");
                Intent intent = new Intent(context, ForthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.fifth:
            {
                Log.d("TKT_game","fifth clue");
                Intent intent = new Intent(context, FifthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.sixth:
            {
                Log.d("TKT_game","sixth clue");
                Intent intent = new Intent(context, SixthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.seventh:
            {
                Log.d("TKT_game","seventh clue");
                Intent intent = new Intent(context, SeventhClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.eighth:
            {
                Log.d("TKT_game","eight clue");
                Intent intent = new Intent(context, EighthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.ninth:
            {
                Log.d("TKT_game","ninth clue");
                Intent intent = new Intent(context, NinthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.tenth:
            {
                Log.d("TKT_game","tenth clue");
                Intent intent = new Intent(context, TenthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.eleventh:
            {
                Log.d("TKT_game","eleventh clue");
                Intent intent = new Intent(context, EleventhClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.twelfth:
            {
                Log.d("TKT_game","twelfth clue");
                Intent intent = new Intent(context, TwelfthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
        }
    }


    public static void getSnackbar(int message, RelativeLayout activity)
    {
        Log.d("TKT_game","getSnackBar");
        Snackbar error = Snackbar.make(activity, message, Snackbar.LENGTH_LONG);
        View errorView = error.getView();
        errorView.setBackgroundColor(Color.DKGRAY);
        TextView textView = (TextView)errorView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        error.show();
    }

    public static void firstClueEditTexts(String red1, String blue1, String red2, String blue2)
    {
        progressEdit = gamePrefs.edit();
        progressEdit.putString("red1", red1);
        progressEdit.putString("blue1", blue1);
        progressEdit.putString("red2", red2);
        progressEdit.putString("blue2", blue2);
        progressEdit.commit();
    }




}
