package com.inonitylab.userslistviewer.di;

import com.inonitylab.userslistviewer.DaggerApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ruhul on 4/8/18.
 */

@Singleton
@Component(modules = {ApplicationModule.class, PresenterModule.class,ServiceModule.class})
public interface ApplicationComponent {
    void inject(DaggerApp EManApp);
}
