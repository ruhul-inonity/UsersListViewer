package com.inonitylab.userslistviewer.network;

import com.inonitylab.userslistviewer.model.UsersDataResponse;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by ruhul on 4/9/18.
 */

public interface ApiInterface {
    @POST("intrvw/users.json")
    Call<UsersDataResponse> getUserData();
}
