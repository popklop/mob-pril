package com.example.pr6;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
{

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                if (menuItem.getItemId() == R.id.glavnaya)
                {
                    Toast.makeText(MainActivity.this, "Dom", Toast.LENGTH_LONG).show();
                    return true;
                } else if (menuItem.getItemId() == R.id.notifications)
                {
                    Toast.makeText(MainActivity.this, "Yvedomlenia", Toast.LENGTH_LONG).show();
                    return true;
                } else if (menuItem.getItemId() == R.id.settings)
                {
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });

        ActionBar actionBar = getSupportActionBar();
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        actionBar.setTitle("Pr6");
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        if (drawerLayout != null)
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        NavigationView navigationView = findViewById(R.id.navDrawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                if (menuItem.getItemId()==R.id.pudge)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,BlankFragment1.class,null).commit();
                    return true;
                }
                if (menuItem.getItemId()==R.id.pudge2)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,BlankFragment2.class,null).commit();
                    return true;
                }
                if (menuItem.getItemId()==R.id.furion)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,BlankFragment3.class,null).commit();
                    return true;
                }
                if (menuItem.getItemId()==R.id.next)
                {
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuxml,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
            if (item.getItemId()==R.id.glavnaya)
            {
                Toast.makeText(MainActivity.this, "Glavnaya", Toast.LENGTH_LONG).show();
                return true;
            }
            if (item.getItemId()==R.id.notifications)
            {
                Toast.makeText(MainActivity.this, "Uved", Toast.LENGTH_LONG).show();
                return true;
            }
            if (item.getItemId()==R.id.settings)
            {
                Toast.makeText(MainActivity.this, "Nastroyki", Toast.LENGTH_LONG).show();
                return true;
            }


        return super.onOptionsItemSelected(item);
    }
}

