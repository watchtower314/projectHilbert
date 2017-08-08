package watchtower.escaperoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class NotesScreen extends AppCompatActivity {

    Button enterCMD, quitCMD;
    RelativeLayout screen;
    boolean show = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_screen);
        Log.d("TKT_notes", "onCreate");
        enterCMD = (Button)findViewById(R.id.iCalendarButton);
        quitCMD = (Button)findViewById(R.id.cmdButton);
        screen = (RelativeLayout)findViewById(R.id.notesId);
        enterCMD.setEnabled(true);
        quitCMD.setEnabled(false);

    }

    public void pressButton(View v)
    {
        if(!show) {
            Log.d("TKT_notes", "enterCmd");
            screen.setBackgroundResource(R.drawable.notes1);
            enterCMD.setEnabled(false);
            quitCMD.setEnabled(true);
            show = true;
        }
        else
        {
            Log.d("TKT_notes", "quitCmd");
            screen.setBackgroundResource(R.drawable.notes);
            enterCMD.setEnabled(true);
            quitCMD.setEnabled(false);
            show = false;
        }
    }



    @Override
    public void onBackPressed() {
        Log.d("TKT_notes", "onBackPressed");
        super.onBackPressed();
    }
}
