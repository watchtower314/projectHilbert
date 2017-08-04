package watchtower.escaperoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SettingsScreen extends AppCompatActivity {

    RelativeLayout screen;
    Button airplaneMode;
    boolean show = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        Log.d("TKT_settings","onCreate");
        screen = (RelativeLayout)findViewById(R.id.settingLayout);
        airplaneMode = (Button)findViewById(R.id.iSettingsButton);
    }

    public void setAirplaneMode(View v)
    {
        Log.d("TKT_settings","setAirplaneMode");
        if(!show)
        {
            Log.d("TKT_settings","landMode");
            screen.setBackgroundResource(R.drawable.settings1);
            show = true;
        }
        else
        {
            Log.d("TKT_settings","airplaneMode");
            screen.setBackgroundResource(R.drawable.settings);
            show = false;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_settings","onBackPressed");
        super.onBackPressed();
    }
}
