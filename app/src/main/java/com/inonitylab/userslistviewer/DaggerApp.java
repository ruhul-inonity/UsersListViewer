package com.inonitylab.userslistviewer;

import android.app.Application;

import com.inonitylab.userslistviewer.di.ApplicationComponent;
import com.inonitylab.userslistviewer.di.ApplicationModule;
import com.inonitylab.userslistviewer.di.DaggerApplicationComponent;

/**
 * Created by ruhul on 4/8/18.
 */

public class DaggerApp extends Application {

    public static final String TAG = DaggerApp.class.getSimpleName();
    public ApplicationComponent mApplicationComponent;
    private static DaggerApp mInstance;

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mApplicationComponent = initDagger(this);
    }

    protected ApplicationComponent initDagger(DaggerApp application) {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
    }

    public static synchronized DaggerApp getInstance() {
        return mInstance;
    }
}

