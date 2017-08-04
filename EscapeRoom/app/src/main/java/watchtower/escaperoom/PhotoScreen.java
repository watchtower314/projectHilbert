package watchtower.escaperoom;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class PhotoScreen extends AppCompatActivity {

    RelativeLayout screen;
    Button morseButton;
    final long [] benNJerrys15 ={0,Game.dash,Game.letter_gap, Game.dot, Game.letter_gap, Game.dot, Game.letter_gap, Game.dot, Game.word_gap,//b
            Game.dot,Game.word_gap,//e
            Game.dash,Game.letter_gap, Game.dot,Game.word_gap,//n
            Game.dash,Game.letter_gap,  Game.dot,Game.word_gap,//n
            Game.dash,Game.letter_gap,  Game.dash,Game.letter_gap, Game.dot,Game.word_gap,//j
            Game.dot, Game.word_gap,//e
            Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot,Game.word_gap, //r
            Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dot,Game.word_gap,//r
            Game.dash, Game.letter_gap, Game.dot, Game.letter_gap, Game.dash, Game.letter_gap, Game.dash,Game.word_gap,//y
            Game.dot, Game.letter_gap, Game.dot, Game.letter_gap, Game.dot, Game.word_gap};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_screen);
        Log.d("TKT_photo","onCreate");
        screen = (RelativeLayout)findViewById(R.id.photosLayout);
        morseButton = (Button)findViewById(R.id.iPhotosButton);
        Game.vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void morse(View v)
    {
        Log.d("TKT_photo","morse bennjerrys");
        Game.vib.vibrate(benNJerrys15,-1);
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_photo","onBackPressed");
        super.onBackPressed();
    }
}
