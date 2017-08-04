package watchtower.escaperoom;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CallScreen extends AppCompatActivity {

    final long [] olive = {Game.dash, Game.letter_gap, Game.dash, Game.letter_gap, Game.dash, Game.word_gap,//o
            Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.letter_gap, Game.dot, Game.word_gap,//l
            Game.dot, Game.letter_gap, Game.dot, Game.word_gap, //i
            Game.dot, Game.letter_gap, Game.dot, Game.letter_gap, Game.dot, Game.letter_gap, Game.dash, Game.word_gap,//v
            Game.dot, Game.word_gap,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_screen);
        Log.d("TKT_call","onCreate");
    }

    public void morse(View v)
    {
        Log.d("TKT_Call","morse");
        Game.vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        Game.vib.vibrate(olive,-1);
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_call","onBackPressed");
        Game.vib.cancel();
        super.onBackPressed();
    }
}
