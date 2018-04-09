package com.inonitylab.userslistviewer.di.module;

import android.content.Context;

import com.inonitylab.userslistviewer.ui.IMainPresenter;
import com.inonitylab.userslistviewer.ui.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ruhul on 4/8/18.
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    IMainPresenter provideMainPresenter(Context context) {
        return new MainPresenter(context);
    }
}
