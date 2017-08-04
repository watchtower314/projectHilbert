package watchtower.escaperoom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Moore on 7/25/2017.
 */

public class Game {

    public static final String GAME_PREFS = "ProgressFile";
    protected static SharedPreferences gamePrefs;
    public static SharedPreferences.Editor progressEdit;
    public static int clueNum;
    public static final String CHECK_TAG = "check";
    public static final String NEXT_TAG = "next";
    public static final String DELETE = "delete";
    public static final String CANCEL = "cancel";
    public static final String EMER = "emergency";
    public static final String SCREEN = "screen";
    public static final String YELLOW_LOCK = "yellow";
    public static final long dot = 200, dash = 400, letter_gap=100, word_gap=300;
    public static Vibrator vib;// = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    public static MediaPlayer mediaPlayer;


    public static void updateSharedPref(Button b, int cNum)
    {

        clueNum = cNum;
       // gamePrefs = getSharedPreferences(GAME_PREFS,0);
        progressEdit = gamePrefs.edit();
        progressEdit.putInt("currentClue",cNum);
        progressEdit.commit();
        b.setBackgroundResource(R.drawable.androidunlockg1);
        b.setEnabled(true);
    }

    public static void whichScreen(int num)
    {


        progressEdit = gamePrefs.edit();
        progressEdit.putInt("screen",num);
        progressEdit.commit();
    }



    public static void getClue(int id, Context context)
    {
        switch (id)
        {
            case R.id.first:
            {
                Intent intent = new Intent(context, FirstClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.second:
            {
                Intent intent = new Intent(context, SecondClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.third:
            {
                Intent intent = new Intent(context, ThirdClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.fourth:
            {
                Intent intent = new Intent(context, ForthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.fifth:
            {
                Intent intent = new Intent(context, FifthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.sixth:
            {
                Intent intent = new Intent(context, SixthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.seventh:
            {
                Intent intent = new Intent(context, SeventhClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.eighth:
            {
                Intent intent = new Intent(context, EighthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.ninth:
            {
                Intent intent = new Intent(context, Morsing.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.tenth:
            {
                Intent intent = new Intent(context, TenthClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.eleventh:
            {
                Intent intent = new Intent(context, EleventhClue.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            }
            case R.id.twelfth:
            {
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
