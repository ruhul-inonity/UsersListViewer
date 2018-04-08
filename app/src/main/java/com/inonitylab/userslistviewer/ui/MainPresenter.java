package com.inonitylab.userslistviewer.ui;

import android.content.Context;

import com.inonitylab.userslistviewer.DaggerApp;

/**
 * Created by ruhul on 4/8/18.
 */

public class MainPresenter implements IMainPresenter {

    private IMainView mainView;
    //private APIService apiService;

    public MainPresenter(Context context) {
        ((DaggerApp) context).getApplicationComponent().inject(this);
        //apiService = new ApiClient().getClient(preferencesHelper.getIMEINumber(), preferencesHelper.getMobileNumber()).create(APIService.class);
    }

    @Override
    public void setView(IMainView mainView) {
        this.mainView = mainView;
    }
}
