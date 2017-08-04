package watchtower.escaperoom;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AppStore extends AppCompatActivity {

    final long [] toilet = {0, Game.dash, Game.word_gap,//t
    Game.dash, Game.letter_gap, Game.dash, Game.letter_gap, Game.dash, Game.word_gap,//o
    Game.dot, Game.letter_gap, Game.dot, Game.word_gap, //i
    Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.letter_gap, Game.dot, Game.word_gap,//l
    Game.dot, Game.word_gap,//e
    Game.dash, Game.word_gap};//t
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_store_screen);
        Log.d("TKT_appStore","onCreate");
    }

    public void morse(View v)
    {
        Log.d("TKT_appStore","morse");
        Game.vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        Game.vib.vibrate(toilet,-1);
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_appStore","onBackPressed");
        Game.vib.cancel();
        super.onBackPressed();
    }
}
