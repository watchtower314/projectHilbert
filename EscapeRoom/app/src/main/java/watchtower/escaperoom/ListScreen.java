package watchtower.escaperoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class ListScreen extends AppCompatActivity {

    public boolean show = false;
    RelativeLayout screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);
        Log.d("TKT_list","onCreate");
        screen = (RelativeLayout)findViewById(R.id.listScreenLayout);
    }


    public void showCompleted(View v)
    {
        if(!show)
        {
            screen.setBackgroundResource(R.drawable.list1);
            show = true;
        }
        else
        {
            screen.setBackgroundResource(R.drawable.list);
            show = false;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_list","onBackPressed");
        super.onBackPressed();
    }
}
