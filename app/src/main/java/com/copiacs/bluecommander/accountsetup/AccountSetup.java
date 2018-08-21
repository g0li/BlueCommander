package com.copiacs.bluecommander.accountsetup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.copiacs.bluecommander.dailyvisitors.DailyVisitors;
import com.copiacs.bluecommander.reports.ReportsActivity;
import com.copiacs.bluecommander.view.CustomTypefaceSpan;
import com.copiacs.bluecommander.visitorexit.VisitorExit;
import com.copiacs.bluecommander.visitorslist.VisitorListActivity;

public class AccountSetup extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setup);
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

        findViewById(R.id.odCardView).setOnClickListener(this);
        findViewById(R.id.odCTV).setOnClickListener(this);
        findViewById(R.id.odLL).setOnClickListener(this);
        findViewById(R.id.odView).setOnClickListener(this);
        findViewById(R.id.odIV).setOnClickListener(this);

        findViewById(R.id.sbCardView).setOnClickListener(this);
        findViewById(R.id.sbCTV).setOnClickListener(this);
        findViewById(R.id.sbLL).setOnClickListener(this);
        findViewById(R.id.sbView).setOnClickListener(this);
        findViewById(R.id.sbIV).setOnClickListener(this);

        findViewById(R.id.sgCardView).setOnClickListener(this);
        findViewById(R.id.sgCTV).setOnClickListener(this);
        findViewById(R.id.sgLL).setOnClickListener(this);
        findViewById(R.id.sgView).setOnClickListener(this);
        findViewById(R.id.sgIV).setOnClickListener(this);

        findViewById(R.id.suCardView).setOnClickListener(this);
        findViewById(R.id.suCTV).setOnClickListener(this);
        findViewById(R.id.suLL).setOnClickListener(this);
        findViewById(R.id.suView).setOnClickListener(this);
        findViewById(R.id.suIV).setOnClickListener(this);

        findViewById(R.id.sgCardView).setOnClickListener(this);
        findViewById(R.id.sgCTV).setOnClickListener(this);
        findViewById(R.id.sgLL).setOnClickListener(this);
        findViewById(R.id.sgView).setOnClickListener(this);
        findViewById(R.id.sgIV).setOnClickListener(this);

        findViewById(R.id.sgCardView).setOnClickListener(this);
        findViewById(R.id.sgCTV).setOnClickListener(this);
        findViewById(R.id.sgLL).setOnClickListener(this);
        findViewById(R.id.sgView).setOnClickListener(this);
        findViewById(R.id.sgIV).setOnClickListener(this);

        findViewById(R.id.shCardView).setOnClickListener(this);
        findViewById(R.id.shCTV).setOnClickListener(this);
        findViewById(R.id.shLL).setOnClickListener(this);
        findViewById(R.id.shView).setOnClickListener(this);
        findViewById(R.id.shIV).setOnClickListener(this);

        findViewById(R.id.sdvCardView).setOnClickListener(this);
        findViewById(R.id.sdCTV).setOnClickListener(this);
        findViewById(R.id.sdvLL).setOnClickListener(this);
        findViewById(R.id.sdvView).setOnClickListener(this);
        findViewById(R.id.sdIV).setOnClickListener(this);
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "noto_serif.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
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
        getMenuInflater().inflate(R.menu.account_setup, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.odCardView:
            case R.id.odIV:
            case R.id.odCTV:
            case R.id.odView:
                startActivity(new Intent(AccountSetup.this,SetupOrg.class));
                break;
            case R.id.sbCardView:
            case R.id.sbIV:
            case R.id.sbCTV:
            case R.id.sbView:
                startActivity(new Intent(AccountSetup.this,SetupBuilding.class));
                break;
            case R.id.suCardView:
            case R.id.suIV:
            case R.id.suCTV:
            case R.id.suView:
                startActivity(new Intent(AccountSetup.this,SetupUser.class));
                break;
            case R.id.sgCardView:
            case R.id.sgIV:
            case R.id.sgCTV:
            case R.id.sgView:
                startActivity(new Intent(AccountSetup.this,SetupGates.class));
                break;
            case R.id.shCardView:
            case R.id.shIV:
            case R.id.shCTV:
            case R.id.shView:
                startActivity(new Intent(AccountSetup.this,SetupHost.class));
                break;
            case R.id.sdvCardView:
            case R.id.sdIV:
            case R.id.sdCTV:
            case R.id.sdvView:
                startActivity(new Intent(AccountSetup.this,SetupGates.class));
                break;
        }
    }
}
