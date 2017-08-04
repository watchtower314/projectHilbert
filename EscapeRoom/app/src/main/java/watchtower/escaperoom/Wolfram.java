package watchtower.escaperoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Wolfram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wolfram);
        Log.d("TKT_wolfram","onCreate");
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_wolfram","onBackPressed");
        super.onBackPressed();
    }
}
