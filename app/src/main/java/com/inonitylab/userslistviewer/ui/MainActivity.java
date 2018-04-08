package com.inonitylab.userslistviewer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.inonitylab.userslistviewer.DaggerApp;
import com.inonitylab.userslistviewer.R;
import com.inonitylab.userslistviewer.model.UsersDataResponse;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView {
    private static final String TAG = "MainActivity";

    @Inject
    IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DaggerApp) getApplicationContext()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        mainPresenter.setView(this);

        mainPresenter.retrieveAllUserData();
    }

    @Override
    public void getAllUserData(UsersDataResponse usersDataResponse) {
        Log.i(TAG, "getAllUserData: ........... num of user "+usersDataResponse.getUsers().size());
    }
}
