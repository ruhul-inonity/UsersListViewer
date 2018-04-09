package com.inonitylab.userslistviewer.ui;

import android.content.Context;
import android.util.Log;

import com.inonitylab.userslistviewer.DaggerApp;
import com.inonitylab.userslistviewer.model.UsersDataResponse;
import com.inonitylab.userslistviewer.network.ApiInterface;
import com.inonitylab.userslistviewer.network.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ruhul on 4/8/18.
 */

public class MainPresenter implements IMainPresenter {
    private static final String TAG = "MainPresenter";

    private IMainView mainView;
    private ApiInterface apiInterface;

    public MainPresenter(Context context) {
        ((DaggerApp) context).getApplicationComponent().inject(this);
        apiInterface = new RetrofitApiClient().getClient().create(ApiInterface.class);
    }

    @Override
    public void setView(IMainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void retrieveAllUserData() {

        Call<UsersDataResponse> call = apiInterface.getUserData();
        call.enqueue(new Callback<UsersDataResponse>() {
            @Override
            public void onResponse(Call<UsersDataResponse> call, Response<UsersDataResponse> response) {
                if (response.isSuccessful()){
                    UsersDataResponse usersDataResponse = response.body();
                    onSuccess(usersDataResponse);
                }
            }

            @Override
            public void onFailure(Call<UsersDataResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ................................ "+t);
            }
        });
    }

    private void onSuccess(UsersDataResponse usersDataResponse) {
        mainView.getAllUserData(usersDataResponse);
    }
}
