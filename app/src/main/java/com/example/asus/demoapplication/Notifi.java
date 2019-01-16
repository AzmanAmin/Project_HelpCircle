package com.example.asus.demoapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Notifi extends AppCompatActivity {

    DrawerLayout dl;
    ActionBarDrawerToggle abdt;

    Toolbar toolbar;
    ListView notifiListView;
    ArrayAdapter adapter;

    String[] notifiList = {

            "Asma Ul Husna Chowdhury accepted your friend request", "Mitu asked for your request", "Anne is safe now", "Mehenika became mad for being rescued", "Nusrat wants to be friend with you","Samia","Khusbi", "Mehenika","Husna","Jasina","Jafrin","Progga","Neela","Esha","Israt","Rasel","Raju"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifi);

        setUpToolbar();
        //getSupportActionBar().setIcon(getDrawable(R.drawable.ic_navigation_icon_24dp));
        //toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setOptionsActivity();
        notifiListView = (ListView) findViewById(R.id.notifi_list_view);
        adapter =  new ArrayAdapter(Notifi.this, android.R.layout.simple_list_item_1,notifiList);

        notifiListView.setAdapter(adapter);
    }
    public void setUpToolbar()
    {
        dl = (DrawerLayout)findViewById(R.id.dl);
        toolbar = (Toolbar) findViewById(R.id.toolbar_notifi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notification");
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
                    Intent intent = new Intent(Notifi.this, MainActivity.class);
                    startActivity( intent);
                }

                else if(id == R.id.notifications)
                {
                }

                else if(id == R.id.searchFriends)
                {
                    Intent intent = new Intent(Notifi.this, Search_friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.friends)
                {
                    Intent intent = new Intent(Notifi.this, Friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.requests)
                {
                    Intent intent = new Intent(Notifi.this, Requests.class);
                    startActivity( intent);
                }

                else if(id == R.id.logOut)
                {
                    Intent intent = new Intent(Notifi.this, LogIn.class);
                    startActivity( intent);
                }
                return true;
            }
        });
    }
}
