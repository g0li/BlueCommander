package com.copiacs.bluecommander.visitorslist;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import com.copiacs.bluecommander.AboutActivity;
import com.copiacs.bluecommander.HelpActivity;
import com.copiacs.bluecommander.HomeActivity;
import com.copiacs.bluecommander.accountsetup.AccountSetup;
import com.copiacs.bluecommander.dailyvisitors.DailyVisitors;
import com.copiacs.bluecommander.reports.ReportsActivity;
import com.copiacs.bluecommander.view.CustomTypefaceSpan;
import com.copiacs.bluecommander.R;
import com.copiacs.bluecommander.visitorexit.VisitorExit;

public class VisitorListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FloatingActionButton fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VisitorListActivity.this,NewVisitorEntry.class));
            }
        });
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

        RecyclerView rec=findViewById(R.id.rec);
        VisitorListAdapter vla=new VisitorListAdapter();
        rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rec.setAdapter(vla);
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
}
