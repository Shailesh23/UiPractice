package co.fmauipractice.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Shal on 11-09-2016.
 */
public class FMAApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
