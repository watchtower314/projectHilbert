package watchtower.escaperoom;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import static watchtower.escaperoom.Game.mediaPlayer;

public class YouTubeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_screen);
        Log.d("TKT_youTube","onCreate");
        mediaPlayer = MediaPlayer.create(this,R.raw.yeahboy);

    }

    public void playMusic(View v)
    {
        Log.d("TKT_youTube","playMusic");
        switch (v.getId())
        {
            case R.id.YeahBoy:
            {
                Log.d("TKT_youTube","yeahBoy");
                stopMusic();
                mediaPlayer = MediaPlayer.create(this,R.raw.yeahboy);
                break;
            }
            case R.id.theWayITalk:
            {
                Log.d("TKT_youTube","theWayITalk");
                stopMusic();
                mediaPlayer = MediaPlayer.create(this,R.raw.thewayitalk);
                break;
            }
            case R.id.nightMoves:
            {
                Log.d("TKT_youTube","nightMoves");
                stopMusic();
                mediaPlayer = MediaPlayer.create(this,R.raw.nightmoves);
                break;
            }
            case R.id.wakeMeUp:
            {
                Log.d("TKT_youTube","wakeMeUp");
                stopMusic();
                mediaPlayer = MediaPlayer.create(this,R.raw.wakemeup);
                break;
            }
            case R.id.carryOn:
            {
                Log.d("TKT_youTube","carryOn");
                stopMusic();
                mediaPlayer = MediaPlayer.create(this,R.raw.carryon);
                break;
            }
        }
        mediaPlayer.start();
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
        Log.d("TKT_youTube","onBackPressed");
        stopMusic();
        mediaPlayer.release();
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        Log.d("TKT_youTube","onPause");
        mediaPlayer.release();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("TKT_youTube","onStop");
        mediaPlayer.release();
        super.onStop();
    }
}
