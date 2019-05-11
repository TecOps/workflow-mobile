package com.tecOps.workflow.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;

import com.gc.materialdesign.views.Button;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.ActivityEventDetailsBinding;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.view.fragments.EventHistoryFragment;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;

public class EventDetails extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,RecyclerView.OnItemTouchListener {


    protected static ActivityEventDetailsBinding activityEventDetailsBinding;
    private EventModel eventModel;
    protected static RecyclerView recyclerView;
   public static SlidingUpPanelLayout  slider;
    AppCompatButton btnCalendarup,btnCalendardown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slider();
        btnCalendarup=(AppCompatButton)findViewById(R.id.btnCalendar);
        btnCalendardown=(AppCompatButton)findViewById(R.id.btnCalendardown);
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
        btnCalendardown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slider.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
    }

    private void slider() {
        slider = (SlidingUpPanelLayout )findViewById(R.id.sliding_layout);
        RelativeLayout sliderImage = (RelativeLayout)findViewById(R.id.upCalender);

        slider.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                if (slideOffset==0.0){btnCalendarup.setVisibility(View.VISIBLE);
                    btnCalendardown.setVisibility(View.GONE);
                }
                else {btnCalendarup.setVisibility(View.GONE);
                    btnCalendardown.setVisibility(View.VISIBLE);
                }
                //
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

//             if (previousState.toString().equals("EXPANDED") )
//             {
//                 btnCalendardown.setVisibility(View.GONE);
//                 btnCalendarup.setVisibility(View.VISIBLE);
//             }

            }
        });
        slider.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slider.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
    }


    private void initDataBinding() {
       eventModel=new EventModel();

        EventDetailsViewModel eventDetailsViewModel=new EventDetailsViewModel(this,eventModel);
        activityEventDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_details);
        activityEventDetailsBinding.setEventModel(eventModel);
        EventRepository eventRepository=new EventRepository(this,eventModel) ;
        eventRepository.sendPost("107");


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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EventHistoryFragment()).commit();
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
