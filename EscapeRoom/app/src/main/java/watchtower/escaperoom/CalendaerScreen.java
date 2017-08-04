package watchtower.escaperoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CalendaerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendaer_screen);
        Log.d("TKT_calendar","onCreate");
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_calendar","onBackPressed");
        super.onBackPressed();
    }
}
