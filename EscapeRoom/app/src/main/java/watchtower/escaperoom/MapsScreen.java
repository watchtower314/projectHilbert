package watchtower.escaperoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MapsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_screen);
        Log.d("TKT_maps","onCreate");
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_maps","onBackPressed");
        super.onBackPressed();
    }
}
