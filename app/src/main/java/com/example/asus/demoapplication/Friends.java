package com.example.asus.demoapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.asus.demoapplication.adapters.FriendsAdapter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class Friends extends AppCompatActivity {

    DrawerLayout dl;
    ActionBarDrawerToggle abdt;

    Toolbar toolbar;
    MaterialSearchView searchView;
    ListView friendListView;
    ArrayAdapter adapter;
    private RecyclerView recyclerView;

    String [] NAME = {"Mehenika Mitu","Kazi Fazil", "Asma Ul Husna Chowdhury", "Israt Jabin", "Jarin Sharif Supty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        setUpToolbar();
        //getSupportActionBar().setTitle("Home");
        //getSupportActionBar().setIcon(getDrawable(R.drawable.ic_navigation_icon_24dp));
        //toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        searchView = (MaterialSearchView) findViewById(R.id.search_view);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        setOptionsActivity();
        setUpListView();
    }

    private void populateRecycler(){
        ArrayList<String> models = new ArrayList<>();
        models.addAll(Arrays.asList(NAME));

        FriendsAdapter adapter = new FriendsAdapter(models);
        recyclerView.setAdapter(adapter);

    }

    public void setUpToolbar()
    {
        dl = (DrawerLayout)findViewById(R.id.dl_friends);
        toolbar = (Toolbar) findViewById(R.id.toolbar_friends);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Friends");
        abdt = new ActionBarDrawerToggle(this,dl,toolbar,R.string.Open,R.string.Close);
       // abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.friends_search_item);
        searchView.setMenuItem(item);
        return true;
    }
    public void setOptionsActivity()
    {

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.home)
                {
                    Intent intent = new Intent(Friends.this, MainActivity.class);
                    startActivity( intent);
                }

                else if(id == R.id.notifications)
                {
                    Intent intent = new Intent(Friends.this, Notifi.class);
                    startActivity( intent);
                }

                else if(id == R.id.searchFriends)
                {
                    Intent intent = new Intent(Friends.this, Search_friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.friends)
                {
                }

                else if(id == R.id.requests)
                {
                    Intent intent = new Intent(Friends.this, Requests.class);
                    startActivity( intent);
                }

                else if(id == R.id.logOut)
                {
                    Intent intent = new Intent(Friends.this, LogIn.class);
                    startActivity( intent);
                }
                return true;
            }
        });
    }
    public void setUpListView()
    {
        friendListView = (ListView) findViewById(R.id.friend_list_view);
        CustomAdapter adapter =  new CustomAdapter();
        friendListView.setAdapter(adapter);


    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int i) {
            return null;

        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "ResourceType"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.friends_lv_layout, null);
            TextView requestNametxtVw = (TextView) findViewById(R.id.friend_name);
            Button btnConfirm = (Button) findViewById(R.id.btn_unfriend);
            //requestNametxtVw.setText(NAME[i]);

            return view;
        }
    }


}
