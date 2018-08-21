package com.copiacs.bluecommander.reports;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.copiacs.bluecommander.AboutActivity;
import com.copiacs.bluecommander.HelpActivity;
import com.copiacs.bluecommander.HomeActivity;
import com.copiacs.bluecommander.R;
import com.copiacs.bluecommander.accountsetup.AccountSetup;
import com.copiacs.bluecommander.dailyvisitors.DailyVisitors;
import com.copiacs.bluecommander.visitorexit.VisitorExit;
import com.copiacs.bluecommander.visitorslist.VisitorListActivity;

public class VisitorInBuilding extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_in_building);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        RecyclerView rc=findViewById(R.id.atul);
        VIBuAdapter vba=new VIBuAdapter();
        rc.setAdapter(vba);
        rc.setLayoutManager(new LinearLayoutManager(this));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.visitor_in_building, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.nav_home:
                startActivity(new Intent(this,HomeActivity.class));

                break;

            case R.id.nav_visEnt:
                startActivity(new Intent(this,VisitorListActivity.class));
                break;

            case R.id.nav_visExit:
                startActivity(new Intent(this,VisitorExit.class));
                break;

            case R.id.nav_dailyVis:
                startActivity(new Intent(this,DailyVisitors.class));
                break;

            case R.id.nav_renew:
                startActivity(new Intent(this,DailyVisitors.class));
                break;

            case R.id.nav_reports:
                startActivity(new Intent(this,ReportsActivity.class));
                break;

            case R.id.nav_setup:
                startActivity(new Intent(this,AccountSetup.class));
                break;

            case R.id.nav_help:
                startActivity(new Intent(this,HelpActivity.class));
                break;

            case R.id.nav_agp:
                startActivity(new Intent(this,AboutActivity.class));
                break;

            case R.id.nav_tnc:
//                startActivity(new Intent(this,TnCActivity.class));
                break;


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
