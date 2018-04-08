package com.inonitylab.userslistviewer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.inonitylab.userslistviewer.DaggerApp;
import com.inonitylab.userslistviewer.R;
import com.inonitylab.userslistviewer.adapter.UsersAdapter;
import com.inonitylab.userslistviewer.model.User;
import com.inonitylab.userslistviewer.model.UsersDataResponse;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView {
    private static final String TAG = "MainActivity";

    @Inject
    IMainPresenter mainPresenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private UsersAdapter adapter;
    private List<User> userList;

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

        adapter = new UsersAdapter(MainActivity.this,usersDataResponse.getUsers());
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
