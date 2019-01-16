package com.example.asus.demoapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ASUS on 10/15/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mFriendNames = new ArrayList<>();
    private Context mContext;
    private Button mButton;

    public RecyclerViewAdapter(ArrayList<String> friendNames, Context context, Button button){
        mFriendNames = friendNames;
        mButton = button;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder; called.");

        holder.friendName.setText(mFriendNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: click on: " + mFriendNames.get(position));

                Toast.makeText(mContext,mFriendNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFriendNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView friendName;
        RelativeLayout parentLayout;
        Button unfriend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            friendName = itemView.findViewById(R.id.friend_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            unfriend = itemView.findViewById(R.id.btn_unfriend);
        }
    }
}
