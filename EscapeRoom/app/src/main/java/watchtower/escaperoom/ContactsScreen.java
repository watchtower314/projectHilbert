package watchtower.escaperoom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ContactsScreen extends AppCompatActivity {

    Button contactButton;
    RelativeLayout screen;
    boolean show = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_screen);
        contactButton = (Button)findViewById(R.id.iContactsButton);
        screen = (RelativeLayout)findViewById(R.id.contactsLayout);
        Log.d("TKT_contacts","onCreate");
    }

    public void enterJerk(View v)
    {
        if(!show)
        {
            Log.d("TKT_contacts","show Jerk");
            screen.setBackgroundResource(R.drawable.contacts1);
            show = true;
        }
        else
        {
            Log.d("TKT_contacts","hide jerk");
            screen.setBackgroundResource(R.drawable.contacts);
            show = false;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("TKT_contacts","onBackPressed");
        super.onBackPressed();
    }
}
