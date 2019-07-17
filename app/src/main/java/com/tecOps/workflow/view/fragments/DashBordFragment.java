package com.tecOps.workflow.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.FragmentDashbordBinding;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.remote.AppStatus;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.view.Calender;
import com.tecOps.workflow.view.EventDetails;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;

import static com.tecOps.workflow.view.EventDetails.drawer;

public class DashBordFragment extends Fragment implements PopupMenu.OnMenuItemClickListener, EventRepository.EventResponses {
    private EventModel eventModel;
    private static int eventId=162;
    public static SlidingUpPanelLayout  slider;
    protected static FragmentDashbordBinding binding;
    AppCompatButton btnCalendarup,btnCalendardown;
    protected static RecyclerView recyclerView;
    public static EventRepository eventRepository;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        eventModel = new EventModel();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashbord, container, false);
        binding.setEventModel(eventModel);
        AppStatus appStatus=new AppStatus();
        RelativeLayout baseLayout=binding.getRoot().findViewById(R.id.baseRalative);

        if ( !appStatus.isOnline(getContext())) {
            baseLayout.setVisibility(View.GONE);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }else {
            Init();
        }



        ImageView btn = binding.getRoot().findViewById(R.id.btnShow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                popup.setOnMenuItemClickListener(DashBordFragment.this::onMenuItemClick);
                popup.inflate(R.menu.event_details);
                popup.show();
            }
        });
        return binding.getRoot();
    }

    private void Init()
    {
        eventRepository = new EventRepository(getContext(),eventModel);
        CalendarView calendarView = binding.getRoot().findViewById(R.id.calendarView);
        Calender calender=new Calender(getContext(),calendarView);
        eventRepository.sendPost("260", (EventRepository.EventResponses) getActivity());
        slider();


        FloatingActionButton fab = binding.getRoot().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private void slider() {
        btnCalendarup=binding.getRoot().findViewById(R.id.btnCalendar);
        btnCalendardown=binding.getRoot().findViewById(R.id.btnCalendardown);

        slider = binding.getRoot().findViewById(R.id.sliding_layout);
        RelativeLayout sliderImage = binding.getRoot().findViewById(R.id.upCalender);

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

            }
        });
        slider.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slider.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });


        btnCalendardown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slider.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(getContext(), "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.action_Delete:
                 eventRepository.deleteEvent(EventRepository.eventId);
                eventRepository.searchMonthEvents(EventDetailsViewModel.year,EventDetailsViewModel.month);
                return true;
            case R.id.action_approved:
                // do your code
                return true;
            case R.id.action_rejected:
                // do your code
                return true;
            case R.id.action_published:
                // do your code
                return true;

            default:
                return false;
        }
    }


    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onPermissionFailure() {

    }
}
