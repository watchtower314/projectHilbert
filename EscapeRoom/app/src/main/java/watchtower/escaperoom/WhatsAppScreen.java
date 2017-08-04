package watchtower.escaperoom;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WhatsAppScreen extends AppCompatActivity {

    Button morseButton;
    final long [] porch = {0, Game.dash, Game.letter_gap, Game.dash, Game.word_gap,//m
    Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.word_gap,//r
    Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.word_gap,//p
    Game.dash, Game.letter_gap, Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot, Game.word_gap,//s
    Game.dash, Game.word_gap};//t

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app_screen);
        Log.d("TKT_whatsApp","onBackPressed");
    }

    public void morse(View v)
    {
        Log.d("TKT_whatsApp","morse");
        Game.vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        Game.vib.vibrate(porch,-1);
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_whatsApp","onBackPressed");
        Game.vib.cancel();
        super.onBackPressed();
    }
}
