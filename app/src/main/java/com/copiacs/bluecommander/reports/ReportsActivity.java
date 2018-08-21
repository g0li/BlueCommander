package com.copiacs.bluecommander.reports;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.SubMenu;
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
import com.copiacs.bluecommander.view.CustomTypefaceSpan;
import com.copiacs.bluecommander.visitorexit.VisitorExit;
import com.copiacs.bluecommander.visitorslist.VisitorListActivity;

public class ReportsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu m = navigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }
            applyFontToMenuItem(mi);
        }

        findViewById(R.id.vehIV).setOnClickListener(this);
        findViewById(R.id.vehTV).setOnClickListener(this);
        findViewById(R.id.vehLL).setOnClickListener(this);

        findViewById(R.id.vibuIV).setOnClickListener(this);
        findViewById(R.id.vibuTV).setOnClickListener(this);
        findViewById(R.id.vibuLL).setOnClickListener(this);

        findViewById(R.id.visIV).setOnClickListener(this);
        findViewById(R.id.visTV).setOnClickListener(this);
        findViewById(R.id.visLL).setOnClickListener(this);

        findViewById(R.id.hostIV).setOnClickListener(this);
        findViewById(R.id.hostTV).setOnClickListener(this);
        findViewById(R.id.hostLL).setOnClickListener(this);

        findViewById(R.id.dailyVIV).setOnClickListener(this);
        findViewById(R.id.dailyVTV).setOnClickListener(this);
        findViewById(R.id.dailyVLL).setOnClickListener(this);

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
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "noto_serif.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
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

    @Override
    public void onClick(View v) {
        Intent i = null;
        switch (v.getId())
        {
            case R.id.vehIV:
            case R.id.vehTV:
            case R.id.vehLL:
                i=new Intent(ReportsActivity.this, VehicleLogActivity.class);
                break;
            case R.id.vibuIV:
            case R.id.vibuTV:
            case R.id.vibuLL:
                i=new Intent(ReportsActivity.this, VisitorInBuilding.class);
                break;
            case R.id.visIV:
            case R.id.visTV:
            case R.id.visLL:
                i=new Intent(ReportsActivity.this, VisitorLog.class);
                break;
            case R.id.hostIV:
            case R.id.hostTV:
            case R.id.hostLL:
                i=new Intent(ReportsActivity.this, VisitorLog.class);
                break;
            case R.id.dailyVIV:
            case R.id.dailyVTV:
            case R.id.dailyVLL:
                i=new Intent(ReportsActivity.this, VisitorLog.class);
                break;
        }
        startActivity(i);

    }
}
