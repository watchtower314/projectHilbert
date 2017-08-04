package watchtower.escaperoom;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class LinkedInScreen extends AppCompatActivity {

    RelativeLayout screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_in_screen);
        screen = (RelativeLayout)findViewById(R.id.linkedInLayout);
        Log.d("TKT_linkedIn", "onCreate");

        new CountDownTimer(2000,1000){
            public void onTick(long millisUntilFinish)
            {
                Log.d("TKT_linkedIn", "Time remaining: "+millisUntilFinish/1000);
            }
            public void onFinish()
            {
                Log.d("TKT_linkedIn", "finished");
                screen.setBackgroundResource(R.drawable.linkedin1);
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_linkedIn", "onBackPressed");
        super.onBackPressed();
    }
}
