package watchtower.escaperoom;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SeventhClue extends AppCompatActivity {

    static Button check;
    TextView process;
    public final int clue = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_clue);

        check = (Button) findViewById(R.id.sixthContinue);
        process = (TextView) findViewById(R.id.processing);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS, 0);
        int clues = Game.gamePrefs.getInt("currentClue", 0);
        System.out.println("this is clues: " + clues);
        System.out.println("got here now");

        if (clues > clue) {
            check.setBackgroundResource(R.drawable.arrowy);
            check.setTag("next");
        }
    }

    public void nextStep(View v)
    {
        long sec = 3000;
        String tag = v.getTag().toString();
        System.out.println("tag: "+tag);
        if(tag.equals("bluetick"))
        {
            check.setBackgroundResource(R.drawable.tickc);
            Snackbarring(R.string.wait, (RelativeLayout)findViewById(R.id.circles));
            check.setTag("next");
        }
        else
        {
            Game.updateSharedPref(ClueAct.clueButtons[clue], clue+1);
            nextClue(v);
        }

    }

    public static void Snackbarring(int message, RelativeLayout activity)
    {
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







    public void nextClue(View v)
    {
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
