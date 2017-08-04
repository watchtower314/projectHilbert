package watchtower.escaperoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class WeatherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_screen);
        Log.d("TKT_weather","onCreate");
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_weather","onBackPressed");
        super.onBackPressed();
    }
}
