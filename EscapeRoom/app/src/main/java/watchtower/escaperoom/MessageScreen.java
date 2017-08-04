package watchtower.escaperoom;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MessageScreen extends AppCompatActivity {

    Button morseButton;
    final long [] carpintry = {0, Game.dash, Game.letter_gap, Game.dot, Game.word_gap,//n
            Game.dash, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.word_gap,//g
            Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.word_gap,//r
            Game.dot, Game.letter_gap, Game.dot, Game.word_gap,//i
            Game.dash, Game.letter_gap, Game.dash, Game.letter_gap, Game.dash, Game.word_gap};//h

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);
        morseButton = (Button)findViewById(R.id.iMusicButton);
        Log.d("TKT_message","onBackPressed");
    }

    public void morse(View v)
    {
        Log.d("TKT_message","morse");
        Game.vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        Game.vib.vibrate(carpintry,-1);
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_message","onBackPressed");
        Game.vib.cancel();
        super.onBackPressed();
    }
}
