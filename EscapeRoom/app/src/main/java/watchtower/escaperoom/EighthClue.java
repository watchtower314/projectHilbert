package watchtower.escaperoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class EighthClue extends AppCompatActivity {

    public Button  iMessage, iCalendar, iNotes, iList, iMaps, iClock, LinkedIn, whatsApp, iContacts, appStore, youTube, iCamara, iSettings, Wolfram, weather, iPhotos, iPhone, Safari, Gmail, iMusic;
    RelativeLayout screen;
    boolean out = true;
    public static int clue = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_clue);
        iMessage = (Button)findViewById(R.id.iMessage);
        iCalendar = (Button)findViewById(R.id.calendar);
        iNotes = (Button)findViewById(R.id.notes);
        iList = (Button)findViewById(R.id.list);
        iMaps = (Button)findViewById(R.id.maps);
        iClock = (Button)findViewById(R.id.clock);
        LinkedIn = (Button)findViewById(R.id.linkedIn);
        whatsApp = (Button)findViewById(R.id.whatsapp);
        iContacts = (Button)findViewById(R.id.contacts);
        appStore = (Button)findViewById(R.id.appStore);
        youTube = (Button)findViewById(R.id.youtube);
        iCamara = (Button)findViewById(R.id.camera);
        iSettings = (Button)findViewById(R.id.settings);
        Wolfram = (Button)findViewById(R.id.wolfram);
        weather = (Button)findViewById(R.id.weather);
        iPhotos = (Button)findViewById(R.id.photos);
        iPhone = (Button)findViewById(R.id.phone);
        Safari = (Button)findViewById(R.id.safari);
        Gmail = (Button)findViewById(R.id.gmail);
        iMusic = (Button)findViewById(R.id.music);
        //backArrow = (Button)findViewById(R.id.yellowArrow);
        Log.d("TKT8", "onCreate");
        screen = (RelativeLayout)findViewById(R.id.homeScreen);
        Game.gamePrefs = getSharedPreferences(Game.GAME_PREFS, 0);
        int clues = Game.gamePrefs.getInt(Game.CURRENT_CLUE, 0);
        Log.d("TKT8","clues: "+clues);


        if(clues > clue)
            disableButtons();
        else
            hangOn(R.string.message);

    }




    public void appPressed(View v)
    {
        Log.d("TKT8", "appPressed");
        switch(v.getId())
        {

            case R.id.iMessage:
            {

                Log.d("TKT8", "iMessage pressed");
                Intent intent = new Intent(this, MessageScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.calendar:
            {
                Log.d("TKT8", "iCalendar pressed");
                Intent intent = new Intent(this, CalendaerScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.notes:
            {
                Log.d("TKT8", "iNotes pressed");
                Intent intent = new Intent(this, NotesScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.list:
            {
                Log.d("TKT8", "iList pressed");
                Intent intent = new Intent(this, ListScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.maps:
            {
                Log.d("TKT8", "iMaps pressed");
                Intent intent = new Intent(this, MapsScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.clock:
            {
                Log.d("TKT8", "iClock pressed");
                Intent intent = new Intent(this, ClockScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.linkedIn:
            {
                Log.d("TKT8", "LinkedIn pressed");
                Intent intent = new Intent(this, LinkedInScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.whatsapp:
            {
                Log.d("TKT8", "whatsapp pressed");
                Intent intent = new Intent(this, WhatsAppScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.contacts:
            {
                Log.d("TKT8", "iContacts pressed");
                Intent intent = new Intent(this, ContactsScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.appStore:
            {
                Log.d("TKT8", "appStore pressed");
                Intent intent = new Intent(this, AppStore.class);
                startActivity(intent);
                break;
            }
            case R.id.youtube:
            {
                Log.d("TKT8", "youtube pressed");
                Intent intent = new Intent(this, YouTubeScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.camera:
            {
                hangOn(R.string.denied);
                break;
            }
            case R.id.settings:
            {
                Log.d("TKT8", "iSettings pressed");
                Intent intent = new Intent(this, SettingsScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.wolfram:
            {
                Log.d("TKT8", "wolfram pressed");
                Intent intent = new Intent(this, Wolfram.class);
                startActivity(intent);
                break;
            }
            case R.id.weather:
            {
                Log.d("TKT8", "weather pressed");
                Intent intent = new Intent(this, WeatherScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.photos:
            {
                Log.d("TKT8", "iPhotos pressed");
                Intent intent = new Intent(this, PhotoScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.phone:
            {
                Log.d("TKT8", "iPhone pressed");
                Intent intent = new Intent(this, CallScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.safari:
            {
                Log.d("TKT8", "safari pressed");
                Intent intent = new Intent(this, SafariScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.gmail:
            {
                Log.d("TKT8", "gmail pressed");
                Intent intent = new Intent(this, GmailScreen.class);
                startActivity(intent);
                break;
            }
            case R.id.music:
            {
                Log.d("TKT8", "iMusic pressed");
                Intent intent = new Intent(this, MusicScreen.class);
                startActivity(intent);
                break;
            }

        }
    }


    public void disableButtons()
    {
        iMessage.setEnabled(false);
        iCalendar.setEnabled(false);
        iNotes.setEnabled(false);
        iList.setEnabled(false);
        iMaps.setEnabled(false);
        iClock.setEnabled(false);
        LinkedIn.setEnabled(false);
        whatsApp.setEnabled(false);
        iContacts.setEnabled(false);
        appStore.setEnabled(false);
        youTube.setEnabled(false);
        iCamara.setEnabled(false);
        iSettings.setEnabled(false);
        Wolfram.setEnabled(false);
        weather.setEnabled(false);
        iPhotos.setEnabled(false);
        iPhone.setEnabled(false);
        Safari.setEnabled(false);
        Gmail.setEnabled(false);
        iMusic.setEnabled(false);
    }

    public void hangOn(int mensaje)
    {
        Log.d("TKT7", "hangOn message is shows");
        AlertDialog.Builder message = new AlertDialog.Builder(this);
        message.setMessage(mensaje).create();
        message.show();
    }



}
