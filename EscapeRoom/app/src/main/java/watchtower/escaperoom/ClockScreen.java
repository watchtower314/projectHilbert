package watchtower.escaperoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ClockScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_screen);
        Log.d("TKT_clock", "onCreate");
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_clock", "onBackPressed");
        super.onBackPressed();
    }
}
