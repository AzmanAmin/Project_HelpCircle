package com.example.asus.demoapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_notifications;
    private ImageView iv_search;
    private ImageView iv_location;
    private ImageView btn_help_here;
    private ImageView btn_panic;


    DrawerLayout dl;
    ActionBarDrawerToggle abdt;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_notifications = (ImageView) findViewById(R.id.iv_notifications);
        iv_notifications.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openNotifi();
            }
        });

        iv_search = (ImageView) findViewById(R.id.iv_search);
        iv_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openSearch_friends();
            }
        });

        iv_location = (ImageView) findViewById(R.id.iv_location);
        iv_location.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openLocation();
            }
        });

        btn_help_here = (ImageView) findViewById(R.id.btn_help_here) ;
        btn_help_here.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openHelpHere();
            }
        });

        btn_panic = (ImageView) findViewById(R.id.btn_panic) ;
        btn_panic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openPanic();
            }
        });


        setUpToolbar();
        getSupportActionBar().setTitle("Help Circle");
        //getSupportActionBar().setIcon(getDrawable(R.drawable.ic_navigation_icon_24dp));
        //toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setOptionsActivity();

    }
    public void setUpToolbar()
    {
        dl = (DrawerLayout)findViewById(R.id.dl);
        toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        abdt = new ActionBarDrawerToggle(this,dl,toolbar,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.my_profile){

            Intent myprofile = new Intent(MainActivity.this, MyProfile.class);
            startActivity(myprofile);

            return false;
        }

        if(id == R.id.about){

            Intent about = new Intent(MainActivity.this, About.class);
            startActivity(about);

            return false;
        }


        return super.onOptionsItemSelected(item);

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
                }

                else if(id == R.id.notifications)
                {
                    Intent intent = new Intent(MainActivity.this, Notifi.class);
                    startActivity( intent);
                }

                else if(id == R.id.searchFriends)
                {
                    Intent intent = new Intent(MainActivity.this, Search_friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.friends)
                {
                    Intent intent = new Intent(MainActivity.this, Friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.requests)
                {
                    Intent intent = new Intent(MainActivity.this, Requests.class);
                    startActivity( intent);
                }

                else if(id == R.id.logOut)
                {
                    Intent intent = new Intent(MainActivity.this, LogIn.class);
                    startActivity( intent);
                }
                return true;
            }
        });
    }



    public void openNotifi() {
        Intent intent = new Intent(this, Notifi.class);
        startActivity(intent);
    }
    public void openSearch_friends(){
        Intent intent = new Intent(this, Search_friends.class);
        startActivity(intent);
    }
    public void openLocation(){
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
    public void openHelpHere(){
        Intent intent = new Intent(this, HelpHere.class);
        startActivity(intent);
    }
    public void openPanic(){
        Intent intent = new Intent(this, Panic.class);
        startActivity(intent);
    }

}
