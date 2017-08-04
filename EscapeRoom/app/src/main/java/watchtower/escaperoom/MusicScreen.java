package watchtower.escaperoom;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import static watchtower.escaperoom.Game.mediaPlayer;

public class MusicScreen extends AppCompatActivity {
    RelativeLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_screen);
        screen = (RelativeLayout)findViewById(R.id.musicLayout);
        mediaPlayer = MediaPlayer.create(this,R.raw.wastedtime);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                screen.setBackgroundResource(R.drawable.music);
            }
        });
        Log.d("TKT_music","onCreate");
    }

    public void playMusic(View v)
    {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
            screen.setBackgroundResource(R.drawable.music);
        }
        else
        {
            mediaPlayer.start();
            screen.setBackgroundResource(R.drawable.music1);
        }

    }



    public void stopMusic()
    {
        Log.d("TKT_youTube","stopMusic");
        if(mediaPlayer.isPlaying()) {
            Log.d("TKT_youTube","music is playing - stop it");
            mediaPlayer.stop();
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_music","onBackPressed");
        stopMusic();
        mediaPlayer.release();
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        Log.d("TKT_music","onPause");
        mediaPlayer.release();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("TKT_music","onStop");
        mediaPlayer.release();
        super.onStop();
    }
}
