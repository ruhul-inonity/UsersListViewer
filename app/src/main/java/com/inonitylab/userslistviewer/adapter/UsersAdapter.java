package com.inonitylab.userslistviewer.adapter;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inonitylab.userslistviewer.R;
import com.inonitylab.userslistviewer.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ruhul on 6/18/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.RecyclerViewHolder> {
    private String TAG = "Clients Adapter";
    private String MEN_IMAGE_URL = "https://randomuser.me/api/portraits/men/";
    private String WOMEN_IMAGE_URL = "https://randomuser.me/api/portraits/women/";
    private String IMAGE_EXTENSION = ".jpg";
    private LayoutInflater layoutInflater;
    private Context context;
    private List<User> userList;

    public UsersAdapter(Context context, List<User> userList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.userList = userList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = layoutInflater.inflate(R.layout.layout_users, parent, false);

        return new RecyclerViewHolder(item);
    }


    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        String imageUrl;

        User user = userList.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.homePhone.setText(user.getPhones().getHome());
        holder.mobile.setText(user.getPhones().getMobile());

        if (user.getGender().equals("male")){
          imageUrl = MEN_IMAGE_URL+user.getPhoto()+IMAGE_EXTENSION;
        }else{
            imageUrl = WOMEN_IMAGE_URL+user.getPhoto()+IMAGE_EXTENSION;
        }
        Glide.with(context).load(imageUrl).into(holder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView circleImageView;
        private TextView firstName;
        private TextView lastName;
        private TextView homePhone;
        private TextView mobile;

        private RecyclerViewHolder(final View v) {
            super(v);

            circleImageView = v.findViewById(R.id.imageViewClient);
            firstName = v.findViewById(R.id.tvFirstName);
            lastName = v.findViewById(R.id.tvLastName);
            homePhone = v.findViewById(R.id.tvHomeMobile);
            mobile =  v.findViewById(R.id.tvMobile);

        }
    }
}
