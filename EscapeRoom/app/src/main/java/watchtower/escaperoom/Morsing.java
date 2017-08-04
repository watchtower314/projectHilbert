package watchtower.escaperoom;

import android.support.v7.app.AppCompatActivity;

public class Morsing extends AppCompatActivity {
/*
    RelativeLayout screen;
    public final int clue = 9;
    int enable = 0;
    Vibrator vib;
    final long dot = 200, dash = 400, letter_gap=100, word_gap=300;
    //Button iMessage, iCalendar, iNote, iList, iMaps, iClock, linkedIn, whatsApp, iContacts, appStore, youTube, iSettings,wolfram, weather, iPhotos, iPhone, safari, gmail, iMusic;
    Button [] buttons = new Button[20];
    final long [] benNJerrys15 ={0,dash,letter_gap, dot, letter_gap, dot, letter_gap, dot, word_gap,//b
            dot,word_gap,//e
            dash,letter_gap, dot,word_gap,//n
            dash,letter_gap,  dot, word_gap,//n
            dash,letter_gap,  dash,letter_gap, dot,word_gap,//j
            dot, word_gap,//e
            dot, letter_gap, dash, letter_gap, dot,word_gap, //r
            dot, letter_gap, dash, letter_gap, dot,word_gap,//r
            dash, letter_gap, dot, letter_gap, dash, letter_gap, dash,word_gap,//y
            dot, letter_gap, dot, letter_gap, dot, word_gap};

    final long [] carpintry = {0, dash, letter_gap, dot, word_gap,//n
                                dash, letter_gap, dash, letter_gap, dot, word_gap,//g
                                dot, letter_gap, dash, letter_gap, dot, word_gap,//r
                                dot, letter_gap, dot, word_gap,//i
                                dash, letter_gap, dash, letter_gap, dash, word_gap};//h



    //final long [] ice = {0, dot,letter_gap, dot, letter_gap, dash, letter_gap, dot, letter_gap, dash, letter_gap, dot,letter_gap, dot, letter_gap};
    //long [] sos = {0,dot, letter_gap, dot, letter_gap, dot, word_gap, dash, letter_gap, dash, letter_gap, dash, word_gap, dot, letter_gap, dot, letter_gap, dot, letter_gap};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morsing);
        screen = (RelativeLayout)findViewById(R.id.assist);
        int whichScreen = getIntent().getIntExtra(Game.SCREEN,0);
        Log.d("TKT8.5", "whichScreen: "+whichScreen);
        buttons[1] = (Button)findViewById(R.id.iMessageButton);
        buttons[2] = (Button)findViewById(R.id.iCalendarButton);
        buttons[3] = (Button)findViewById(R.id.iNotesButton);
        buttons[4] = (Button)findViewById(R.id.iListButton);
        buttons[5] = (Button)findViewById(R.id.iMapsButton);
        buttons[6] = (Button)findViewById(R.id.iClockButton);
        buttons[7] = (Button)findViewById(R.id.LinkedInButton);
        buttons[8] = (Button)findViewById(R.id.WhatsAppButton);
        buttons[9] = (Button)findViewById(R.id.iContactsButton);
        buttons[10] = (Button)findViewById(R.id.AppStoreButton);
        buttons[11] = (Button)findViewById(R.id.YouTubeButton);
        buttons[12] = (Button)findViewById(R.id.iSettingsButton);
        buttons[13] = (Button)findViewById(R.id.WolframButton);
        buttons[14] = (Button)findViewById(R.id.WeatherButton);
        buttons[15] = (Button)findViewById(R.id.iPhotosButton);
        buttons[16] = (Button)findViewById(R.id.iPhoneButton);
        buttons[17] = (Button)findViewById(R.id.SafariButton);
        buttons[18] = (Button)findViewById(R.id.GmailButton);
        buttons[19] = (Button)findViewById(R.id.iMusicButton);
        vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        setScreen(whichScreen);




        //// TODO: 8/2/2017 decide what the next message will be, create morse of that message and a few other dummy messages, assign morse messages to apps.


    }

    public void setScreen(int i)
    {
        enable = i;
        buttons[enable].setEnabled(true);

        switch (i)
        {
            case 1:
            {
                //iMessage
                Log.d("TKT8.5", "iMessage shown");
                screen.setBackgroundResource(R.drawable.imessage);
                //buttons[i].setEnabled(true);
                break;
            }
            case 2:
            {
                //iCalender
                Log.d("TKT8.5", "calender shown");
                screen.setBackgroundResource(R.drawable.calendar);
                //buttons[i].setEnabled(true);
                break;
            }
            case 3:
            {
                //iNote
                Log.d("TKT8.5", "notes shown");
                screen.setBackgroundResource(R.drawable.notes);
                //iNote.setEnabled(true);
                break;
            }
            case 4:
            {
                //iList
                Log.d("TKT8.5", "list shown");
                screen.setBackgroundResource(R.drawable.list);
                //iList.setEnabled(true);
                break;
            }
            case 5:
            {
                //iMaps
                Log.d("TKT8.5", "maps shown");
                screen.setBackgroundResource(R.drawable.maps);
                //iMaps.setEnabled(true);
                break;
            }
            case 6:
            {
                //iClock
                Log.d("TKT8.5", "clock shown");
                screen.setBackgroundResource(R.drawable.clock);
                //iClock.setEnabled(true);
                break;
            }
            case 7:
            {
                //linkedIn
                Log.d("TKT8.5", "linkedin shown");
                screen.setBackgroundResource(R.drawable.linkedin1);
                //linkedIn.setEnabled(true);
                break;
            }
            case 8:
            {
                //whatsApp
                Log.d("TKT8.5", "whatsapp shown");
                screen.setBackgroundResource(R.drawable.whatsapp);
                //whatsApp.setEnabled(true);
                break;
            }
            case 9:
            {
                //iContacts
                Log.d("TKT8.5", "contacts shown");
                screen.setBackgroundResource(R.drawable.contacts);
                //iContacts.setEnabled(true);
                break;
            }
            case 10:
            {
                //appStore
                Log.d("TKT8.5", "appstore shown");
                screen.setBackgroundResource(R.drawable.appstore);
                //appStore.setEnabled(true);
                break;
            }
            case 11:
            {
                //youTube
                Log.d("TKT8.5", "youtube shown");
                screen.setBackgroundResource(R.drawable.youtube);
                //youTube.setEnabled(true);
                break;
            }
            case 12:
            {
                //iSettings
                Log.d("TKT8.5", "settings shown");
                screen.setBackgroundResource(R.drawable.settings);
                //iSettings.setEnabled(true);
                break;
            }
            case 13:
            {
                //wolfram
                Log.d("TKT8.5", "wolfram shown");
                screen.setBackgroundResource(R.drawable.wolfram);
                //wolfram.setEnabled(true);
                break;
            }
            case 14:
            {
                //weather
                Log.d("TKT8.5", "weather shown");
                screen.setBackgroundResource(R.drawable.weather1);
                //weather.setEnabled(true);
                break;
            }
            case 15:
            {
                //iPhotos
                Log.d("TKT8.5", "photos shown");
                screen.setBackgroundResource(R.drawable.photos);
                //iPhotos.setEnabled(true);
                break;
            }
            case 16:
            {
                //iPhone
                Log.d("TKT8.5", "call shown");
                screen.setBackgroundResource(R.drawable.call);
                //iPhone.setEnabled(true);
                break;
            }
            case 17:
            {
                //safari
                Log.d("TKT8.5", "safari shown");
                screen.setBackgroundResource(R.drawable.safarispanish);
                //safari.setEnabled(true);
                break;
            }
            case 18:
            {
                //gmail
                Log.d("TKT8.5", "gmail shown");
                screen.setBackgroundResource(R.drawable.gmail1);
                //gmail.setEnabled(true);
                break;
            }
            case 19:
            {
                //iMusic
                Log.d("TKT8.5", "music shown");
                screen.setBackgroundResource(R.drawable.music);
                //iMusic.setEnabled(true);
                break;
            }


        }
    }


    public void morse(View v)
    {



    }




    @Override
    public void onBackPressed() {
        Log.d("TKT8.5", "onBackPressed, button disabled");
        buttons[enable].setEnabled(false);
        super.onBackPressed();
    }
    */
}
