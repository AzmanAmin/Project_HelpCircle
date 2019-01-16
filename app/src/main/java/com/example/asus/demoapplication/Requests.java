package com.example.asus.demoapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Requests extends AppCompatActivity {
    DrawerLayout dl;
    ActionBarDrawerToggle abdt;
    Toolbar toolbar;

    ListView listView;
    String [] NAME = {"Mehenika Mitu","Kazi Fazil", "Asma Ul Husna Chowdhury", "Israt Jabin", "Jarin Sharif Supty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        setUpToolbar();
        setOptionsActivity();

        setUpListView();
    }


    public void setUpToolbar()
    {
        dl = (DrawerLayout)findViewById(R.id.dl);
        toolbar = (Toolbar) findViewById(R.id.toolbar_requests);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Requests");
        abdt = new ActionBarDrawerToggle(this,dl,toolbar,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
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
                    Intent intent = new Intent(Requests.this, MainActivity.class);
                    startActivity( intent);
                }

                else if(id == R.id.notifications)
                {
                    Intent intent = new Intent(Requests.this, Notifi.class);
                    startActivity( intent);
                }

                else if(id == R.id.searchFriends)
                {
                    Intent intent = new Intent(Requests.this, Search_friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.friends)
                {
                    Intent intent = new Intent(Requests.this, Friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.requests)
                {
                }

                else if(id == R.id.logOut)
                {
                    Intent intent = new Intent(Requests.this, LogIn.class);
                    startActivity( intent);
                }
                return true;
            }
        });
    }
    public void setUpListView()
    {
        listView = (ListView) findViewById(R.id.requests_list_view);
        CustomAdapter adapter =  new CustomAdapter();
        listView.setAdapter(adapter);


    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 7;
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

            view = getLayoutInflater().inflate(R.layout.requests_lv_layout,null);
            TextView requestNametxtVw = (TextView) findViewById(R.id.request_name);
            Button btnConfirm = (Button) findViewById(R.id.btn_confirm);
            Button btnDelete = (Button) findViewById(R.id.btn_delete);
            //requestNametxtVw.setText(NAME[i]);

            return view;
        }
    }
}
