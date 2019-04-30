package com.tecOps.workflow.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.Calendar;
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.applandeo.materialcalendarview.utils.DateUtils;
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.ActivityEventDetailsBinding;
import com.tecOps.workflow.databinding.ActivityLoginPageBinding;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;
import com.tecOps.workflow.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EventDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    protected static ActivityEventDetailsBinding activityEventDetailsBinding;
    private EventModel eventModel;
   public static SlidingUpPanelLayout  slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slider();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        Calender calender=new Calender(this,calendarView);

    }

    private void slider() {
        slider = (SlidingUpPanelLayout )findViewById(R.id.sliding_layout);
        RelativeLayout sliderImage = (RelativeLayout)findViewById(R.id.upCalender);



    }

    private void initDataBinding() {
       eventModel=new EventModel();

        EventDetailsViewModel eventDetailsViewModel=new EventDetailsViewModel(this,eventModel);
        activityEventDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_details);
        activityEventDetailsBinding.setEventModel(eventModel);
        EventRepository eventRepository=new EventRepository(this,eventModel) ;
        eventRepository.sendPost("1");


        activityEventDetailsBinding.executePendingBindings();


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

        if (id == R.id.nav_History) {
            // Handle the camera action
        } else if (id == R.id.nav_Calender) {
            slider.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED); //to open
        } else if (id == R.id.nav_Explorer) {

        } else if (id == R.id.nav_newEvent) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
