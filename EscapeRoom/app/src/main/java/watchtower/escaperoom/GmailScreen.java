package watchtower.escaperoom;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class GmailScreen extends AppCompatActivity {

    RelativeLayout screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_screen);
        screen = (RelativeLayout)findViewById(R.id.gmailLayout);
        Log.d("TKT_gmail","onCreate");

        screen.setBackgroundResource(R.drawable.gmail);
        new CountDownTimer(2000,1000){
            public void onTick(long millisUntilFinish)
            {
                Log.d("TKT_gmail", "Time remaining: "+millisUntilFinish/1000);
            }
            public void onFinish()
            {
                Log.d("TKT_gmail", "finished");
                screen.setBackgroundResource(R.drawable.gmail1);
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_gmail","onBackPressed");
        super.onBackPressed();
    }
}
