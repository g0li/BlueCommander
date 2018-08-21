package com.copiacs.bluecommander;

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

import com.copiacs.bluecommander.accountsetup.AccountSetup;
import com.copiacs.bluecommander.dailyvisitors.DailyVisitors;
import com.copiacs.bluecommander.reports.ReportsActivity;
import com.copiacs.bluecommander.view.CustomTypefaceSpan;
import com.copiacs.bluecommander.visitorexit.VisitorExit;
import com.copiacs.bluecommander.visitorslist.VisitorListActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        findViewById(R.id.vlistCardView).setOnClickListener(this);
        findViewById(R.id.vlistIV).setOnClickListener(this);
        findViewById(R.id.vlistTV).setOnClickListener(this);
        findViewById(R.id.vlistLL).setOnClickListener(this);


        findViewById(R.id.dVisCardView).setOnClickListener(this);
        findViewById(R.id.dVisIV).setOnClickListener(this);
        findViewById(R.id.dVisTV).setOnClickListener(this);
        findViewById(R.id.dVisLL).setOnClickListener(this);


        findViewById(R.id.vExitCardView).setOnClickListener(this);
        findViewById(R.id.vExitIV).setOnClickListener(this);
        findViewById(R.id.vExitTV).setOnClickListener(this);
        findViewById(R.id.vExitLL).setOnClickListener(this);


        findViewById(R.id.reportsCardView).setOnClickListener(this);
        findViewById(R.id.reportsIV).setOnClickListener(this);
        findViewById(R.id.reportsTV).setOnClickListener(this);
        findViewById(R.id.reportsLL).setOnClickListener(this);


        findViewById(R.id.reportsCardView).setOnClickListener(this);
        findViewById(R.id.reportsIV).setOnClickListener(this);
        findViewById(R.id.reportsTV).setOnClickListener(this);
        findViewById(R.id.reportsLL).setOnClickListener(this);

        findViewById(R.id.accSetIV).setOnClickListener(this);
        findViewById(R.id.accSetTV).setOnClickListener(this);
        findViewById(R.id.accSetLL).setOnClickListener(this);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.nav_home:
                break;

            case R.id.nav_visEnt:
                startActivity(new Intent(HomeActivity.this,VisitorListActivity.class));
                break;

            case R.id.nav_visExit:
                startActivity(new Intent(HomeActivity.this,VisitorExit.class));
                break;

            case R.id.nav_dailyVis:
                startActivity(new Intent(HomeActivity.this,DailyVisitors.class));
                break;

            case R.id.nav_renew:
                startActivity(new Intent(HomeActivity.this,DailyVisitors.class));
                break;

            case R.id.nav_reports:
                startActivity(new Intent(HomeActivity.this,ReportsActivity.class));
                break;

            case R.id.nav_setup:
                startActivity(new Intent(HomeActivity.this,AccountSetup.class));
                break;

            case R.id.nav_help:
                startActivity(new Intent(HomeActivity.this,HelpActivity.class));
                break;

            case R.id.nav_agp:
                startActivity(new Intent(HomeActivity.this,AboutActivity.class));
                break;

            case R.id.nav_tnc:
//                startActivity(new Intent(HomeActivity.this,TnCActivity.class));
                break;


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.vlistCardView:
            case R.id.vlistIV:
            case R.id.vlistTV:
            case R.id.vlistLL:
                startActivity(new Intent(HomeActivity.this, VisitorListActivity.class));

            break;
        
            case R.id.dVisCardView:
            case R.id.dVisIV:
            case R.id.dVisTV:
            case R.id.dVisLL:
                startActivity(new Intent(HomeActivity.this, DailyVisitors.class));
            break;
        
            case R.id.vExitCardView:
            case R.id.vExitIV:
            case R.id.vExitTV:
            case R.id.vExitLL:
                startActivity(new Intent(HomeActivity.this, VisitorExit.class));

                break;

            case R.id.reportsCardView:
            case R.id.reportsIV:
            case R.id.reportsTV:
            case R.id.reportsLL:
                startActivity(new Intent(HomeActivity.this, ReportsActivity.class));
            break;

            case R.id.accSetIV:
            case R.id.accSetTV:
            case R.id.accSetLL:
                startActivity(new Intent(HomeActivity.this, AccountSetup.class));
            break;
        }
    }
}
