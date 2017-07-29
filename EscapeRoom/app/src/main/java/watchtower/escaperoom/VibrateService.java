package watchtower.escaperoom;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Moore on 7/28/2017.
 */

public class VibrateService extends Service {
/*
    Vibrator v = new Vibrator() {
        @Override
        public boolean hasVibrator() {
            return false;
        }

        @Override
        public void cancel() {

        }
    };
    */
    public final long pattern[]={0,800,200,1200,300,2000,400,4000};
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

       // v.vibrate(2000);//-1 if we dont want to repeat the vib
    }






    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
