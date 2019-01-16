package com.example.asus.demoapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.demoapplication.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 1/8/2019.
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    private ArrayList<String> modelList = new ArrayList<>();
    private Context context;

    public FriendsAdapter(ArrayList<String> list){
        modelList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friends_recycler_item, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final String name = modelList.get(i);

        viewHolder.nameTv.setText(name);
        viewHolder.btnUnfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You have unfriended "+name, Toast.LENGTH_SHORT);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTv;
        private Button btnUnfriend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.tv_friend_name);
            btnUnfriend = itemView.findViewById(R.id.btn_recycler_unfriend);
        }
    }
}
