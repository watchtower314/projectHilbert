package watchtower.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class WelcomeAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void connectWhatsapp(View v)
    {//TODO: check if this opens the whatsapp group,
        goToUrl("https://chat.whatsapp.com/CpmlLGBke45CZpuUKlxpTF");
    }

    public void goToUrl(String url)
    {
        /*
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
        */
        Log.d("TKT", "here should be the whatsapp connection, there will be instructions of how to proceed");
        Intent intent = new Intent(this, ClueAct.class);
        startActivity(intent);
    }
}
