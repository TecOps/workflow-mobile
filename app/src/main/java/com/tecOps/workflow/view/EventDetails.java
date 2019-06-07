package com.tecOps.workflow.view;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.tecOps.workflow.R;
import com.tecOps.workflow.remote.AppStatus;
import com.tecOps.workflow.view.fragments.DashBordFragment;
import com.tecOps.workflow.view.fragments.EventHistoryFragment;

public class EventDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,RecyclerView.OnItemTouchListener {
 public static NavigationView navigationView;
    public static  DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new DashBordFragment()).commit();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
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
        getMenuInflater().inflate(R.menu.event_details, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Delete) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_History) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EventHistoryFragment()).commit();
        } else if (id == R.id.nav_Calender) {

        } else if (id == R.id.DashBord) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashBordFragment()).commit();
        } else if (id == R.id.nav_newEvent) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Disallow ScrollView to intercept touch events.
                v.getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_UP:
                // Allow ScrollView to intercept touch events.
                v.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }

        // Handle ListView touch events.
        v.onTouchEvent(event);
        return true;
    }

    @Override
    public void onTouchEvent(RecyclerView v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // Disallow ScrollView to intercept touch events.
                v.getParent().requestDisallowInterceptTouchEvent(true);
                break;

            case MotionEvent.ACTION_UP:
                // Allow ScrollView to intercept touch events.
                v.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }

        // Handle ListView touch events.
        v.onTouchEvent(event);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @BindingAdapter("app:srcVector")
    public static void setSrcVector(ImageView view, @DrawableRes int drawable) {
        view.setImageResource(drawable);
    }
}
