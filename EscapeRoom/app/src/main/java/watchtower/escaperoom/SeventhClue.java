package watchtower.escaperoom;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SeventhClue extends AppCompatActivity {

    static Button check;
    public final int clue = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_clue);

        check = (Button) findViewById(R.id.sixthContinue);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS, 0);
        int clues = Game.gamePrefs.getInt("currentClue", 0);
        Log.d("TKT7", "onCreate");

        if (clues > clue) {
            check.setBackgroundResource(R.drawable.arrowy);
            check.setTag("next");
        }
    }

    public void nextStep(View v)
    {
        Log.d("TKT7", "nextStep was pressed");
        String tag = v.getTag().toString();
        if(tag.equals("bluetick"))
        {
            Log.d("TKT7", "tag = bluetick");
            check.setBackgroundResource(R.drawable.tickc);
            Snackbarring(R.string.wait, (RelativeLayout)findViewById(R.id.circles));
            check.setTag("next");
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
        }
        else
        {
            Log.d("TKT7", "tag = next");
            nextClue();
        }

    }

    public static void Snackbarring(int message, RelativeLayout activity)
    {
        Log.d("TKT7", "snackbarring was called");
        Snackbar error = Snackbar.make(activity, message, Snackbar.LENGTH_LONG);
        View errorView = error.getView();
        errorView.setBackgroundColor(Color.DKGRAY);
        TextView textView = (TextView)errorView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        error.show();

        error.setCallback(new Snackbar.Callback() {

            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                if (event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                    check.setBackgroundResource(R.drawable.arrowy);
                }
            }

            @Override
            public void onShown(Snackbar snackbar) {
            }
        });
    }







    public void nextClue()
    {
        Log.d("TKT7", "nextClue was called");
        Intent intent = new Intent(this, ClueAct.class);
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


}
