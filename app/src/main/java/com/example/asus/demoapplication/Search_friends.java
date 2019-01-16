package com.example.asus.demoapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class Search_friends extends AppCompatActivity {

    DrawerLayout dl;
    ActionBarDrawerToggle abdt;
    Toolbar toolbar;
    MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friends);

        setUpToolbar();
        //getSupportActionBar().setIcon(getDrawable(R.drawable.ic_navigation_icon_24dp));
        //toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        setOptionsActivity();
    }
    public void setUpToolbar()
    {
        dl = (DrawerLayout)findViewById(R.id.dl);
        toolbar = (Toolbar) findViewById(R.id.toolbar_search_friends);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Friends");
        abdt = new ActionBarDrawerToggle(this,dl,toolbar,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.friends_search_item);
        searchView.setMenuItem(item);
        return true;
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
                    Intent intent = new Intent(Search_friends.this, MainActivity.class);
                    startActivity( intent);
                }

                else if(id == R.id.notifications)
                {
                    Intent intent = new Intent(Search_friends.this, Notifi.class);
                    startActivity( intent);
                }

                else if(id == R.id.searchFriends)
                {
                }

                else if(id == R.id.friends)
                {
                    Intent intent = new Intent(Search_friends.this, Friends.class);
                    startActivity( intent);
                }

                else if(id == R.id.requests)
                {
                    Intent intent = new Intent(Search_friends.this, Requests.class);
                    startActivity( intent);
                }

                else if(id == R.id.logOut)
                {
                    Intent intent = new Intent(Search_friends.this, LogIn.class);
                    startActivity( intent);
                }
                return true;
            }
        });
    }
}
