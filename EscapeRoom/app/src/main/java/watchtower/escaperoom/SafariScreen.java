package watchtower.escaperoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SafariScreen extends AppCompatActivity {

    RelativeLayout screen;
    Button chanceButton;
    final int [] keyboards = {R.drawable.safarihebrew, R.drawable.safarifrench, R.drawable.safariemoji, R.drawable.safarigerman, R.drawable.safarigreek, R.drawable.safariitalian, R.drawable.safarispanish};
    int screenNum = 0;
    final int size = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safari_screen);
        screen = (RelativeLayout)findViewById(R.id.safariLayout);
        Log.d("TKT_safari","onCreate");
    }

    public void changeKeyboard(View v)
    {
        Log.d("TKT_safari","changeKeyboard");
        screen.setBackgroundResource(keyboards[screenNum%size]);
        screenNum++;
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_safari","onBackPressed");
        super.onBackPressed();
    }
}
