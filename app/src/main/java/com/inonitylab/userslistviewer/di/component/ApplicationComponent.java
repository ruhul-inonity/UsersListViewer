package com.inonitylab.userslistviewer.di.component;

import com.inonitylab.userslistviewer.DaggerApp;
import com.inonitylab.userslistviewer.di.module.ApplicationModule;
import com.inonitylab.userslistviewer.di.module.PresenterModule;
import com.inonitylab.userslistviewer.di.module.ServiceModule;
import com.inonitylab.userslistviewer.ui.MainActivity;
import com.inonitylab.userslistviewer.ui.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ruhul on 4/8/18.
 */

@Singleton
@Component(modules = {ApplicationModule.class, PresenterModule.class,ServiceModule.class})
public interface ApplicationComponent {
    void inject(DaggerApp EManApp);
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
}
